package academy.atl.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "obstaculo")
public class Obstaculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "posy")
    private Integer y;

    @Column(name = "posx")
    private Integer x;
}
