package vshchur.com.spaceScanner.entities;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "FLIGHT_DETAILS_T")
public class FlightDetails {

    @EmbeddedId
    private FlightDetailsKey flightDetailsKey;
    @ManyToOne
    @MapsId("touristId")
    @JoinColumn(name = "TOURIST_ID")
    private Tourist tourist;
    @ManyToOne
    @MapsId("flightId")
    @JoinColumn(name = "FLIGHT_ID")
    private Flight flight;

    public FlightDetailsKey getTouristFlightKey() {
        return flightDetailsKey;
    }

    public void setTouristFlightKey(FlightDetailsKey flightDetailsKey) {
        this.flightDetailsKey = flightDetailsKey;
    }

    public Tourist getTourist() {
        return tourist;
    }

    public void setTourist(Tourist tourist) {
        this.tourist = tourist;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }
}
