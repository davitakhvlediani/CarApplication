package com.davit.carApplication.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TradeInTransactionDTO extends TransactionDto {
    private Long id;

    public ModelDTO tradeInCar;
    public Double tradeInCarPrice;
}
