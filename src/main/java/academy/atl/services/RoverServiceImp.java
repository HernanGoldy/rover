package academy.atl.services;

import academy.atl.models.Obstaculo;
import academy.atl.models.Orientacion;
import academy.atl.models.Rover;
import academy.atl.repository.ObstaculoRepository;
import academy.atl.repository.RoverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoverServiceImp implements RoverService{

    // Para acceder a todas las funciones del repositorio
    @Autowired
    private RoverRepository repository;

    @Autowired
    private ObstaculoRepository obstaculoRepository;

    @Override
    public Rover obtener() {
        List<Rover> rovers = repository.findAll();
        return rovers.get(0);
    }

    @Override
    public void enviarComando(String comando) {
        Rover rover = obtener();

        switch (comando) {
            case "F": moverRover(rover, true); break;
            case "B": moverRover(rover, false); break;
            case "R": rotarRover(rover, true); break;
            case "L": rotarRover(rover, false); break;
        }
        repository.save(rover);
    }

    private void rotarRover(Rover rover, boolean rotacion) {
        Orientacion orientacion = rover.getOrientacion();
        Orientacion orientacionFinal = null;

        if (rotacion) {
            switch (orientacion) {
                case NORTE: orientacionFinal = Orientacion.ESTE; break;
                case ESTE: orientacionFinal = Orientacion.SUR; break;
                case SUR: orientacionFinal = Orientacion.OESTE; break;
                case OESTE: orientacionFinal = Orientacion.NORTE; break;
            }
        } else {
            switch (orientacion) {
                case NORTE: orientacionFinal = Orientacion.OESTE; break;
                case OESTE: orientacionFinal = Orientacion.SUR; break;
                case SUR: orientacionFinal = Orientacion.ESTE; break;
                case ESTE: orientacionFinal = Orientacion.NORTE; break;
            }
        }
        rover.setOrientacion(orientacionFinal);
    }

    private void moverRover(Rover rover, boolean mover) {
        int posXFinal = rover.getX();
        int posYFinal = rover.getY();

        Orientacion orientacion = rover.getOrientacion();
        if (Orientacion.ESTE.equals(orientacion)
                || Orientacion.OESTE.equals(orientacion)) {
            posXFinal -= mover ? orientacion.getValue() : -orientacion.getValue();
        }

        if (Orientacion.NORTE.equals(orientacion)
                || Orientacion.SUR.equals(orientacion)) {
            posYFinal -= mover ? orientacion.getValue() : -orientacion.getValue();
        }

        if (puedeMoverseAEstaPosicion(posXFinal, posYFinal)) {
            rover.setX(posXFinal);
            rover.setY(posYFinal);
        }
    }

    private boolean puedeMoverseAEstaPosicion(int posXFinal, int posYFinal) {
        List<Obstaculo> obstaculos =obstaculoRepository.findAll();

        for (Obstaculo obstaculo : obstaculos) {
            if (obstaculo.getX() == posXFinal
                    && obstaculo.getY() == posYFinal) {
                return false;
            }
        }
        return true;
    }
}
