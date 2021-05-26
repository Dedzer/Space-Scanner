package vshchur.com.spaceScanner.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vshchur.com.spaceScanner.entities.Flight;

import java.util.Optional;

public interface FlightRepository extends JpaRepository<Flight, Long> {

    Optional<Flight> findFlightByArrivalAirportIdAndDepartureAirportId (long arrivalId, long departureId);
}
