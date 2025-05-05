package pawpal.Stats;


import pawpal.Stats.booking.BookingRepository;
import pawpal.Stats.petService.PetService;
import pawpal.Stats.petService.PetServiceRepository;
import pawpal.Stats.provider.Provider;
import pawpal.Stats.provider.ProviderRepository;
import pawpal.Stats.review.Review;
import pawpal.Stats.review.ReviewRepository;
import pawpal.Stats.user.User;
import pawpal.Stats.user.UserRepository;
import pawpal.Stats.review.ReviewService;
import pawpal.Stats.petService.PetServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/stats")
public class statsController {
    private final UserRepository userRepository;
    private final PetServiceRepository petServiceRepository;
    private final StatsRepository statsRepository;
    private final StatsService statsService;
    private final ReviewService reviewService;
    private final PetServiceService petServiceService;
    private final ProviderRepository providerRepository;
    private ReviewRepository reviewRepository;
    private BookingRepository bookingRepository;

    @Autowired
    public statsController(UserRepository userRepository,
                           PetServiceRepository petServiceRepository,
                           StatsRepository statsRepository,
                           StatsService statsService,
                           ReviewService reviewService,
                           PetServiceService petServiceService,
                           ProviderRepository providerRepository,
                           ReviewRepository reviewRepository) {
        this.userRepository = userRepository;
        this.petServiceRepository = petServiceRepository;
        this.statsRepository = statsRepository;
        this.statsService = statsService;
        this.reviewService = reviewService;
        this.petServiceService = petServiceService;
        this.providerRepository = providerRepository;
        this.reviewRepository = reviewRepository;
    }



    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        return "dashboard";
    }

    @GetMapping("/admin-moderation")
    public String moderateServices(Model model) {
        model.addAttribute("services", petServiceRepository.findAll());
        model.addAttribute("pendingServices", petServiceRepository.findByStatus("PENDING"));
        model.addAttribute("flaggedServices", petServiceRepository.findByFlaggedTrue());
        return "admin-moderation";
    }

    @GetMapping("/users")
    public String manageUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "manage-users";
    }

    @GetMapping("/view")
    public String viewStats(Model model) {
        model.addAttribute("activeUsersJan", userRepository.countByActiveAndMonth(1));
        model.addAttribute("activeUsersFeb", userRepository.countByActiveAndMonth(2));
        model.addAttribute("activeUsersMar", userRepository.countByActiveAndMonth(3));
        model.addAttribute("activeUsersApr", userRepository.countByActiveAndMonth(4));
        model.addAttribute("overallAvg", reviewService.getAverageRating());
        model.addAttribute("statsList", statsService.getAllStatistics());
        model.addAttribute("title", "Usage Statistics");
        return "admin-stats";
    }





    @PostMapping("/services/approve/{id}")
    public String approveService(@PathVariable int id) {
        petServiceRepository.findById(id).ifPresent(service -> {
            service.setApproved(true);
            service.setStatus("APPROVED");
            petServiceRepository.save(service);
        });
        return "redirect:/stats/admin-moderation";
    }

    @PostMapping("/services/delete/{id}")
    public String deleteService(@PathVariable int id) {
        petServiceRepository.deleteById(id);
        return "redirect:/stats/admin-moderation";
    }





    @DeleteMapping("/{id}")
    public void deleteStatisticsById(@PathVariable int id) {
        statsService.deleteStatisticsById(id);
    }


    @GetMapping("/applist")
    public String appList(Model model) {
        // Retrieve all applications
        List<PetService> pendingApplications = petServiceRepository.findByStatus("PENDING");
        List<PetService> approvedApplications = petServiceRepository.findByStatus("APPROVED");
        List<PetService> deniedApplications = petServiceRepository.findByStatus("DENIED");

        // Add application data to the model
        model.addAttribute("pendingApplications", pendingApplications);
        model.addAttribute("approvedApplications", approvedApplications);
        model.addAttribute("deniedApplications", deniedApplications);

        // Retrieve users to associate applications with users (if needed)
        model.addAttribute("users", userRepository.findAll());

        // Return the view for the app-list page
        return "app-list";

    }

    @GetMapping("/admin/stats")
    public String getSystemStats(Model model) {
        long activeUserCount = userRepository.countByStatus("Active");
        String popularService = petServiceRepository.findMostPopularService();
        double avgProviderRating = reviewRepository.calculateAverageRating();
        Long totalBookings = bookingRepository.count();

        model.addAttribute("totalBookings", totalBookings);
        model.addAttribute("activeUserCount", activeUserCount);
        model.addAttribute("popularService", popularService);
        model.addAttribute("bookingTrend", "Stable"); // placeholder
        model.addAttribute("avgProviderRating", avgProviderRating);
        model.addAttribute("systemUptime", "99.95%"); // placeholder

        return "admin-stats";
    }

    @GetMapping("/reviews")
    public String getAllReviews(Model model) {
        List<Review> reviews = reviewService.getAllReviews(); // use service for abstraction
        model.addAttribute("reviews", reviews);


        return "admin-reviews"; // Ensure this matches your Freemarker template file name
    }
}



