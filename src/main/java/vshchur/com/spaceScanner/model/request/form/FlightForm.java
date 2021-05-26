package vshchur.com.spaceScanner.model.request.form;

import java.math.BigDecimal;

public class FlightForm {

    private String departure;
    private String arrival;
    private BigDecimal price;
    private String spaceShuttleCode;

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getSpaceShuttleCode() {
        return spaceShuttleCode;
    }

    public void setSpaceShuttleCode(String spaceShuttleCode) {
        this.spaceShuttleCode = spaceShuttleCode;
    }
}
