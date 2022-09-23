package com.davit.carApplication.model.param;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ModelCreateParam {
    private LocalDate releaseDate;
    private String color;
    private Double price;
    private String name;
}
