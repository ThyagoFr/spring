package br.com.insight.ufc.repository;

import br.com.insight.ufc.model.AddressModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends PagingAndSortingRepository<AddressModel, Long> {
}

