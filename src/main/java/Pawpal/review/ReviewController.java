package Pawpal.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/all")
    public String getAllReviews(Model model) {
        List<Review> reviews = reviewService.getAllReviews();
        model.addAttribute("reviews", reviews);
        model.addAttribute("title", "All Reviews");
        return "review-list"; // Create review-list.ftlh
    }

    @GetMapping("/create/{bookingId}")
    public String showReviewForm(@PathVariable int bookingId, Model model) {
        model.addAttribute("bookingId", bookingId);
        model.addAttribute("review", new Review());
        return "review-create";
    }

    @PostMapping("/create/{bookingId}")
    public String submitReview(@PathVariable int bookingId, @ModelAttribute Review review) {
        reviewService.addReview(review);
        return "redirect:/profile";
    }

    @GetMapping("/{id}")
    public String viewReview(@PathVariable int id, Model model) {
        Review review = reviewService.getReviewById(id).orElse(null);
        if (review == null) {
            return "redirect:/reviews/all";
        }
        model.addAttribute("review", review);
        return "review-details";
    }

    @GetMapping("/provider/{id}")
    public String getReviewsByProvider(@PathVariable int id, Model model) {
        List<Review> reviews = reviewService.getReviewsByProviderId(id);
        model.addAttribute("reviews", reviews);
        model.addAttribute("title", "Reviews for Provider #" + id);
        return "review-list";
    }

    @GetMapping("/delete/{id}")
    public String deleteReview(@PathVariable int id) {
        reviewService.deleteReviewById(id);
        return "redirect:/reviews/all";
    }

    @GetMapping("/{id}/reply")
    public String showReplyForm(@PathVariable int id, Model model) {
        Review review = reviewService.getReviewById(id).orElse(null);
        if (review == null) return "redirect:/reviews/all";
        model.addAttribute("review", review);
        return "review-reply";
    }

    @PostMapping("/{id}/reply")
    public String handleReply(@PathVariable int id, @RequestParam String reply) {
        reviewService.replyToReview(id, reply);
        return "redirect:/reviews/" + id;
    }

    @GetMapping("/{id}/report")
    public String reportReview(@PathVariable int id) {
        reviewService.reportReview(id);
        return "redirect:/reviews/" + id;
    }
}
