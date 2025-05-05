package Provider.Provider_Use_Cases.review;

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

    // Show all reviews
    @GetMapping("/all")
    public String getAllReviews(Model model) {
        List<Review> reviews = reviewService.getAllReviews();
        model.addAttribute("title", "All Reviews");
        model.addAttribute("reviews", reviews);
        return "review-list"; // review-list.ftlh
    }

    // Show form to add a new review
    @GetMapping("/add")
    public String showAddReviewForm(Model model) {
        model.addAttribute("review", new Review());
        model.addAttribute("title", "Add Review");
        return "review-add"; // review-add.ftlh
    }

    // Handle review submission from form
    @PostMapping("/add")
    public String addReview(@ModelAttribute Review review) {
        reviewService.addReview(review);
        return "redirect:/reviews/all";
    }

    // View a single review
    @GetMapping("/{id}")
    public String getReviewById(@PathVariable int id, Model model) {
        return reviewService.getReviewById(id).map(review -> {
            model.addAttribute("review", review);
            model.addAttribute("title", "Review Details");
            return "review-detail"; // review-detail.ftlh
        }).orElse("redirect:/reviews/all");
    }

    // Get reviews for a specific provider
    @GetMapping("/provider/{id}")
    public String getReviewsByProvider(@PathVariable int id, Model model) {
        List<Review> reviews = reviewService.getReviewsByProviderId(id);
        model.addAttribute("title", "Provider Reviews");
        model.addAttribute("reviews", reviews);
        return "review-list"; // Can reuse review-list.ftlh
    }

    // Show form to reply to a review
    @GetMapping("/{id}/reply")
    public String showReplyForm(@PathVariable int id, Model model) {
        return reviewService.getReviewById(id).map(review -> {
            model.addAttribute("review", review);
            model.addAttribute("title", "Reply to Review");
            return "review-reply"; // review-reply.ftlh
        }).orElse("redirect:/reviews/all");
    }

    // Handle reply submission
    @PostMapping("/{id}/reply")
    public String replyToReview(@PathVariable int id, @RequestParam String reply) {
        reviewService.replyToReview(id, reply);
        return "redirect:/reviews/" + id;
    }

    // Delete review
    @GetMapping("/delete/{id}")
    public String deleteReview(@PathVariable int id) {
        reviewService.deleteReviewById(id);
        return "redirect:/reviews/all";
    }

    // Report a review
    @GetMapping("/{id}/report")
    public String reportReview(@PathVariable int id) {
        reviewService.reportReview(id);
        return "redirect:/reviews/" + id;
    }
}
