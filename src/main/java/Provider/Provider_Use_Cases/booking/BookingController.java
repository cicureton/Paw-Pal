package Provider.Provider_Use_Cases.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/all")
    public String getAllBookings(Model model) {
        List<Booking> bookings = bookingService.getAllBookings();
        model.addAttribute("bookings", bookings);
        model.addAttribute("title", "All Booking Requests");
        return "booking-list";
    }

    @GetMapping("/createForm")
    public String showCreateForm(Model model) {
        model.addAttribute("booking", new Booking());
        model.addAttribute("title", "Create Booking");
        return "booking-create";
    }

    @PostMapping("/new")
    public String createBooking(@ModelAttribute Booking booking) {
        bookingService.createBooking(booking);
        return "redirect:/bookings/all";
    }

    @GetMapping("/{id}")
    public String getBooking(@PathVariable int id, Model model) {
        Booking booking = bookingService.getBookingById(id)
                .orElseThrow(() -> new IllegalArgumentException("Booking not found with id: " + id));
        model.addAttribute("booking", booking);
        model.addAttribute("title", "Booking Details");
        return "booking-details";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable int id, Model model) {
        Booking booking = bookingService.getBookingById(id)
                .orElseThrow(() -> new IllegalArgumentException("Booking not found with id: " + id));
        model.addAttribute("booking", booking);
        model.addAttribute("title", "Update Booking");
        return "booking-update";
    }

    @PostMapping("/update/{id}")
    public String updateBooking(@PathVariable int id, @ModelAttribute Booking booking) {
        bookingService.updateBooking(id, booking);
        return "redirect:/bookings/" + id;
    }

    @GetMapping("/delete/{id}")
    public String deleteBooking(@PathVariable int id) {
        bookingService.deleteBooking(id);
        return "redirect:/bookings/all";
    }

    @GetMapping("/provider/{providerId}")
    public String getBookingsByProvider(@PathVariable int providerId, Model model) {
        List<Booking> bookings = bookingService.getBookingsByProviderId(providerId);
        model.addAttribute("bookings", bookings);
        model.addAttribute("title", "Bookings for Provider " + providerId);
        return "booking-list";
    }

}
