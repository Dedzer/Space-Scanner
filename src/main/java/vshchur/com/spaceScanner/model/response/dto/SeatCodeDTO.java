package vshchur.com.spaceScanner.model.response.dto;

import vshchur.com.spaceScanner.entities.SeatCode;

public class SeatCodeDTO {


    private long seatCodeId;
    private String seatCode;

    public static SeatCodeDTO fromSeatCode(SeatCode seatCode) {
        SeatCodeDTO seatCodeDTO = new SeatCodeDTO();
        seatCodeDTO.setSeatCode(seatCode.getSeatCode());
        seatCodeDTO.setSeatCodeId(seatCode.getSeatCodeId());
        return seatCodeDTO;
    }

    public long getSeatCodeId() {
        return seatCodeId;
    }

    public void setSeatCodeId(long seatCodeId) {
        this.seatCodeId = seatCodeId;
    }

    public String getSeatCode() {
        return seatCode;
    }

    public void setSeatCode(String seatCode) {
        this.seatCode = seatCode;
    }
}
