package com.davit.carApplication.repostories;

import com.davit.carApplication.model.domain.TradeInTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradeInTransactionRepository extends CommonRepository<TradeInTransaction> {
}
