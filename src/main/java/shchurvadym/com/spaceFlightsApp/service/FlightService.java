package shchurvadym.com.spaceFlightsApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shchurvadym.com.spaceFlightsApp.entity.Flight;
import shchurvadym.com.spaceFlightsApp.repository.FlightRepository;

import java.util.List;

@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> getAllFlights(){
        return flightRepository.findAll();
    }

    public void addFlight(Flight flight){
        flightRepository.save(flight);
    }

    public void updateFlight(Flight flight){
        Flight flightToUpdate = flightRepository.getOne(flight.getId());
        if(flightToUpdate != null){
            flightRepository.save(flight);
        }
    }
    public void deleteFlight(Long id){
        Flight flight = flightRepository.getOne(id);
        if(flight != null){
            flightRepository.deleteById(id);
        }
    }
}
