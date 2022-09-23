package com.davit.carApplication.model.mapper;

import com.davit.carApplication.model.domain.ModelToCountry;
import com.davit.carApplication.model.dto.CountryDTO;
import com.davit.carApplication.model.dto.ModelDTO;
import com.davit.carApplication.model.dto.ModelToCountryDTO;

public class ModelToCountryMapper {

    public static ModelToCountryDTO mapModelToCountryToDto(ModelToCountry model){
        ModelToCountryDTO modelToCountryDTO = new ModelToCountryDTO();
        modelToCountryDTO.setQuantity(modelToCountryDTO.getQuantity());
        modelToCountryDTO.setId(model.getId());
        ModelDTO modelDTO = ModelMapper.mapModelToDTO(model.getModel());
        modelToCountryDTO.setModelDTO(modelDTO);
        CountryDTO countryDTO = CountryMapper.mapCountryToDTO(model.getCountry());
        modelToCountryDTO.setCountryDTO(countryDTO);
        return modelToCountryDTO;
    }
}
