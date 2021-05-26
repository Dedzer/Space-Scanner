package vshchur.com.spaceScanner.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vshchur.com.spaceScanner.entities.SeatCode;
import vshchur.com.spaceScanner.entities.SpaceShuttle;

import java.util.Optional;

public interface SeatCodeRepository extends JpaRepository<SeatCode, Long> {

    Optional<SeatCode> findSeatCodeBySeatCodeAndSpaceShuttle(String seatCode, SpaceShuttle spaceShuttleId);
}
