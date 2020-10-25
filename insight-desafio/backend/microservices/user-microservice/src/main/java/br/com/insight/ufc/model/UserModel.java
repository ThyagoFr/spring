package br.com.insight.ufc.model;

import br.com.insight.ufc.model.view.UserView;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
@Data
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(UserView.Resumo.class)
    private Long id;

    @JsonView(UserView.Resumo.class)
    private String name;

    @JsonView(UserView.Resumo.class)
    private String email;

    @JsonView(UserView.Resumo.class)
    private String cpf;

    @JsonView(UserView.Resumo.class)
    private String telephone;

    private String password;

    @JsonView(UserView.Resumo.class)
    private int age;

    @JsonView(UserView.Resumo.class)
    private String gender;

    @OneToOne
    @JoinColumn(name = "id_address", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_user_address"))
    @NotNull(message = "Endereço nao pode ser nulo")
    @JsonView(UserView.Resumo.class)
    private AddressModel address;

}
