package booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import booking.converter.CustomerConverter;
import booking.dto.CustomerDTO;
import booking.entity.City;
import booking.entity.Customer;
import booking.entity.District;
import booking.reposity.CityReposity;
import booking.reposity.CustomerReposity;
import booking.reposity.DistrictReposity;


@Service
public class CustomerService {
	@Autowired
	private CustomerReposity cr;
	@Autowired
	private DistrictReposity dr;
	@Autowired
	private CityReposity cityres;
	public CustomerDTO findOneidaccount(int id) {
		Customer customer=cr.findByAccount(id);
		District district=dr.findOne(customer.getIddistrict());
		City city=cityres.findOne(district.getCitys().getId());
		CustomerDTO customerdto=new CustomerDTO();
		CustomerConverter cc=new CustomerConverter();
		cc.mapEntityToDTO(customer, customerdto, district, city);
		return customerdto;
	}
	public void updatecustomer(int id,CustomerDTO customerdto) {
		Customer customer=cr.findByAccount(id);
		CustomerConverter cc=new CustomerConverter();
		cc.mapDTOtoEntity(customer, customerdto);
		cr.save(customer);
	}
	public void createCustomer(CustomerDTO customerdto) {

		Customer customer=new Customer();
		CustomerConverter cc=new CustomerConverter();
		cc.mapDTOtoEntity(customer, customerdto);
		customer.setIdaccount(customerdto.getIdaccount());
		cr.save(customer);
	}

	public void updateIamgecustomer(int id, CustomerDTO image) {
		Customer customer=cr.findByAccount(id);
		customer.setImage(image.getImage());
		cr.save(customer);
	}
}
