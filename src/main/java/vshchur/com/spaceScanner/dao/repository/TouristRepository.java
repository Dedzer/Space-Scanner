package vshchur.com.spaceScanner.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vshchur.com.spaceScanner.entities.Tourist;

public interface TouristRepository extends JpaRepository<Tourist, Long> {


}
