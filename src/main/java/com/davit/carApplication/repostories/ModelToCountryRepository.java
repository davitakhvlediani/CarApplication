package com.davit.carApplication.repostories;

import com.davit.carApplication.model.domain.ModelToCountry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelToCountryRepository extends JpaRepository<ModelToCountry, Long> {
}
