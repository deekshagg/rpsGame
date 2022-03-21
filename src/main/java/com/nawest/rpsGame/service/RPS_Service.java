package com.nawest.rpsGame.service;

import com.nawest.rpsGame.model.Player;
import com.nawest.rpsGame.model.Room;
import com.nawest.rpsGame.repository.PlayerRepository;
import com.nawest.rpsGame.repository.RoomRepository;
import com.nawest.rpsGame.request.JoinPlayerRequest;
import com.nawest.rpsGame.request.PlayGame;
import com.nawest.rpsGame.response.NewGameResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class RPS_Service {

    static HashMap<Long, String> map = new HashMap<>();
    private PlayerRepository playerRepository;
    private RoomRepository roomRepository;

    @Autowired
    public RPS_Service(PlayerRepository playerRepository, RoomRepository roomRepository){
        this.playerRepository = playerRepository;
        this.roomRepository = roomRepository;
    }

    public NewGameResponse startGame(Player player){
        Player newPlayer = playerRepository.save(player);
        Room room = new Room();
        room.setP1id(newPlayer.getId());
        Room newRoom = roomRepository.save(room);
        NewGameResponse response = new NewGameResponse(newRoom, newPlayer);
        return response;
    }

    public Player joinGame(JoinPlayerRequest request) {
        if(!roomRepository.existsById(request.gid)){
            throw new RuntimeException("No Room found with this " + request.gid);
        }
        Room room = roomRepository.getById(request.gid);
        if(room.getP2id() != null) {
            throw new RuntimeException("Another Player Already joins the Game");
        }

        Player player = new Player();
        player.setCountry(request.country);
        player.setName(request.name);
        Player newPlayer = playerRepository.save(player);

        room.setP2id(newPlayer.getId());
        roomRepository.save(room);
        return newPlayer;
    }

    public String runGame(PlayGame playGame) {
        long gid = playGame.gid;
        map.put(playGame.pid, playGame.choice);
        while(roomRepository.getById(gid).getP2id() == null);
        long p2id;
        if(roomRepository.getById(gid).getP1id() == playGame.pid) {
            p2id = roomRepository.getById(gid).getP2id();
        } else {
            p2id = roomRepository.getById(gid).getP1id();
        }

        while (!map.containsKey(p2id));

        // logic and declare result

        // value1 -> p1choice
        // value2 -> p2choice
        int value1 = getValueofChoice(playGame.choice);
        int value2 = getValueofChoice(map.get(p2id));

        Player player1 = playerRepository.getById(playGame.pid);
        Player player2 = playerRepository.getById(p2id);
        // 1. draw
        if(value1 == value2 ) {
            return setGameWinner("Draw", playGame);
        }
        // 2. Paper and Rock
        else if(value1 == 1 && value2 == 0) {
            roomRepository.getById(gid).setWinner("Draw");
            return setGameWinner(player1.getName() + " Wins", playGame);
        }
        // 3. Scissor and Rock
        else if(value1 == 2 && value2 == 0) {
            return setGameWinner(player2.getName() + " Wins", playGame);
        }
        // 4. Rock and Paper
        else if(value1 == 0 && value2 == 1) {
            return setGameWinner(player2.getName() + " Wins", playGame);
        }
        // 5. Rock and Scissor
        else if(value1 == 0 && value2 == 2) {
            return setGameWinner(player1.getName() + " Wins", playGame);
        }
        // 6. Paper and Scissor
        else if(value1 == 1 && value2 == 2) {
            return setGameWinner(player2.getName() + " Wins", playGame);
        }
        // 7. Scissor and Paper
        else {
            return setGameWinner(player1.getName() + " Wins", playGame);
        }

    }

    private int getValueofChoice(String choice) {
        if(choice.equals("rock")) return 0;
        else if(choice.equals("paper")) return 1;
        else return 2;
    }
    private String setGameWinner(String result, PlayGame playGame) {
        long gid = playGame.gid;
        Room room = roomRepository.getById(gid);
        room.setWinner(result);
        roomRepository.save(room);
        return result;
    }
}
