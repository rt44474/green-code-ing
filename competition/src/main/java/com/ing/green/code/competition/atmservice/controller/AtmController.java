package com.ing.green.code.competition.atmservice.controller;

import com.ing.green.code.competition.atmservice.api.AtmsApi;
import com.ing.green.code.competition.atmservice.model.ATM;
import com.ing.green.code.competition.atmservice.model.Task;
import com.ing.green.code.competition.atmservice.service.AtmServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class AtmController implements AtmsApi {
    private final AtmServiceInterface atmServiceInterface;

    public AtmController(AtmServiceInterface atmServiceInterface) {
        this.atmServiceInterface = atmServiceInterface;
    }

    @Override
    public ResponseEntity<List<ATM>> calculate(List<Task> task) {
        return new ResponseEntity<>(atmServiceInterface.getListOfAtms(task), HttpStatus.OK);
    }
}
