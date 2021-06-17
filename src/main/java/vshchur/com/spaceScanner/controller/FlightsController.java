package vshchur.com.spaceScanner.controller;

import org.springframework.web.bind.annotation.*;
import vshchur.com.spaceScanner.enums.FlightType;
import vshchur.com.spaceScanner.model.request.form.FlightSearchForm;
import vshchur.com.spaceScanner.model.response.dto.AvailableFlightsDTO;
import vshchur.com.spaceScanner.model.response.dto.BorderPassDTO;
import vshchur.com.spaceScanner.model.response.dto.FlightDTO;
import vshchur.com.spaceScanner.model.response.dto.SeatCodeDTO;
import vshchur.com.spaceScanner.service.BorderPassService;
import vshchur.com.spaceScanner.service.CharterFlightService;
import vshchur.com.spaceScanner.service.RegularFlightService;
import vshchur.com.spaceScanner.util.JwtUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    private final BorderPassService borderPassService;
    private final JwtUtil jwtUtil;

    public FlightsController(CharterFlightService charterFlightService,
                             RegularFlightService regularFlightService,
                             BorderPassService borderPassService,
                             JwtUtil jwtUtil) {
        this.charterFlightService = charterFlightService;
        this.regularFlightService = regularFlightService;
        this.borderPassService = borderPassService;
        this.jwtUtil = jwtUtil;
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
        returnFlights.addAll(charterFlights.getReturnAvailableFlights());
        returnFlights.addAll(regularFlights.getReturnAvailableFlights());
        availableFlightsDTO.setAvailableFlights(flights);
        availableFlightsDTO.setReturnAvailableFlights(returnFlights);
        return availableFlightsDTO;
    }

    @GetMapping("/user")
    public List<BorderPassDTO> getUserFlights(HttpServletRequest request) {
        return borderPassService.findUserFlights(jwtUtil.retrieveUserId(Optional.of(request.getHeader("Authorization"))));
    }

    @GetMapping("/{flightId}")
    public FlightDTO getFlightDetails(@PathVariable Long flightId, @RequestParam FlightType flightType) {
        if (FlightType.CHARTER.equals(flightType)) {
            return charterFlightService.getFlight(flightId);
        }
        if (FlightType.CYCLE.equals(flightType)) {
            return charterFlightService.getFlight(flightId);
        }
        return new FlightDTO();
    }

    @GetMapping("/{flightId}/seat-codes")
    public List<SeatCodeDTO> findAvailableSeatCodes(@PathVariable Long flightId, @RequestParam FlightType flightType) {
        return borderPassService.findAvailableSeatCodes(flightId, flightType);
    }
}
