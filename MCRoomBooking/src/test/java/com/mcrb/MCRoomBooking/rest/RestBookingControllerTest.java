package com.mcrb.MCRoomBooking.rest;

import com.mcrb.MCRoomBooking.data.BookingRepository;
import com.mcrb.MCRoomBooking.model.Layout;
import com.mcrb.MCRoomBooking.model.entities.Booking;
import com.mcrb.MCRoomBooking.model.entities.Room;
import com.mcrb.MCRoomBooking.model.entities.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RestBookingControllerTest {

	@InjectMocks
	RestBookingsController restBookingsController;

	@Mock
	BookingRepository bookingRepository;

	@Test
	public void getBooking_whenIdPassed(){
		//Given
		Room room = new Room("Abdul Kalam","4th Floor");
		User user = new User("John","");
		Booking booking = new Booking(room, user, Layout.BOARD,"Test Meeting",new Date(1581877800000L), new Time(19800000),new Time(21600000), 10);
		List<Booking> bookings = new ArrayList<>();
		bookings.add(booking);
		Date sqlDate = Date.valueOf("2020-02-17");
		when(bookingRepository.findAllByDate(sqlDate)).thenReturn(bookings);

		//When
		List<Booking> bookings1 = restBookingsController.getBookingsByDate("2020-02-17");

		//then
		Assertions.assertThat(bookings1.size()).isEqualTo(1);

	}
}
