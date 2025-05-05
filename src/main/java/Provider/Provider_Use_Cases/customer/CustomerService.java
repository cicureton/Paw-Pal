package Provider.Provider_Use_Cases.customer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * CustomerService.java
 * Centralizes data access to the Customer database.
 */
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    /**
     * Fetch all Customers.
     *
     * @return the list of all Customers.
     */
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    /**
     * Fetch a unique Customer.
     *
     * @param customerId the unique Customer id.
     * @return a unique Customer object.
     */
    public Customer getCustomerById(int customerId) {
        return customerRepository.findById(customerId).orElse(null);
    }

    /**
     * Add a new Customer to the database.
     *
     * @param customer the new Customer to add.
     */
    public void addNewCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    /**
     * Update an existing Customer.
     *
     * @param customerId the unique Customer Id.
     * @param customer   the new Customer details.
     */
    public void updateCustomer(int customerId, Customer customer) {
        Customer existing = getCustomerById(customerId);
        if (existing != null) {
            existing.setName(customer.getName());
            existing.setEmail(customer.getEmail());
            existing.setPhone(customer.getPhone());
            existing.setAddress(customer.getAddress());

            customerRepository.save(existing);
        }
    }

    /**
     * Delete a unique Customer.
     *
     * @param customerId the unique Customer Id.
     */
    public void deleteCustomerById(int customerId) {
        customerRepository.deleteById(customerId);
    }
}
