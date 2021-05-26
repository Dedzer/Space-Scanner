package vshchur.com.spaceScanner.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vshchur.com.spaceScanner.model.request.form.FlightSearchForm;
import vshchur.com.spaceScanner.model.response.dto.AvailableFlightsDTO;
import vshchur.com.spaceScanner.model.response.dto.FlightDTO;
import vshchur.com.spaceScanner.service.CharterFlightService;
import vshchur.com.spaceScanner.service.RegularFlightService;

import java.util.ArrayList;
import java.util.List;

//todo search flights
//todo view flight details
//todo book flight
//todo lock place while booking process
//todo cancel booking
//todo seat codes
@RestController
@RequestMapping(value = "/flights")
public class FlightsController {

    private final CharterFlightService charterFlightService;
    private final RegularFlightService regularFlightService;

    public FlightsController(CharterFlightService charterFlightService, RegularFlightService regularFlightService) {
        this.charterFlightService = charterFlightService;
        this.regularFlightService = regularFlightService;
    }

    @PostMapping("/get")
    public AvailableFlightsDTO findAvailableFlight(@RequestBody FlightSearchForm form) {
        AvailableFlightsDTO charterFlights = charterFlightService.findAvailableFlights(form);
        AvailableFlightsDTO regularFlights = regularFlightService.findAvailableFlights(form);
        AvailableFlightsDTO availableFlightsDTO = new AvailableFlightsDTO();
        List<FlightDTO> flights = new ArrayList<>();
        flights.addAll(charterFlights.getAvailableFlights());
        flights.addAll(regularFlights.getAvailableFlights());
        List<FlightDTO> returnFlights = new ArrayList<>();
        flights.addAll(regularFlights.getReturnAvailableFlights());
        flights.addAll(charterFlights.getReturnAvailableFlights());
        availableFlightsDTO.setAvailableFlights(flights);
        availableFlightsDTO.setReturnAvailableFlights(returnFlights);
        return availableFlightsDTO;
    }
}
