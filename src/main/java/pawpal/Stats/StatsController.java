package pawpal.Stats;
import com.example.demo.Reviews.ReviewService;
import com.example.demo.Services.ServiceService;
import com.example.demo.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/stats")
public class StatsController {
    private final UserService userService;
    private final ServiceService serviceService;
    private final ReviewService reviewService;
    private final StatsService statsService;

    @Autowired
    public StatsController(UserService userService, ServiceService serviceService,
                           ReviewService reviewService, StatsService statsService) {
        this.userService = userService;
        this.serviceService = serviceService;
        this.reviewService = reviewService;
        this.statsService = statsService;
    }

    @GetMapping("/all")
    public String getAllStatistics(Model model) {
        model.addAttribute("statisticsList", statsService.getAllStatistics());
        model.addAttribute("title", "All Statistics");
        return "statistics/statistics-list";
    }

    @GetMapping("/{id}")
    public String getStatisticsById(@PathVariable int id, Model model) {
        model.addAttribute("statistics", statsService.getStatisticsById(id));
        model.addAttribute("title", "Statistics ID: " + id);
        return "statistics/statistics-details";
    }

    @PostMapping("/new")
    public String addNewStatistics(@ModelAttribute Stats statistics) {
        statsService.addNewStatistics(statistics);
        return "redirect:/statistics/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteStatisticsById(@PathVariable int id) {
        statsService.deleteStatisticsById(id);
        return "redirect:/statistics/all";
    }

    @GetMapping("/provider/{providerId}")
    public String getStatisticsByProvider(@PathVariable int providerId, Model model) {
        model.addAttribute("statistics", statsService.getStatisticsByProvider(providerId));
        model.addAttribute("title", "Provider ID: " + providerId);
        return "statistics/statistics-provider";
    }
}
