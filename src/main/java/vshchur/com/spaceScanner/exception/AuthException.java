package vshchur.com.spaceScanner.exception;

import vshchur.com.spaceScanner.model.response.dto.ErrorDTO;

public class AuthException extends SingleErrorException {

    public AuthException() {
        super(new ErrorDTO("BAD_CREDENTIALS"));
    }
}
