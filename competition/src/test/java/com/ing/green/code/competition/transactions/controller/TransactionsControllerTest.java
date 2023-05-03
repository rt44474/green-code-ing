package com.ing.green.code.competition.transactions.controller;

import com.ing.green.code.competition.transactions.model.Account;
import com.ing.green.code.competition.transactions.model.Transaction;
import com.ing.green.code.competition.transactions.service.TransactionsServiceInterface;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TransactionsControllerTest {
    private final TransactionsServiceInterface transactionsServiceInterface = mock(TransactionsServiceInterface.class);

    private final TransactionController transactionController = new TransactionController(transactionsServiceInterface);

    @Test
    void reportCorrectly() {
        List<Account> accounts = new ArrayList<>();
        List<Transaction> transactions = new ArrayList<>();
        when(transactionsServiceInterface.createReport(transactions)).thenReturn(accounts);

        ResponseEntity<List<Account>> response = transactionController.report(transactions);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(accounts, response.getBody());
    }
}
