package vshchur.com.spaceScanner.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BorderPassKey implements Serializable {

    @Column(name = "SEAT_CODE_ID")
    private long seatCodeId;
    @Column(name = "TOURIST_ID")
    private Long touristId;

    public long getSeatCodeId() {
        return seatCodeId;
    }

    public void setSeatCodeId(long seatCodeId) {
        this.seatCodeId = seatCodeId;
    }

    public Long getTouristId() {
        return touristId;
    }

    public void setTouristId(Long touristId) {
        this.touristId = touristId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BorderPassKey that = (BorderPassKey) o;
        return Objects.equals(seatCodeId, that.seatCodeId) && Objects.equals(touristId, that.touristId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seatCodeId, touristId);
    }
}
