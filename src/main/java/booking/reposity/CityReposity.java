package booking.reposity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import booking.entity.Booking;
import booking.entity.City;
import booking.entity.District;
import booking.entity.Store_Service;


public interface CityReposity extends JpaRepository<City,Integer>{
	@Query(value="select city.id from city,district\n"
			+ " where city.id=district.idcity\n"
			+ " and district.id=?1", nativeQuery = true)
	int findByIdCity(int id);
}
