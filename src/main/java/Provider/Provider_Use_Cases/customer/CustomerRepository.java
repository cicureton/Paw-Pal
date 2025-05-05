package Provider.Provider_Use_Cases.customer;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Provides the actual database transactions for the Customer entity.
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    // You can add custom query methods here if needed in the future
}
