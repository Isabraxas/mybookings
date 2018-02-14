package isvarvega.booking;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HotelBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String hotelName;
    private double pricePerNight;
    private int nbOfNight;

    public HotelBooking(){}

    public HotelBooking(String hotelName, double pricePerNight, int nbOfNight) {
        this.hotelName = hotelName;
        this.pricePerNight = pricePerNight;
        this.nbOfNight = nbOfNight;
    }

    public String getHotelName() {
        return hotelName;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public int getNbOfNight() {
        return nbOfNight;
    }

    public double getTotalPrice(){
        return nbOfNight * pricePerNight;
    }

    public long getId() {
        return id;
    }
}


