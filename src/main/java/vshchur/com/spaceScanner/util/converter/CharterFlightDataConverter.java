package vshchur.com.spaceScanner.util.converter;

import org.springframework.stereotype.Component;
import vshchur.com.spaceScanner.entities.CharterFlight;
import vshchur.com.spaceScanner.entities.Flight;
import vshchur.com.spaceScanner.model.request.form.CharterFlightForm;
import vshchur.com.spaceScanner.service.AirportService;
import vshchur.com.spaceScanner.service.FlightService;
import vshchur.com.spaceScanner.service.SpaceShuttleService;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Locale;
import java.util.Map;

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
        charterFlight.setArrivalTime(parseUSTime(charterFlightForm.getArrivalTime()));
        charterFlight.setDepartureDate(charterFlightForm.getDepartureDate());
        charterFlight.setDepartureTime(parseUSTime(charterFlightForm.getDepartureTime()));
        return charterFlight;
    }

    private LocalTime parseUSTime(String time) {
        Map<Long, String> ampmStrings = Map.of(0L, "p", 1L, "a");
        DateTimeFormatter timeFormatter = new DateTimeFormatterBuilder()
                .appendPattern("hh:mm")
                .appendText(ChronoField.AMPM_OF_DAY, ampmStrings)
                .toFormatter();
        return LocalTime.parse(time, timeFormatter);
    }

}
