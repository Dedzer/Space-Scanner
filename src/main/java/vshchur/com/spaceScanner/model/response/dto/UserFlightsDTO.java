package vshchur.com.spaceScanner.model.response.dto;

import java.util.List;

public class UserFlightsDTO {

    List<FlightDTO> flights;

    public List<FlightDTO> getFlights() {
        return flights;
    }

    public void setFlights(List<FlightDTO> flights) {
        this.flights = flights;
    }
}
