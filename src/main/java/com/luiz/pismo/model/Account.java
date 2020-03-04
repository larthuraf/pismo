package com.luiz.pismo.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue
    @Column(name = "account_id", updatable = false, nullable = false)
    private long accountId;

    @Column(name = "document_number", updatable = false, nullable = false, unique = true)
    private String documentNumber;


    public Account(long accountId, String documentNumber) {
        this.accountId = accountId;
        this.documentNumber = documentNumber;
    }

    public Account(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public Account() {
    }

    public long getAccountId() {
        return accountId;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", documentNumber=" + documentNumber +
                '}';
    }
}
