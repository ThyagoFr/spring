package ufc.thyago.multipledatabases.infrastructure.postgres.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ufc.thyago.multipledatabases.infrastructure.postgres.model.LivroModel;

/**
 * Criado por : Thyago Freitas
 * Data :  02/11/2020
 * Projeto  : multiple-databases
 **/

public interface LivroRepository extends JpaRepository<LivroModel, Long> {
}
