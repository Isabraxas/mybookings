package isvarvega.booking;

import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiPathParam;
import org.jsondoc.core.pojo.ApiStage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/bookings")
@Api(
        name = "Hotel Booking API",
        description="Provides a list methods that manage hotel bookings",
        stage = ApiStage.RC)
public class BookingController {

    private BookingRepository bookingRepository;

    @Autowired
    public BookingController(BookingRepository bookingRepository){
        this.bookingRepository = bookingRepository;
    }

    @RequestMapping(value="/all" , method = RequestMethod.GET)
    @ApiMethod(description = "Get all hotel bookings from Data Base")
    public List<HotelBooking> getAll() {
        return bookingRepository.findAll();
    }

    @RequestMapping(value = "/affordable/{price}" , method = RequestMethod.GET)
    @ApiMethod(description = "Get affordable hotel bookings list where price per night is less to parameter")
    public List<HotelBooking> getAffordable(@ApiPathParam(name = "price") @PathVariable double price){
        return bookingRepository.findByPricePerNightIsLessThan(price);
    }

    @RequestMapping(value = "/create", method= RequestMethod.POST)
    @ApiMethod(description = "Create one hotel booking and save it in the Data Base")
    public List<HotelBooking> create(@RequestBody HotelBooking hotelBooking){

        bookingRepository.save(hotelBooking);

        return bookingRepository.findAll();
    }

    @RequestMapping (value = "/delete/{id}", method= RequestMethod.POST)
    @ApiMethod(description = "Delete hotel booking with provide id form the Data Base")
    public List<HotelBooking> remove(@ApiPathParam(name = "id") @PathVariable long id){
        bookingRepository.delete(id);

        return bookingRepository.findAll();
    }



    @RequestMapping(value="/")
    public String hola() {
        return "Hola";
    }
}
