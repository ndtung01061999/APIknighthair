package booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import booking.dto.DistrictDTO;
import booking.entity.City;
import booking.entity.District;
import booking.reposity.DistrictReposity;
import booking.service.CityService;
import booking.service.DIstrictService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/district")
public class DistrictController {
	
	@Autowired
	private DIstrictService ds;
	@GetMapping("/{id}")
	public List<DistrictDTO> getDistrictByCity(@PathVariable("id") int id){
		return ds.findbyCity(id);
	}
}
