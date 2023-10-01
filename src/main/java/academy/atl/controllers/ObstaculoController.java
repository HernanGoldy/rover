package academy.atl.controllers;

import academy.atl.dto.ObstaculoDto;
import academy.atl.models.Obstaculo;
import academy.atl.services.ObstaculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ObstaculoController {

    @Autowired
    private ObstaculoService service;

    // Para crear un obstáculo
    @PostMapping("api/obstaculo/")
    public void crear(@RequestBody ObstaculoDto obstaculo) {

        System.out.println(obstaculo);
    }

    // Para mostrar todos los obstáculos
    @GetMapping("api/obstaculo/")
    public List<Obstaculo> mostrarObstaculos() {
        return service.mostrarObstaculos();
    }
}
