package academy.atl.services;

import academy.atl.models.Rover;
import academy.atl.repository.RoverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoverServiceImp implements RoverService{

    // Para acceder a todas las funciones del repositorio
    @Autowired
    private RoverRepository repository;

    @Override
    public Rover obtener() {
        List<Rover> rovers = repository.findAll();
        return rovers.get(0);
    }
}
