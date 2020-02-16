package com.mcrb.MCRoomBooking.util;

import com.mcrb.MCRoomBooking.model.entities.Booking;
import com.mcrb.MCRoomBooking.model.entities.LayoutCapacity;

import java.util.Optional;

public class BookingCheck {
    public static boolean seatCapacityCheck(Booking booking){

           int requiredCapacities = booking.getParticipants();
           String layout = booking.getLayout().getDescription();

        LayoutCapacity availableCapacity = booking.getRoom().getCapacities()
                .stream()
                .filter(layoutCapacity -> layout.equals(layoutCapacity.getLayout().getDescription()))
                .findAny()
                .orElse(null);
        if(availableCapacity.getCapacity() >= requiredCapacities){
            return true;
        }
        return false;

    }
}
