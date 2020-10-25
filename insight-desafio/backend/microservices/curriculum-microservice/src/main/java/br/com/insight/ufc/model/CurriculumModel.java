package br.com.insight.ufc.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "curriculum")
public class CurriculumModel implements Serializable {

    @Id
    private String id;

    private Long idUser;

    private List<ActivitiesModel> activities = new ArrayList<>();

}
