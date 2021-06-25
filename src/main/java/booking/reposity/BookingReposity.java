package booking.reposity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import booking.entity.Booking;


public interface BookingReposity extends JpaRepository<Booking,Integer>{
	@Query(value="SELECT * FROM booking WHERE idaccount=?1", nativeQuery = true)
	List<Booking> findByAccount(int id);
	
	@Query(value=" SELECT booking.id,booking.idaccount,booking.date,booking.pointcomment,booking.comment,booking.status FROM booking,detail_booking,store_service\n"
			+ " where\n"
			+ " booking.id=detail_booking.idbooking\n"
			+ " and detail_booking.idstore_service=store_service.id \n"
			+ " and store_service.idstore=?1\n"
			+ " group by booking.id", nativeQuery = true)
	List<Booking> findByIdstore(int id);
}
