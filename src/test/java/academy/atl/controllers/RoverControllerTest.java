package academy.atl.controllers;

import academy.atl.dto.ComandosDto;
import academy.atl.services.RoverService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class RoverControllerTest {

    @MockBean
    private RoverService roverService;

    @Autowired
    private RoverController controller;


    @Test
    @DisplayName("Al enviar comando, se llama al servicio")
    public void cuandoSeEnviaComando_llamarAlServicio() {
        ComandosDto commandDto = new ComandosDto();
        List<String> commandsList = new ArrayList<>();
        commandsList.add("F");
        commandDto.setComandos(commandsList);

        controller.enviarComandos(commandDto);

        verify(roverService, times(1)).enviarComando("F");
    }

    @Test
    @DisplayName("Al enviar comandos FRF, se llama al servicio")
    public void cuandoSeEnvianComandos_FRF_llamarAlServicio() {
        ComandosDto commandDto = new ComandosDto();
        List<String> commandsList = new ArrayList<>();
        commandsList.add("F");
        commandsList.add("R");
        commandsList.add("F");
        commandDto.setComandos(commandsList);

        controller.enviarComandos(commandDto);

        // comprobamos si se llama un método
        verify(roverService, times(3)).enviarComando(any());

        // verificamos el tamaño de la lista
        assertEquals(3, commandsList.size());

        // verificamos si el valor enviado es el no esperado
        assertNotEquals("F", commandsList.get(1));
    }
}