package academy.atl.repository;

import academy.atl.models.Obstaculo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @apiNote JpaRepository nos va a generar automáticamente las Altas,
 * Bajas, Modificaciones y Búsquedas, para poder utilizarlo en el servicio.
 */

public interface ObstaculoRepository extends JpaRepository<Obstaculo, Long> {
}
