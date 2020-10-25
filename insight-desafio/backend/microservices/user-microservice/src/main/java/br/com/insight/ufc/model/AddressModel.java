package br.com.insight.ufc.model;

import br.com.insight.ufc.model.view.UserView;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users_addresses")
@Data
@JsonView(UserView.Resumo.class)
public class AddressModel  {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer number;

    @Column(name="zip_code")
    private String zipCode;

    private String logradouro;

    private String complement;

    @NotNull(message = "Cidade nao pode ser nula")
    private String city;

    @NotNull(message = "UF nao pode ser nula")
    @Size(max = 2, min = 2)
    private String state;

    @NotNull(message = "Bairro nao pode ser nula")
    private String neighborhood;

}
