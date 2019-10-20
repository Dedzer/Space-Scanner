package shchurvadym.com.spaceFlightsApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import shchurvadym.com.spaceFlightsApp.entity.Tourist;

import java.util.Optional;

public interface TouristRepository extends JpaRepository<Tourist, Long> {
    @Query("select t from Tourist t where t.passportNumber=?1")
    Optional<Tourist> findTouristByPassportNumber(String passportNumber);
}
