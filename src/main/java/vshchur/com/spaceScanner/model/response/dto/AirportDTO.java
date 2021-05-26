package vshchur.com.spaceScanner.model.response.dto;

import vshchur.com.spaceScanner.entities.Airport;

public class AirportDTO {

    private String airportCode;
    private String airportName;


    public static AirportDTO fromAirport(Airport airport) {
        AirportDTO airportDTO = new AirportDTO();
        airportDTO.setAirportCode(airport.getAirportCode());
        airportDTO.setAirportName(airport.getAirportName());
        return airportDTO;
    }

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }
}
