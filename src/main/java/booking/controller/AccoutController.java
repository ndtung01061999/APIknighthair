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

import booking.dto.AccountDTO;
import booking.dto.CreateCustomerDTO;
import booking.entity.City;
import booking.service.AccountService;
import booking.service.CityService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/account")
public class AccoutController {
	
	@Autowired
	private AccountService as;
	
	@GetMapping("")
	public List<AccountDTO> findall(){
		return as.findall();
	}
	@GetMapping("/{name}/{password}/{type}")
	public AccountDTO findoneaccount(@PathVariable("name") String name,@PathVariable("password") String password,@PathVariable("type") int type){
		return as.findone(name,password,type);
	}

	@PostMapping("/login")
	public String login(@RequestBody AccountDTO accountdto){
		return as.login(accountdto.getName(),accountdto.getPassword(),accountdto.getType());
	}

	@PutMapping("/{id}")
	public void updatePassword(@PathVariable("id") int id,@RequestBody AccountDTO accountdto) {
		as.updatePassword(id,accountdto);
	}
	@PostMapping("")
	public void createAccount(@RequestBody CreateCustomerDTO customer) {
		as.createAccount(customer);
	}
}
