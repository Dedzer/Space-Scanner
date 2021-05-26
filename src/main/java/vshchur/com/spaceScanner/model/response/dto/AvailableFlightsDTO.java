package vshchur.com.spaceScanner.model.response.dto;

import java.util.List;

public class AvailableFlightsDTO {

    List<FlightDTO> availableFlights;
    List<FlightDTO> returnAvailableFlights;

    public List<FlightDTO> getAvailableFlights() {
        return availableFlights;
    }

    public void setAvailableFlights(List<FlightDTO> availableFlights) {
        this.availableFlights = availableFlights;
    }

    public List<FlightDTO> getReturnAvailableFlights() {
        return returnAvailableFlights;
    }

    public void setReturnAvailableFlights(List<FlightDTO> returnAvailableFlights) {
        this.returnAvailableFlights = returnAvailableFlights;
    }
}
