package vshchur.com.spaceScanner.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vshchur.com.spaceScanner.entities.Planet;

import java.util.Optional;

public interface PlanetRepository extends JpaRepository<Planet, Long> {

    Optional<Planet> findPlanetByPlanetCode(String planetCode);
}
