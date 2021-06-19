package booking.reposity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import booking.entity.City;
import booking.entity.District;
import booking.entity.Store_Service;


public interface DistrictReposity extends JpaRepository<District,Integer>{
	@Query(value="SELECT * FROM district WHERE idcity=?1", nativeQuery = true)
	List<District> findByIdCity(int id);
}
