package com.ing.green.code.competition.onlinegame.service;

import com.ing.green.code.competition.onlinegame.model.Clan;
import com.ing.green.code.competition.onlinegame.model.Players;

import java.util.List;

public interface OnlineGameServiceInterface {
    List<List<Clan>> getClans(Players players);
}
