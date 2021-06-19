package booking.reposity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import booking.entity.ServiceHair;
import booking.entity.Store;
import booking.entity.Store_Service;

public interface ServiceReposity extends JpaRepository<ServiceHair, Integer> {
	@Query(value = "SELECT * FROM service WHERE service.nameservice=?1", nativeQuery = true)
	ServiceHair findByName(String name);
}
