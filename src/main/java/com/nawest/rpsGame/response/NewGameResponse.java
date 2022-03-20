package com.nawest.rpsGame.response;

import com.nawest.rpsGame.model.Player;
import com.nawest.rpsGame.model.Room;

public class NewGameResponse {
    private Room room;
    private Player player;

    public NewGameResponse(Room room, Player player) {
        this.room = room;
        this.player = player;
    }
}
