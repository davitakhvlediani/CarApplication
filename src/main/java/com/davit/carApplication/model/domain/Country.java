package com.davit.carApplication.model.domain;

import com.davit.carApplication.model.enums.CountryStatus;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double rate;
    private String code;
    @Enumerated(EnumType.STRING)
    private CountryStatus countryStatus;

    @OneToMany(mappedBy = "country")
    private List<ModelToCountry> modelToCountries;
}
