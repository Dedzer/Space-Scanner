package vshchur.com.spaceScanner.service;

import org.springframework.stereotype.Service;
import vshchur.com.spaceScanner.dao.repository.BorderPassRepository;
import vshchur.com.spaceScanner.entities.*;
import vshchur.com.spaceScanner.enums.FlightType;
import vshchur.com.spaceScanner.exception.SeatCodeUnavailableException;
import vshchur.com.spaceScanner.model.request.form.FlightReservationForm;
import vshchur.com.spaceScanner.model.response.dto.BorderPassDTO;

import java.util.Optional;

@Service
public class BorderPassService {

    private final BorderPassRepository borderPassRepository;
    private final CharterFlightService charterFlightService;
    private final RegularFlightService regularFlightService;
    private final TouristService touristService;
    private final SeatCodeService seatCodeService;

    public BorderPassService(BorderPassRepository borderPassRepository, CharterFlightService charterFlightService,
                             RegularFlightService regularFlightService, TouristService touristService,
                             SeatCodeService seatCodeService) {
        this.borderPassRepository = borderPassRepository;
        this.charterFlightService = charterFlightService;
        this.regularFlightService = regularFlightService;
        this.touristService = touristService;
        this.seatCodeService = seatCodeService;
    }

    public BorderPassDTO generateBorderPass(FlightReservationForm form, Long userId) {
        BorderPass borderPass = new BorderPass();
        BorderPassKey borderPassKey = new BorderPassKey();
        SeatCode seatCode;
        if (FlightType.CHARTER.equals(form.getFlightType())) {
            CharterFlight charterFlight = getCharterFlight(form.getFlightId());
            borderPass.setCharterFlight(charterFlight);
            seatCode = seatCodeService.findByShuttleIdAndSeatCode(form.getSeatCode(),
                    charterFlight.getSpaceShuttle());
            verifyCharterFlightSeatCode(seatCode, charterFlight);
        } else {
            CycleFlight cycleFlight = getCycleFlight(form.getFlightId());
            borderPass.setCycleFlight(cycleFlight);
            seatCode = seatCodeService.findByShuttleIdAndSeatCode(form.getSeatCode(),
                    cycleFlight.getRegularFlight().getSpaceShuttle());
            verifyCycleFlightSeatCode(seatCode, cycleFlight);
        }
        borderPassKey.setSeatCodeId(seatCode.getSeatCodeId());
        borderPass.setSeatCode(seatCode);
        Tourist tourist = touristService.generateTourist(form.getTourist(), userId);
        borderPassKey.setTouristId(tourist.getTouristId());
        borderPass.setTourist(tourist);
        borderPass.setBorderPassId(borderPassKey);
        return BorderPassDTO.fromBorderPass(borderPassRepository.saveAndFlush(borderPass));
    }

    private CharterFlight getCharterFlight(long flightId) {
        return charterFlightService.findFlight(flightId);
    }

    private CycleFlight getCycleFlight(long flightId) {
        return regularFlightService.findFlight(flightId);
    }

    private void verifyCharterFlightSeatCode(SeatCode seatCodeId, CharterFlight flightId) {
        Optional<BorderPass> borderPass = borderPassRepository.findBorderPassByCharterFlightAndSeatCode(flightId, seatCodeId);
        if (borderPass.isPresent()) {
            throw new SeatCodeUnavailableException();
        }
    }

    private void verifyCycleFlightSeatCode(SeatCode seatCodeId, CycleFlight flightId) {
        Optional<BorderPass> borderPass = borderPassRepository.findBorderPassByCycleFlightAndSeatCode(flightId, seatCodeId);
        if (borderPass.isPresent()) {
            throw new SeatCodeUnavailableException();
        }
    }
}
