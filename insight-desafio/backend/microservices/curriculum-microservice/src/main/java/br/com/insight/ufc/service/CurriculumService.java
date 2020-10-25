package br.com.insight.ufc.service;

import br.com.insight.ufc.client.UserClient;
import br.com.insight.ufc.client.response.UserDTO;
import br.com.insight.ufc.dto.CreateCurriculumDTO;
import br.com.insight.ufc.dto.CurriculumDTO;
import br.com.insight.ufc.model.ActivitiesModel;
import br.com.insight.ufc.model.CurriculumModel;
import br.com.insight.ufc.repository.CurriculumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CurriculumService {

    private final CurriculumRepository curriculumRepository;

    private final ActivitiesService activitiesService;

    private final UserClient userClient ;

    @Autowired
    public CurriculumService(
            CurriculumRepository curriculumRepository,
            ActivitiesService activitiesService,
            UserClient userClient
            ) {
        this.curriculumRepository = curriculumRepository;
        this.activitiesService = activitiesService;
        this.userClient = userClient;
    }

    public CurriculumModel createCurriculum(CreateCurriculumDTO body) {

        CurriculumModel model = new CurriculumModel();
        List<ActivitiesModel> activitiesModel = activitiesService.createActivities(body.getActivities());
        activitiesModel.forEach(activitiesM -> model.getActivities().add(activitiesM));
        model.setIdUser(body.getIdUser());
        return this.curriculumRepository.save(model);

    }

    public CurriculumDTO findCurriculum(String id) {

        CurriculumModel model = this.curriculumRepository.findById(id).get();
        return fromModelToDTO(model);

    }

    public List<CurriculumDTO> findCurriculums(List<String> courses) {

        if (courses == null) {
            return this.curriculumRepository.findAll()
                    .stream()
                    .map(this::fromModelToDTO)
                    .collect(Collectors.toList());
        }
        return this.curriculumRepository.findAllByActivity(courses)
                .stream()
                .map(this::fromModelToDTO)
                .collect(Collectors.toList());


    }

    private CurriculumDTO fromModelToDTO(CurriculumModel model) {

        CurriculumDTO dto = new CurriculumDTO();
        UserDTO userInfo = userClient.getUser(model.getIdUser());
        dto.setActivities(model.getActivities());
        dto.setId(model.getId());
        dto.setUser(userInfo);
        return dto;

    }

}
