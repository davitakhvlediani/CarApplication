package com.davit.carApplication.model.domain;


import com.davit.carApplication.model.enums.CarStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data

public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    @Enumerated(EnumType.STRING)
    private CarStatus carStatus;
    @OneToMany(mappedBy = "car")
    private List<Model> models;

}
