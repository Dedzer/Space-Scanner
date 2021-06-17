package vshchur.com.spaceScanner.model.response.dto;


import vshchur.com.spaceScanner.entities.Planet;

public class PlanetDTO {

    private String planetName;
    private String planetCode;


    public static PlanetDTO fromPlanet(Planet planet) {
        PlanetDTO planetDTO = new PlanetDTO();
        planetDTO.setPlanetCode(planet.getPlanetCode());
        planetDTO.setPlanetName(planet.getPlanetName());
        return planetDTO;
    }

    public String getPlanetName() {
        return planetName;
    }

    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }

    public String getPlanetCode() {
        return planetCode;
    }

    public void setPlanetCode(String planetCode) {
        this.planetCode = planetCode;
    }
}
