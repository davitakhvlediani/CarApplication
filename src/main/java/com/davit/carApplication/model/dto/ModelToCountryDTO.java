package com.davit.carApplication.model.dto;

import lombok.Data;

@Data
public class ModelToCountryDTO {

    private ModelDTO modelDTO;
    private CountryDTO countryDTO;
    private Long quantity;
    private Long id;
}
