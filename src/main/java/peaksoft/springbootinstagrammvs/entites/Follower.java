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
private int subscribers = 0;
    private int subscription = 0;
    private Long id;
    @ManyToMany
    private List<User>subscribersList = new ArrayList<>();
    @ManyToMany
    private List<User>subscriptionList = new ArrayList<>();
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Follower() {
    }

    public Follower(int subscribers, int subscription) {
        this.subscribers = subscribers;
        this.subscription = subscription;
    }

    public int getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(int subscribers) {
        this.subscribers = subscribers;
    }

    public int getSubscription() {
        return subscription;
    }

    public void setSubscription(int subscription) {
        this.subscription = subscription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<User> getSubscribersList() {
        return subscribersList;
    }

    public void setSubscribersList(List<User> subscribersList) {
        this.subscribersList = subscribersList;
    }

    public List<User> getSubscriptionList() {
        return subscriptionList;
    }

    public void setSubscriptionList(List<User> subscriptionList) {
        this.subscriptionList = subscriptionList;
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
