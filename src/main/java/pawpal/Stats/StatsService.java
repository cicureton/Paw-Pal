package pawpal.Stats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StatsService {
    private final StatsRepository statsRepository;

    @Autowired
    public StatsService(StatsRepository statsRepository) {
        this.statsRepository = statsRepository;
    }

    public List<Stats> getAllStatistics() {
        return statsRepository.findAll();
    }

    public Stats getStatisticsById(int id) {
        return statsRepository.findById(id).orElse(null);
    }

    public void addNewStatistics(Stats statistics) {
        statsRepository.save(statistics);
    }

    public void deleteStatisticsById(int id) {
        statsRepository.deleteById(id);
    }

    public Stats getStatisticsByProvider(int providerId) {
        return statsRepository.findByProviderId(providerId);
    }
}
