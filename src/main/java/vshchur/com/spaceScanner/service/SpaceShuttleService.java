package vshchur.com.spaceScanner.service;

import org.springframework.stereotype.Service;
import vshchur.com.spaceScanner.dao.repository.SpaceShuttleRepository;
import vshchur.com.spaceScanner.entities.SpaceShuttle;
import vshchur.com.spaceScanner.exception.SpaceShuttleNotFoundException;
import vshchur.com.spaceScanner.model.response.dto.SpaceShuttleDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SpaceShuttleService {

    private final SpaceShuttleRepository spaceShuttleRepository;

    public SpaceShuttleService(SpaceShuttleRepository spaceShuttleRepository) {
        this.spaceShuttleRepository = spaceShuttleRepository;
    }

    public SpaceShuttle findSpaceShuttleByCode(String spaceShipCode) {
        return spaceShuttleRepository.findSpaceShuttleBySpaceShuttleCode(spaceShipCode).orElseThrow(SpaceShuttleNotFoundException::new);
    }

    public List<SpaceShuttleDTO> findAvailableShuttles() {
        return spaceShuttleRepository.findAll().stream()
                .map(SpaceShuttleDTO::fromSpaceShuttle)
                .collect(Collectors.toList());
    }
}
