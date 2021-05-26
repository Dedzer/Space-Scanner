package vshchur.com.spaceScanner.exception;

import vshchur.com.spaceScanner.model.response.dto.ErrorDTO;

public class UserNotFoundException extends SingleErrorException {

    public UserNotFoundException() {
        super(new ErrorDTO("User is not found"));
    }
}
