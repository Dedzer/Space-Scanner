package vshchur.com.spaceScanner.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vshchur.com.spaceScanner.entities.CharterFlight;

import java.time.LocalDate;
import java.util.List;

public interface CharterFlightRepository extends JpaRepository<CharterFlight, Long> {

    @Query(
            value = "select * from charter_flight_t " +
                    "join flight_t on charter_flight_t.flight_id = flight_t.flight_id " +
                    "join space_shuttle_t on charter_flight_t.space_shuttle_id = space_shuttle_t.space_shuttle_id " +
                    "join airport_t as departure on flight_t.departure_id = departure.airport_id " +
                    "join airport_t as arrival on flight_t.arrival_id = arrival.airport_id " +
                    "where (" +
                    " select count(*) from border_pass_t where charter_flight_id=charter_flight_t.charter_flight_id" +
                    ") < space_shuttle_t.places_amount " +
                    "and charter_flight_t.departure_date =:departureDate " +
                    "and departure.airport_code =:departureAirportCode " +
                    "and arrival.airport_code =:arrivalAirportCode",
            nativeQuery = true
    )
    List<CharterFlight> findAllAvailableFlights(@Param("departureDate") LocalDate departureDate,
                                                @Param("departureAirportCode") String departureAirportCode,
                                                @Param("arrivalAirportCode") String arrivalAirportCode);
}
