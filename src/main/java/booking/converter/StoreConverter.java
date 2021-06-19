package booking.converter;

import java.util.List;

import org.modelmapper.ModelMapper;

import booking.dto.ServiceHairDTO;
import booking.dto.StoreDTO;
import booking.entity.City;
import booking.entity.Store;
import booking.entity.Timeline;

public class StoreConverter {
	
	
	public void mapEntityToDTO(Store store, StoreDTO storedto,Timeline timeline,int idcity) {
		storedto.setId(store.getId());
		storedto.setIdaccount(store.getIdaccount());
		storedto.setAddress(store.getAddress());
		storedto.setPhone(store.getPhone());
		storedto.setFacebook(store.getFacebook());
		storedto.setDescription(store.getDescription());
		storedto.setIddistrict(store.getIddistrict());
		storedto.setImage(store.getImage());
		storedto.setName(store.getName());
		storedto.setTime_start(timeline.getTime_start());
		storedto.setTime_end(timeline.getTime_end());
		storedto.setIdcity(idcity);
	}
	
	
	public void mapUpdatestore(Store store, StoreDTO storedto,Timeline timeline) {
		store.setAddress(storedto.getAddress());
		store.setPhone(storedto.getPhone());
		store.setFacebook(storedto.getFacebook());
		store.setDescription(storedto.getDescription());
		store.setIddistrict(storedto.getIddistrict());
		store.setImage(storedto.getImage());
		store.setName(storedto.getName());
		timeline.setTime_start(storedto.getTime_start());
		timeline.setTime_end(storedto.getTime_end());
	}
	
	
	public void mappEtitytoDTOforService(Store store, StoreDTO storedto,List<ServiceHairDTO> service) {
		storedto.setId(store.getId());
		storedto.setIdaccount(store.getIdaccount());
		storedto.setAddress(store.getAddress());
		storedto.setPhone(store.getPhone());
		storedto.setFacebook(store.getFacebook());
		storedto.setDescription(store.getDescription());
		storedto.setIddistrict(store.getIddistrict());
		storedto.setImage(store.getImage());
		storedto.setName(store.getName());
		
		storedto.setListservice(service);
	}
}
