package com.davit.carApplication.service;

import com.davit.carApplication.model.domain.UserTransaction;
import com.davit.carApplication.repostories.UserTransactionRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class UserTransactionService extends AbstractService<UserTransaction, UserTransactionRepository> {

    public UserTransactionService(UserTransactionRepository repository) {
        super(repository);
    }
}
