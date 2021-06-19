package booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import booking.dto.CustomerDTO;
import booking.entity.City;
import booking.service.CityService;
import booking.service.CustomerService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService cs;
	@GetMapping("/{id}")
	public CustomerDTO getId(@PathVariable("id") int id){
		return  cs.findOneidaccount(id);
	}
	@PutMapping("/{id}")
	public void updateCustomer(@PathVariable("id") int id, @RequestBody CustomerDTO customerdto) {
		cs.updatecustomer(id,customerdto);
	}
	@PostMapping("")
	public void createCustomer(@RequestBody CustomerDTO customerdto) {
		cs.createCustomer(customerdto);
	}
}
