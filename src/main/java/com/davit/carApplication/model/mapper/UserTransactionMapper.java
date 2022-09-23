package com.davit.carApplication.model.mapper;

import com.davit.carApplication.model.domain.UserTransaction;
import com.davit.carApplication.model.dto.TransactionDto;

public class UserTransactionMapper {
    public static TransactionDto mapUserTransactionToDTO(UserTransaction transaction){
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setId(transaction.getId());
        transactionDto.setBoughtTime(transaction.getBoughtTime());
        transactionDto.setPayedAmount(transaction.getPayedAmount());
        transactionDto.setTotalCost(transaction.getTotalCost());
        transactionDto.setCountryDTO(CountryMapper.mapCountryToDTO(transaction.getCountry()));
    transactionDto.setModelDTO(ModelMapper.mapModelToDTO(transaction.getBoughtCarModel()));
    return transactionDto;
    }
}
