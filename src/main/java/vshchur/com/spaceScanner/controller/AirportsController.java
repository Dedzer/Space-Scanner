package vshchur.com.spaceScanner.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vshchur.com.spaceScanner.model.response.dto.AirportDTO;
import vshchur.com.spaceScanner.service.AirportService;

import java.util.List;

@RestController
@RequestMapping("/airports")
public class AirportsController {

    private final AirportService airportService;

    public AirportsController(AirportService airportService) {
        this.airportService = airportService;
    }

    @GetMapping
    public List<AirportDTO> findAllByPlanetCode(@RequestParam String planetCode) {
        return airportService.findAllByPlanetCode(planetCode);
    }
}
