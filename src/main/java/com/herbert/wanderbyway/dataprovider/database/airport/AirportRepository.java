package com.herbert.wanderbyway.dataprovider.database.airport;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface AirportRepository extends MongoRepository<AirportDB, String> {

}
