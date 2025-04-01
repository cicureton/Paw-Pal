package pawpal.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    /**
     * Create a new booking.(POST)
     * http://localhost:8080/bookings/add
     {
        "customerId": 1,
        "providerId": 2,
        "serviceId": 3,
        "appointment": "2025-04-01T10:00:00",
        "status": "pending"
     }
     */
    @PostMapping("/add")
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        Booking savedBooking = bookingService.createBooking(booking);
        return new ResponseEntity<>(savedBooking, HttpStatus.CREATED);
    }

    /**
     * Get all bookings.(GET)
     * http://localhost:8080/bookings/all
     */
    @GetMapping("/all")
    public ResponseEntity<List<Booking>> getAllBookings() {
        return new ResponseEntity<>(bookingService.getAllBookings(), HttpStatus.OK);
    }

    /**
     * Get a specific booking by ID.(GET)
     * http://localhost:8080/bookings/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBooking(@PathVariable int id) {
        return bookingService.getBookingById(id)
                .map(booking -> new ResponseEntity<>(booking, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Update an existing booking(PUT)
     * http://localhost:8080/bookings/update/{id}
     {
     "customerId": 1,
     "providerId": 2,
     "serviceId": 3,
     "appointment": "2025-04-01T12:00:00",
     "status": "confirmed"
     }
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable int id, @RequestBody Booking booking) {
        return bookingService.updateBooking(id, booking)
                .map(updatedBooking -> new ResponseEntity<>(updatedBooking, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Delete a booking by ID.(DELETE)
     * http://localhost:8080/bookings/delete/{id}
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBooking(@PathVariable int id) {
        return bookingService.deleteBooking(id)
                ? new ResponseEntity<>("Booking deleted successfully.", HttpStatus.OK)
                : new ResponseEntity<>("Booking not found.", HttpStatus.NOT_FOUND);
    }
}
