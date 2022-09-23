package com.davit.carApplication.service;

import com.davit.carApplication.model.domain.TradeInTransaction;
import com.davit.carApplication.repostories.TradeInTransactionRepository;
import org.springframework.stereotype.Service;

@Service
public class TradeInTransactionService extends AbstractService<TradeInTransaction, TradeInTransactionRepository>{

    public TradeInTransactionService(TradeInTransactionRepository repository) {
        super(repository);
    }
}
