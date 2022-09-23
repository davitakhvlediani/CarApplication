package com.davit.carApplication.model.mapper;

import com.davit.carApplication.model.domain.Country;
import com.davit.carApplication.model.dto.CountryDTO;
import com.davit.carApplication.model.enums.CountryStatus;
import com.davit.carApplication.model.param.CountryCreateParam;

public class CountryMapper {

    public static CountryDTO mapCountryToDTO(Country country) {
        CountryDTO countryDTO = new CountryDTO();
        countryDTO.setName(country.getName());
        countryDTO.setRate(country.getRate());
        countryDTO.setCode(country.getCode());
        countryDTO.setId(countryDTO.getId());
        return countryDTO;
    }
    public static Country mapCountryToDTO(CountryCreateParam param) {
        Country country =new Country();
        country.setCode(param.getCode());
        country.setRate(param.getRate());
        country.setName(param.getName());
        country.setCountryStatus(CountryStatus.ACTIVE);
        return country;
    }
}
