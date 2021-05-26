package vshchur.com.spaceScanner.service;

import org.springframework.stereotype.Service;
import vshchur.com.spaceScanner.dao.repository.AirportRepository;
import vshchur.com.spaceScanner.entities.Airport;
import vshchur.com.spaceScanner.exception.AirportNotFoundException;
import vshchur.com.spaceScanner.model.response.dto.AirportDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AirportService {

    private final AirportRepository airportRepository;

    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public Airport findAirportByCode(String code) {
        return airportRepository.findAirportByAirportCode(code).orElseThrow(AirportNotFoundException::new);
    }

    public List<AirportDTO> findAllByPlanetCode(String planetCode) {
        return airportRepository.findAllByPlanetCode(planetCode).stream()
                .map(AirportDTO::fromAirport)
                .collect(Collectors.toList());
    }
}
