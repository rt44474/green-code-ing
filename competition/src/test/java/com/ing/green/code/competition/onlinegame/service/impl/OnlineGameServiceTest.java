package com.ing.green.code.competition.onlinegame.service.impl;

import com.ing.green.code.competition.TestData;
import com.ing.green.code.competition.onlinegame.model.Clan;
import com.ing.green.code.competition.onlinegame.model.Players;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.util.List;

class OnlineGameServiceTest {
    private final OnlineGameService onlineGameService = new OnlineGameService();

    @ParameterizedTest
    @CsvSource({
            "online_game_example_request.json, online_game_example_response.json"
    })
    void testGetClansCorrectly(String requestFileName, String responseFileName) throws IOException {
        Players inputRequest = TestData.getExampleOnlineGameRequest(Players.class, requestFileName);
        List<List<Clan>> expectedResponse = TestData.getExampleOnlineGameResponse(Clan.class, responseFileName);

        List<List<Clan>> actualResponse = onlineGameService.getClans(inputRequest);

        Assertions.assertEquals(expectedResponse, actualResponse);
    }
}
