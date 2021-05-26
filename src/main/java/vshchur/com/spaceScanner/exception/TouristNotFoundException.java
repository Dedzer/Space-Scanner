package vshchur.com.spaceScanner.exception;

import vshchur.com.spaceScanner.model.response.dto.ErrorDTO;

public class TouristNotFoundException extends SingleErrorException {

    public TouristNotFoundException() {
        super(new ErrorDTO("Tourist not found"));
    }
}
