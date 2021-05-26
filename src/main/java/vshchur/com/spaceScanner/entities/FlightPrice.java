package vshchur.com.spaceScanner.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "FLIGHT_PRICE_T")
public class FlightPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRICE_ID", nullable = false)
    private Long priceId;
    @Column(name = "ORIGINAL_PRICE", nullable = false)
    private BigDecimal originalPrice;
    @Column(name = "CURRENT_PRICE")
    private BigDecimal currentPrice;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FLIGHT_ID", nullable = false)
    private Flight flight;

    public Long getPriceId() {
        return priceId;
    }

    public void setPriceId(Long priceId) {
        this.priceId = priceId;
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }
}
