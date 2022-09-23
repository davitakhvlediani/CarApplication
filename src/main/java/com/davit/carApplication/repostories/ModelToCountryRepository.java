package com.davit.carApplication.repostories;

import com.davit.carApplication.model.domain.ModelToCountry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ModelToCountryRepository extends CommonRepository<ModelToCountry> {

    @Query("select mtc from ModelToCountry mtc where mtc.model.id =:modelId and mtc.country.id = :countryId")
    Optional<ModelToCountry> findModelToCountryByModelAndCountry(@Param("modelId")Long modelId,@Param("countryId") Long countryId);
}
