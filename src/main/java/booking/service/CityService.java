package booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import booking.entity.City;
import booking.reposity.CityReposity;


@Service
public class CityService {
	@Autowired
	private CityReposity cr;
	public List<City> findAll(){
		return (List<City>) cr.findAll();
	}
}
