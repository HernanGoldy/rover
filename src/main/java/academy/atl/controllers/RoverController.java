package academy.atl.controllers;

import academy.atl.dto.*;
//import academy.atl.dto.RoverDto;
import academy.atl.models.Orientacion;
import academy.atl.models.Rover;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoverController {

    // Para crear el Rover
    @PostMapping("api/rover/")
    public void crear(@RequestBody RoverDto rover) {
        System.out.println(rover);
    }

    // Para obtener la ubicación del Rover
    @GetMapping("api/rover/")
    public Rover obtener() {
        Rover rover = new Rover();
        rover.setX(2);
        rover.setY(2);
        rover.setOrientacion(Orientacion.NORTE);
        return rover;
    }

    // Para enviar una lista de comandos para que los ejecute el Rover
    @PostMapping("api/rover/comandos/")
    public void enviarComandos(@RequestBody ComandosDto comandos) {
        System.out.println(comandos);
    }
}
