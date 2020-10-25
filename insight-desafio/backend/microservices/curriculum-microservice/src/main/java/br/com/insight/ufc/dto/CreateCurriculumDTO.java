package br.com.insight.ufc.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class CreateCurriculumDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long idUser;

    private List<ActivitiesDTO> activities = new ArrayList<>();

}
