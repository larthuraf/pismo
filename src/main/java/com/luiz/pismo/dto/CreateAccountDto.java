package com.luiz.pismo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateAccountDto {

    @JsonProperty(value = "document_number")
    private String documentNumber;

    public String getDocumentNumber() {
        return documentNumber;
    }

    public boolean isValid() {
        return documentNumber != null && !documentNumber.isEmpty();
    }

    public CreateAccountDto(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public CreateAccountDto() {
    }
}
