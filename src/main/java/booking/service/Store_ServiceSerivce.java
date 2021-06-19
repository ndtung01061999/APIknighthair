package booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import booking.entity.City;
import booking.entity.Store;
import booking.entity.Store_Service;
import booking.reposity.StoreReposity;
import booking.reposity.Store_ServiceReposity;


@Service
public class Store_ServiceSerivce {
	@Autowired
	private Store_ServiceReposity cr;
	public List<Store_Service> findAll(){
		return (List<Store_Service>) cr.findAll();
	}
}
