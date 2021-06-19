package booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import booking.entity.ServiceHair;
import booking.reposity.ServiceReposity;


@Service
public class ServiceService {
	@Autowired
	private ServiceReposity cr;
	public List<ServiceHair> findAll(){
		return (List<ServiceHair>) cr.findAll();
	}
}
