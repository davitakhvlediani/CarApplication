package com.davit.carApplication.facade;

import com.davit.carApplication.model.domain.Car;
import com.davit.carApplication.model.domain.Country;
import com.davit.carApplication.model.domain.Model;
import com.davit.carApplication.model.dto.CarDTO;
import com.davit.carApplication.model.dto.CountryDTO;
import com.davit.carApplication.model.dto.ModelDTO;
import com.davit.carApplication.model.enums.CarStatus;
import com.davit.carApplication.model.mapper.CarMapper;
import com.davit.carApplication.model.mapper.CountryMapper;
import com.davit.carApplication.model.mapper.ModelMapper;
import com.davit.carApplication.model.param.CarCreateParam;
import com.davit.carApplication.model.param.CountryCreateParam;
import com.davit.carApplication.model.param.ModelCreateParam;
import com.davit.carApplication.service.CountryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CountryFacade {
    private final CountryService countryService;

    public CountryFacade(CountryService countryService) {
        this.countryService = countryService;
    }

    public Page<CountryDTO> getAllCountry(Pageable pageable){
        Page<Country> all = countryService.getAll(pageable);
        return   all.map(CountryMapper::mapCountryToDTO);
    }
    public CountryDTO getCountryById(Long id){
        Country country = countryService.get(id);
        return CountryMapper.mapCountryToDTO(country);
    }

    public CountryDTO saveCountry(CountryCreateParam param){
        Country country = CountryMapper.mapCountryToDTO(param);
        Country savedCountry = countryService.create(country);
        return CountryMapper.mapCountryToDTO(savedCountry);
    }
}

