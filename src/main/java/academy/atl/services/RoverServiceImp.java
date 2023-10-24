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

        switch (comando.toUpperCase()) {
            case "F" -> moverRover(rover, true);
            case "B" -> moverRover(rover, false);
            case "R" -> rotarRover(rover, true);
            case "L" -> rotarRover(rover, false);
        }
        repository.save(rover);
    }

    /**
     * @param rotacionDerecha Aquí la rotación del Rover va a ser en sentido de las agujas del reloj. Por ej: Si en
     *                        la «orientación inicial» el Rover está mirando al NORTE, al «rotar», su
     *                        «orientación final» será mirando al ESTE y así rotará sucesivamente.
     */
    private void rotarRover(Rover rover, boolean rotacionDerecha) {
        Orientacion orientacion = rover.getOrientacion();
        Orientacion orientacionFinal = null;

        if (rotacionDerecha) {
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
        List<Obstaculo> obstaculos = (List<Obstaculo>) obstaculoRepository.findAll();

        for (Obstaculo obstaculo : obstaculos) {
            if (obstaculo.getX() == posXFinal
                    && obstaculo.getY() == posYFinal) {
                return false;
            }
        }
        return true;
    }
}
