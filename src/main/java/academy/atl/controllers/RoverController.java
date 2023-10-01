package academy.atl.controllers;

import academy.atl.dto.*;
import academy.atl.models.Rover;
import academy.atl.services.RoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoverController {

    @Autowired
    private RoverService service;

    // Para crear el Rover
    @PostMapping("api/rover/")
    public void crear(@RequestBody RoverDto rover) {
        System.out.println(rover);
    }

    // Para obtener la ubicación del Rover
    @GetMapping("api/rover/")
    public Rover obtener() {
        return service.obtener();
    }

    // Para enviar una lista de comandos para que los ejecute el Rover
    @PostMapping("api/rover/comandos/")
    public void enviarComandos(@RequestBody ComandosDto comandos) {
        System.out.println(comandos);
    }
}
