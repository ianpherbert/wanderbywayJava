package com.herbert.wanderbyway.dataprovider.database.city;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface CityRepository extends MongoRepository<CityDB, String> {
    List<CityDB> findCityDBBySlugContaining(String name);
}
