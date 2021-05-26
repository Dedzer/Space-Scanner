package vshchur.com.spaceScanner.model.response.dto;

import vshchur.com.spaceScanner.entities.Airport;
import vshchur.com.spaceScanner.entities.CharterFlight;
import vshchur.com.spaceScanner.entities.CycleFlight;
import vshchur.com.spaceScanner.entities.Flight;
import vshchur.com.spaceScanner.enums.FlightType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class FlightDTO {

    private Long flightId;
    private FlightType flightType;
    private LocalTime arrivalTime;
    private LocalDate arrivalDate;
    private LocalTime departureTime;
    private LocalDate departureDate;
    private String departureAirport;
    private String departurePlanet;
    private String arrivalAirport;
    private String arrivalPlanet;
    private Float distance;
    private BigDecimal price;

    public static FlightDTO fromCharterFlight(CharterFlight charterFlight) {
        FlightDTO flightDTO = new FlightDTO();
        flightDTO.setFlightId(charterFlight.getCharterFlightId());
        flightDTO.setArrivalTime(charterFlight.getArrivalTime());
        flightDTO.setArrivalDate(charterFlight.getArrivalDate());
        flightDTO.setDepartureTime(charterFlight.getDepartureTime());
        flightDTO.setDepartureDate(charterFlight.getDepartureDate());
        Flight flight = charterFlight.getFlight();
        Airport departureAirport = flight.getDeparture();
        Airport arrivalAirport = flight.getArrival();
        flightDTO.setDepartureAirport(departureAirport.getAirportName());
        flightDTO.setDeparturePlanet(departureAirport.getPlanet().getPlanetName());
        flightDTO.setArrivalAirport(arrivalAirport.getAirportName());
        flightDTO.setArrivalPlanet(arrivalAirport.getPlanet().getPlanetName());
        flightDTO.setDistance(flight.getDistance());
        flightDTO.setPrice(flight.getFlightPrice().getOriginalPrice());
        flightDTO.setFlightType(FlightType.CHARTER);
        return flightDTO;
    }

    public static FlightDTO fromCycleFlight(CycleFlight cycleFlight) {
        FlightDTO flightDTO = new FlightDTO();
        flightDTO.setFlightId(cycleFlight.getCycleFlightId());
        flightDTO.setArrivalTime(cycleFlight.getRegularFlight().getArrivalTime());
        flightDTO.setArrivalDate(cycleFlight.getArrivalDate());
        flightDTO.setDepartureTime(cycleFlight.getRegularFlight().getDepartureTime());
        flightDTO.setDepartureDate(cycleFlight.getDepartureDate());
        Flight flight = cycleFlight.getRegularFlight().getFlight();
        Airport departureAirport = flight.getDeparture();
        Airport arrivalAirport = flight.getArrival();
        flightDTO.setDepartureAirport(departureAirport.getAirportName());
        flightDTO.setDeparturePlanet(departureAirport.getPlanet().getPlanetName());
        flightDTO.setArrivalAirport(arrivalAirport.getAirportName());
        flightDTO.setArrivalPlanet(arrivalAirport.getPlanet().getPlanetName());
        flightDTO.setDistance(flight.getDistance());
        flightDTO.setPrice(flight.getFlightPrice().getOriginalPrice());
        flightDTO.setFlightType(FlightType.CYCLE);
        return flightDTO;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public FlightType getFlightType() {
        return flightType;
    }

    public void setFlightType(FlightType flightType) {
        this.flightType = flightType;
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

    public Float getDistance() {
        return distance;
    }

    public void setDistance(Float distance) {
        this.distance = distance;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
