package academy.atl.repository;

import academy.atl.models.Obstaculo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @apiNote CrudRepository nos va a generar automáticamente las Altas,
 * Bajas, Modificaciones y Búsquedas, para poder utilizarlo en el servicio.
 */
@Repository
public interface ObstaculoRepository extends CrudRepository<Obstaculo, Long> {
}
