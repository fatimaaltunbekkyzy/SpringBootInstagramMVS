package peaksoft.springbootinstagrammvs.entites;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_gen")
    @SequenceGenerator(name = "post_gen", sequenceName = "post_seq",allocationSize = 1)

    private Long id;
    private String description;
    private LocalDateTime cratedAt;
    @ElementCollection
    private List<String> images = new ArrayList<>();

    @ManyToOne
    private User user;

    @Column(nullable = false, columnDefinition = "integer default 0")
    private int likeCount;

    public Post() {
    }

    public Post(String description, LocalDateTime cratedAt) {
        this.description = description;
        this.cratedAt = cratedAt;

}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCratedAt() {
        return cratedAt;
    }

    public void setCratedAt(LocalDateTime cratedAt) {
        this.cratedAt = cratedAt;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }


    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", cratedAt=" + cratedAt +
                ", images=" + images +
                ", user=" + user +
                '}';
    }
}
