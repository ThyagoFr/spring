package br.com.insight.ufc.service;

import br.com.insight.ufc.dto.ActivitiesDTO;
import br.com.insight.ufc.model.ActivitiesModel;
import br.com.insight.ufc.repository.ActivitiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivitiesService {

    private final ActivitiesRepository activitiesRepository;

    @Autowired
    public ActivitiesService(ActivitiesRepository activitiesRepository) {
        this.activitiesRepository = activitiesRepository;
    }

    public ActivitiesModel createActivity(ActivitiesDTO body) {
        return this.activitiesRepository.save(fromDTOToModel(body));
    }

    public List<ActivitiesModel> createActivities(List<ActivitiesDTO> body) {
        List<ActivitiesModel> list = body.stream().map(this::fromDTOToModel).collect(Collectors.toList());
        return this.activitiesRepository.saveAll(list);

    }

    private ActivitiesModel fromDTOToModel(ActivitiesDTO dto) {

        ActivitiesModel activitiesModel = new ActivitiesModel();
        activitiesModel.setDescription(dto.getDescription());
        activitiesModel.setActivityDate(null);
        activitiesModel.setName(dto.getName());
        return activitiesModel;

    }

}
