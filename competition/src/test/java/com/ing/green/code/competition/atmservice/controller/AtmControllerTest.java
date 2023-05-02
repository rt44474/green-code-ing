package com.ing.green.code.competition.atmservice.controller;

import com.ing.green.code.competition.atmservice.model.ATM;
import com.ing.green.code.competition.atmservice.model.Task;
import com.ing.green.code.competition.atmservice.service.AtmServiceInterface;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AtmControllerTest {
    private final AtmServiceInterface atmServiceInterface = mock(AtmServiceInterface.class);
    private final AtmController atmController = new AtmController(atmServiceInterface);

    @Test
    void testCalculate()
    {
        List<Task> tasks = new ArrayList<>();
        List<ATM> atms = new ArrayList<>();
        when(atmServiceInterface.getListOfAtms(tasks)).thenReturn(atms);

        ResponseEntity<List<ATM>> response = atmController.calculate(tasks);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(atms, response.getBody());
    }
}
