package peaksoft.springbootinstagrammvs.entites;

import jakarta.persistence.*;

import java.time.LocalDate;
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
    private LocalDate crateAt;
    @ElementCollection
    private List<String> images = new ArrayList<>();
}
