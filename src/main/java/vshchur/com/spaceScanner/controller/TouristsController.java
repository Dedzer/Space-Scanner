package vshchur.com.spaceScanner.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vshchur.com.spaceScanner.model.request.form.FlightReservationForm;
import vshchur.com.spaceScanner.model.response.dto.BorderPassDTO;
import vshchur.com.spaceScanner.service.BorderPassService;
import vshchur.com.spaceScanner.service.TouristService;
import vshchur.com.spaceScanner.util.JwtUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

//todo tourist profile with login/password
//todo store user data
//todo border passes
@RestController
@RequestMapping(value = "/tourists")
public class TouristsController {

    private final TouristService touristService;
    private final BorderPassService borderPassService;
    private final JwtUtil jwtUtil;

    public TouristsController(TouristService touristService, BorderPassService borderPassService, JwtUtil jwtUtil) {
        this.touristService = touristService;
        this.borderPassService = borderPassService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/reserve")
    public ResponseEntity<BorderPassDTO> reservePlace(@RequestBody FlightReservationForm form, HttpServletRequest request) {
        return ResponseEntity.ok(borderPassService.generateBorderPass(form, jwtUtil.retrieveUserId(readToken(request))));
    }

    private Optional<String> readToken(HttpServletRequest request) {
        return Optional.ofNullable(request.getHeader("Authorization"));
    }

}
