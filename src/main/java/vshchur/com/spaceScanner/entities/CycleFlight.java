package vshchur.com.spaceScanner.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "CYCLE_FLIGHT_T")
public class CycleFlight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CYCLE_FLIGHT_ID", nullable = false)
    private Long cycleFlightId;
    @Column(name = "ARRIVAL_DATE", nullable = false)
    private LocalDate arrivalDate;
    @Column(name = "DEPARTURE_DATE", nullable = false)
    private LocalDate departureDate;
    @ManyToOne
    @JoinColumn(name = "regular_flight_id")
    private RegularFlight regularFlight;
    @OneToMany(mappedBy = "cycleFlight")
    private Set<BorderPass> borderPasses;

    public Long getCycleFlightId() {
        return cycleFlightId;
    }

    public void setCycleFlightId(Long cycleDetailsId) {
        this.cycleFlightId = cycleDetailsId;
    }

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

    public RegularFlight getRegularFlight() {
        return regularFlight;
    }

    public void setRegularFlight(RegularFlight regularFlight) {
        this.regularFlight = regularFlight;
    }

    public Set<BorderPass> getBorderPasses() {
        return borderPasses;
    }

    public void setBorderPasses(Set<BorderPass> borderPasses) {
        this.borderPasses = borderPasses;
    }
}
