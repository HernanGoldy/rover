package academy.atl.controllers;

import academy.atl.dto.ComandosDto;
import academy.atl.dto.RoverDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoverController {

    // Para crear el Rover
    @PostMapping("api/rover/")
    public void create(@RequestBody RoverDto rover) {
        System.out.println(rover);
    }

    // Para crear una lista de comandos para que los ejecute el Rover
    @PostMapping("api/rover/comandos")
    public void create(@RequestBody ComandosDto comandos) {
        System.out.println(comandos);
    }
}
