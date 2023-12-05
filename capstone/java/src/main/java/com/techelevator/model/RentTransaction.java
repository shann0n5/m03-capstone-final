package com.techelevator.model;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

public class RentTransaction {
    @NotNull( message = "The field 'transactionId' is required.")
    private int transactionId;
    @NotNull( message = "The field 'amount' is required.")
    private BigDecimal amount;
    @NotNull( message = "The field 'dueDate' is required.")
    private Date dueDate;
    @NotNull( message = "The field 'pastDue' is required.")
    private boolean pastDue;

    public RentTransaction() {}

    public RentTransaction(int transactionId, BigDecimal amount, Date dueDate, boolean pastDue) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.dueDate = dueDate;
        this.pastDue = pastDue;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isPastDue() {
        return pastDue;
    }

    public void setPastDue(boolean pastDue) {
        this.pastDue = pastDue;
    }
}
