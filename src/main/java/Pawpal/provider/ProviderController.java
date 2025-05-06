package Pawpal.provider;

import Pawpal.customer.Customer;
import Pawpal.customer.CustomerService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

/**
 * ProviderController.java.
 * Includes all MVC mappings for the Provider object.
 */
@Controller
@RequestMapping("/providers")
public class ProviderController {

    @Autowired
    private ProviderService providerService;

    @Autowired
    private CustomerService service;


    /**
     * Get a list of all Providers.
     * http://localhost:8080/providers/all
     */
    @GetMapping("/all")
    public String getAllProviders(Model model) {
        model.addAttribute("providerList", providerService.getAllProviders());
        model.addAttribute("title", "All Providers");
        return "provider-list";
    }

    /**
     * Get a specific Provider by ID.
     * http://localhost:8080/providers/{providerId}
     */
    @GetMapping("/{providerId}")
    public String getOneProvider(@PathVariable int providerId, Model model) {
        Optional<Provider> providerOpt = providerService.getProviderById(providerId);
        if (providerOpt.isPresent()) {
            model.addAttribute("provider", providerOpt.get());
            model.addAttribute("title", "Provider #" + providerId);
        } else {
            model.addAttribute("error", "Provider not found");
            return "error";  // Or any appropriate error page
        }
        return "provider-details";
    }

    /**
     * Show the view for creating a new Provider.
     * http://localhost:8080/providers/createForm
     */
    @GetMapping("/createForm")
    public String showCreateForm(Model model) {
        Provider provider = new Provider();
        model.addAttribute("provider", provider);
        model.addAttribute("title", "Create New Provider");
        return "provider-signup";
    }

    /**
     * Create a new Provider.
     * http://localhost:8080/providers/new
     */
    @PostMapping("/new")
    public String createProvider(@ModelAttribute Provider provider) {
        provider.setCreatedAt(new Date());
        provider.setUpdatedAt(new Date());
        provider.setStatus("active");
        provider.setApprovalStatus("pending");
        Provider savedProvider = providerService.createProvider(provider);
        return "redirect:/providers/" + savedProvider.getProviderId(); // Redirect to profile page
    }


    /**
     * Show the update form.
     * http://localhost:8080/providers/update/{providerId}
     */
    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable int id, Model model) {
        Optional<Provider> optionalProvider = providerService.getProviderById(id);
        if (optionalProvider.isPresent()) {
            Provider provider = optionalProvider.get();
            model.addAttribute("provider", provider);
            model.addAttribute("title", "Update Provider");
            return "provider-update";
        } else {
            return "error/404";
        }
    }

    /**
     * Update a Provider.
     * http://localhost:8080/providers/update/{providerId}
     */
    @PostMapping("/update/{providerId}")
    public String updateProvider(@PathVariable int providerId, @ModelAttribute Provider provider) {
        provider.setUpdatedAt(new Date());
        providerService.updateProvider(providerId, provider);
        return "redirect:/providers/" + providerId;
    }

    /**
     * Delete a Provider.
     * http://localhost:8080/providers/delete/{providerId}
     */
    @GetMapping("/delete/{providerId}")
    public String deleteProvider(@PathVariable int providerId) {
        providerService.deleteProvider(providerId);
        return "redirect:/providers/all";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model,
                        HttpSession session) {  // <-- Add HttpSession here

        Customer customer = service.getAllCustomers().stream()
                .filter(c -> c.getUsername().equals(username) && c.getPassword().equals(password))
                .findFirst()
                .orElse(null);

        if (customer != null) {
            model.addAttribute("customer", customer);
            return "redirect:/customers/" + customer.getCustomerId();
        }

        Provider provider = providerService.getAllProviders().stream()
                .filter(p -> p.getUsername().equals(username) && p.getPassword().equals(password))
                .findFirst()
                .orElse(null);

        if (provider != null) {
            model.addAttribute("provider", provider);

            session.setAttribute("providerId", provider.getProviderId());

            return "redirect:/providers/" + provider.getProviderId();
        }

        model.addAttribute("error", "Invalid username or password");
        return "login";
    }


    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

}
