package vshchur.com.spaceScanner.model.response.dto;

public class ErrorDTO {

    private final String errorMessage;
    private final String errorField;
    private final String errorCode;

    public ErrorDTO(String errorMessage, String errorField, String errorCode) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
        this.errorField = errorField;
    }

    public ErrorDTO(String errorMessage, String errorCode) {
        this(errorMessage, errorCode, null);
    }

    public ErrorDTO(String errorMessage) {
        this(errorMessage, null, null);
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getErrorField() {
        return errorField;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
