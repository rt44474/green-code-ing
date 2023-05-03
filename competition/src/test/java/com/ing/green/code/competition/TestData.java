package com.ing.green.code.competition;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ing.green.code.competition.atmservice.model.ATM;
import com.ing.green.code.competition.atmservice.model.Task;
import com.ing.green.code.competition.onlinegame.model.Clan;
import com.ing.green.code.competition.onlinegame.model.Players;
import com.ing.green.code.competition.transactions.model.Account;
import com.ing.green.code.competition.transactions.model.Transaction;

import java.io.IOException;
import java.util.List;

public class TestData {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static List<Task> getExampleAtmRequest(Class<?> clazz, String fileName) throws IOException {
        return objectMapper.readValue(
                clazz.getClassLoader().getResourceAsStream("testrequests/" + fileName),
                new TypeReference<>() {
                }
        );
    }

    public static List<ATM> getExampleAtmResponse(Class<?> clazz, String fileName) throws IOException {
        return objectMapper.readValue(
                clazz.getClassLoader().getResourceAsStream("testresponses/" + fileName),
                new TypeReference<>() {
                }
        );
    }

    public static Players getExampleOnlineGameRequest(Class<?> clazz, String fileName) throws IOException {
        return objectMapper.readValue(
                clazz.getClassLoader().getResourceAsStream("testrequests/" + fileName),
                new TypeReference<>() {
                }
        );
    }

    public static List<List<Clan>> getExampleOnlineGameResponse(Class<?> clazz, String fileName) throws IOException {
        return objectMapper.readValue(
                clazz.getClassLoader().getResourceAsStream("testresponses/" + fileName),
                new TypeReference<>() {
                }
        );
    }

    public static List<Transaction> getExampleTransactionsRequest(Class<?> clazz, String fileName) throws IOException {
        return objectMapper.readValue(
                clazz.getClassLoader().getResourceAsStream("testrequests/" + fileName),
                new TypeReference<>() {
                }
        );
    }

    public static List<Account> getExampleTransactionsResponse(Class<?> clazz, String fileName) throws IOException {
        return objectMapper.readValue(
                clazz.getClassLoader().getResourceAsStream("testresponses/" + fileName),
                new TypeReference<>() {
                }
        );
    }

    public static List<Task> createTaskList() {
        Task firstTask = createTask(1, Task.RequestTypeEnum.STANDARD, 1);
        Task secondTask = createTask(1, Task.RequestTypeEnum.STANDARD, 2);
        Task thirdTask = createTask(2, Task.RequestTypeEnum.PRIORITY, 1);
        return List.of(firstTask, secondTask, thirdTask);
    }

    public static List<ATM> createAtmList() {
        ATM firstATM = createAtm(1, 1);
        ATM secondATM = createAtm(1, 2);
        ATM thirdATM = createAtm(2, 1);
        return List.of(firstATM, secondATM, thirdATM);
    }

    private static ATM createAtm(Integer region, Integer atmId) {
        ATM atm = new ATM();
        atm.setRegion(region);
        atm.setAtmId(atmId);
        return atm;
    }

    private static Task createTask(Integer region, Task.RequestTypeEnum requestTypeEnum, Integer atmId) {
        Task task = new Task();
        task.setRegion(region);
        task.setRequestType(requestTypeEnum);
        task.setAtmId(atmId);
        return task;
    }
}
