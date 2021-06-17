package vshchur.com.spaceScanner.model.response.dto;

import vshchur.com.spaceScanner.entities.SpaceShuttle;

public class SpaceShuttleDTO {

    private Long spaceShuttleId;
    private String spaceShuttleCode;

    public static SpaceShuttleDTO fromSpaceShuttle(SpaceShuttle spaceShuttle) {
        SpaceShuttleDTO spaceShuttleDTO = new SpaceShuttleDTO();
        spaceShuttleDTO.setSpaceShuttleCode(spaceShuttle.getSpaceShuttleCode());
        spaceShuttleDTO.setSpaceShuttleId(spaceShuttle.getSpaceShuttleId());
        return spaceShuttleDTO;
    }

    public Long getSpaceShuttleId() {
        return spaceShuttleId;
    }

    public void setSpaceShuttleId(Long spaceShuttleId) {
        this.spaceShuttleId = spaceShuttleId;
    }

    public String getSpaceShuttleCode() {
        return spaceShuttleCode;
    }

    public void setSpaceShuttleCode(String spaceShuttleCode) {
        this.spaceShuttleCode = spaceShuttleCode;
    }
}
