package vshchur.com.spaceScanner.util.converter;

import org.springframework.stereotype.Component;
import vshchur.com.spaceScanner.entities.CharterFlight;
import vshchur.com.spaceScanner.entities.Flight;
import vshchur.com.spaceScanner.model.request.form.CharterFlightForm;
import vshchur.com.spaceScanner.service.AirportService;
import vshchur.com.spaceScanner.service.FlightService;
import vshchur.com.spaceScanner.service.SpaceShuttleService;

@Component
public class CharterFlightDataConverter extends FlightDataConverter {

    public CharterFlightDataConverter(AirportService airportService, FlightService flightService, SpaceShuttleService spaceShuttleService) {
        super(airportService, flightService, spaceShuttleService);
    }

    public CharterFlight toCharterFlight(CharterFlightForm charterFlightForm) {
        Flight flight = toFlight(charterFlightForm);
        CharterFlight charterFlight = new CharterFlight();
        charterFlight.setFlight(flight);
        charterFlight.setSpaceShip(getSpaceShuttle(charterFlightForm.getSpaceShuttleCode()));
        charterFlight.setArrivalDate(charterFlightForm.getArrivalDate());
        charterFlight.setArrivalTime(charterFlightForm.getArrivalTime());
        charterFlight.setDepartureDate(charterFlightForm.getDepartureDate());
        charterFlight.setDepartureTime(charterFlightForm.getDepartureTime());
        return charterFlight;
    }
}
