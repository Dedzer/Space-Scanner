package vshchur.com.spaceScanner.model.request.form;

import java.time.LocalDate;
import java.time.LocalTime;

public class FlightSearchForm {

    private LocalTime departureTime;
    private LocalDate departureDate;
    private LocalTime returnDepartureTime;
    private LocalDate returnDepartureDate;
    private String arrivalAirportCode;
    private String departureAirportCode;

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

    public LocalTime getReturnDepartureTime() {
        return returnDepartureTime;
    }

    public void setReturnDepartureTime(LocalTime returnDepartureTime) {
        this.returnDepartureTime = returnDepartureTime;
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
