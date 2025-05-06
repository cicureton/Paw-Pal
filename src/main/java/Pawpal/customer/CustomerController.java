package Pawpal.customer;

import Pawpal.provider.Provider;
import Pawpal.provider.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;


import java.util.Date;
import java.util.Optional;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @Autowired
    private ProviderService providerService;

    @GetMapping("/all")
    public String getAllCustomers(Model model) {
        model.addAttribute("customerList", service.getAllCustomers());
        model.addAttribute("title", "All Customers");
        return "customer-list";
    }

    @GetMapping("/{customerId}")
    public String getCustomerById(@PathVariable int customerId, Model model) {
        Customer customer = service.getCustomerById(customerId).orElse(null);
        if (customer != null) {
            model.addAttribute("customer", customer);
            model.addAttribute("title", "Customer #: " + customerId);
            return "customer-details";
        } else {
            model.addAttribute("error", "Customer not found");
            return "error";  // or some other error handling view
        }
    }

    @GetMapping("/createForm")
    public String showCreateForm(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("title", "Create New Customer");
        return "customer-signup";
    }

    @PostMapping("/new")
    public String createCustomer(@ModelAttribute Customer customer) {
        customer.setCreatedAt(new Date());
        customer.setUpdatedAt(new Date());
        customer.setStatus("active");
        Customer savedCustomer = service.createCustomer(customer);
        return "redirect:/customers/" + savedCustomer.getCustomerId();
    }


    @GetMapping("/update/{customerId}")
    public String getCustomerUpdatePage(@PathVariable int customerId, Model model) {
        Customer customer = service.getCustomerById(customerId).orElse(null);
        if (customer != null) {
            model.addAttribute("customer", customer);
            model.addAttribute("title", "Update Customer #: " + customerId);
            return "customer-update";
        } else {
            model.addAttribute("error", "Customer not found");
            return "error"; // or redirect to some other error page
        }
    }

    @PostMapping("/update")
    public String updateCustomer(@ModelAttribute Customer customer, Model model) {
        Optional<Customer> updatedCustomerOpt = service.updateCustomer(customer.getCustomerId(), customer);

        if (updatedCustomerOpt.isPresent()) {
            return "redirect:/customers/" + updatedCustomerOpt.get().getCustomerId();
        } else {
            model.addAttribute("error", "Customer not found");
            return "error";
        }
    }


    @GetMapping("/delete/{customerId}")
    public String deleteCustomer(@PathVariable int customerId) {
        service.deleteCustomer(customerId);
        return "redirect:/customers/all";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model,
                        HttpSession session) {

        Customer customer = service.getAllCustomers().stream()
                .filter(c -> c.getUsername().equals(username) && c.getPassword().equals(password))
                .findFirst()
                .orElse(null);

        if (customer != null) {
            session.setAttribute("customerId", customer.getCustomerId());

            return "redirect:/customers/" + customer.getCustomerId();
        }

        Provider provider = providerService.getAllProviders().stream()
                .filter(p -> p.getUsername().equals(username) && p.getPassword().equals(password))
                .findFirst()
                .orElse(null);

        if (provider != null) {
            session.setAttribute("providerId", provider.getProviderId());

            return "redirect:/providers/" + provider.getProviderId();
        }

        model.addAttribute("error", "Invalid username or password");
        return "login";
    }
}