package vshchur.com.spaceScanner.service;

import org.springframework.stereotype.Service;
import vshchur.com.spaceScanner.entities.Flight;
import vshchur.com.spaceScanner.dao.repository.FlightRepository;

import java.util.Optional;

@Service
public class FlightService {

    private final FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public Optional<Flight> findFlightByDepartureAndArrivalIds(long arrivalId, long departureId) {
        return flightRepository.findFlightByArrivalAirportIdAndDepartureAirportId(arrivalId, departureId);
    }
}
