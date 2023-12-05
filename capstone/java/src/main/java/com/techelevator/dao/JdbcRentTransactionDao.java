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
                "WHERE transaction_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, transactionId);
            if (results.next()) {
                rentTransaction = mapRowToTransfer(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return rentTransaction;
    }

    @Override
    public List<RentTransaction> getRentTransactionsPastDue(boolean isPastDue) {
        List<RentTransaction> rentTransactions = new ArrayList<>();
        String sql = "SELECT transaction_id, amount, due_date, past_due " +
                "FROM rent_transactions " +
                "WHERE past_due = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, isPastDue);
            while (results.next()) {
                RentTransaction rentTransaction = mapRowToTransfer(results);
                rentTransactions.add(rentTransaction);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return rentTransactions;
    }

    @Override
    public List<RentTransaction> getRentTransactionsByProperty(int propertyId) {
        List<RentTransaction> rentTransactions = new ArrayList<>();
        String sql = "SELECT transaction_id, amount, due_date, past_due " +
                "FROM rent_transactions rt " +
                "JOIN tenant_rent_transactions trt ON rt.transaction_id = trt.transaction_id " +
                "JOIN user_properties up ON trt.tenant = up.user_id " +
                "JOIN properties p ON up.property_id = p.property_id " +
                "WHERE property_id = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, propertyId);
            while (results.next()) {
                RentTransaction rentTransaction = mapRowToTransfer(results);
                rentTransactions.add(rentTransaction);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return rentTransactions;
    }

    @Override
    public RentTransaction createRentTransaction(RentTransaction rentTransaction) {
        RentTransaction newRentTransaction = null;
        String sql = "INSERT INTO rent_transactions (amount, due_date, past_due) " +
                "VALUES (?, ?, ?) RETURNING transaction_id;";
        try {
            int newRentTransactionId = jdbcTemplate.queryForObject(sql, int.class, rentTransaction.getAmount(), rentTransaction.getDueDate(), rentTransaction.isPastDue());
            newRentTransaction = getRentTransactionById(newRentTransactionId);

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return newRentTransaction;
    }

    @Override
    public RentTransaction updateRentTransaction(RentTransaction rentTransaction) {
        RentTransaction updatedRentTransaction = null;
        String sql = "UPDATE rent_transactions SET amount = ?, due_date = ?, past_due = ? " +
                "WHERE transaction_id = ?;";
        try {
            int numberOfRows = jdbcTemplate.update(sql, rentTransaction.getAmount(),
                    rentTransaction.getDueDate(), rentTransaction.isPastDue(), rentTransaction.getTransactionId());
            if (numberOfRows == 0) {
                throw new DaoException("Zero rows affected, expected at least one");
            } else {
                updatedRentTransaction = getRentTransactionById(rentTransaction.getTransactionId());
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return updatedRentTransaction;
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
        RentTransaction rentTransaction = new RentTransaction();
        rentTransaction.setTransactionId(results.getInt("transaction_id"));
        rentTransaction.setAmount(results.getBigDecimal("amount"));
        rentTransaction.setDueDate(results.getDate("due_date"));
        rentTransaction.setPastDue(results.getBoolean("past_due"));
        return rentTransaction;
    }
}
