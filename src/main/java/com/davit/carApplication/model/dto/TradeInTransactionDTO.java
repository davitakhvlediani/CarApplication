package com.davit.carApplication.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TradeInTransactionDTO extends TransactionDto {

    public ModelDTO tradeInCar;
    public Double tradeInCarPrice;
}
