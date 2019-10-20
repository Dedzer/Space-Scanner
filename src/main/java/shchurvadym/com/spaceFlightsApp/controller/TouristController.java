package shchurvadym.com.spaceFlightsApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shchurvadym.com.spaceFlightsApp.entity.Tourist;
import shchurvadym.com.spaceFlightsApp.service.TouristService;

import java.util.List;

@RestController
public class TouristController {

    @Autowired
    private TouristService touristService;

    @GetMapping("/tourists")
    public List<Tourist> tourists(){
        return touristService.allTourists();
    }

    @PostMapping("/{id}/tourist")
    public void addTouristToflight(@PathVariable("id")Long id, @RequestBody Tourist tourist){
        touristService.addTourist(tourist, id);
    }

    @DeleteMapping("/{id}/{touristId}")
    public void deleteTouristFromFlight(@PathVariable("id")Long id, @PathVariable("touristId") Long touristId){
        touristService.deleteTouristFromFlight(id, touristId);
    }
}
