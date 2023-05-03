package com.ing.green.code.competition.onlinegame.controller;

import com.ing.green.code.competition.onlinegame.model.Clan;
import com.ing.green.code.competition.onlinegame.model.Players;
import com.ing.green.code.competition.onlinegame.service.OnlineGameServiceInterface;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class OnlineGameControllerTest {
    private final OnlineGameServiceInterface onlineGameServiceInterface = mock(OnlineGameServiceInterface.class);
    private final OnlineGameController onlineGameController = new OnlineGameController(onlineGameServiceInterface);

    @Test
    void testCalculate() {
        Players players = new Players();
        List<List<Clan>> clans = new ArrayList<>();
        when(onlineGameServiceInterface.getClans(players)).thenReturn(clans);

        ResponseEntity<List<List<Clan>>> response = onlineGameController.calculate(players);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(clans, response.getBody());
    }
}
