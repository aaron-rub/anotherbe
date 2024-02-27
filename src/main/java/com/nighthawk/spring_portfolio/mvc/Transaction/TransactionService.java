package com.nighthawk.spring_portfolio.mvc.Transaction;

import java.util.List;

public interface TransactionService {
    Transaction addTransaction(Transaction transaction);
    List<Transaction> getAllTransactions();
}
