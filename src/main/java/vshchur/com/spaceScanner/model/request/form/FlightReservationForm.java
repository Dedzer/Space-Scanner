package vshchur.com.spaceScanner.model.request.form;

import vshchur.com.spaceScanner.enums.FlightType;

public class FlightReservationForm {

    private Long flightId;
    private FlightType flightType;
    private String seatCode;
    private TouristForm tourist;

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

    public TouristForm getTourist() {
        return tourist;
    }

    public void setTourist(TouristForm tourist) {
        this.tourist = tourist;
    }

    public String getSeatCode() {
        return seatCode;
    }

    public void setSeatCode(String seatCode) {
        this.seatCode = seatCode;
    }
}
