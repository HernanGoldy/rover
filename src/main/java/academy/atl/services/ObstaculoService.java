package academy.atl.services;

import academy.atl.models.Obstaculo;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public interface ObstaculoService {
    @Transactional
    List<Obstaculo> mostrarObstaculos();

    @Transactional
    Optional<Obstaculo> crear(Obstaculo obstaculo);

    @Transactional
    void actualizar(Obstaculo obstaculo);

    @Transactional
    void borrar(Obstaculo obstaculo);
}
