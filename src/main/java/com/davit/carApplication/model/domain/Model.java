package com.davit.carApplication.model.domain;

import com.davit.carApplication.model.enums.CarStatus;
import com.davit.carApplication.model.enums.ModelStatus;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data

public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate releaseDate;
    private String color;
    private Double price;
    private ModelStatus modelStatus;

    @ManyToOne
    private Car car;

    @OneToMany(mappedBy = "model")
    private List<ModelToCountry> modelToCountries;
}
