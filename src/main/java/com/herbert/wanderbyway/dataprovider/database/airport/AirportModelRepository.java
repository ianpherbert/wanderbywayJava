package com.herbert.wanderbyway.dataprovider.database.airport;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AirportModelRepository  extends JpaRepository<AirportModel, Long> {
    List<AirportModel> findBySlugContaining(String slug);
}
