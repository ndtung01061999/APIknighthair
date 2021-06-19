package booking.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import booking.dto.DistrictDTO;
import booking.entity.City;
import booking.entity.District;
import booking.reposity.CityReposity;
import booking.reposity.DistrictReposity;


@Service
public class DIstrictService {
	@Autowired
	private DistrictReposity cr;
	public List<DistrictDTO> findbyCity(int id){
		List<District> districts=  cr.findByIdCity(id);
		List<DistrictDTO> districtdtos=new ArrayList<>();
		for (District item : districts) {
			DistrictDTO districtdto=new DistrictDTO();
			districtdto.setId(item.getId());
			districtdto.setIdcity(item.getCitys().getId());
			districtdto.setName(item.getName());
			districtdtos.add(districtdto);
		}
		return districtdtos;
	}
}
