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

    @Column(name = "posX")
    private Integer x;

    @Column(name = "posY")
    private Integer y;

    @Column(name = "orientacion")
    private Orientacion orientacion;
}
