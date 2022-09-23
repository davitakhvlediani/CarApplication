package com.davit.carApplication.model.domain;


import com.davit.carApplication.model.enums.CarStatus;
import lombok.Data;
import org.hibernate.annotations.Cascade;

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

    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    private List<Model> models;

}
