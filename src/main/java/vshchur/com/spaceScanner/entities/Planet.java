package vshchur.com.spaceScanner.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PLANET_T")
public class Planet {

    @Id
    @Column(name = "PLANET_ID", nullable = false)
    private Long planetId;
    @Column(name = "PLANET_CODE", length = 5, nullable = false)
    private String planetCode;
    @Column(name = "PLANET_NAME", length = 128, nullable = false)
    private String planetName;
    @Column(name = "DISTANCE_FROM_SUN", nullable = false)
    private Float distanceFromSun;
    @OneToMany(mappedBy = "planet")
    private List<Airport> airports;

    public Long getPlanetId() {
        return planetId;
    }

    public void setPlanetId(Long countryId) {
        this.planetId = countryId;
    }

    public String getPlanetCode() {
        return planetCode;
    }

    public void setPlanetCode(String countryCode) {
        this.planetCode = countryCode;
    }

    public String getPlanetName() {
        return planetName;
    }

    public void setPlanetName(String countryName) {
        this.planetName = countryName;
    }

    public Float getDistanceFromSun() {
        return distanceFromSun;
    }

    public void setDistanceFromSun(Float distanceFromSun) {
        this.distanceFromSun = distanceFromSun;
    }

    public List<Airport> getAirports() {
        return airports;
    }

    public void setAirports(List<Airport> airports) {
        this.airports = airports;
    }
}
