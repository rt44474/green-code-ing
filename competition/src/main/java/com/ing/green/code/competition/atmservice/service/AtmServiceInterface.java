package com.ing.green.code.competition.atmservice.service;

import com.ing.green.code.competition.atmservice.model.ATM;
import com.ing.green.code.competition.atmservice.model.Task;

import java.util.List;

public interface AtmServiceInterface {

    List<ATM> getListOfAtms(List<Task> tasks);
}
