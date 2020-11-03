package ufc.thyago.multipledatabases.infrastructure.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ufc.thyago.multipledatabases.infrastructure.mysql.model.AutorModel;

/**
 * Criado por : Thyago Freitas
 * Data :  02/11/2020
 * Projeto  : multiple-databases
 **/

public interface AutorRepository extends JpaRepository<AutorModel, Long> {
}
