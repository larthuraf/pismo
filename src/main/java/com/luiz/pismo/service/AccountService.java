package com.luiz.pismo.service;

import com.luiz.pismo.dto.AccountDto;
import com.luiz.pismo.dto.CreateAccountDto;
import com.luiz.pismo.dto.CreateTransactionDto;
import com.luiz.pismo.exception.AccountNotFoundException;
import com.luiz.pismo.exception.InvalidDocumentNumberException;
import com.luiz.pismo.exception.InvalidTransactionException;
import com.luiz.pismo.model.Account;
import com.luiz.pismo.model.OperationType;
import com.luiz.pismo.model.Transaction;
import com.luiz.pismo.repository.AccountRepository;
import com.luiz.pismo.repository.OperationTypeRepository;
import com.luiz.pismo.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class AccountService {

    private final OperationTypeRepository typeRepository;
    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    @Autowired
    public AccountService(OperationTypeRepository typeRepository,
                          AccountRepository accountRepository,
                          TransactionRepository transactionRepository) {

        this.typeRepository = typeRepository;
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }


    public void createAccount(CreateAccountDto accountDto) {
        if (!accountDto.isValid())
            throw new InvalidDocumentNumberException("Invalid Document Number " + accountDto.getDocumentNumber());

        if (accountRepository.existsByDocumentNumber(accountDto.getDocumentNumber()))
            throw new InvalidDocumentNumberException("Cannot create account for Document Number " + accountDto.getDocumentNumber());

        Account account = new Account(accountDto.getDocumentNumber());
        accountRepository.save(account);
        System.out.println("Created account " + account);
    }



    public AccountDto fetchAccount(long accountId) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new AccountNotFoundException("Account Id " + accountId + " not found!"));
        return new AccountDto(account.getAccountId(), account.getDocumentNumber());
    }



    public void createTransaction(CreateTransactionDto transactionDto) {
        OperationType operationType = typeRepository.findById(transactionDto.getOperationTypeId())
                .orElseThrow(()-> new InvalidTransactionException("Invalid Operation Type"));

        Account account = accountRepository.findById(transactionDto.getAccountId())
                .orElseThrow(()-> new InvalidTransactionException("Invalid Account Id"));

        double amount = Math.abs(transactionDto.getAmount());
        if (operationType.isNegative()) amount *= -1;

        Transaction transaction = new Transaction(account, operationType, amount, new Date());
        transactionRepository.save(transaction);
        System.out.println("Created transaction " + transaction);

    }
}
