package com.ing.green.code.competition.onlinegame.validation;

import com.ing.green.code.competition.TestData;
import com.ing.green.code.competition.onlinegame.model.Clan;
import com.ing.green.code.competition.onlinegame.model.Players;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

class OnlineGameValidatorTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 1001})
    void shouldThrowExceptionWhenWrongGroupCount(int invalidGroupCount)
    {
        Players players = TestData.createPlayers(invalidGroupCount);
        List<Clan> clans = players.getClans();

        Assertions.assertThrows(IllegalArgumentException.class, () -> OnlineGameValidator.validateInputs(players, clans));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 1001})
    void shouldThrowExceptionWhenWrongNumberOfPlayers(int invalidNumberOfPlayers)
    {
        Players players = TestData.createPlayers(1);
        List<Clan> clans = List.of(TestData.createClan(invalidNumberOfPlayers, 1));

        Assertions.assertThrows(IllegalArgumentException.class, () -> OnlineGameValidator.validateInputs(players, clans));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 100001})
    void shouldThrowExceptionWhenWrongPoints(int invalidPoints)
    {
        Players players = TestData.createPlayers(1);
        List<Clan> clans = List.of(TestData.createClan(1, invalidPoints));

        Assertions.assertThrows(IllegalArgumentException.class, () -> OnlineGameValidator.validateInputs(players, clans));
    }
}
