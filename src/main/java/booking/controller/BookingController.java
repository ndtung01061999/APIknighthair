package booking.controller;

import java.util.List;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import booking.dto.BookingDTO;
import booking.entity.Booking;
import booking.entity.City;
import booking.service.BookingService;
import booking.service.CityService;

@CrossOrigin(origins = "*")

@RestController
@RequestMapping(value = "/booking")
public class BookingController {

	@Autowired
	private BookingService bs;

	@GetMapping("/{id}")
	public List<BookingDTO> getaccount(@PathVariable("id") int id) {
		return bs.getaccount(id);
	}

	@PutMapping("/{id}")
	public void updatebooking(@PathVariable("id") int id, @RequestBody BookingDTO bookingdto) {
		bs.update(id, bookingdto);
	}

//	@PutMapping("/status/{id}")
//	public void updatestatus(@PathVariable("id") int id , @RequestBody String status) throws JSONException {
//		bs.updatestatus(id,status);
//	}

	@PostMapping("")
	public void createbooking(@RequestBody BookingDTO bookingdto) {
		bs.create(bookingdto);
	}

	@DeleteMapping("/{id}")
	public void delbooking(@PathVariable("id") int id) {
		bs.delete(id);
	}
}