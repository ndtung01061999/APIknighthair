package booking.reposity;

import java.util.List;

import booking.dto.reportDTO;
import booking.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import booking.entity.Booking;


public interface BookingReposity extends JpaRepository<Booking,Integer>{
	@Query(value="SELECT * FROM booking WHERE idaccount=?1 order by date DESC", nativeQuery = true)
	List<Booking> findByAccount(int id);

	@Query(value=" SELECT booking.id,booking.idaccount,booking.date,booking.pointcomment,booking.comment,booking.status FROM booking,detail_booking,store_service\n"
			+ " where\n"
			+ " booking.id=detail_booking.idbooking\n"
			+ " and detail_booking.idstore_service=store_service.id \n"
			+ " and store_service.idstore=?1\n"
			+ " group by booking.id ", nativeQuery = true)
	List<Booking> findByIdstore(int id);

	@Query(value = "select COUNT(distinct booking.id), day(equipment_timeline.date) from booking, store,detail_booking,equipment_timeline,equipment\n" +
			" where\n" +
			" booking.id = detail_booking.idbooking and\n" +
			" detail_booking.idet= equipment_timeline.id and\n" +
			" equipment_timeline.idequipment= equipment.id and\n" +
			" equipment.idstore= store.id and\n" +
			" store.id=?1 and month(equipment_timeline.date)=?2 and year(equipment_timeline.date)=?3\n" +
			" group by day(equipment_timeline.date)" +
			" order by day(equipment_timeline.date) asc",nativeQuery = true)
	List<Report> findByIdandDate(int id, int month, int year);

	@Query(value = "select COUNT(distinct booking.id), month(equipment_timeline.date) from booking, store,detail_booking,equipment_timeline,equipment\n" +
			" where\n" +
			" booking.id = detail_booking.idbooking and\n" +
			" detail_booking.idet= equipment_timeline.id and\n" +
			" equipment_timeline.idequipment= equipment.id and\n" +
			" equipment.idstore= store.id and\n" +
			" store.id=?1 and year(equipment_timeline.date)=?2\n" +
			" group by month(equipment_timeline.date)" +
			" order by month(equipment_timeline.date) asc",nativeQuery = true)
	List<Report> findByIdandMonth(int id,int year);
}
