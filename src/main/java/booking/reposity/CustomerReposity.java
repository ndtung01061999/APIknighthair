package booking.reposity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import booking.entity.Booking;
import booking.entity.City;
import booking.entity.Customer;
import booking.entity.Store_Service;


public interface CustomerReposity extends JpaRepository<Customer,Integer>{
	@Query(value="select * from customer where idAccount=?1", nativeQuery = true)
	Customer findByAccount(int id);
}
