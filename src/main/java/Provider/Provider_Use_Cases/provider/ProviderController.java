package Provider.Provider_Use_Cases.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/providers")
public class ProviderController {

    @Autowired
    private ProviderService providerService;

    /**
     * Show all providers.
     * http://localhost:8080/providers/all
     */
    @GetMapping("/all")
    public String getAllProviders(Model model) {
        List<Provider> providerList = providerService.getAllProviders();
        model.addAttribute("providerList", providerList);
        model.addAttribute("title", "All Providers");
        return "provider-list";
    }

    /**
     * Show details for a specific provider.
     * http://localhost:8080/providers/{id}
     */
    @GetMapping("/{id}")
    public String getProvider(@PathVariable int id, Model model) {
        providerService.getProviderById(id).ifPresent(provider -> model.addAttribute("provider", provider));
        model.addAttribute("title", "Provider #" + id);
        return "provider-details";
    }

    /**
     * Show the form to register a new provider.
     * http://localhost:8080/providers/createForm
     */
    @GetMapping("/createForm")
    public String showCreateForm(Model model) {
        Provider provider = new Provider();
        model.addAttribute("provider", provider);
        model.addAttribute("title", "Register as a Service Provider");
        return "provider-create";
    }

    /**
     * Create a new provider entry.
     * http://localhost:8080/providers/new
     */
    @PostMapping("/new")
    public String createProvider(Provider provider) {
        provider.setApprovalStatus("pending");
        providerService.createProvider(provider);
        return "redirect:/providers/all";
    }

    /**
     * Show the update form for an existing provider.
     * http://localhost:8080/providers/update/{id}
     */
    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable int id, Model model) {
        providerService.getProviderById(id).ifPresent(provider -> model.addAttribute("provider", provider));
        model.addAttribute("title", "Update Provider");
        return "provider-update";
    }

    /**
     * Update a provider profile.
     * http://localhost:8080/providers/update/{id}
     */
    @PostMapping("/update/{id}")
    public String updateProvider(@PathVariable int id, Provider provider) {
        providerService.updateProvider(id, provider);
        return "redirect:/providers/" + id;
    }

    /**
     * Delete a provider.
     * http://localhost:8080/providers/delete/{id}
     */
    @GetMapping("/delete/{id}")
    public String deleteProvider(@PathVariable int id) {
        providerService.deleteProvider(id);
        return "redirect:/providers/all";
    }
}
