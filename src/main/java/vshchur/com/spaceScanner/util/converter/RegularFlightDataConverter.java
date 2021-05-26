package vshchur.com.spaceScanner.util.converter;

import org.springframework.stereotype.Component;
import vshchur.com.spaceScanner.entities.CycleFlight;
import vshchur.com.spaceScanner.entities.Flight;
import vshchur.com.spaceScanner.entities.RegularFlight;
import vshchur.com.spaceScanner.model.request.form.CycleDetailsForm;
import vshchur.com.spaceScanner.model.request.form.RegularFlightForm;
import vshchur.com.spaceScanner.service.AirportService;
import vshchur.com.spaceScanner.service.FlightService;
import vshchur.com.spaceScanner.service.SpaceShuttleService;

import java.util.ArrayList;
import java.util.List;

@Component
public class RegularFlightDataConverter extends FlightDataConverter {

    public RegularFlightDataConverter(AirportService airportService, FlightService flightService, SpaceShuttleService spaceShuttleService) {
        super(airportService, flightService, spaceShuttleService);
    }

    public RegularFlight toRegularFlight(RegularFlightForm flightForm) {
        Flight flight = toFlight(flightForm);
        RegularFlight regularFlight = new RegularFlight();
        regularFlight.setFlight(flight);
        regularFlight.setArrivalTime(flightForm.getArrivalTime());
        regularFlight.setDepartureTime(flightForm.getDepartureTime());
        regularFlight.setSpaceShuttle(getSpaceShuttle(flightForm.getSpaceShuttleCode()));
        regularFlight.setCycleFlights(prepareCycleDetails(flightForm.getCycleDetails()));
        return regularFlight;
    }

    private List<CycleFlight> prepareCycleDetails(List<CycleDetailsForm> cycleDetailsForms) {
        List<CycleFlight> cycleDetails = new ArrayList<>();
        for (CycleDetailsForm cycleDetailsForm : cycleDetailsForms) {
            CycleFlight cycleDetail = new CycleFlight();
            cycleDetail.setArrivalDate(cycleDetailsForm.getArrivalDate());
            cycleDetail.setDepartureDate(cycleDetailsForm.getDepartureDate());
        }
        return cycleDetails;
    }
}
