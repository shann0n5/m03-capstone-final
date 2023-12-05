package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.RentTransaction;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcRentTransactionDao implements RentTransactionDao {

    private JdbcTemplate jdbcTemplate;

    private List<RentTransaction> rentTransactions = new ArrayList<>();

    public JdbcRentTransactionDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<RentTransaction> getRentTransactions() {
        List<RentTransaction> rentTransactions = new ArrayList<>();

        String sql = "SELECT transaction_id, amount, due_date, past_due " +
                "FROM rent_transactions;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                rentTransactions.add(mapRowToTransfer(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return rentTransactions;
    }

    @Override
    public RentTransaction getRentTransactionById(int transactionId) {
        RentTransaction rentTransaction = null;
        String sql = "SELECT transaction_id, amount, due_date, past_due " +
                "FROM rent_transactions " +
                "WHERE transaction_id = ?"
    }

    @Override
    public List<RentTransaction> getRentTransactionsPastDue(boolean isPastDue)

    @Override
    public List<RentTransaction> getRentTransactionsByProperty(int propertyId)

    @Override
    public RentTransaction createRentTransaction(RentTransaction rentTransaction)

    @Override
    public RentTransaction updateRentTransaction(RentTransaction rentTransaction) {

    }

    @Override
    public int deleteRentTransactionById(int transactionId) {
        int rowsAffected;
        String sql = "DELETE FROM rent_transactions WHERE transaction_id = ?;";
        try {
            rowsAffected = jdbcTemplate.update(sql, transactionId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return rowsAffected;
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
