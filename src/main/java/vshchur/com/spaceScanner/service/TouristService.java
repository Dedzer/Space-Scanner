package vshchur.com.spaceScanner.service;

import org.springframework.stereotype.Service;
import vshchur.com.spaceScanner.dao.repository.TouristRepository;
import vshchur.com.spaceScanner.entities.Tourist;
import vshchur.com.spaceScanner.exception.TouristNotFoundException;
import vshchur.com.spaceScanner.model.request.form.TouristForm;

@Service
public class TouristService {

    private final TouristRepository touristRepository;
    private final PlanetService planetService;
    private final UserService userService;

    public TouristService(TouristRepository touristRepository, PlanetService planetService, UserService userService) {
        this.touristRepository = touristRepository;
        this.planetService = planetService;
        this.userService = userService;
    }

    public Tourist generateTourist(TouristForm touristForm, Long userId) {
        if (touristForm.getTouristId() != null) {
            return getExistingTourist(touristForm.getTouristId());
        }
        Tourist tourist = new Tourist();
        tourist.setDocumentId(touristForm.getDocumentId());
        tourist.setDocumentType(touristForm.getDocumentType().getDatabaseKey());
        tourist.setFirstName(touristForm.getFirstName());
        tourist.setLastName(touristForm.getLastName());
        tourist.setGender(touristForm.getGender().getDatabaseKey());
        tourist.setPlanet(planetService.getPlanetByCode(touristForm.getCitizenship()));
        if (userId != null) {
            tourist.setUser(userService.findUserById(userId));
        }
        return touristRepository.saveAndFlush(tourist);
    }

    public Tourist getExistingTourist(long touristId) {
        return touristRepository.findById(touristId)
                .orElseThrow(TouristNotFoundException::new);
    }
}
