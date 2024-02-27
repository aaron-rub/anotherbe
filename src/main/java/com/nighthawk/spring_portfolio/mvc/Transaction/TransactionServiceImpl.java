package com.nighthawk.spring_portfolio.mvc.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionRepository repository;

    @Override
    public Transaction addTransaction(Transaction transaction) {
        transaction.setTimestamp(LocalDateTime.now());
        return repository.save(transaction);
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return repository.findAll();
    }
}
