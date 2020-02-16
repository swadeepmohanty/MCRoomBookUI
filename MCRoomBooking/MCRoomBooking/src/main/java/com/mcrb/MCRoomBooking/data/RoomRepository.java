package com.mcrb.MCRoomBooking.data;


import com.mcrb.MCRoomBooking.model.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
