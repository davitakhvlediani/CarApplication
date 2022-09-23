package com.davit.carApplication.model.domain;

import com.davit.carApplication.model.enums.ModelToCountryStatus;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ModelToCountry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long quantity;

    @ManyToOne
    private Model model;
    @ManyToOne
    private Country country;


    @Enumerated(EnumType.STRING)
    private ModelToCountryStatus status;

    public void decrement(){
        this.quantity-=1;
    }
}
