package vshchur.com.spaceScanner.service;

import org.springframework.stereotype.Service;
import vshchur.com.spaceScanner.entities.Planet;
import vshchur.com.spaceScanner.exception.PlanetNotFoundException;
import vshchur.com.spaceScanner.dao.repository.PlanetRepository;
import vshchur.com.spaceScanner.model.response.dto.PlanetDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlanetService {

    private final PlanetRepository planetRepository;

    public PlanetService(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    public Planet getPlanetById(long id) {
        return planetRepository.findById(id).orElseThrow(PlanetNotFoundException::new);
    }

    public Planet getPlanetByCode(String code) {
        return planetRepository.findPlanetByPlanetCode(code).orElseThrow(PlanetNotFoundException::new);
    }

    public List<PlanetDTO> getPlanets() {
        return planetRepository.findAll().stream()
                .map(PlanetDTO::fromPlanet)
                .collect(Collectors.toList());
    }
}
