package pawpal.Stats;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pawpal.Stats.provider.ProviderService;

//import pawpal.Stats.stats.customer.CustomerService;
//import pawpal.Stats.stats.provider.ProviderService;
import pawpal.Stats.user.UserService;
import pawpal.Stats.user.UserRepository;
import pawpal.Stats.review.ReviewService;
import pawpal.Stats.petService.PetServiceService;




import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
@Service
public class statsService {
    private final statsRepository statsRepository;
    private final UserService userService;
    private final PetServiceService serviceService;
    //private final CustomerService customerService;
    private final ProviderService providerService;
    private final ReviewService reviewService;

    @Autowired
    public statsService(statsRepository statsRepository,
                        PetServiceService serviceService, ReviewService reviewService, PetServiceService serviceService1,UserService userService,ProviderService providerService) {
        this.statsRepository = statsRepository;
        this.userService = userService;
        // this.serviceService = serviceService;
        this.reviewService = reviewService;
        // this.customerService = customerService;
        // CustomerService customerService
        this.providerService = providerService;
        this.serviceService = serviceService1;
    }

    public List<stats> getAllStatistics() {
        return statsRepository.findAll();
    }

    public stats getStatisticsById(int id) {
        return statsRepository.findById(id).orElse(null);
    }

    public stats generateLiveStats() {
        stats stats = new stats();
        stats.setDate(LocalDate.now());
        stats.setLastUpdated(LocalTime.now());
        stats.setTotalUsers(userService.getAllUsers().size());
        //stats.setTotalCustomers(CustomerService.getAllCustomers().size());
        //stats.setTotalServiceProviders(providerService.getAllProviders().size());
        stats.setPendingProviderApplications((int) userService.countByStatus("PENDING"));
        stats.setApprovedProviderApplications((int) userService.countByStatus("APPROVED"));
        stats.setDeniedProviderApplications((int) userService.countByStatus("DENIED"));
        stats.setTotalServices(serviceService.getAllServices().size());
        stats.setActiveServices((int) serviceService.countByStatus("ACTIVE"));
        stats.setInactiveServices((int) serviceService.countByStatus("INACTIVE"));
        stats.setMostPopularService(serviceService.getMostPopularServiceName());
        stats.setTotalReviews(reviewService.getAllReviews().size());

        stats.setAvgRating(reviewService.getAverageRating());
        return stats;
    }


    public void saveCurrentStatsSnapshot() {
        statsRepository.save(generateLiveStats());
    }


    public void addNewStatistics(stats statistics) {
        statsRepository.save(statistics);
    }

    public void deleteStatisticsById(int id) {
        statsRepository.deleteById(id);
    }

    public Optional<stats> getStatisticsByProvider(int providerId) {
        return statsRepository.findByProviderId(providerId);
    }
}


