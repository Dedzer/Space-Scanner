package vshchur.com.spaceScanner.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vshchur.com.spaceScanner.model.response.dto.SpaceShuttleDTO;
import vshchur.com.spaceScanner.service.SpaceShuttleService;

import java.util.List;

@RestController
@RequestMapping("/shuttle")
public class SpaceShuttleController {


    private final SpaceShuttleService spaceShuttleService;

    public SpaceShuttleController(SpaceShuttleService spaceShuttleService) {
        this.spaceShuttleService = spaceShuttleService;
    }

    @GetMapping
    public List<SpaceShuttleDTO> findAvailableShuttles() {
        return spaceShuttleService.findAvailableShuttles();
    }
}
