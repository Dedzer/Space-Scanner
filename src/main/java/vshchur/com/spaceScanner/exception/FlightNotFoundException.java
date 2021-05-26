package vshchur.com.spaceScanner.exception;

import vshchur.com.spaceScanner.model.response.dto.ErrorDTO;

public class FlightNotFoundException extends SingleErrorException {

    public FlightNotFoundException() {
        super(new ErrorDTO("Flight is not found"));
    }
}
