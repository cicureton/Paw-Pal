package Pawpal.booking;

import Pawpal.customer.Customer;
import Pawpal.petService.PetService;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;

    private int customerId;
    private int providerId;
    private int serviceId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date appointment;

    private String status;

    @ManyToOne
    @JoinColumn(name = "customerId", referencedColumnName = "customerId", insertable = false, updatable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "serviceId", referencedColumnName = "serviceId", insertable = false, updatable = false)
    private PetService petService;

    public Booking() {
    }

    public Booking(int customerId, int providerId, int serviceId, Date appointment, String status) {
        this.customerId = customerId;
        this.providerId = providerId;
        this.serviceId = serviceId;
        this.appointment = appointment;
        this.status = status;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getProviderId() {
        return providerId;
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public Date getAppointment() {
        return appointment;
    }

    public void setAppointment(Date appointment) {
        this.appointment = appointment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public PetService getPetService() {
        return petService;
    }

    public void setPetService(PetService petService) {
        this.petService = petService;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", customerId=" + customerId +
                ", providerId=" + providerId +
                ", serviceId=" + serviceId +
                ", appointment=" + appointment +
                ", status='" + status + '\'' +
                '}';
    }
}
