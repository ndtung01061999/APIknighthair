package booking.converter;

import java.util.List;

import booking.dto.BookingDTO;
import booking.dto.DetailbookingDTO;
import booking.entity.Booking;

public class BookingConverter {
	public void mapEntityToDTO(Booking booking, BookingDTO bookingdto,List<DetailbookingDTO> details) {
		bookingdto.setId(booking.getId());
		bookingdto.setIdaccount(booking.getAccounts().getId());
		bookingdto.setDate(booking.getDate());
		bookingdto.setPointcomment(booking.getPointcomment());
		bookingdto.setComment(booking.getComment());
		bookingdto.setStatus(booking.getStatus());
		int total=0;
		for(int i=0;i<details.size();i++) {
			total+=details.get(i).getPrice();
		}
		bookingdto.setTotal(total);
	}
}
