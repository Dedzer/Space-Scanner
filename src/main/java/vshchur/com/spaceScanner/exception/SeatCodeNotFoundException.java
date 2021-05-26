package vshchur.com.spaceScanner.exception;

import vshchur.com.spaceScanner.model.response.dto.ErrorDTO;

public class SeatCodeNotFoundException extends SingleErrorException {

    public SeatCodeNotFoundException() {
        super(new ErrorDTO("Seat code is not found"));
    }
}
