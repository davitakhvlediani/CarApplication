package com.davit.carApplication.facade;

import com.davit.carApplication.model.domain.Country;
import com.davit.carApplication.model.domain.Model;
import com.davit.carApplication.model.domain.ModelToCountry;
import com.davit.carApplication.model.dto.ModelToCountryDTO;
import com.davit.carApplication.model.enums.ModelToCountryStatus;
import com.davit.carApplication.model.mapper.ModelToCountryMapper;
import com.davit.carApplication.model.param.ModelToCountryParam;
import com.davit.carApplication.service.CountryService;
import com.davit.carApplication.service.ModelService;
import com.davit.carApplication.service.ModelToCountryService;
import org.springframework.stereotype.Service;

@Service
public class ModelToCountryFacade {

    private final CountryService countryService;
    private final ModelService modelService;
    private final ModelToCountryService modelToCountryService;

    public ModelToCountryFacade(CountryService countryService, ModelService modelService,ModelToCountryService modelToCountryService) {
        this.countryService = countryService;
        this.modelService = modelService;
        this.modelToCountryService=modelToCountryService;
    }

    public ModelToCountryDTO createModelToCar(ModelToCountryParam param){
        Country country = countryService.get(param.getCountryId());
        Model model = modelService.get(param.getModelId());
        ModelToCountry modelToCountry = new ModelToCountry();
        modelToCountry.setCountry(country);
        modelToCountry.setModel(model);
        modelToCountry.setQuantity(param.getQuantity());
        modelToCountry.setStatus(ModelToCountryStatus.ACTIVE);
        ModelToCountry savedModelToCountry = modelToCountryService.create(modelToCountry);
        return ModelToCountryMapper.mapModelToCountryToDto(savedModelToCountry);
    }
}
