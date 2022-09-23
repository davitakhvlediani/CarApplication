package com.davit.carApplication.model.mapper;

import com.davit.carApplication.model.domain.TradeInTransaction;
import com.davit.carApplication.model.domain.UserTransaction;
import com.davit.carApplication.model.dto.TradeInTransactionDTO;
import com.davit.carApplication.model.dto.TransactionDto;

public class TradeInTransactionMapper {
    public static TradeInTransactionDTO mapTradeInTransactionToDTO(TradeInTransaction transaction){
        TradeInTransactionDTO transactionDto = new TradeInTransactionDTO();
        transactionDto.setId(transaction.getId());
        transactionDto.setBoughtTime(transaction.getBoughtTime());
        transactionDto.setPayedAmount(transaction.getPayedAmount());
        transactionDto.setTotalCost(transaction.getTotalCost());
        transactionDto.setCountryDTO(CountryMapper.mapCountryToDTO(transaction.getCountry()));
        transactionDto.setModelDTO(ModelMapper.mapModelToDTO(transaction.getBoughtCarModel()));
        transactionDto.setTradeInCar( ModelMapper.mapModelToDTO(transaction.getOldCarModel()));
        transactionDto.setTradeInCarPrice(transaction.getOldCarValue());
        transactionDto.setId(transactionDto.getId());
        return transactionDto;
    }
}
