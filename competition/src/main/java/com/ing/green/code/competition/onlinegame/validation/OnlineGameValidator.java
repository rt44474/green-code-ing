package com.ing.green.code.competition.onlinegame.validation;

import com.ing.green.code.competition.onlinegame.model.Clan;
import com.ing.green.code.competition.onlinegame.model.Players;

import java.util.List;

public class OnlineGameValidator {
    private static final int MIN_GROUP_COUNT = 1;
    private static final int MAX_GROUP_COUNT = 1000;
    private static final int MIN_NUMBER_OF_PLAYERS = 1;
    private static final int MAX_NUMBER_OF_PLAYERS = 1000;
    private static final int MIN_TOTAL_POINTS = 1;
    private static final int MAX_TOTAL_POINTS = 100000;

    public static void validateInputs(Players players, List<Clan> queue) {
        validateGroupCount(players.getGroupCount());
        for (Clan clan : queue) {
            validateNumberOfPlayers(clan.getNumberOfPlayers());
            validateTotalPoints(clan.getPoints());
        }
    }

    private static void validateGroupCount(int groupCount) {
        if (groupCount < MIN_GROUP_COUNT || groupCount > MAX_GROUP_COUNT) {
            throw new IllegalArgumentException("Group count must be between 1 and 1000.");
        }
    }

    private static void validateNumberOfPlayers(int numberOfPlayers) {
        if (numberOfPlayers < MIN_NUMBER_OF_PLAYERS || numberOfPlayers > MAX_NUMBER_OF_PLAYERS) {
            throw new IllegalArgumentException("Number of players must be between 1 and 1000.");
        }
    }

    private static void validateTotalPoints(int totalPoints) {
        if (totalPoints < MIN_TOTAL_POINTS || totalPoints > MAX_TOTAL_POINTS) {
            throw new IllegalArgumentException("Total points must be between 1 and 100000.");
        }
    }
}
