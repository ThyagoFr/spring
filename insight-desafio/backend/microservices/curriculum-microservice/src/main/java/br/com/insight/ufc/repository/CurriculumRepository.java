package br.com.insight.ufc.repository;

import br.com.insight.ufc.model.CurriculumModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CurriculumRepository extends MongoRepository<CurriculumModel, String> {

    @Query("{ 'activities.name' : { $all:  ?0 } }")
    List<CurriculumModel> findAllByActivity(List<String> acti);
}
