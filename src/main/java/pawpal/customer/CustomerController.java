package pawpal.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService service;

    /**
     * Get a list of all customers.(GET)
     * http://localhost:8080/customers/all
     */
    @GetMapping("/all")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return new ResponseEntity<>(service.getAllCustomers(), HttpStatus.OK);
    }

    /**
     * Get a specific customer by ID.(GET)
     * http://localhost:8080/customers/{id}
     */
    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable int customerId) {
        return new ResponseEntity<>(service.getCustomerById(customerId), HttpStatus.OK);
    }

    /**
     * Create a new customer.(POST)
     * http://localhost:8080/customers/new
     *
     * Request body:
     {
        "userId": 1,
        "address": "123 Pet Street, Pet City",
        "petDetails": "Golden Retriever, 3 years old"
     }
     */
    @PostMapping("/new")
    public ResponseEntity<List<Customer>> addNewCustomer(@RequestBody Customer customer) {
        service.addNewCustomer(customer);
        return new ResponseEntity<>(service.getAllCustomers(), HttpStatus.CREATED);
    }

    /**
     * Update an existing customer.(PUT)
     http://localhost:8080/customers/update/{id}

     Request body:
      {
        "userId": 1,
        "address": "123 New Pet Street, Pet City",
        "petDetails": "Golden Retriever, 4 years old"
     }
     */
    @PutMapping("/update/{customerId}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable int customerId, @RequestBody Customer customer) {
        service.updateCustomer(customerId, customer);
        return new ResponseEntity<>(service.getCustomerById(customerId), HttpStatus.OK);
    }

    /**
     * Delete a customer by ID.(DELETE)
     * http://localhost:8080/customers/delete/{id}
     */
    @DeleteMapping("/delete/{customerId}")
    public ResponseEntity<List<Customer>> deleteCustomerById(@PathVariable int customerId) {
        service.deleteCustomerById(customerId);
        return new ResponseEntity<>(service.getAllCustomers(), HttpStatus.OK);
    }
}
