package vshchur.com.spaceScanner.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class FlightDetailsKey implements Serializable {

    @Column(name = "TOURIST_ID", nullable = false)
    private Long touristId;
    @Column(name = "FLIGHT_ID", nullable = false)
    private Long flightId;

    public Long getTouristId() {
        return touristId;
    }

    public void setTouristId(Long touristId) {
        this.touristId = touristId;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightDetailsKey that = (FlightDetailsKey) o;
        return Objects.equals(touristId, that.touristId) && Objects.equals(flightId, that.flightId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(touristId, flightId);
    }
}
