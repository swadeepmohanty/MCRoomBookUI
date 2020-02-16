package com.mcrb.MCRoomBooking.services;


import com.mcrb.MCRoomBooking.data.BookingRepository;
import com.mcrb.MCRoomBooking.data.RoomRepository;
import com.mcrb.MCRoomBooking.data.UserRepository;
import com.mcrb.MCRoomBooking.model.Layout;
import com.mcrb.MCRoomBooking.model.entities.Booking;
import com.mcrb.MCRoomBooking.model.entities.LayoutCapacity;
import com.mcrb.MCRoomBooking.model.entities.Room;
import com.mcrb.MCRoomBooking.model.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataInitialization {

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BookingRepository bookingRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void initData() {
        List<Room> rooms = roomRepository.findAll();
        if (rooms.size() == 0) {
            Room roomOne = new Room("Abdul Kalam","4th Floor");
            roomOne.setCapacity(new LayoutCapacity(Layout.BOARD,8));
            roomOne.setCapacity(new LayoutCapacity(Layout.THEATER,16));
            roomRepository.save(roomOne);

            Room roomTwo = new Room("J.C Bose","4th Floor");
            roomTwo.setCapacity(new LayoutCapacity(Layout.BOARD,12));
            roomTwo.setCapacity(new LayoutCapacity(Layout.USHAPE,26));
            roomRepository.save(roomTwo);

            Room confRoom = new Room("Mary Kom","3rd Floor");
            confRoom.setCapacity(new LayoutCapacity(Layout.THEATER,80));
            confRoom.setCapacity(new LayoutCapacity(Layout.USHAPE,40));
            roomRepository.save(confRoom);

            User user = new User("John", "secret");
            userRepository.save(user);

            Booking booking1 = new Booking();
            booking1.setDate(new java.sql.Date(new java.util.Date().getTime()));
            booking1.setStartTime(java.sql.Time.valueOf("11:00:00"));
            booking1.setEndTime(java.sql.Time.valueOf("11:30:00"));
            booking1.setLayout(Layout.USHAPE);
            booking1.setParticipants(8);
            booking1.setTitle("Knowledge Sharing Session");
            booking1.setRoom(roomOne);
            booking1.setUser(user);
            bookingRepository.save(booking1);

            Booking booking2 = new Booking();
            booking2.setDate(new java.sql.Date(new java.util.Date().getTime()));
            booking2.setStartTime(java.sql.Time.valueOf("13:00:00"));
            booking2.setEndTime(java.sql.Time.valueOf("14:30:00"));
            booking2.setLayout(Layout.BOARD);
            booking2.setParticipants(5);
            booking2.setTitle("Sprint Call");
            booking2.setRoom(roomTwo);
            booking2.setUser(user);
            bookingRepository.save(booking2);
        }
    }
}
