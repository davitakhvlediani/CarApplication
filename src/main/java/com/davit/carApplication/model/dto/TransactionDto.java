package com.davit.carApplication.model.dto;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class TransactionDto {
    private Long id;
    private LocalDateTime boughtTime;
    private Double payedAmount;
    private Double totalCost;

    private ModelDTO modelDTO;
    private CountryDTO countryDTO;
}
