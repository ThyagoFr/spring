package br.com.insight.ufc.repository;

import br.com.insight.ufc.model.ActivitiesModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ActivitiesRepository extends MongoRepository<ActivitiesModel, String> {
}
