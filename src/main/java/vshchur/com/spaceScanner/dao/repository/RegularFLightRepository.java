package vshchur.com.spaceScanner.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vshchur.com.spaceScanner.entities.RegularFlight;

public interface RegularFLightRepository extends JpaRepository<RegularFlight, Long> {
}
