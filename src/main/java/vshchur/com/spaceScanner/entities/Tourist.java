package vshchur.com.spaceScanner.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "TOURIST_T")
public class Tourist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TOURIST_ID", nullable = false)
    private Long touristId;
    @Column(name = "FIRST_NAME", nullable = false, length = 128)
    private String firstName;
    @Column(name = "LAST_NAME", nullable = false, length = 128)
    private String lastName;
    @Column(name = "GENDER", nullable = false, length = 3)
    private Integer gender;
    @Column(name = "DOCUMENT_ID", nullable = false, length = 128)
    private String documentId;
    @Column(name = "DOCUMENT_TYPE", nullable = false, length = 3)
    private Integer documentType;
    @Column(name = "BIRTH_DATE")
    private LocalDate birthDate;
    @OneToOne
    @JoinColumn(name = "PLANET_ID")
    private Planet planet;
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;
    @OneToMany(mappedBy = "tourist")
    private List<FlightDetails> flights;

    public Long getTouristId() {
        return touristId;
    }

    public void setTouristId(Long touristId) {
        this.touristId = touristId;
    }

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

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public Integer getDocumentType() {
        return documentType;
    }

    public void setDocumentType(Integer documentType) {
        this.documentType = documentType;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Planet getPlanet() {
        return planet;
    }

    public void setPlanet(Planet planet) {
        this.planet = planet;
    }

    public List<FlightDetails> getFlights() {
        return flights;
    }

    public void setFlights(List<FlightDetails> flightDetailsList) {
        this.flights = flightDetailsList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
