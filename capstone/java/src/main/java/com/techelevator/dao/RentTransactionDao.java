package com.techelevator.dao;

import com.techelevator.model.RentTransaction;

import java.util.List;

public interface RentTransactionDao {

    List<RentTransaction> getRentTransactions();

    RentTransaction getRentTransactionById(int transactionId);

    List<RentTransaction> getRentTransactionsPastDue(boolean isPastDue);

    List<RentTransaction> getRentTransactionsByProperty(int propertyId);

    RentTransaction createRentTransaction(RentTransaction rentTransaction);

    RentTransaction updateRentTransaction(RentTransaction rentTransaction);

    int deleteRentTransactionById(int rentTransaction);
}
