package vshchur.com.spaceScanner.exception;

import vshchur.com.spaceScanner.model.response.dto.ErrorDTO;

public class SeatCodeUnavailableException extends SingleErrorException {

    public SeatCodeUnavailableException() {
        super(new ErrorDTO("Seat Code is not available"));
    }
}
