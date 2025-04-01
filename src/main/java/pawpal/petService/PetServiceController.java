package pawpal.petService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/services")
public class PetServiceController {

    @Autowired
    private PetServiceService petServiceService;

    /**
     * Add a new pet service.(POST)
     * http://localhost:8080/services/add
     *
     * Request body:
     {
        "providerId": 1,
        "description": "Daily dog walking service.",
        "price": 20.0,
        "availability": "Monday to Friday, 9 AM - 5 PM"
     }
     */
    @PostMapping("/add")
    public ResponseEntity<PetService> addService(@RequestBody PetService petService) {
        PetService savedService = petServiceService.addService(petService);
        return new ResponseEntity<>(savedService, HttpStatus.CREATED);
    }

    /**
     * Get all pet services.(GET)
     * http://localhost:8080/services/all
     */
    @GetMapping("/all")
    public ResponseEntity<List<PetService>> getAllServices() {
        return new ResponseEntity<>(petServiceService.getAllServices(), HttpStatus.OK);
    }

    /**
     * Get a specific service by ID.(GET)
     * http://localhost:8080/services/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<PetService> getService(@PathVariable int id) {
        return petServiceService.getServiceById(id)
                .map(service -> new ResponseEntity<>(service, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Update an existing pet service.(PUT)
     * Request:
     * http://localhost:8080/services/update/{id}
     * Request body:
      {
        "providerId": 1,
        "description": "Weekly dog walking service.",
        "price": 25.00,
        "availability": "Monday to Friday, 9 AM - 5 PM"
     }
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<PetService> updateService(@PathVariable int id, @RequestBody PetService petService) {
        return petServiceService.updateService(id, petService)
                .map(updatedService -> new ResponseEntity<>(updatedService, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Delete a pet service by ID.(DELETE)
     *
     * Request:
     * http://localhost:8080/services/delete/{id}
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteService(@PathVariable int id) {
        return petServiceService.deleteService(id)
                ? new ResponseEntity<>("Service deleted successfully.", HttpStatus.OK)
                : new ResponseEntity<>("Service not found.", HttpStatus.NOT_FOUND);
    }
}
