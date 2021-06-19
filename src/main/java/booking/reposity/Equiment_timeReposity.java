package booking.reposity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import booking.entity.Booking;
import booking.entity.Equipment_timeline;


public interface Equiment_timeReposity extends JpaRepository<Equipment_timeline,Integer>{
	
}
