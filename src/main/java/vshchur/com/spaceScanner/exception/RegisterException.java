package vshchur.com.spaceScanner.exception;

import vshchur.com.spaceScanner.model.response.dto.ErrorDTO;

public class RegisterException extends SingleErrorException {

    public RegisterException() {
        super(new ErrorDTO("USER_EXISTS"));
    }
}
