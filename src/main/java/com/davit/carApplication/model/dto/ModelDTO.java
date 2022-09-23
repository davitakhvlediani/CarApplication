package com.davit.carApplication.model.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ModelDTO {

    private String name;

    private LocalDate releaseDate;

    private String color;

    private Double price;
    private Double tradeInPercent;

}
