package com.davit.carApplication.repostories;

import com.davit.carApplication.model.domain.UserTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTransactionRepository extends CommonRepository<UserTransaction> {
}
