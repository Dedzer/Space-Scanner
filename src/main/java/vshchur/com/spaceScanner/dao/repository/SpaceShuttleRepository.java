package vshchur.com.spaceScanner.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vshchur.com.spaceScanner.entities.SpaceShuttle;

import java.util.Optional;

public interface SpaceShuttleRepository extends JpaRepository<SpaceShuttle, Long> {

    Optional<SpaceShuttle> findSpaceShuttleBySpaceShuttleCode(String spaceShuttleCode);
}
