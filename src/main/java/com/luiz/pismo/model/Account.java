package com.luiz.pismo.model;

import javax.persistence.*;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue
    @Column(name = "account_id", updatable = false, nullable = false)
    private long accountId;

    @Column(name = "document_number", updatable = false, nullable = false, unique = true)
    private String documentNumber;

    @Column(name = "available_credit_limit", updatable = true, nullable =  false)
    private double availableCreditLimit;


    public Account(long accountId, String documentNumber, double availableCreditLimit) {
        this.accountId = accountId;
        this.documentNumber = documentNumber;
        this.availableCreditLimit = availableCreditLimit;
    }

    public Account(String documentNumber, double availableCreditLimit) {
        this.documentNumber = documentNumber;
        this.availableCreditLimit = availableCreditLimit;
    }

    public Account() {
    }

    public long getAccountId() {
        return accountId;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public double getAvailableCreditLimit() {
        return availableCreditLimit;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", documentNumber='" + documentNumber + '\'' +
                ", availableCreditLimit=" + availableCreditLimit +
                '}';
    }

    public void setAvailableCreditLimit(double availableCreditLimit) {
        this.availableCreditLimit = availableCreditLimit;
    }
}
