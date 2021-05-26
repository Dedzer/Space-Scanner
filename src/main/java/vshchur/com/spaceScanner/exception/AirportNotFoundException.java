package vshchur.com.spaceScanner.exception;

import vshchur.com.spaceScanner.model.response.dto.ErrorDTO;

public class AirportNotFoundException extends SingleErrorException{

    public AirportNotFoundException() {
        super(new ErrorDTO("Airport is not found"));
    }
}
