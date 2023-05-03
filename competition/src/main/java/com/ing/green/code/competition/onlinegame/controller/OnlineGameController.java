package com.ing.green.code.competition.onlinegame.controller;

import com.ing.green.code.competition.onlinegame.api.OnlinegameApi;
import com.ing.green.code.competition.onlinegame.model.Clan;
import com.ing.green.code.competition.onlinegame.model.Players;
import com.ing.green.code.competition.onlinegame.service.OnlineGameServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class OnlineGameController implements OnlinegameApi {
    private final OnlineGameServiceInterface onlineGameServiceInterface;

    public OnlineGameController(OnlineGameServiceInterface onlineGameServiceInterface) {
        this.onlineGameServiceInterface = onlineGameServiceInterface;
    }

    @Override
    public ResponseEntity<List<List<Clan>>> calculate(Players players) {
        return new ResponseEntity<>(onlineGameServiceInterface.getClans(players), HttpStatus.OK);
    }
}
