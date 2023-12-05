package com.techelevator.service;

import com.techelevator.model.RentTransaction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
public class RentTransactionServiceImpl implements RentTransactionService{
    @Override
    public List<RentTransaction> viewAllRentTransactions(Principal principal) {
        return null;
    }

    @Override
    public List<RentTransaction> viewRentTransactionById(Principal principal, int rentTransactionId) {
        return null;
    }
}
