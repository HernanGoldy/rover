package academy.atl.services;

import academy.atl.models.Rover;
import jakarta.transaction.Transactional;

public interface RoverService {
    @Transactional
    Rover obtener();

    @Transactional
    void enviarComando(String comando);
}
