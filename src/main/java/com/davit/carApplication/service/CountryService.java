package com.davit.carApplication.service;

import com.davit.carApplication.model.domain.Country;
import com.davit.carApplication.repostories.CountryRepository;
import org.springframework.stereotype.Service;

@Service
public class CountryService extends AbstractService<Country, CountryRepository> {


    public CountryService(CountryRepository repository) {
        super(repository);
    }
}
