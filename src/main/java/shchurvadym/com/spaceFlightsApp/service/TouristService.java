package shchurvadym.com.spaceFlightsApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shchurvadym.com.spaceFlightsApp.entity.Flight;
import shchurvadym.com.spaceFlightsApp.entity.Tourist;
import shchurvadym.com.spaceFlightsApp.repository.FlightRepository;
import shchurvadym.com.spaceFlightsApp.repository.TouristRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TouristService {

    @Autowired
    private TouristRepository touristRepository;
    @Autowired
    private FlightRepository flightRepository;

    public List<Tourist> allTourists() {
        return touristRepository.findAll();
    }

    public void addTourist(Tourist tourist, Long id) {
        Flight flight = flightRepository.getOne(id);
        if (flight.getNumberOfPlaces() != 0) {
            flight.getTourists().add(tourist);
            Integer places = flight.getNumberOfPlaces();
            flight.setNumberOfPlaces(--places);
            flightRepository.save(flight);
        }
    }

    public void deleteTouristFromFlight(Long id, Long touristId) {
        Flight flight = flightRepository.getOne(id);
        if (touristRepository.findById(touristId).isPresent()) {
            List tourists = flight.getTourists();
            tourists.remove(touristRepository.getOne(touristId));
            flight.setTourists(tourists);
            Integer places = flight.getNumberOfPlaces();
            flight.setNumberOfPlaces(++places);
            flightRepository.save(flight);
        }
    }
}
