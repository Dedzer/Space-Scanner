package vshchur.com.spaceScanner.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "AIRPORT_T")
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "AIRPORT_ID", nullable = false)
    private Long airportId;
    @Column(name = "AIRPORT_CODE", nullable = false, length = 10)
    private String airportCode;
    @Column(name = "AIRPORT_NAME", nullable = false, length = 50)
    private String airportName;
    @ManyToOne
    @JoinColumn(name = "PLANET_ID", nullable = false)
    private Planet planet;

    public Long getAirportId() {
        return airportId;
    }

    public void setAirportId(Long airportId) {
        this.airportId = airportId;
    }

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public Planet getPlanet() {
        return planet;
    }

    public void setPlanet(Planet planet) {
        this.planet = planet;
    }
}
