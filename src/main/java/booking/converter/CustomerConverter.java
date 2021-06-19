package booking.converter;

import booking.dto.CustomerDTO;
import booking.entity.City;
import booking.entity.Customer;
import booking.entity.District;

public class CustomerConverter {
	public void mapEntityToDTO(Customer customer, CustomerDTO custormerdto, District district, City city) {
		custormerdto.setId(customer.getId());
		custormerdto.setIdaccount(customer.getIdaccount());
		custormerdto.setName(customer.getName());
		custormerdto.setPhone(customer.getPhone());
		custormerdto.setImage(customer.getImage());
		custormerdto.setAddress(customer.getAddress());
		custormerdto.setIddistrict(district.getId());
		custormerdto.setDistrict(district.getName());
		custormerdto.setCity(city.getName());
		custormerdto.setIdcity(city.getId());
	}
	public void mapDTOtoEntity(Customer customer, CustomerDTO custormerdto) {
		customer.setName(custormerdto.getName());
		customer.setPhone(custormerdto.getPhone());
		customer.setImage(custormerdto.getImage());
		customer.setAddress(custormerdto.getAddress());
		customer.setIddistrict(custormerdto.getIddistrict());
	}
}
