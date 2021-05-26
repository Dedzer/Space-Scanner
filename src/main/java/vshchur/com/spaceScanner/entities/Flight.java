package vshchur.com.spaceScanner.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "FLIGHT_T")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "FLIGHT_ID", nullable = false)
    private Long flightId;
    @Column(name = "DISTANCE", nullable = false)
    private Float distance;
    @OneToOne
    @JoinColumn(name = "DEPARTURE_ID", nullable = false)
    private Airport departure;
    @OneToOne
    @JoinColumn(name = "ARRIVAL_ID", nullable = false)
    private Airport arrival;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "flight")
    private FlightPrice flightPrice;
    @OneToMany(mappedBy = "flight")
    private List<CharterFlight> charterFlights;
    @OneToMany(mappedBy = "flight")
    private List<RegularFlight> regularFlights;

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long id) {
        this.flightId = id;
    }

    public Airport getDeparture() {
        return departure;
    }

    public void setDeparture(Airport departure) {
        this.departure = departure;
    }

    public Airport getArrival() {
        return arrival;
    }

    public void setArrival(Airport arrival) {
        this.arrival = arrival;
    }

    public Float getDistance() {
        return distance;
    }

    public void setDistance(Float distance) {
        this.distance = distance;
    }

    public FlightPrice getFlightPrice() {
        return flightPrice;
    }

    public void setFlightPrice(FlightPrice flightPrice) {
        this.flightPrice = flightPrice;
    }

    public List<CharterFlight> getCharterFlights() {
        return charterFlights;
    }

    public void setCharterFlights(List<CharterFlight> charterFlights) {
        this.charterFlights = charterFlights;
    }

    public List<RegularFlight> getRegularFlights() {
        return regularFlights;
    }

    public void setRegularFlights(List<RegularFlight> regularFlights) {
        this.regularFlights = regularFlights;
    }

}
