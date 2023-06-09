package com.ing.green.code.competition.onlinegame.service.impl;

import com.ing.green.code.competition.onlinegame.model.Clan;
import com.ing.green.code.competition.onlinegame.model.Players;
import com.ing.green.code.competition.onlinegame.service.OnlineGameServiceInterface;
import com.ing.green.code.competition.onlinegame.validation.OnlineGameValidator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

@Service
public class OnlineGameService implements OnlineGameServiceInterface {

    @Override
    public List<List<Clan>> getClans(Players players) {
        List<List<Clan>> result = new ArrayList<>();
        int maxNumberOfPlayers = players.getGroupCount();
        LinkedList<Clan> queue = new LinkedList<>(sortClans(players.getClans()));

        OnlineGameValidator.validateInputs(players, queue);

        while (!queue.isEmpty()) {
            List<Clan> clans = new ArrayList<>();
            int currentNumberOfPlayers = queue.get(0).getNumberOfPlayers();
            clans.add(queue.removeFirst());

            addClansToGroup(queue, clans, currentNumberOfPlayers, maxNumberOfPlayers);

            result.add(clans);
        }
        return result;
    }

    private void addClansToGroup(List<Clan> queue, List<Clan> clans, int currentNumberOfPlayers, int maxNumberOfPlayers) {
        for (Clan clan : queue) {
            if (currentNumberOfPlayers + clan.getNumberOfPlayers() <= maxNumberOfPlayers) {
                currentNumberOfPlayers += clan.getNumberOfPlayers();
                clans.add(clan);
            }
            if (currentNumberOfPlayers == maxNumberOfPlayers) {
                break;
            }
        }
        queue.removeAll(clans);
    }

    private List<Clan> sortClans(List<Clan> clans) {
        return clans.stream()
                .sorted(Comparator.comparingInt(Clan::getPoints).reversed()
                        .thenComparingInt(Clan::getNumberOfPlayers))
                .toList();
    }


}
