package com.davit.carApplication.service;

import com.davit.carApplication.model.domain.ModelToCountry;
import com.davit.carApplication.repostories.ModelToCountryRepository;
import org.springframework.stereotype.Service;

@Service
public class ModelToCountryService extends AbstractService<ModelToCountry, ModelToCountryRepository> {
    public ModelToCountryService(ModelToCountryRepository repository) {
        super(repository);
    }
    public ModelToCountry findModelToCountryByModelAndCountry(Long modelId,Long countryId){
       return repository.findModelToCountryByModelAndCountry(modelId,countryId).orElseThrow();
    }
}
