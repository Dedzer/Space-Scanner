package vshchur.com.spaceScanner.service;

import org.springframework.stereotype.Service;
import vshchur.com.spaceScanner.dao.repository.SeatCodeRepository;
import vshchur.com.spaceScanner.entities.SeatCode;
import vshchur.com.spaceScanner.entities.SpaceShuttle;
import vshchur.com.spaceScanner.exception.SeatCodeNotFoundException;

@Service
public class SeatCodeService {

    private final SeatCodeRepository seatCodeRepository;

    public SeatCodeService(SeatCodeRepository seatCodeRepository) {
        this.seatCodeRepository = seatCodeRepository;
    }

    public SeatCode findByShuttleIdAndSeatCode(String seatCode, SpaceShuttle shuttle) {
        return seatCodeRepository.findSeatCodeBySeatCodeAndSpaceShuttle(seatCode, shuttle)
                .orElseThrow(SeatCodeNotFoundException::new);
    }
}
