package vshchur.com.spaceScanner.service;

import org.springframework.stereotype.Service;
import vshchur.com.spaceScanner.dao.repository.CharterFlightRepository;
import vshchur.com.spaceScanner.entities.CharterFlight;
import vshchur.com.spaceScanner.exception.FlightNotFoundException;
import vshchur.com.spaceScanner.model.request.form.CharterFlightForm;
import vshchur.com.spaceScanner.model.request.form.FlightSearchForm;
import vshchur.com.spaceScanner.model.response.dto.AvailableFlightsDTO;
import vshchur.com.spaceScanner.model.response.dto.FlightDTO;
import vshchur.com.spaceScanner.util.converter.CharterFlightDataConverter;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharterFlightService {

    private final CharterFlightRepository charterFlightRepository;
    private final CharterFlightDataConverter charterFlightDataConverter;

    public CharterFlightService(CharterFlightRepository charterFlightRepository, CharterFlightDataConverter charterFlightDataConverter) {
        this.charterFlightRepository = charterFlightRepository;
        this.charterFlightDataConverter = charterFlightDataConverter;
    }

    public void createCharterFlight(CharterFlightForm charterFlightForm) {
        charterFlightRepository.save(charterFlightDataConverter.toCharterFlight(charterFlightForm));
    }

    public AvailableFlightsDTO findAvailableFlights(FlightSearchForm form) {
        AvailableFlightsDTO availableFlightsDTO = new AvailableFlightsDTO();
        availableFlightsDTO.setAvailableFlights(getAvailableFlights(form));
        if (form.getReturnDepartureDate() != null && form.getReturnDepartureTime() != null) {
            availableFlightsDTO.setAvailableFlights(getAvailableReturnFlights(form));
        }
        if (availableFlightsDTO.getReturnAvailableFlights() == null) {
            availableFlightsDTO.setReturnAvailableFlights(Collections.emptyList());
        }
        if (availableFlightsDTO.getAvailableFlights() == null) {
            availableFlightsDTO.setAvailableFlights(Collections.emptyList());
        }
        return availableFlightsDTO;
    }

    private List<FlightDTO> getAvailableFlights(FlightSearchForm form) {
        return charterFlightRepository.findAllAvailableFlights(form.getDepartureDate(),
                form.getDepartureTime(), form.getDepartureAirportCode(), form.getArrivalAirportCode()).stream()
                .map(FlightDTO::fromCharterFlight).collect(Collectors.toList());
    }

    private List<FlightDTO> getAvailableReturnFlights(FlightSearchForm form) {
        return charterFlightRepository.findAllAvailableFlights(form.getReturnDepartureDate(),
                form.getReturnDepartureTime(), form.getArrivalAirportCode(), form.getDepartureAirportCode()).stream()
                .map(FlightDTO::fromCharterFlight).collect(Collectors.toList());
    }

    public CharterFlight findFlight(long flightId) {
        return charterFlightRepository.findById(flightId).orElseThrow(FlightNotFoundException::new);
    }
}
