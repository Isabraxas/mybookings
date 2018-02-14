package isvarvega.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner{

    private  BookingRepository bookingRepository;

    @Autowired
    public DatabaseSeeder (BookingRepository bookingRepository){
        this.bookingRepository = bookingRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        List<HotelBooking> bookings = new ArrayList<>();

        bookings.add(new HotelBooking("Palicio",90,3));
        bookings.add(new HotelBooking("Royale", 120, 2));
        bookings.add(new HotelBooking("Aria", 60, 4));

        bookingRepository.save(bookings);
    }
}
