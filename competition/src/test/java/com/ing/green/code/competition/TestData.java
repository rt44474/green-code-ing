package com.ing.green.code.competition;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ing.green.code.competition.atmservice.model.ATM;
import com.ing.green.code.competition.atmservice.model.Task;

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
}
