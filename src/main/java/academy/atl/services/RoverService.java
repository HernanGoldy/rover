package academy.atl.services;

import academy.atl.models.Rover;

public interface RoverService {
    Rover obtener();

    void enviarComando(String comando);
}
