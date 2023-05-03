package com.ing.green.code.competition.transactions.service.impl;

import com.ing.green.code.competition.TestData;
import com.ing.green.code.competition.transactions.model.Account;
import com.ing.green.code.competition.transactions.model.Transaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.util.List;

class TransactionsServiceTest {
    private final TransactionsService transactionsService = new TransactionsService();

    @ParameterizedTest
    @CsvSource({
            "transactions_example_request.json, transactions_example_response.json"
    })
    void testCreateReportCorrectly(String requestFileName, String responseFileName) throws IOException {
        List<Transaction> inputRequest = TestData.getExampleTransactionsRequest(Transaction.class, requestFileName);
        List<Account> expectedResponse = TestData.getExampleTransactionsResponse(Account.class, responseFileName);

        List<Account> actualResponse = transactionsService.createReport(inputRequest);

        Assertions.assertEquals(expectedResponse, actualResponse);
    }
}
