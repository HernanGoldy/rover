package academy.atl.services;

import academy.atl.models.Orientacion;
import academy.atl.models.Rover;
import academy.atl.repository.RoverRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@SpringBootTest
public class RoverServiceImpTest {

    @MockBean
    private RoverRepository roverRepository;

    @Autowired
    private RoverServiceImp service;

    @Test
    @DisplayName("Al enviar comando, se llama al servicio")
    public void alEnviarComando_llamarAlServicio() {
        Rover rover = new Rover();
        rover.setX(5);
        rover.setY(5);
        rover.setOrientacion(Orientacion.NORTE);
        List<Rover> roverList = new ArrayList<>();
        roverList.add(rover);

        when(roverRepository.findAll()).thenReturn(roverList);

        service.enviarComando("F");

        Rover finalRover = new Rover();
        finalRover.setX(5);
        finalRover.setY(4);
        finalRover.setOrientacion(Orientacion.NORTE);

        verify(roverRepository, times(1)).save(finalRover);
    }
}