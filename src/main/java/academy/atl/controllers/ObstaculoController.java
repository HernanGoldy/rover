package academy.atl.controllers;

import academy.atl.dto.ObstaculoDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ObstaculoController {

    // Para crear un obstáculo
    @PostMapping("api/obstaculo/")
    public void crear(@RequestBody ObstaculoDto obstaculo) {
        System.out.println(obstaculo);
    }
}
