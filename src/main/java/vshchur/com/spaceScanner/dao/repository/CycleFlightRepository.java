package vshchur.com.spaceScanner.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vshchur.com.spaceScanner.entities.CycleFlight;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface CycleFlightRepository extends JpaRepository<CycleFlight, Long> {

    @Query(
            value = "select * from cycle_flight_t " +
                    "join regular_flight_t on cycle_flight_t.regular_flight_id = regular_flight_t.regular_flight_id " +
                    "join flight_t on regular_flight_t.flight_id = flight_t.flight_id " +
                    "join space_shuttle_t on regular_flight_t.space_shuttle_id = space_shuttle_t.space_shuttle_id " +
                    "join airport_t as departure on flight_t.departure_id = departure.airport_id " +
                    "join airport_t as arrival on flight_t.arrival_id = arrival.airport_id " +
                    "where (" +
                    " select count(*) from border_pass_t where border_pass_t.cycle_flight_id=cycle_flight_t.cycle_flight_id" +
                    ") < space_shuttle_t.places_amount " +
                    "and cycle_flight_t.departure_date =:departureDate " +
                    "and regular_flight_t.departure_time >:departureTime " +
                    "and departure.airport_code =:departureAirportCode " +
                    "and arrival.airport_code =:arrivalAirportCode",
            nativeQuery = true
    )
    List<CycleFlight> findAllAvailableFlights(@Param("departureDate") LocalDate departureDate,
                                              @Param("departureTime") LocalTime departureTime,
                                              @Param("departureAirportCode") String departureAirportCode,
                                              @Param("arrivalAirportCode") String arrivalAirportCode);
}
