package vshchur.com.spaceScanner.model.request.form;

import java.time.LocalDate;
import java.time.LocalTime;

public class FlightSearchForm {

    private LocalDate departureDate;
    private LocalDate returnDepartureDate;
    private String arrivalAirportCode;
    private String departureAirportCode;


    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDate getReturnDepartureDate() {
        return returnDepartureDate;
    }

    public void setReturnDepartureDate(LocalDate returnDepartureDate) {
        this.returnDepartureDate = returnDepartureDate;
    }

    public String getArrivalAirportCode() {
        return arrivalAirportCode;
    }

    public void setArrivalAirportCode(String arrivalAirportCode) {
        this.arrivalAirportCode = arrivalAirportCode;
    }

    public String getDepartureAirportCode() {
        return departureAirportCode;
    }

    public void setDepartureAirportCode(String departureAirportCode) {
        this.departureAirportCode = departureAirportCode;
    }
}
