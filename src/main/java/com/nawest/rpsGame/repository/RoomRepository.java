package com.nawest.rpsGame.repository;

import com.nawest.rpsGame.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
