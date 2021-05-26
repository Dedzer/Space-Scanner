package vshchur.com.spaceScanner.util.converter;

import vshchur.com.spaceScanner.entities.Airport;
import vshchur.com.spaceScanner.entities.Flight;
import vshchur.com.spaceScanner.entities.FlightPrice;
import vshchur.com.spaceScanner.entities.SpaceShuttle;
import vshchur.com.spaceScanner.model.request.form.FlightForm;
import vshchur.com.spaceScanner.service.AirportService;
import vshchur.com.spaceScanner.service.FlightService;
import vshchur.com.spaceScanner.service.SpaceShuttleService;

import java.util.Optional;

public class FlightDataConverter {

    private final AirportService airportService;
    private final FlightService flightService;
    private final SpaceShuttleService spaceShuttleService;

    public FlightDataConverter(AirportService airportService, FlightService flightService, SpaceShuttleService spaceShuttleService) {
        this.airportService = airportService;
        this.flightService = flightService;
        this.spaceShuttleService = spaceShuttleService;
    }

    protected Flight toFlight(FlightForm flightForm) {
        Airport arrival = getAirport(flightForm.getArrival());
        Airport departure = getAirport(flightForm.getDeparture());
        Optional<Flight> flight = flightService.findFlightByDepartureAndArrivalIds(arrival.getAirportId(), departure.getAirportId());
        if (flight.isPresent()) {
            return flight.get();
        } else {
            Flight newFlight = new Flight();
            newFlight.setArrival(arrival);
            newFlight.setDeparture(departure);
            newFlight.setDistance(countPlanetsDistance(arrival.getPlanet().getDistanceFromSun(), departure.getPlanet().getDistanceFromSun()));
            newFlight.setFlightPrice(populatePrice(flightForm));
            newFlight.getFlightPrice().setFlight(newFlight);
            return newFlight;
        }
    }

    private FlightPrice populatePrice(FlightForm flightForm) {
        FlightPrice flightPrice = new FlightPrice();
        flightPrice.setOriginalPrice(flightForm.getPrice());
        return flightPrice;
    }

    protected SpaceShuttle getSpaceShuttle(String spaceShuttleCode) {
        return spaceShuttleService.findSpaceShuttleByCode(spaceShuttleCode);
    }

    private Airport getAirport(String code) {
        return airportService.findAirportByCode(code);
    }

    private Float countPlanetsDistance(float first, float second) {
        if (first > second) {
            return first - second;
        }
        return second - first;
    }
}
