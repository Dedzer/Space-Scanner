package vshchur.com.spaceScanner.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vshchur.com.spaceScanner.entities.Airport;

import java.util.List;
import java.util.Optional;

public interface AirportRepository extends JpaRepository<Airport, Long> {

    Optional<Airport> findAirportByAirportCode(String airportCode);

    @Query(value = "select a from Airport a where a.planet.planetCode = ?1")
    List<Airport> findAllByPlanetCode(String planetCode);
}
