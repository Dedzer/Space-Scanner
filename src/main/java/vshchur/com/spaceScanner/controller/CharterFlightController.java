package vshchur.com.spaceScanner.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vshchur.com.spaceScanner.model.request.form.CharterFlightForm;
import vshchur.com.spaceScanner.service.CharterFlightService;

@RestController
@RequestMapping(value = "/flights/charter")
public class CharterFlightController {

    private final CharterFlightService charterFlightService;

    public CharterFlightController(CharterFlightService charterFlightService) {
        this.charterFlightService = charterFlightService;
    }

    @PostMapping
    public ResponseEntity<Void> createCharterFlight(@RequestBody CharterFlightForm charterFlightForm) {
        charterFlightService.createCharterFlight(charterFlightForm);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
