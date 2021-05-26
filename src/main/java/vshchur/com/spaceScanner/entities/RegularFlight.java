package vshchur.com.spaceScanner.entities;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "REGULAR_FLIGHT_T")
public class RegularFlight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "REGULAR_FLIGHT_ID", nullable = false)
    private Long regularFlightId;
    @Column(name = "ARRIVAL_TIME", nullable = false)
    private LocalTime arrivalTime;
    @Column(name = "DEPARTURE_TIME", nullable = false)
    private LocalTime departureTime;
    @OneToOne
    @JoinColumn(name = "SPACE_SHUTTLE_ID")
    private SpaceShuttle spaceShuttle;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "FLIGHT_ID")
    private Flight flight;
    @OneToMany(mappedBy = "regularFlight", cascade = CascadeType.PERSIST)
    private List<CycleFlight> cycleFlights;

    public Long getRegularFlightId() {
        return regularFlightId;
    }

    public void setRegularFlightId(Long regularFlightId) {
        this.regularFlightId = regularFlightId;
    }

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

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public SpaceShuttle getSpaceShuttle() {
        return spaceShuttle;
    }

    public void setSpaceShuttle(SpaceShuttle spaceShuttle) {
        this.spaceShuttle = spaceShuttle;
    }

    public List<CycleFlight> getCycleFlights() {
        return cycleFlights;
    }

    public void setCycleFlights(List<CycleFlight> cycleDetails) {
        this.cycleFlights = cycleDetails;
    }
}
