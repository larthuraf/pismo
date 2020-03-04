package com.luiz.pismo.controller;

import com.luiz.pismo.dto.AccountDto;
import com.luiz.pismo.dto.CreateAccountDto;
import com.luiz.pismo.dto.CreateTransactionDto;
import com.luiz.pismo.exception.AccountNotFoundException;
import com.luiz.pismo.exception.InvalidDocumentNumberException;
import com.luiz.pismo.exception.InvalidTransactionException;
import com.luiz.pismo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class AccountController {

    private final AccountService service;

    @Autowired
    public AccountController(AccountService service) {
        this.service = service;
    }


    @PostMapping(value = "/accounts")
    void createAccount(@RequestBody CreateAccountDto createAccountDto){
        try{
            service.createAccount(createAccountDto);
        }catch (InvalidDocumentNumberException idne){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, idne.getMessage());
        }
        catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/accounts/{accountId}")
    AccountDto getAccountDetail(@PathVariable long accountId){
        try{
            return service.fetchAccount(accountId);
        }catch (AccountNotFoundException anfe){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, anfe.getMessage());
        }
        catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping(value = "/transactions")
    void createTransaction(@RequestBody CreateTransactionDto transactionDto){
        try{
            service.createTransaction(transactionDto);
        }catch (InvalidTransactionException ite){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ite.getMessage());
        }
        catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
