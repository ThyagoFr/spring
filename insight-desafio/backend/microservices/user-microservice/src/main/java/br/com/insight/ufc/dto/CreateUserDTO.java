package br.com.insight.ufc.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CreateUserDTO implements Serializable  {

    private static final long serialVersionUID = 1L;

    private String name;

    private String email;

    private String cpf;

    private String telephone;

    private String password;

    private int age;

    private String gender;

    private AddressDTO address;

}
