package vshchur.com.spaceScanner.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vshchur.com.spaceScanner.entities.BorderPass;
import vshchur.com.spaceScanner.entities.CharterFlight;
import vshchur.com.spaceScanner.entities.CycleFlight;
import vshchur.com.spaceScanner.entities.SeatCode;

import java.util.List;
import java.util.Optional;

public interface BorderPassRepository extends JpaRepository<BorderPass, Long> {

    Optional<BorderPass> findBorderPassByCharterFlightAndSeatCode(CharterFlight charterFlight, SeatCode seatCode);
    Optional<BorderPass> findBorderPassByCycleFlightAndSeatCode(CycleFlight cycleFlight, SeatCode seatCode);

    @Query("select b from BorderPass b where b.tourist.user.userId = ?1")
    List<BorderPass> findAllByUserId(long userId);

    @Query("select b from BorderPass b where b.charterFlight.charterFlightId = ?1")
    List<BorderPass> findAllByCharterId(long charterId);

    @Query("select b from BorderPass b where b.cycleFlight.cycleFlightId = ?1")
    List<BorderPass> findAllByCycleId(long charterId);
}
