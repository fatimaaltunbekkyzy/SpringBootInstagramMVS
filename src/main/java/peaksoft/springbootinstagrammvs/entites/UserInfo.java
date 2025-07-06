package peaksoft.springbootinstagrammvs.entites;

import jakarta.persistence.*;
import peaksoft.springbootinstagrammvs.enums.Gender;

@Entity
@Table(name="userInfos")
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userInfo_gen")
    @SequenceGenerator(name = "userInfo_gen", sequenceName = "userInfo_seq",allocationSize = 1)

    private Long id;
    private String firstName;
    private String biography;
    private Gender gender;
    private String imageUrl;
    @OneToOne
    private User user;

    public UserInfo() {
    }

    public UserInfo(String firstName, String biography, Gender gender, String imageUrl) {
        this.firstName = firstName;
        this.biography = biography;
        this.gender = gender;
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", biography='" + biography + '\'' +
                ", gender=" + gender +
                ", imageUrl='" + imageUrl + '\'' +
                ", user=" + user +
                '}';
    }
}
