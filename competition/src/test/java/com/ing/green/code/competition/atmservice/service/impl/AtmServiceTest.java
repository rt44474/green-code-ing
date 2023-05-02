package com.ing.green.code.competition.atmservice.service.impl;

import com.ing.green.code.competition.TestData;
import com.ing.green.code.competition.atmservice.model.ATM;
import com.ing.green.code.competition.atmservice.model.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.util.List;

class AtmServiceTest {

    private final AtmService atmService = new AtmService();

    @ParameterizedTest
    @CsvSource({
            "atm_service_example_request_1.json, atm_service_example_response_1.json",
            "atm_service_example_request_2.json, atm_service_example_response_2.json"
    })
    void testGetListOfAtmsCorrectly(String requestFileName, String responseFileName) throws IOException {
        List<Task> inputRequest = TestData.getExampleAtmRequest(Task.class, requestFileName);
        List<ATM> expectedResponse = TestData.getExampleAtmResponse(ATM.class, responseFileName);

        List<ATM> actualResponse = atmService.getListOfAtms(inputRequest);

        Assertions.assertEquals(expectedResponse, actualResponse);
    }
}
