package com.luiz.pismo.repository;

import com.luiz.pismo.model.Transaction;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransactionRepository  extends CrudRepository<Transaction, Long> {

}
