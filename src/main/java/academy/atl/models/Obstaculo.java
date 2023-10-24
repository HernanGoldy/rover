package academy.atl.models;

import academy.atl.dto.ObstaculoDto;
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


    // constructors
    public Obstaculo() { }

    public Obstaculo(ObstaculoDto obstaculo) {
        this.x = obstaculo.getX();
        this.y = obstaculo.getY();
    }
}
