package pawpal.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    /**
     * Add a new review.(POST)
     * http://localhost:8080/reviews/add
     * Request body:
      {
        "customerId": 1,
        "providerId": 2,
        "serviceId": 3,
        "rating": 5,
        "description": "Excellent service!",
        "createdAt": "2025-04-01T"
     }
     */
    @PostMapping("/add")
    public ResponseEntity<Review> addReview(@RequestBody Review review) {
        Review savedReview = reviewService.addReview(review);
        return new ResponseEntity<>(savedReview, HttpStatus.CREATED);
    }

    /**
     * Get all reviews.(GET)
     * http://localhost:8080/reviews/all
     */
    @GetMapping("/all")
    public ResponseEntity<List<Review>> getAllReviews() {
        return new ResponseEntity<>(reviewService.getAllReviews(), HttpStatus.OK);
    }

    /**
     * Get a specific review by ID.(GET)
     * http://localhost:8080/reviews/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable int id) {
        return reviewService.getReviewById(id)
                .map(review -> new ResponseEntity<>(review, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Get reviews for a specific provider.(GET)
     * http://localhost:8080/reviews/provider/{id}
     */
    @GetMapping("/provider/{id}")
    public ResponseEntity<List<Review>> getReviewsByProvider(@PathVariable int id) {
        return new ResponseEntity<>(reviewService.getReviewsByProviderId(id), HttpStatus.OK);
    }

    /**
     * Delete a review by ID.(DELETE)
     * http://localhost:8080/reviews/delete/{id}
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteReview(@PathVariable int id) {
        return reviewService.deleteReviewById(id)
                ? new ResponseEntity<>("Review deleted successfully.", HttpStatus.OK)
                : new ResponseEntity<>("Review not found.", HttpStatus.NOT_FOUND);
    }

    /**
     * Reply to a review.(PUT)
     * http://localhost:8080/reviews/{id}/reply
     *
     * Request body:
     {
        reply:"Thank you for your feedback!"
     }

     */
    @PutMapping("/{id}/reply")
    public ResponseEntity<String> replyToReview(@PathVariable int id, @RequestBody String reply) {
        return reviewService.replyToReview(id, reply)
                ? new ResponseEntity<>("Reply added successfully.", HttpStatus.OK)
                : new ResponseEntity<>("Review not found.", HttpStatus.NOT_FOUND);
    }

    /**
     * Report a review.(PUT)
     * Example: http://localhost:8080/reviews/{id}/report
     */
    @PutMapping("/{id}/report")
    public ResponseEntity<String> reportReview(@PathVariable int id) {
        return reviewService.reportReview(id)
                ? new ResponseEntity<>("Review reported successfully.", HttpStatus.OK)
                : new ResponseEntity<>("Review not found.", HttpStatus.NOT_FOUND);
    }
}
