package peaksoft.springbootinstagrammvs.entites;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="followers")

public class Follower {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "follower_gen")
    @SequenceGenerator(name = "follower_gen", sequenceName = "follower_seq",allocationSize = 1)

    private Long id;
    @ManyToMany
    private List<User>subscribers = new ArrayList<>();
    @ManyToMany
    private List<User>subscription = new ArrayList<>();
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Follower() {
    }

    public Follower(List<User> subscribers, List<User> subscription) {
        this.subscribers = subscribers;
        this.subscription = subscription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<User> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(List<User> subscribers) {
        this.subscribers = subscribers;
    }

    public List<User> getSubscription() {
        return subscription;
    }

    public void setSubscription(List<User> subscription) {
        this.subscription = subscription;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Follower{" +
                "id=" + id +
                ", subscribers=" + subscribers +
                ", subscription=" + subscription +
                ", user=" + user +
                '}';
    }
}
