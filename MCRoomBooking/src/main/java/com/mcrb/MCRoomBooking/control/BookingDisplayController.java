package com.mcrb.MCRoomBooking.control;


import com.mcrb.MCRoomBooking.data.BookingRepository;
import com.mcrb.MCRoomBooking.model.DateRequestCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class BookingDisplayController {

    @Autowired
    BookingRepository bookingRepository;

    private ModelAndView showCalendar(Date date) {
        Map<String,Object> model = new HashMap<>();
        model.put("dateRequest", new DateRequestCommand(date));
        model.put("bookings", bookingRepository.findAllByDate(date));
        return new ModelAndView ("home", model);
    }

    @RequestMapping("")
    public ModelAndView homePage() {
        Date date = new Date(new java.util.Date().getTime());
        return showCalendar(date);
    }

    @RequestMapping("/calendar")
    public ModelAndView calendar(@RequestParam Date date) {
        return showCalendar(date);
    }

}
