package com.davit.carApplication.model.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class TradeInTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Model boughtCarModel;
    @ManyToOne
    private Country country;

    private LocalDateTime boughtTime;
    private Double payedAmount;
    private Double totalCost;
    private Double oldCarValue;
    private Model oldCarModel;
}
