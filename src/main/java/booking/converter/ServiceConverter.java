package booking.converter;

import org.modelmapper.ModelMapper;

import booking.dto.ServiceHairDTO;
import booking.dto.StoreDTO;
import booking.entity.ServiceHair;
import booking.entity.Store;
import booking.entity.Store_Service;

public class ServiceConverter {

	
	public void mapEntityToDTO(Store_Service store_service,ServiceHair sh, ServiceHairDTO servicedto) {
		servicedto.setId(store_service.getId());
		servicedto.setNameservice(sh.getNameservice());
		servicedto.setDuration(sh.getDuration());
		servicedto.setPrice(store_service.getPrice());
		servicedto.setImage(store_service.getImage());
		
	}
	
}

