package com.ing.green.code.competition.transactions.service.impl;

import com.ing.green.code.competition.transactions.model.Account;
import com.ing.green.code.competition.transactions.model.Transaction;
import com.ing.green.code.competition.transactions.service.TransactionsServiceInterface;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
public class TransactionsService implements TransactionsServiceInterface {
    @Override
    public List<Account> createReport(List<Transaction> transactions) {
        ConcurrentHashMap<String, Account> accountsMap = new ConcurrentHashMap<>();

        transactions.parallelStream().forEach(transaction -> {
            updateDebitAccount(accountsMap, transaction);
            updateCreditAccount(accountsMap, transaction);
        });

        return formatAndSortAccounts(accountsMap.values());
    }

    private List<Account> formatAndSortAccounts(Collection<Account> accounts) {
        NumberFormat nf = NumberFormat.getInstance(Locale.US);
        nf.setMaximumFractionDigits(2);
        nf.setMinimumFractionDigits(2);

        return accounts.stream()
                .peek(account -> account.setBalance(Float.parseFloat(nf.format(account.getBalance()))))
                .sorted(Comparator.comparing(Account::getAccount))
                .collect(Collectors.toList());
    }

    private void updateDebitAccount(ConcurrentHashMap<String, Account> accountsMap, Transaction transaction) {
        String debitAccount = transaction.getDebitAccount();
        Account debitAcc = accountsMap.getOrDefault(debitAccount, createNewAccount(debitAccount));

        debitAcc.setDebitCount(debitAcc.getDebitCount() + 1);
        debitAcc.setBalance(debitAcc.getBalance() - transaction.getAmount());

        accountsMap.put(debitAccount, debitAcc);
    }

    private void updateCreditAccount(ConcurrentHashMap<String, Account> accountsMap, Transaction transaction) {
        String creditAccount = transaction.getCreditAccount();
        Account creditAcc = accountsMap.getOrDefault(creditAccount, createNewAccount(creditAccount));

        creditAcc.setCreditCount(creditAcc.getCreditCount() + 1);
        creditAcc.setBalance(creditAcc.getBalance() + transaction.getAmount());

        accountsMap.put(creditAccount, creditAcc);
    }

    private Account createNewAccount(String accountName) {
        Account account = new Account();
        account.setAccount(accountName);
        account.setDebitCount(0);
        account.setCreditCount(0);
        account.setBalance(0.00f);
        return account;
    }
}
