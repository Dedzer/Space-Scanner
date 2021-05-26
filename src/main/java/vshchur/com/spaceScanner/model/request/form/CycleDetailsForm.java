package vshchur.com.spaceScanner.model.request.form;

import java.time.LocalDate;

public class CycleDetailsForm {

    private LocalDate arrivalDate;
    private LocalDate departureDate;

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }
}
