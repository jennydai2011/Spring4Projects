package com.jdai.AccessingMongoDbRest;

import org.springframework.data.repository.query.Param;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "people", path="people")
public interface PersonRepository  extends MongoRepository<Person, String>{

    List<Person> findByLastName(@Param("name") String name);
}
