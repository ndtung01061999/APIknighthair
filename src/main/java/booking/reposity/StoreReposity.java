package booking.reposity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import booking.dto.CommentDTO;
import booking.entity.Booking;
import booking.entity.City;
import booking.entity.Comment;
import booking.entity.Store;


public interface StoreReposity extends JpaRepository<Store,Integer>{
	@Query(value="SELECT * FROM store WHERE iddistrict=?1", nativeQuery = true)
	List<Store> findByDistrict(int id);
	
	@Query(value="select customer.name as name,customer.image as avatar,booking.comment as comment,booking.pointcomment as point\n"
			+ "from customer,account,booking, detail_booking, store_service, store\n"
			+ "where\n"
			+ "customer.idaccount=account.id and\n"
			+ "account.id =booking.idaccount and\n"
			+ "booking.id=detail_booking.idbooking and\n"
			+ "detail_booking.idstore_service=store_service.id and\n"
			+ "store_service.idstore=store.id and\n"
			+ "store.id=?1 and booking.pointcomment>0",nativeQuery = true)
	List<Comment> findByComment(int id);

	
	@Query(value="SELECT * FROM store WHERE idaccount=?1", nativeQuery = true)
	Store findbyAccount(int id);
}


