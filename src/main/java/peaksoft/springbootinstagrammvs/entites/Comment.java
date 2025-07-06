package peaksoft.springbootinstagrammvs.entites;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_gen")
    @SequenceGenerator(name = "user_gen", sequenceName = "user_seq",allocationSize = 1)

    private Long id;
    private String comment;
    private LocalDate crateAt;
}
