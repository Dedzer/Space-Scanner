package vshchur.com.spaceScanner.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@Entity
@Table(name = "CHARTER_FLIGHT_T")
public class CharterFlight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CHARTER_FLIGHT_ID", nullable = false)
    private Long charterFlightId;
    @Column(name = "ARRIVAL_TIME", nullable = false)
    private LocalTime arrivalTime;
    @Column(name = "ARRIVAL_DATE", nullable = false)
    private LocalDate arrivalDate;
    @Column(name = "DEPARTURE_TIME", nullable = false)
    private LocalTime departureTime;
    @Column(name = "DEPARTURE_DATE", nullable = false)
    private LocalDate departureDate;
    @OneToOne
    @JoinColumn(name = "SPACE_SHUTTLE_ID")
    private SpaceShuttle spaceShuttle;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "FLIGHT_ID")
    private Flight flight;
    @OneToMany(mappedBy = "charterFlight")
    private Set<BorderPass> borderPasses;

    public Long getCharterFlightId() {
        return charterFlightId;
    }

    public void setCharterFlightId(Long charterFlightId) {
        this.charterFlightId = charterFlightId;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate localDate) {
        this.departureDate = localDate;
    }

    public SpaceShuttle getSpaceShip() {
        return spaceShuttle;
    }

    public void setSpaceShip(SpaceShuttle spaceShuttle) {
        this.spaceShuttle = spaceShuttle;
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

    public Set<BorderPass> getBorderPasses() {
        return borderPasses;
    }

    public void setBorderPasses(Set<BorderPass> borderPasses) {
        this.borderPasses = borderPasses;
    }
}
