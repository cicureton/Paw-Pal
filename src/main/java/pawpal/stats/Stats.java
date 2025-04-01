package pawpal.stats;
import jakarta.persistence.*;

@Entity
@Table(name = "stats")
public class Stats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int providerId;

    @Column(nullable = false)
    private int totalCustomers;

    @Column(nullable = false)
    private double avgRating;

    public Stats() {}

    public Stats(int providerId, int totalCustomers, double avgRating) {
        this.providerId = providerId;
        this.totalCustomers = totalCustomers;
        this.avgRating = avgRating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProviderId() {
        return providerId;
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }

    public int getTotalCustomers() {
        return totalCustomers;
    }

    public void setTotalCustomers(int totalCustomers) {
        this.totalCustomers = totalCustomers;
    }

    public double getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(double avgRating) {
        this.avgRating = avgRating;
    }

    @Override
    public String toString() {
        return "Stats{" +
                "id=" + id +
                ", providerId=" + providerId +
                ", totalCustomers=" + totalCustomers +
                ", avgRating=" + avgRating +
                '}';
    }
}