package Pawpal.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(int id) {
        return customerRepository.findById(id);
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Optional<Customer> updateCustomer(int id, Customer updatedCustomer) {
        return customerRepository.findById(id).map(existingCustomer -> {
            // Set the username and email
            existingCustomer.setUsername(updatedCustomer.getUsername());
            existingCustomer.setEmail(updatedCustomer.getEmail());

            if (updatedCustomer.getPassword() != null && !updatedCustomer.getPassword().isEmpty()) {
                existingCustomer.setPassword(updatedCustomer.getPassword());
            }

            existingCustomer.setFirstName(updatedCustomer.getFirstName());
            existingCustomer.setLastName(updatedCustomer.getLastName());
            existingCustomer.setStatus(updatedCustomer.getStatus());
            existingCustomer.setAddress(updatedCustomer.getAddress());
            existingCustomer.setPetDetails(updatedCustomer.getPetDetails());

            existingCustomer.setUpdatedAt(new Date());

            return customerRepository.save(existingCustomer);
        });
    }


    public void deleteCustomer(int id) {
        customerRepository.deleteById(id);
    }


}
