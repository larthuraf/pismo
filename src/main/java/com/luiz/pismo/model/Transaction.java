package com.luiz.pismo.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue
    @Column(name = "transaction_id", updatable = false, nullable = false)
    private long transactionId;

    @ManyToOne
    @JoinColumn(name = "account_id", updatable = false, nullable = false)
    private Account account;

    @ManyToOne
    @JoinColumn(name = "operation_type_id", updatable = false, nullable = false)
    private OperationType operationType;

    @Column(updatable = false, nullable = false)
    private double amount;

    @Column(name = "event_date", updatable = false, nullable = false)
    private Date eventDate;

    @Column(updatable = true, nullable = false)
    private double balance;

    public Transaction(long transactionId, Account account, OperationType operationType, double amount, Date eventDate, double balance) {
        this.transactionId = transactionId;
        this.account = account;
        this.operationType = operationType;
        this.amount = amount;
        this.eventDate = eventDate;
        this.balance = balance;
    }

    public Transaction(Account account, OperationType operationType, double amount, Date eventDate, double balance) {
        this.account = account;
        this.operationType = operationType;
        this.amount = amount;
        this.eventDate = eventDate;
        this.balance = balance;
    }

    public Transaction() {
    }

    public long getTransactionId() {
        return transactionId;
    }

    public Account getAccount() {
        return account;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public double getAmount() {
        return amount;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", account=" + account +
                ", operationType=" + operationType +
                ", amount=" + amount +
                ", eventDate=" + eventDate +
                ", balance=" + balance +
                '}';
    }
}
