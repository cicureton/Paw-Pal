package Pawpal.petService;

import jakarta.persistence.*;

@Entity
public class PetService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int serviceId;
    private int providerId;
    private String title; // <-- Added title
    private String description;
    private float price;
    private String availability;

    public PetService() {
    }

    public PetService(int providerId, String title, String description, float price, String availability) {
        this.providerId = providerId;
        this.title = title;
        this.description = description;
        this.price = price;
        this.availability = availability;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public int getProviderId() {
        return providerId;
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "PetService{" +
                "serviceId=" + serviceId +
                ", providerId=" + providerId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", availability='" + availability + '\'' +
                '}';
    }
}
