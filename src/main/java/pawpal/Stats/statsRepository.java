package pawpal.Stats;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;
@Repository
public interface statsRepository  extends JpaRepository<stats, Integer> {

    Optional<stats> findByProviderId(int providerId);
    Optional<stats> findByDate(LocalDate date);
}
