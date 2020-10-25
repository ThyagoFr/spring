package br.com.insight.ufc.dto;

import br.com.insight.ufc.client.response.UserDTO;
import br.com.insight.ufc.model.ActivitiesModel;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class CurriculumDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private UserDTO user;

    private List<ActivitiesModel> activities = new ArrayList<>();

}
