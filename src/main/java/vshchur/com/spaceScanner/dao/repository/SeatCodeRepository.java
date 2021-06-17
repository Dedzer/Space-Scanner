package vshchur.com.spaceScanner.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vshchur.com.spaceScanner.entities.SeatCode;
import vshchur.com.spaceScanner.entities.SpaceShuttle;

import java.util.List;
import java.util.Optional;

public interface SeatCodeRepository extends JpaRepository<SeatCode, Long> {

    Optional<SeatCode> findSeatCodeBySeatCodeAndSpaceShuttle(String seatCode, SpaceShuttle spaceShuttleId);

    @Query("select s from SeatCode s where s.spaceShuttle.spaceShuttleId = ?1")
    List<SeatCode> findAllBySpaceShuttleId(long shuttleId);

}
