package com.luiz.pismo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateTransactionDto {

    @JsonProperty(value = "account_id")
    private long accountId;

    @JsonProperty(value = "operation_type_id")
    private int operationTypeId;

    @JsonProperty()
    private double amount;


    public long getAccountId() {
        return accountId;
    }

    public int getOperationTypeId() {
        return operationTypeId;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "CreateTransactionDto{" +
                "accountId=" + accountId +
                ", operationTypeId=" + operationTypeId +
                ", amount=" + amount +
                '}';
    }

    public boolean isValid() {
        return true;
    }
}
