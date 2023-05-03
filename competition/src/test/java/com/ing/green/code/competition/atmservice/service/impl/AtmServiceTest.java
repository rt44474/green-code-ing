package com.ing.green.code.competition.atmservice.service.impl;

import com.ing.green.code.competition.TestData;
import com.ing.green.code.competition.atmservice.model.ATM;
import com.ing.green.code.competition.atmservice.model.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
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

    @Test
    void testCreateTaskLinkedMap() {
        List<Task> tasks = TestData.createTaskList();
        List<ATM> expectedAtms = TestData.createAtmList();
        List<ATM> actualAtms = atmService.getListOfAtms(tasks);

        Assertions.assertAll(
                () -> Assertions.assertEquals(expectedAtms.get(0).getAtmId(), actualAtms.get(0).getAtmId()),
                () -> Assertions.assertEquals(expectedAtms.get(0).getRegion(), actualAtms.get(0).getRegion()),
                () -> Assertions.assertEquals(expectedAtms.get(1).getAtmId(), actualAtms.get(1).getAtmId()),
                () -> Assertions.assertEquals(expectedAtms.get(1).getRegion(), actualAtms.get(1).getRegion()),
                () -> Assertions.assertEquals(expectedAtms.get(2).getAtmId(), actualAtms.get(2).getAtmId()),
                () -> Assertions.assertEquals(expectedAtms.get(2).getRegion(), actualAtms.get(2).getRegion())
        );
    }
}
