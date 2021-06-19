package booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import booking.entity.City;
import booking.service.CityService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/city")
public class CityController {
	
	@Autowired
	private CityService cs;
	@GetMapping("")
	public List<City> getAll(){

		System.out.print(cs.findAll());
		return (List<City>) cs.findAll();
	}
}
