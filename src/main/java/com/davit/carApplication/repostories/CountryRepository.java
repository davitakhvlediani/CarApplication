package com.davit.carApplication.repostories;

import com.davit.carApplication.model.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends CommonRepository<Country> {
}
