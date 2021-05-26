package vshchur.com.spaceScanner.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vshchur.com.spaceScanner.entities.BorderPass;
import vshchur.com.spaceScanner.entities.CharterFlight;
import vshchur.com.spaceScanner.entities.CycleFlight;
import vshchur.com.spaceScanner.entities.SeatCode;

import java.util.Optional;

public interface BorderPassRepository extends JpaRepository<BorderPass, Long> {

    Optional<BorderPass> findBorderPassByCharterFlightAndSeatCode(CharterFlight charterFlight, SeatCode seatCode);
    Optional<BorderPass> findBorderPassByCycleFlightAndSeatCode(CycleFlight cycleFlight, SeatCode seatCode);
}
