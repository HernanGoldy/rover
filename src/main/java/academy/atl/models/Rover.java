package academy.atl.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "rover")
public class Rover {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "posy")
    private Integer y;

    @Column(name = "posx")
    private Integer x;

    @Enumerated(EnumType.STRING)
    @Column(name = "orientacion")
    private Orientacion orientacion;
}
