package br.com.insight.ufc.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ActivitiesDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Date activityDate;

    private String name;

    private String description;

}
