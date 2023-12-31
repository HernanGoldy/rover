package academy.atl.services;

import academy.atl.models.Obstaculo;
import academy.atl.repository.ObstaculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ObstaculoServiceImp implements ObstaculoService {

    // Para acceder a todas las funciones del repositorio
    @Autowired
    private ObstaculoRepository repository;

    @Override
    public List<Obstaculo> mostrarObstaculos() {
        return (List<Obstaculo>) repository.findAll();
    }

    @Override
    public Optional<Obstaculo> crear(Obstaculo obstaculo) {
         return Optional.of(repository.save(obstaculo));
    }

    @Override
    public void actualizar(Obstaculo obstaculo) { }

    @Override
    public void borrar(Obstaculo obstaculo) { }
}
