package com.ing.green.code.competition.transactions.controller;

import com.ing.green.code.competition.transactions.api.TransactionsApi;
import com.ing.green.code.competition.transactions.model.Account;
import com.ing.green.code.competition.transactions.model.Transaction;
import com.ing.green.code.competition.transactions.service.TransactionsServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class TransactionController implements TransactionsApi {
    private final TransactionsServiceInterface transactionsServiceInterface;

    public TransactionController(TransactionsServiceInterface transactionsServiceInterface) {
        this.transactionsServiceInterface = transactionsServiceInterface;
    }

    @Override
    public ResponseEntity<List<Account>> report(List<Transaction> transaction) {
        return new ResponseEntity<>(transactionsServiceInterface.createReport(transaction), HttpStatus.OK);
    }
}
