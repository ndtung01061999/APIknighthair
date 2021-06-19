package booking.reposity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import booking.entity.Account;
import booking.entity.Booking;


public interface AccountReposity extends JpaRepository<Account,Integer>{
	@Query(value="SELECT * FROM knightdb.account where name=?1 and password=?2 and type=?3", nativeQuery = true)
	Account findByAccount(String name,String password, int type);
}
