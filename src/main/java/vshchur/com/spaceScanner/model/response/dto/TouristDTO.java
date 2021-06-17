package vshchur.com.spaceScanner.model.response.dto;

public class TouristDTO {

    private String firstName;
    private String lastName;
    private long touristId;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getTouristId() {
        return touristId;
    }

    public void setTouristId(long touristId) {
        this.touristId = touristId;
    }
}
