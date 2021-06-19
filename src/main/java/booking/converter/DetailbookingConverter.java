package booking.converter;

import booking.dto.DetailbookingDTO;
import booking.entity.Detail_Booking;
import booking.entity.Equipment_timeline;
import booking.entity.ServiceHair;
import booking.entity.Store;
import booking.entity.Store_Service;

public class DetailbookingConverter {
	public void mapEntityToDTO(Detail_Booking detailbooking,Equipment_timeline equipmenttimeline,Store_Service storeservice,DetailbookingDTO detailbookingdto) {
		detailbookingdto.setId(detailbooking.getId());
		detailbookingdto.setIdstore(storeservice.getStores().getId());
		detailbookingdto.setNamestore(storeservice.getStores().getName());
		detailbookingdto.setIdservice(storeservice.getServicehairs().getId());
		detailbookingdto.setNameservice(storeservice.getServicehairs().getNameservice());
		detailbookingdto.setPrice(storeservice.getPrice());
		detailbookingdto.setTime(equipmenttimeline.getOrdinalnumber());
		detailbookingdto.setDate(equipmenttimeline.getDate());
		detailbookingdto.setIdstore_service(storeservice.getId());
	}
}
