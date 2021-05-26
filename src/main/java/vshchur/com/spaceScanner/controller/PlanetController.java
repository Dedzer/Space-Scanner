package vshchur.com.spaceScanner.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vshchur.com.spaceScanner.model.response.dto.PlanetDTO;
import vshchur.com.spaceScanner.service.PlanetService;

import java.util.List;

@RestController
@RequestMapping("/planets")
public class PlanetController {

    private final PlanetService planetService;

    public PlanetController(PlanetService planetService) {
        this.planetService = planetService;
    }

    @GetMapping
    public List<PlanetDTO> getPlanets() {
        return planetService.getPlanets();
    }
}
