package shchurvadym.com.spaceFlightsApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shchurvadym.com.spaceFlightsApp.entity.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {

}
