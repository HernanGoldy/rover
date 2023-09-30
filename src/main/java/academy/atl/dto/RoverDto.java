package academy.atl.dto;

import academy.atl.models.Orientacion;

/**
 * @apiNote Con la clase RoverDto me inventaré un objeto que contenga la mínima información
 * necesaria para ser utilizado por un endpoint.
 * Esto permite la creación de endpoints robustos.
 */
public class RoverDto {
    private Integer x;
    private Integer y;
    private Orientacion orientacion;
}
