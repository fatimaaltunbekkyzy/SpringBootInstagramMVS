package peaksoft.springbootinstagrammvs.entites;

import jakarta.persistence.*;

@Entity
@Table(name="likes")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "like_gen")
    @SequenceGenerator(name = "like_gen", sequenceName = "like_seq",allocationSize = 1)
    private Long id;
    private boolean isLike;
}
