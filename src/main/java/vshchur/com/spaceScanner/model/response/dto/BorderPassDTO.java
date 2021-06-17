package vshchur.com.spaceScanner.model.response.dto;

import vshchur.com.spaceScanner.entities.*;

import java.time.LocalDate;
import java.time.LocalTime;

public class BorderPassDTO extends FlightDTO {

    private BorderPassTouristDTO tourist;

    public static BorderPassDTO fromBorderPass(BorderPass borderPass) {
        BorderPassDTO borderPassDTO = new BorderPassDTO();
        Tourist tourist = borderPass.getTourist();
        BorderPassTouristDTO borderPassTouristDTO = new BorderPassTouristDTO();
        borderPassTouristDTO.setFirstName(tourist.getFirstName());
        borderPassTouristDTO.setLastName(tourist.getLastName());
        borderPassTouristDTO.setTouristId(tourist.getTouristId());
        if (borderPass.getCharterFlight() != null) {
            CharterFlight charterFlight = borderPass.getCharterFlight();
            borderPassDTO.setFlightId(charterFlight.getCharterFlightId());
            borderPassDTO.setArrivalTime(charterFlight.getArrivalTime());
            borderPassDTO.setArrivalDate(charterFlight.getArrivalDate());
            borderPassDTO.setDepartureTime(charterFlight.getDepartureTime());
            borderPassDTO.setDepartureDate(charterFlight.getDepartureDate());
            borderPassDTO.setArrivalAirport(charterFlight.getFlight().getArrival().getAirportName());
            borderPassDTO.setArrivalPlanet(charterFlight.getFlight().getArrival().getPlanet().getPlanetName());
            borderPassDTO.setDepartureAirport(charterFlight.getFlight().getDeparture().getAirportName());
            borderPassDTO.setDeparturePlanet(charterFlight.getFlight().getDeparture().getPlanet().getPlanetName());
        }
        if (borderPass.getCycleFlight() != null) {
            CycleFlight cycleFlight = borderPass.getCycleFlight();
            borderPassDTO.setFlightId(cycleFlight.getCycleFlightId());
            borderPassDTO.setArrivalTime(cycleFlight.getRegularFlight().getArrivalTime());
            borderPassDTO.setArrivalDate(cycleFlight.getArrivalDate());
            borderPassDTO.setDepartureTime(cycleFlight.getRegularFlight().getDepartureTime());
            borderPassDTO.setDepartureDate(cycleFlight.getDepartureDate());
            borderPassDTO.setArrivalAirport(cycleFlight.getRegularFlight().getFlight().getArrival().getAirportName());
            borderPassDTO.setArrivalPlanet(cycleFlight.getRegularFlight().getFlight().getArrival().getPlanet().getPlanetName());
            borderPassDTO.setDepartureAirport(cycleFlight.getRegularFlight().getFlight().getDeparture().getAirportName());
            borderPassDTO.setDeparturePlanet(cycleFlight.getRegularFlight().getFlight().getDeparture().getPlanet().getPlanetName());
        }
        borderPassTouristDTO.setSeatCodeId(borderPass.getSeatCode().getSeatCode());
        borderPassDTO.setTourist(borderPassTouristDTO);
        return borderPassDTO;
    }

    public BorderPassTouristDTO getTourist() {
        return tourist;
    }

    public void setTourist(BorderPassTouristDTO tourist) {
        this.tourist = tourist;
    }
}
