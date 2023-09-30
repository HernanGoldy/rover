package academy.atl.dto;

import academy.atl.models.Orientacion;
import lombok.Data;

/**
 * @apiNote Con la clase RoverDto me inventaré un objeto que contenga la mínima información
 * necesaria para ser utilizado por un endpoint.
 * Esta práctica permite la creación de endpoints robustos.
 */

@Data
public class RoverDto {
    private Integer x;
    private Integer y;
    private Orientacion orientacion;
}
