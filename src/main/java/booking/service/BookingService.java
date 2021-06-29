package booking.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import booking.converter.BookingConverter;
import booking.converter.DetailbookingConverter;
import booking.dto.BookingDTO;
import booking.dto.DetailbookingDTO;
import booking.entity.Account;
import booking.entity.Booking;
import booking.entity.City;
import booking.entity.Detail_Booking;
import booking.entity.Equipment;
import booking.entity.Equipment_timeline;
import booking.entity.ServiceHair;
import booking.entity.Store;
import booking.entity.Store_Service;
import booking.entity.Timeline;
import booking.reposity.AccountReposity;
import booking.reposity.BookingReposity;
import booking.reposity.CityReposity;
import booking.reposity.Detail_BookingReposity;
import booking.reposity.EquimentReposity;
import booking.reposity.Equiment_timeReposity;
import booking.reposity.ServiceReposity;
import booking.reposity.StoreReposity;
import booking.reposity.Store_ServiceReposity;
import booking.reposity.TimelineReposity;

@Service
public class BookingService {
	private final BookingReposity br;
	private final Detail_BookingReposity dbr;
	private final Store_ServiceReposity ssr;
	private final Equiment_timeReposity etr;
	private final AccountReposity ar;
	private final EquimentReposity er;
	private final TimelineReposity tlr;

	public BookingService(BookingReposity br, Detail_BookingReposity dbr, Store_ServiceReposity ssr, Equiment_timeReposity etr, AccountReposity ar, EquimentReposity er, TimelineReposity tlr) {
		this.br = br;
		this.dbr = dbr;
		this.ssr = ssr;
		this.etr = etr;
		this.ar = ar;
		this.er = er;
		this.tlr = tlr;
	}

	public List<BookingDTO> getaccount(int id) {
		List<BookingDTO> bookingdtos = new ArrayList();
		List<Booking> bookings = br.findByAccount(id);
		for (int i = 0; i < bookings.size(); i++) {
			List<DetailbookingDTO> detailbookingdtos = new ArrayList();
			List<Detail_Booking> detailbookings = dbr.findByAccount(bookings.get(i).getId());
			for (int j = 0; j < detailbookings.size(); j++) {
				Store_Service store_service = ssr.findOne(detailbookings.get(j).getStore_services().getId());
				Timeline timeline= tlr.findByStore(store_service.getStores().getId());
				Equipment_timeline equimenttime = etr.findOne(detailbookings.get(j).getEquipment_timelines().getId());
				DetailbookingConverter db = new DetailbookingConverter();
				DetailbookingDTO detailbookingdto = new DetailbookingDTO();
				db.mapEntityToDTO(detailbookings.get(j), equimenttime, store_service, detailbookingdto);
				detailbookingdto.setTimebooking(converTime(timeline.getTime_start(), detailbookingdto.getTime()));
				detailbookingdtos.add(detailbookingdto);
			}
			BookingConverter bc = new BookingConverter();
			BookingDTO bookingdto = new BookingDTO();
			bookingdto.setListdetail(detailbookingdtos);
			bc.mapEntityToDTO(bookings.get(i), bookingdto,detailbookingdtos);
			bookingdtos.add(bookingdto);
		}
		return bookingdtos;
	}
	String converTime(String time_start, int n) {
		String time = "";
		String time_startnew[] = time_start.split(":");
		int hourStart = Integer.parseInt(time_startnew[0]);
		int minStart = Integer.parseInt(time_startnew[1]);
		if (n == 0) {
			time = time = hourStart + ":" + minStart;;
		} else {

			if (minStart > 0) {
				if (n == 1) {
					hourStart += 1;
					time = hourStart + ":" + "00";
				} else if (n % 2 != 0) {
					hourStart += (n / 2) + 1;
					time = hourStart + ":" + "00";
				} else {
					hourStart += (n / 2);
					time = hourStart + ":" + minStart;
				}
			} else if (minStart == 0) {
				if (n == 1) {
					time = hourStart + ":30";
				} else if (n % 2 != 0) {
					hourStart += (n / 2);
					time = hourStart + ":30";
				} else {
					hourStart += (n / 2);
					time = hourStart + ":" + "00";
				}
			}
		}

		return time;
	}

	public String update(int id, BookingDTO bookingdto) {
		Booking booking = br.findOne(id);
		if (booking != null) {
			booking.setComment(bookingdto.getComment());
			booking.setPointcomment(bookingdto.getPointcomment());
			booking.setStatus(bookingdto.getStatus());
			br.save(booking);
			List<DetailbookingDTO> detailbookingdtos = bookingdto.getListdetail();
			for (DetailbookingDTO item : detailbookingdtos) {
				int idet = dbr.findByET(item.getId());
				Equipment_timeline et = etr.findOne(idet);
				et.setOrdinalnumber(item.getTime());
				et.setDate(item.getDate());
				etr.save(et);
			}
			return "success!!!";
		}

		return "fail";
	}

	public int checkEquiment(int idstore, int idservice, int time, String date) {
		int type = 0;
		if (idservice == 1 || idservice == 3)
			type = 1;
		else
			type = 2;
		int ideq = 0;
		List<Equipment> eqs = er.findByStoreandType(idstore, type);
		List<Equipment_timeline> ets = etr.findAll();
		for (Equipment item : eqs) {
			int kt = 0;
			for (Equipment_timeline item1 : ets) {

				if (item.getId() == item1.getEquipments().getId() && time == item1.getOrdinalnumber()
						&& date.equals(item1.getDate())) {
					kt = 1;
					break;
				}
			}
			if (kt == 0) {
				ideq = item.getId();
				break;
			}
		}
		return ideq;
	}

	public void create(BookingDTO bookingdto) {
		Booking booking = new Booking();
		Account account = ar.findOne(bookingdto.getIdaccount());
		booking.setAccounts(account);
		if(account.getType()==2) booking.setStatus(1);
		else booking.setStatus(3); 
		booking.setDate(java.time.LocalDateTime.now().toString());
		br.save(booking);
		List<DetailbookingDTO> details = bookingdto.getListdetail();
		for (int i = 0; i < details.size(); i++) {
			Store_Service store_service = ssr.findOne(details.get(i).getIdstore_service());
			int id = checkEquiment(store_service.getStores().getId(), store_service.getServicehairs().getId(),
					details.get(i).getTime(), details.get(i).getDate());
			if (id != 0) {
				Equipment equip = er.findOne(id);
				Equipment_timeline et = new Equipment_timeline();
				et.setEquipments(equip);
				et.setDate(details.get(i).getDate());
				System.out.println(details.get(i).getDate());
				et.setOrdinalnumber(details.get(i).getTime());
				etr.save(et);
				Detail_Booking db = new Detail_Booking();
				db.setBookings(booking);
				db.setEquipment_timelines(et);
				db.setStore_services(store_service);
				dbr.save(db);
				if(store_service.getServicehairs().getNameservice().equals("Nhuộm tóc")) {
					Equipment_timeline et_painthair = new Equipment_timeline();
					et_painthair.setEquipments(equip);
					System.out.println(details.get(i).getDate());
					et_painthair.setDate(details.get(i).getDate());
					et_painthair.setOrdinalnumber(details.get(i).getTime()+1);
					etr.save(et_painthair);
					Detail_Booking db_painthair = new Detail_Booking();
					db_painthair.setBookings(booking);
					db_painthair.setEquipment_timelines(et);
					db_painthair.setStore_services(store_service);
					
					dbr.save(db_painthair);
				}
			}
		}

	}
	
	public void delete(int id) {
		Booking booking=br.findOne(id);
		List<Detail_Booking> db=booking.getListdeatail_booking();
		for (Detail_Booking item : db) {
			Equipment_timeline et= item.getEquipment_timelines();
			dbr.delete(item);
			etr.delete(et);
		}
		br.delete(booking);
	}

}
