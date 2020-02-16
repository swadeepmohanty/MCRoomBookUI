package com.mcrb.MCRoomBooking.data;


import com.mcrb.MCRoomBooking.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
