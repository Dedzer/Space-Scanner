package vshchur.com.spaceScanner.service;

import org.springframework.stereotype.Service;
import vshchur.com.spaceScanner.dao.repository.CycleFlightRepository;
import vshchur.com.spaceScanner.dao.repository.RegularFLightRepository;
import vshchur.com.spaceScanner.entities.CycleFlight;
import vshchur.com.spaceScanner.exception.FlightNotFoundException;
import vshchur.com.spaceScanner.model.request.form.FlightSearchForm;
import vshchur.com.spaceScanner.model.request.form.RegularFlightForm;
import vshchur.com.spaceScanner.model.response.dto.AvailableFlightsDTO;
import vshchur.com.spaceScanner.model.response.dto.FlightDTO;
import vshchur.com.spaceScanner.util.converter.RegularFlightDataConverter;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegularFlightService {

    private final RegularFLightRepository regularFLightRepository;
    private final RegularFlightDataConverter regularFlightDataConverter;
    private final CycleFlightRepository cycleFlightRepository;

    public RegularFlightService(RegularFLightRepository regularFLightRepository,
                                RegularFlightDataConverter regularFlightDataConverter,
                                CycleFlightRepository cycleFlightRepository) {
        this.regularFLightRepository = regularFLightRepository;
        this.regularFlightDataConverter = regularFlightDataConverter;
        this.cycleFlightRepository = cycleFlightRepository;
    }

    public void createRegularFlight(RegularFlightForm regularFlightForm) {
        regularFLightRepository.save(regularFlightDataConverter.toRegularFlight(regularFlightForm));
    }

    public CycleFlight findFlight(long flightId) {
        return cycleFlightRepository.findById(flightId).orElseThrow(FlightNotFoundException::new);
    }

    public AvailableFlightsDTO findAvailableFlights(FlightSearchForm form) {
        AvailableFlightsDTO availableFlightsDTO = new AvailableFlightsDTO();
        availableFlightsDTO.setAvailableFlights(getAvailableFlights(form));
        if (form.getReturnDepartureDate() != null) {
            availableFlightsDTO.setReturnAvailableFlights(getAvailableReturnFlights(form));
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
        return cycleFlightRepository.findAllAvailableFlights(form.getDepartureDate(), form.getDepartureAirportCode(),
                form.getArrivalAirportCode()).stream()
                .map(FlightDTO::fromCycleFlight).collect(Collectors.toList());
    }

    private List<FlightDTO> getAvailableReturnFlights(FlightSearchForm form) {
        return cycleFlightRepository.findAllAvailableFlights(form.getReturnDepartureDate(), form.getArrivalAirportCode(),
                form.getDepartureAirportCode()).stream()
                .map(FlightDTO::fromCycleFlight).collect(Collectors.toList());
    }
}
