package com.luiz.pismo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountDto {

    @JsonProperty("account_id")
    private final long accountId;

    @JsonProperty("document_number")
    private final String documentNumber;

    public AccountDto(long accountId, String documentNumber) {
        this.accountId = accountId;
        this.documentNumber = documentNumber;
    }


    public long getAccountId() {
        return accountId;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }
}
