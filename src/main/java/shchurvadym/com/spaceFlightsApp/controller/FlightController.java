package shchurvadym.com.spaceFlightsApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shchurvadym.com.spaceFlightsApp.entity.Flight;
import shchurvadym.com.spaceFlightsApp.service.FlightService;

import java.util.List;

@RestController
public class FlightController {
    @Autowired
    private FlightService flightService;

    @GetMapping("/flights")
    public List<Flight> flights(){
        return flightService.getAllFlights();
    }
    @PostMapping("/flight")
    public void addFlight(@RequestBody Flight flight){
        flightService.addFlight(flight);
    }
    @PutMapping("/flight/{id}")
    public void updateFlight(@RequestBody Flight flight, @PathVariable("id")Long id){
        flight.setId(id);
        flightService.updateFlight(flight);
    }
    @DeleteMapping("/flight/{id}")
    public void deleteFlight(@PathVariable("id")Long id){
        flightService.deleteFlight(id);
    }
}
