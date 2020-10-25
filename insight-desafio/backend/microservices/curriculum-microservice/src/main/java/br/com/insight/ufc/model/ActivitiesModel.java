package br.com.insight.ufc.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Data
@Document(collection = "activities")
public class ActivitiesModel implements Serializable {

    @Id
    private String id;

    private Date activityDate;

    private String name;

    private String description;
}
