package vshchur.com.spaceScanner.exception;

import vshchur.com.spaceScanner.model.response.dto.ErrorDTO;

public class SingleErrorException extends RuntimeException {

    private final ErrorDTO errorDTO;

    public SingleErrorException(ErrorDTO errorDTO) {
        this.errorDTO = errorDTO;
    }

    public ErrorDTO getErrorDTO() {
        return errorDTO;
    }
}
