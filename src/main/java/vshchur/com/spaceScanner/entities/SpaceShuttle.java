package vshchur.com.spaceScanner.entities;

import javax.persistence.*;

@Entity
@Table(name = "SPACE_SHUTTLE_T")
public class SpaceShuttle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SPACE_SHUTTLE_ID", nullable = false)
    private Long spaceShuttleId;
    @Column(name = "SPACE_SHUTTLE_CODE", nullable = false, length = 15)
    private String spaceShuttleCode;
    @Column(name = "PLACES_AMOUNT", nullable = false)
    private Integer placesAmount;

    public Long getSpaceShuttleId() {
        return spaceShuttleId;
    }

    public void setSpaceShuttleId(Long spaceShipId) {
        this.spaceShuttleId = spaceShipId;
    }

    public String getSpaceShuttleCode() {
        return spaceShuttleCode;
    }

    public void setSpaceShuttleCode(String spaceShipCode) {
        this.spaceShuttleCode = spaceShipCode;
    }

    public Integer getPlacesAmount() {
        return placesAmount;
    }

    public void setPlacesAmount(Integer placesAmount) {
        this.placesAmount = placesAmount;
    }
}
