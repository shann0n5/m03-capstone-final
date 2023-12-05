package com.techelevator.dao;

import com.techelevator.model.RentTransaction;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.List;

public class JdbcRentTransactionDao implements RentTransactionDao {
    public List<RentTransaction> getRentTransactions() {

    }

    public RentTransaction getRentTransactionById(int transactionId)

    public List<RentTransaction> getRentTransactionsPastDue(boolean isPastDue)

    public List<RentTransaction> getRentTransactionsByProperty(int propertyId)

    public RentTransaction createRentTransaction(RentTransaction rentTransaction)

    public RentTransaction updateRentTransaction(RentTransaction rentTransaction)

    public int deleteRentTransactionById(int rentTransaction) {

    }

    private RentTransaction mapRowToTransfer(SqlRowSet results) {
        RentTransaction rentTransaction = new RentTransaction(
                results.getInt("transaction_id"),
                results.getBigDecimal("amount"),
                results.getDate("due_date"),
                results.getBoolean("past_due"));
        return rentTransaction;
    }
}
