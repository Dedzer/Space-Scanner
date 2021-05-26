package vshchur.com.spaceScanner.entities;

import javax.persistence.*;

@Entity
@Table(name = "BORDER_PASS_T")
public class BorderPass {

    @EmbeddedId
    private BorderPassKey borderPassId;
    @ManyToOne
    @MapsId("seatCodeId")
    @JoinColumn(name = "SEAT_CODE_ID")
    private SeatCode seatCode;
    @ManyToOne
    @MapsId("touristId")
    @JoinColumn(name = "TOURIST_ID")
    private Tourist tourist;
    @ManyToOne
    @JoinColumn(name = "CHARTER_FLIGHT_ID")
    private CharterFlight charterFlight;

    @ManyToOne
    @JoinColumn(name = "CYCLE_FLIGHT_ID")
    private CycleFlight cycleFlight;

    public BorderPassKey getBorderPassId() {
        return borderPassId;
    }

    public void setBorderPassId(BorderPassKey borderPassId) {
        this.borderPassId = borderPassId;
    }

    public SeatCode getSeatCode() {
        return seatCode;
    }

    public void setSeatCode(SeatCode seatCode) {
        this.seatCode = seatCode;
    }

    public Tourist getTourist() {
        return tourist;
    }

    public void setTourist(Tourist tourist) {
        this.tourist = tourist;
    }

    public CharterFlight getCharterFlight() {
        return charterFlight;
    }

    public void setCharterFlight(CharterFlight charterFlight) {
        this.charterFlight = charterFlight;
    }

    public CycleFlight getCycleFlight() {
        return cycleFlight;
    }

    public void setCycleFlight(CycleFlight cycleFlight) {
        this.cycleFlight = cycleFlight;
    }
}
