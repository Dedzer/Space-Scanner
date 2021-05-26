package vshchur.com.spaceScanner.exception;

import vshchur.com.spaceScanner.model.response.dto.ErrorDTO;

public class PlanetNotFoundException extends SingleErrorException {

    public PlanetNotFoundException() {
        super(new ErrorDTO("Planet not found"));
    }
}
