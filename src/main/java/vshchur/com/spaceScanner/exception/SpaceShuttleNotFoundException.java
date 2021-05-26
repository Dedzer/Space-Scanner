package vshchur.com.spaceScanner.exception;

import vshchur.com.spaceScanner.model.response.dto.ErrorDTO;

public class SpaceShuttleNotFoundException extends SingleErrorException {

    public SpaceShuttleNotFoundException() {
        super(new ErrorDTO("Space shuttle is not found"));
    }
}
