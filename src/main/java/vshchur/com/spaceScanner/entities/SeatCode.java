package vshchur.com.spaceScanner.entities;

import javax.persistence.*;

@Entity
@Table(name = "SEAT_CODE_T")
public class SeatCode {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SEAT_CODE_ID", nullable = false)
    private String seatCodeId;
    @Column(name = "SEAT_CODE", length = 15, nullable = false)
    private String seatCode;
    @OneToOne
    @JoinColumn(name = "space_shuttle_id")
    private SpaceShuttle spaceShuttle;

    public String getSeatCodeId() {
        return seatCodeId;
    }

    public void setSeatCodeId(String seatCodeId) {
        this.seatCodeId = seatCodeId;
    }

    public String getSeatCode() {
        return seatCode;
    }

    public void setSeatCode(String seatCode) {
        this.seatCode = seatCode;
    }

    public SpaceShuttle getSpaceShuttle() {
        return spaceShuttle;
    }

    public void setSpaceShuttle(SpaceShuttle spaceShuttle) {
        this.spaceShuttle = spaceShuttle;
    }
}
