package com.mcrb.MCRoomBooking.control;

import com.mcrb.MCRoomBooking.data.BookingRepository;
import com.mcrb.MCRoomBooking.data.RoomRepository;
import com.mcrb.MCRoomBooking.data.UserRepository;
import com.mcrb.MCRoomBooking.model.BookingCommand;
import com.mcrb.MCRoomBooking.model.Layout;
import com.mcrb.MCRoomBooking.model.entities.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    UserRepository userRepository;

    private Map<String,Object> getBookingFormModel(Booking booking) {
        Map<String,Object> model = new HashMap<>();
        model.put("booking",new BookingCommand(booking));
        model.put("rooms", roomRepository.findAll());
        model.put("layouts", Layout.values());
        model.put("users", userRepository.findAll());
        return model;
    }

    @RequestMapping("/edit")
    public ModelAndView editBooking(@RequestParam Long id) {
        return new ModelAndView("bookings/edit", getBookingFormModel(bookingRepository.findById(id).get()));
    }

    @RequestMapping("/new")
    public ModelAndView newBooking() {
        return new ModelAndView("bookings/edit", getBookingFormModel(new Booking()));
    }

    @PostMapping("/save")
    public String save(BookingCommand booking) {
        bookingRepository.save(booking.toBooking());
        return "redirect:/";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam Long id) {
        bookingRepository.deleteById(id);
        return "redirect:/";
    }
}
