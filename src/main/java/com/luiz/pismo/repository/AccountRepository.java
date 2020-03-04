package com.luiz.pismo.repository;

import com.luiz.pismo.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {

    boolean existsByDocumentNumber(String documentNumber);
}
