package vshchur.com.spaceScanner.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vshchur.com.spaceScanner.model.request.form.RegularFlightForm;
import vshchur.com.spaceScanner.service.RegularFlightService;

@RestController
@RequestMapping(value = "/flights/regular")
public class RegularFlightController {

    private final RegularFlightService regularFlightService;

    public RegularFlightController(RegularFlightService regularFlightService) {
        this.regularFlightService = regularFlightService;
    }

    @PostMapping(value = "/regular")
    public ResponseEntity<Void> createRegularFlight(@RequestBody RegularFlightForm flightForm) {
        regularFlightService.createRegularFlight(flightForm);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
