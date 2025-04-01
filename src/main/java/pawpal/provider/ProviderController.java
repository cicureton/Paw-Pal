package pawpal.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/providers")
public class ProviderController {

    @Autowired
    private ProviderService providerService;

    /**
     * Register a new provider.(POST)
     * http://localhost:8080/providers/register
     *
     * Request body:
     {
        "userId": 1,
        "about": "I have 5 years of experience in pet care.",
        "experience": "5 years",
        "approvalStatus": "pending"
     }
     */
    @PostMapping("/register")
    public ResponseEntity<Provider> createProvider(@RequestBody Provider provider) {
        Provider savedProvider = providerService.createProvider(provider);
        return new ResponseEntity<>(savedProvider, HttpStatus.CREATED);
    }

    /**
     * Get all providers.(GET)
     * http://localhost:8080/providers/all
     */
    @GetMapping("/all")
    public ResponseEntity<List<Provider>> getAllProviders() {
        return new ResponseEntity<>(providerService.getAllProviders(), HttpStatus.OK);
    }

    /**
     * Get a specific provider by ID.(GET)
     * http://localhost:8080/providers/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<Provider> getProvider(@PathVariable int id) {
        return providerService.getProviderById(id)
                .map(provider -> new ResponseEntity<>(provider, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Update an existing provider profile.(PUT)
     * http://localhost:8080/providers/update/{id}
     *
     * Request body:
     {
        "userId": 1,
        "about": "I have 6 years of experience in pet care.",
        "experience": "6 years",
        "approvalStatus": "approved"
     }
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<Provider> updateProvider(@PathVariable int id, @RequestBody Provider provider) {
        return providerService.updateProvider(id, provider)
                .map(updatedProvider -> new ResponseEntity<>(updatedProvider, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Delete a provider by ID.(DELETE)
     * http://localhost:8080/providers/delete/{id}
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProvider(@PathVariable int id) {
        return providerService.deleteProvider(id)
                ? new ResponseEntity<>("Provider deleted successfully.", HttpStatus.OK)
                : new ResponseEntity<>("Provider not found.", HttpStatus.NOT_FOUND);
    }
}