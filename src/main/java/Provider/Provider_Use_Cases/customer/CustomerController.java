package Provider.Provider_Use_Cases.customer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * CustomerController.java.
 * Includes all REST API endpoint mappings for the Customer object.
 */
@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService service;

    /**
     * Get a list of all Customers in the database.
     * http://localhost:8080/customers/all
     *
     * @return a list of Customer objects.
     */
    @GetMapping("/all")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return new ResponseEntity<>(service.getAllCustomers(), HttpStatus.OK);
    }

    /**
     * Get a specific Customer by Id.
     * http://localhost:8080/customers/{customerId}
     *
     * @param customerId the unique Id for a Customer.
     * @return One Customer object.
     */
    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable int customerId) {
        return new ResponseEntity<>(service.getCustomerById(customerId), HttpStatus.OK);
    }

    /**
     * Add a new Customer entry.
     * http://localhost:8080/customers/new
     *
     * @param customer the new Customer object.
     * @return the updated list of Customers.
     */
    @PostMapping("/new")
    public ResponseEntity<List<Customer>> addNewCustomer(@RequestBody Customer customer) {
        service.addNewCustomer(customer);
        return new ResponseEntity<>(service.getAllCustomers(), HttpStatus.CREATED);
    }

    /**
     * Update an existing Customer object.
     * http://localhost:8080/customers/update/{customerId}
     *
     * @param customerId the unique Customer Id.
     * @param customer   the new updated Customer details.
     * @return the updated Customer object.
     */
    @PutMapping("/update/{customerId}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable int customerId, @RequestBody Customer customer) {
        service.updateCustomer(customerId, customer);
        return new ResponseEntity<>(service.getCustomerById(customerId), HttpStatus.OK);
    }

    /**
     * Delete a Customer object.
     * http://localhost:8080/customers/delete/{customerId}
     *
     * @param customerId the unique Customer Id.
     * @return the updated list of Customers.
     */
    @DeleteMapping("/delete/{customerId}")
    public ResponseEntity<List<Customer>> deleteCustomerById(@PathVariable int customerId) {
        service.deleteCustomerById(customerId);
        return new ResponseEntity<>(service.getAllCustomers(), HttpStatus.OK);
    }
}
