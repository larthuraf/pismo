package com.luiz.pismo.service;

import com.luiz.pismo.dto.AccountDto;
import com.luiz.pismo.dto.CreateAccountDto;
import com.luiz.pismo.dto.CreateTransactionDto;
import com.luiz.pismo.exception.AccountNotFoundException;
import com.luiz.pismo.exception.InvalidDocumentNumberException;
import com.luiz.pismo.exception.InvalidTransactionException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AccountServiceTest {


    @Autowired
    private AccountService service;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    public void accountServiceShouldBeNotNull(){
        assertNotNull(service);
    }

    @Test
    void createAccountWithSuccess() {
        long accountId = service.createAccount(new CreateAccountDto("12345678900"));
        assertTrue(accountId > 0);
    }

    @Test
    void createAccountWithNullDocumentIdShouldThrowError() {
        assertThrows(InvalidDocumentNumberException.class,
                ()-> service.createAccount(new CreateAccountDto(null)));
    }

    @Test
    void createAccountWithEmptyDocumentIdShouldThrowError() {
        assertThrows(InvalidDocumentNumberException.class,
                ()-> service.createAccount(new CreateAccountDto("")));
    }

    @Test
    void createAccountWithDuplicatedDocumentIdShouldThrowError() {
        service.createAccount(new CreateAccountDto("12345678901"));
        assertThrows(InvalidDocumentNumberException.class,
                ()-> service.createAccount(new CreateAccountDto("12345678901")));
    }

    @Test
    void fetchAccountWithSuccess() {
        long accountId = service.createAccount(new CreateAccountDto("12345678902"));
        AccountDto account = service.fetchAccount(accountId);
        assertTrue(account != null && account.getAccountId() == accountId);
    }

    @Test
    void fetchAccountWithNotExistingIdShouldThrowError() {
        assertThrows(AccountNotFoundException.class,
                ()-> service.fetchAccount(0));
    }

    @Test
    void createTransactionWithSuccess() {
        long accountId = service.createAccount(new CreateAccountDto("12345678903"));
        long transactionId = service.createTransaction(new CreateTransactionDto(accountId, 1, 75.84));
        assertTrue(transactionId > 0);
    }

    @Test
    void createTransactionWithNotExistingAccountIdShouldThrowError() {
        assertThrows(InvalidTransactionException.class,
                ()-> service.createTransaction(new CreateTransactionDto(0, 1, 75.84)));
    }

    @Test
    void createTransactionWithNotExistingOperationTypeIdShouldThrowError() {
        long accountId = service.createAccount(new CreateAccountDto("12345678904"));
        assertThrows(InvalidTransactionException.class,
                ()-> service.createTransaction(new CreateTransactionDto(accountId, 0, 75.84)));
    }
}