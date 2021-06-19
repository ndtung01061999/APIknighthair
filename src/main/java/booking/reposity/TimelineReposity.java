package booking.reposity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import booking.entity.City;
import booking.entity.Store;
import booking.entity.Store_Service;
import booking.entity.Timeline;


public interface TimelineReposity extends JpaRepository<Timeline,Integer>{
	@Query(value="SELECT * FROM timeline WHERE idstore=?1", nativeQuery = true)
	Timeline findByStore(int id);
}
