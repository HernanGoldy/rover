package academy.atl.controllers;

import academy.atl.dto.ObstaculoDto;
import academy.atl.models.Obstaculo;
import academy.atl.services.ObstaculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Obstaculo> crear(@RequestBody ObstaculoDto obstaculo) {
        Obstaculo obstaculo1 = service.crear(new Obstaculo(obstaculo)).orElseThrow();
        return ResponseEntity.status(HttpStatus.CREATED).body(obstaculo1);
    }

    // Para mostrar todos los obstáculos
    @GetMapping("api/obstaculo/")
    public ResponseEntity<List<Obstaculo>> mostrarObstaculos() {
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body(service.mostrarObstaculos());
    }
}
