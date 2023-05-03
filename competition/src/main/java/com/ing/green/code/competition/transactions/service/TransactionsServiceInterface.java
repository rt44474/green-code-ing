package com.ing.green.code.competition.transactions.service;

import com.ing.green.code.competition.transactions.model.Account;
import com.ing.green.code.competition.transactions.model.Transaction;

import java.util.List;

public interface TransactionsServiceInterface {
    List<Account> createReport(List<Transaction> transactions);
}
