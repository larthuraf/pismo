package com.luiz.pismo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountDto {

    @JsonProperty("account_id")
    private final long accountId;

    @JsonProperty("document_number")
    private final String documentNumber;

    @JsonProperty("available_credit_limit")
    private final double availableCreditLimit;

    public AccountDto(long accountId, String documentNumber, double availableCreditLimit) {
        this.accountId = accountId;
        this.documentNumber = documentNumber;
        this.availableCreditLimit = availableCreditLimit;
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
}
