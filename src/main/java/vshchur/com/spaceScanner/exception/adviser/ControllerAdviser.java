package vshchur.com.spaceScanner.exception.adviser;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import vshchur.com.spaceScanner.exception.*;
import vshchur.com.spaceScanner.model.response.dto.ErrorDTO;

@ControllerAdvice
public class ControllerAdviser extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AuthException.class)
    public ResponseEntity<ErrorDTO> handleAuthException(AuthException ex) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(ex.getErrorDTO());
    }

    @ExceptionHandler(PlanetNotFoundException.class)
    public ResponseEntity<ErrorDTO> handlePlanetNotFoundException(PlanetNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getErrorDTO());
    }

    @ExceptionHandler(AirportNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleAirportNotFoundException(AirportNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getErrorDTO());
    }

    @ExceptionHandler(SpaceShuttleNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleSpaceShuttleNotFoundException(SpaceShuttleNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getErrorDTO());
    }

    @ExceptionHandler(TouristNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleTouristNotFoundException(TouristNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getErrorDTO());
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleUserNotFoundException(UserNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getErrorDTO());
    }

    @ExceptionHandler(FlightNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleFlightNotFoundException(FlightNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getErrorDTO());
    }

    @ExceptionHandler(SeatCodeUnavailableException.class)
    public ResponseEntity<ErrorDTO> handleSeatCodeUnavailableException(SeatCodeUnavailableException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getErrorDTO());
    }

    @ExceptionHandler(SeatCodeNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleSeatCodeNotFoundException(SeatCodeNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getErrorDTO());
    }
}
