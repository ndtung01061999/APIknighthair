package booking.reposity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import booking.entity.Booking;
import booking.entity.Detail_Booking;
import booking.entity.Equipment_timeline;


public interface Detail_BookingReposity extends JpaRepository<Detail_Booking,Integer>{
	@Query(value="SELECT * FROM detail_booking WHERE idbooking=?1", nativeQuery = true)
	List<Detail_Booking> findByAccount(int id);
	
	@Query(value="SELECT * FROM detail_booking,equipment_timeline \n"
			+ "	WHERE\n"
			+ "	detail_booking.idet=equipment_timeline.id\n"
			+ "	and idbooking=?1\n"
			+ "	and equipment_timeline.date=?2", nativeQuery = true)
	List<Detail_Booking> findbyBookingandDate(int id,String date);
	
	@Query(value="SELECT idet FROM detail_booking WHERE idet=?1", nativeQuery = true)
	int findByET(int id);
	
	
}
