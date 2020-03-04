package com.luiz.pismo.repository;

import com.luiz.pismo.model.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository  extends CrudRepository<Transaction, Long> {
}
