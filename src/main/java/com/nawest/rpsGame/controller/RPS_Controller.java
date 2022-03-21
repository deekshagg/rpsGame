package com.nawest.rpsGame.controller;

import com.nawest.rpsGame.model.Player;
import com.nawest.rpsGame.request.JoinPlayerRequest;
import com.nawest.rpsGame.request.PlayGame;
import com.nawest.rpsGame.response.NewGameResponse;
import com.nawest.rpsGame.service.RPS_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/rps")
public class RPS_Controller {

    @Autowired
    private RPS_Service rps_service;

    @PostMapping("/start")
    public NewGameResponse startGame(@RequestBody final Player player){
        return rps_service.startGame(player);
    }

    @PostMapping("/join")
    public Player joinGame(@RequestBody final JoinPlayerRequest request) {
        return rps_service.joinGame(request);
    }

    @GetMapping("/play")
    public String runGame(@RequestBody final PlayGame playGame) {
        return rps_service.runGame(playGame);
    }

//    @GetMapping("/play/new/{gid}")
//    public String newGame(@RequestBody final )

}
