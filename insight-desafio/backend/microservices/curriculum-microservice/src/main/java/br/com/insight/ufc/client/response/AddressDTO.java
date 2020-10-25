package br.com.insight.ufc.client.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class AddressDTO implements Serializable  {

    private static final long serialVersionUID = 1L;

    private Integer number;

    private String zipCode;

    private String logradouro;

    private String complement;

    private String city;

    private String state;

    private String neighborhood;

}
