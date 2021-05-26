package vshchur.com.spaceScanner.model.response.dto;


import vshchur.com.spaceScanner.entities.Planet;

public class PlanetDTO {

    private String planetName;
    private String planerCode;


    public static PlanetDTO fromPlanet(Planet planet) {
        PlanetDTO planetDTO = new PlanetDTO();
        planetDTO.setPlanerCode(planet.getPlanetCode());
        planetDTO.setPlanetName(planet.getPlanetName());
        return planetDTO;
    }

    public String getPlanetName() {
        return planetName;
    }

    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }

    public String getPlanerCode() {
        return planerCode;
    }

    public void setPlanerCode(String planerCode) {
        this.planerCode = planerCode;
    }
}
