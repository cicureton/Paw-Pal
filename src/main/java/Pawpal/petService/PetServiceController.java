package Pawpal.petService;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/services")
public class PetServiceController {

    @Autowired
    private PetServiceService petServiceService;

    /**
     * Get all pet services.
     * http://localhost:8080/services/all
     */
    @GetMapping("/all")
    public String getAllServices(Model model) {
        List<PetService> services = petServiceService.getAllServices();
        model.addAttribute("services", services);
        model.addAttribute("title", "All Pet Services");
        return "service-list";
    }

    /**
     * Get a specific pet service by ID.
     * http://localhost:8080/services/{id}
     */
    @GetMapping("/{id}")
    public String getService(@PathVariable int id, Model model) {
        PetService service = petServiceService.getServiceById(id)
                .orElseThrow(() -> new IllegalArgumentException("Service not found with id: " + id));
        model.addAttribute("service", service);
        model.addAttribute("title", "Service Details");
        return "service-details";
    }

    /**
     * Show form to create a new pet service.
     * http://localhost:8080/services/createForm
     */
    @GetMapping("/createForm")
    public String showCreateForm(Model model, HttpSession session) {
        Integer providerId = (Integer) session.getAttribute("providerId");

        if (providerId == null) {
            // Handle unauthenticated access
            return "redirect:/login";
        }

        PetService service = new PetService();
        service.setProviderId(providerId);
        model.addAttribute("service", service);
        model.addAttribute("providerId", providerId);
        model.addAttribute("title", "Create New Service");
        return "service-create";
    }


    /**
     * Create a new pet service.
     * http://localhost:8080/services/new
     */
    @PostMapping("/new")
    public String addNewService(PetService petService, HttpSession session) {
        Integer providerId = (Integer) session.getAttribute("providerId");

        if (providerId == null) {
            return "redirect:/login";
        }

        petService.setProviderId(providerId);
        petServiceService.addService(petService);
        return "redirect:/services/all";
    }


    /**
     * Show form to update an existing pet service.
     * http://localhost:8080/services/update/{id}
     */
    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable int id, Model model) {
        PetService service = petServiceService.getServiceById(id)
                .orElseThrow(() -> new IllegalArgumentException("Service not found with id: " + id));
        model.addAttribute("service", service);
        model.addAttribute("title", "Update Service");
        return "service-update";
    }

    /**
     * Update an existing pet service.
     * http://localhost:8080/services/update/{id}
     */
    @PostMapping("/update/{id}")
    public String updateService(@PathVariable int id, PetService petService, Model model) {
        petServiceService.updateService(id, petService);
        return "redirect:/services/" + id;
    }

    /**
     * Delete a pet service by ID.
     * http://localhost:8080/services/delete/{id}
     */
    @GetMapping("/delete/{id}")
    public String deleteService(@PathVariable int id) {
        petServiceService.deleteService(id);
        return "redirect:/services/all";
    }
}
