package br.com.insight.ufc.repository;

import br.com.insight.ufc.model.UserModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<UserModel, Long> {
}
