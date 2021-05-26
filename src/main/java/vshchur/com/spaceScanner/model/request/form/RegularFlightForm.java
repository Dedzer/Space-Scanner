package vshchur.com.spaceScanner.model.request.form;

import java.time.LocalTime;
import java.util.List;

public class RegularFlightForm extends FlightForm {

    private LocalTime arrivalTime;
    private LocalTime departureTime;
    private List<CycleDetailsForm> cycleDetails;

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public List<CycleDetailsForm> getCycleDetails() {
        return cycleDetails;
    }

    public void setCycleDetails(List<CycleDetailsForm> cycleDetails) {
        this.cycleDetails = cycleDetails;
    }
}
