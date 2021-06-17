package vshchur.com.spaceScanner.exception;

import vshchur.com.spaceScanner.model.response.dto.ErrorDTO;

public class UnauthorizedException extends SingleErrorException {

    public UnauthorizedException() {
        super(new ErrorDTO("UNAUTHORIZED"));
    }
}
