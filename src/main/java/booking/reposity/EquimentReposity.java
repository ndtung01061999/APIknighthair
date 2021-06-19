package booking.reposity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import booking.entity.Booking;
import booking.entity.Equipment;
import booking.entity.Equipment_timeline;


public interface EquimentReposity extends JpaRepository<Equipment,Integer>{
	@Query(value="select * from equipment WHERE idstore=?1 and type=?2 and status=1", nativeQuery = true)
	List<Equipment> findByStoreandType(int id,int type);
	
	@Query(value="SELECT COUNT(equipment.type) FROM equipment WHERE equipment.idstore=?1 and type=?2 and status=1 ", nativeQuery = true)
	int findCountStoreandType(int id,int type);
	
	
	@Query(value="SELECT equipment.id FROM equipment, equipment_timeline where equipment.id=equipment_timeline.idequipment and equipment.idstore=?1 and equipment.type=?2 and equipment_timeline.date>now()",nativeQuery = true)
	List<Integer> findIdetBystoreanDate(int id,int type);

}
