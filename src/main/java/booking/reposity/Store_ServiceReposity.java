package booking.reposity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import booking.entity.ServiceHair;
import booking.entity.Store_Service;

public interface Store_ServiceReposity extends JpaRepository<Store_Service, Integer> {
	@Query(value = "SELECT * FROM store_service WHERE idstore=:idstore", nativeQuery = true)
	List<Store_Service> findByIdstore(@Param("idstore") int idstore);

	@Query(value = "SELECT * FROM store_service WHERE idservice=?1", nativeQuery = true)
	List<Store_Service> findByIdservice(int id);

	@Query(value = "SELECT * FROM store_service WHERE idstore=?1 and idservice=?2", nativeQuery = true)
	Store_Service findByIdStoreandService(int idstore,int idservice);
}
