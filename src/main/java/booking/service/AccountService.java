package booking.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import booking.converter.AccountConverter;
import booking.converter.CustomerConverter;
import booking.dto.AccountDTO;
import booking.dto.CreateCustomerDTO;
import booking.dto.StoreDTO;
import booking.entity.Account;
import booking.entity.City;
import booking.entity.Customer;
import booking.reposity.AccountReposity;
import booking.reposity.CityReposity;
import booking.reposity.CustomerReposity;

@Service
public class AccountService {
	@Autowired
	AccountReposity ar;
	@Autowired
	private CustomerReposity cr;
	public List<AccountDTO> findall() {
		List<Account> accounts =ar.findAll();
		List<AccountDTO> accountdtos=new ArrayList<>();
		for (Account item : accounts) {
			AccountDTO accountdto = new AccountDTO();
			AccountConverter ac = new AccountConverter();
			ac.mappingEntitytoDTO(accountdto, item);
			accountdtos.add(accountdto);
		}
		return accountdtos;
	}

	public AccountDTO findone(String name, String password, int type) {
		Account account = ar.findByAccount(name, password, type);
		AccountDTO accountdto = new AccountDTO();
		if (account != null) {
			AccountConverter ac = new AccountConverter();
			ac.mappingEntitytoDTO(accountdto, account);
		}
		return accountdto;
	}
	public void updatePassword(int id, AccountDTO accountdto) {
		Account account = ar.findOne(id);
		if (account != null) {
			account.setPassword(accountdto.getPassword());
			ar.save(account);
		}

	}

	public void createAccount(CreateCustomerDTO customer) {
		Account account = new Account();
		account.setName(customer.getName());
		account.setPassword(customer.getPassword());
		account.setType(2);
		ar.save(account);
		Customer customera=new Customer();
		customera.setIdaccount(account.getId());
		customera.setName(customer.getNamecustomer());
		customera.setPhone(customer.getPhone());
		customera.setAddress(customer.getAddress());
		customera.setIddistrict(customer.getIddistrict());
		cr.save(customera);
	}

}
