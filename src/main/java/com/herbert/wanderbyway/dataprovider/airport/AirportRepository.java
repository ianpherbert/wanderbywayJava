package com.herbert.wanderbyway.dataprovider.airport;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface AirportRepository extends MongoRepository<AirportDB, String> {

}
