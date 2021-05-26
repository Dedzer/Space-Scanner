package vshchur.com.spaceScanner.model.response.dto;

import vshchur.com.spaceScanner.entities.*;

import java.time.LocalDate;
import java.time.LocalTime;

public class BorderPassDTO {

    private Long charterFlightId;
    private Long cycleFlightId;
    private long touristId;
    private String seatCodeId;
    private String firstName;
    private String lastName;
    private LocalTime arrivalTime;
    private LocalDate arrivalDate;
    private LocalTime departureTime;
    private LocalDate departureDate;
    private String departureAirport;
    private String departurePlanet;
    private String arrivalAirport;
    private String arrivalPlanet;

    public static BorderPassDTO fromBorderPass(BorderPass borderPass) {
        BorderPassDTO borderPassDTO = new BorderPassDTO();
        Tourist tourist = borderPass.getTourist();
        borderPassDTO.setFirstName(tourist.getFirstName());
        borderPassDTO.setLastName(tourist.getLastName());
        borderPassDTO.setTouristId(tourist.getTouristId());
        if (borderPass.getCharterFlight() != null) {
            CharterFlight charterFlight = borderPass.getCharterFlight();
            borderPassDTO.setCharterFlightId(charterFlight.getCharterFlightId());
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
            borderPassDTO.setCycleFlightId(cycleFlight.getCycleFlightId());
            borderPassDTO.setArrivalTime(cycleFlight.getRegularFlight().getArrivalTime());
            borderPassDTO.setArrivalDate(cycleFlight.getArrivalDate());
            borderPassDTO.setDepartureTime(cycleFlight.getRegularFlight().getDepartureTime());
            borderPassDTO.setDepartureDate(cycleFlight.getDepartureDate());
            borderPassDTO.setArrivalAirport(cycleFlight.getRegularFlight().getFlight().getArrival().getAirportName());
            borderPassDTO.setArrivalPlanet(cycleFlight.getRegularFlight().getFlight().getArrival().getPlanet().getPlanetName());
            borderPassDTO.setDepartureAirport(cycleFlight.getRegularFlight().getFlight().getDeparture().getAirportName());
            borderPassDTO.setDeparturePlanet(cycleFlight.getRegularFlight().getFlight().getDeparture().getPlanet().getPlanetName());
        }
        borderPassDTO.setSeatCodeId(borderPass.getSeatCode().getSeatCode());
        return borderPassDTO;
    }

    public Long getCharterFlightId() {
        return charterFlightId;
    }

    public void setCharterFlightId(Long charterFlightId) {
        this.charterFlightId = charterFlightId;
    }

    public Long getCycleFlightId() {
        return cycleFlightId;
    }

    public void setCycleFlightId(Long cycleFlightId) {
        this.cycleFlightId = cycleFlightId;
    }

    public long getTouristId() {
        return touristId;
    }

    public void setTouristId(long touristId) {
        this.touristId = touristId;
    }

    public String getSeatCodeId() {
        return seatCodeId;
    }

    public void setSeatCodeId(String seatCodeId) {
        this.seatCodeId = seatCodeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getDeparturePlanet() {
        return departurePlanet;
    }

    public void setDeparturePlanet(String departurePlanet) {
        this.departurePlanet = departurePlanet;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public String getArrivalPlanet() {
        return arrivalPlanet;
    }

    public void setArrivalPlanet(String arrivalPlanet) {
        this.arrivalPlanet = arrivalPlanet;
    }

}
