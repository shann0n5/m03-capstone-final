package com.techelevator.service;

import com.techelevator.model.RentTransaction;

import java.security.Principal;
import java.util.List;

public interface RentTransactionService {
    List<RentTransaction> viewAllRentTransactions(Principal principal);
    List<RentTransaction> viewRentTransactionById(Principal principal, int rentTransactionId);

}
