package com.nawest.rpsGame.repository;

import com.nawest.rpsGame.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
