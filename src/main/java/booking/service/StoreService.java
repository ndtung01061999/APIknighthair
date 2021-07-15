package booking.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import booking.dto.*;
import booking.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import booking.converter.BookingConverter;
import booking.converter.DetailbookingConverter;
import booking.converter.ServiceConverter;
import booking.converter.StoreConverter;
import booking.reposity.BookingReposity;
import booking.reposity.CityReposity;
import booking.reposity.Detail_BookingReposity;
import booking.reposity.DistrictReposity;
import booking.reposity.EquimentReposity;
import booking.reposity.Equiment_timeReposity;
import booking.reposity.ServiceReposity;
import booking.reposity.StoreReposity;
import booking.reposity.Store_ServiceReposity;
import booking.reposity.TimelineReposity;

@Service
public class StoreService {
	@Autowired
	private BookingReposity br;
	@Autowired
	private Detail_BookingReposity dbr;
	@Autowired
	private StoreReposity sr;
	@Autowired
	private Store_ServiceReposity ssr;
	@Autowired
	private ServiceReposity serr;
	@Autowired
	private CityReposity citr;
	@Autowired
	private DistrictReposity dr;
	@Autowired
	private TimelineReposity tr;
	@Autowired
	private EquimentReposity er;
	@Autowired
	private Equiment_timeReposity etr;
	@Autowired
	private TimelineReposity tlr;

	public List<StoreDTO> findAll() {
		List<Store> stores = new ArrayList<Store>();
		stores = sr.findAll();
		List<StoreDTO> storedtos = new ArrayList<StoreDTO>();
		for (int i = 0; i < stores.size(); i++) {
			List<Store_Service> liststore_service = ssr.findByIdstore(stores.get(i).getId());
			List<ServiceHairDTO> listservicedto = new ArrayList<ServiceHairDTO>();
			for (Store_Service item : liststore_service) {
				ServiceHairDTO serviceDTO = new ServiceHairDTO();
				ServiceConverter sc = new ServiceConverter();
				ServiceHair service = serr.findOne(item.getServicehairs().getId());
				sc.mapEntityToDTO(item, service, serviceDTO);
				listservicedto.add(serviceDTO);
			}
			StoreConverter sc = new StoreConverter();
			StoreDTO storedto = new StoreDTO();
			sc.mappEtitytoDTOforService(stores.get(i), storedto, listservicedto);
			storedtos.add(storedto);
		}
		return storedtos;
	}

	public StoreDTO getone(int id) {
		Store store = sr.findOne(id);
		StoreDTO storedto = new StoreDTO();
		StoreConverter sc = new StoreConverter();
		sc.mapEntityToDTO(store, storedto, tr.findByStore(store.getId()), citr.findByIdCity(store.getIddistrict()));
		return storedto;
	}

	public List<ServiceHairDTO> findService(int id) {
		List<ServiceHairDTO> listshd = new ArrayList();
		Store store = sr.findOne(id);
		List<Store_Service> ss = ssr.findByIdstore(id);
		for (int i = 0; i < ss.size(); i++) {
			ServiceHair sh = serr.findOne(ss.get(i).getServicehairs().getId());
			ServiceHairDTO shd = new ServiceHairDTO();
			ServiceConverter sc = new ServiceConverter();
			sc.mapEntityToDTO(ss.get(i), sh, shd);
			listshd.add(shd);
		}

		return listshd;
	}

	public List<StoreDTO> findByCity(int id) {
		List<StoreDTO> storedtos = new ArrayList();
		City city = citr.findOne(id);
		List<District> district = dr.findByIdCity(city.getId());
		for (int i = 0; i < district.size(); i++) {
			List<Store> stores = sr.findByDistrict(district.get(i).getId());
			if (stores != null) {
				for (Store item : stores) {
					StoreDTO storedto = new StoreDTO();
					StoreConverter sc = new StoreConverter();
					sc.mapEntityToDTO(item, storedto, tr.findByStore(item.getId()),
							citr.findByIdCity(item.getIddistrict()));
					storedtos.add(storedto);
				}
			}
		}
		return storedtos;
	}

	public List<StoreDTO> findDistrict(int id) {
		List<StoreDTO> storedtos = new ArrayList();
		List<Store> stores = sr.findByDistrict(id);
		for (int i = 0; i < stores.size(); i++) {
			StoreDTO storedto = new StoreDTO();
			StoreConverter sc = new StoreConverter();
			sc.mapEntityToDTO(stores.get(i), storedto, tr.findByStore(stores.get(i).getId()),
					citr.findByIdCity(stores.get(i).getIddistrict()));
			storedtos.add(storedto);
		}
		return storedtos;
	}

	public List<StoreDTO> findOneService(int id) {
		List<StoreDTO> storedtos = new ArrayList();
		List<Store_Service> listss = ssr.findByIdservice(id);
		for (int i = 0; i < listss.size(); i++) {
			List<ServiceHairDTO> listservicedto = new ArrayList<ServiceHairDTO>();
			ServiceHairDTO serviceDTO = new ServiceHairDTO();
			ServiceConverter scc = new ServiceConverter();
			ServiceHair services = serr.findOne(listss.get(i).getServicehairs().getId());
			scc.mapEntityToDTO(listss.get(i), services, serviceDTO);
			listservicedto.add(serviceDTO);
			StoreDTO storedto = new StoreDTO();
			StoreConverter sc = new StoreConverter();
			ServiceHairDTO service = new ServiceHairDTO();
			sc.mappEtitytoDTOforService(sr.findOne(listss.get(i).getStores().getId()), storedto, listservicedto);
			storedtos.add(storedto);
		}
		return storedtos;
	}

	public List<TimelineDTO> findEquipment(int id, int type, String date) {
		List<TimelineDTO> timelinedtos = new ArrayList();

		Store store = sr.findOne(id);
		Timeline time = tr.findByStore(store.getId());
		int n = countTime(time.getTime_start(), time.getTime_end());
		for (int i = 0; i < n; i++) {
			TimelineDTO timelinedto = new TimelineDTO();
			timelinedto.setId(i);
			timelinedto.setNumber(numberOf(id, type, date, i));
			timelinedto.setTime(converTime(time.getTime_start(), i));
			timelinedtos.add(timelinedto);
		}
		return timelinedtos;
	}
	String converTime(String time_start, int n) {
		String time = "";
		String time_startnew[] = time_start.split(":");
		int hourStart = Integer.parseInt(time_startnew[0]);
		int minStart = Integer.parseInt(time_startnew[1]);
		if (n == 0) {
			time = time = hourStart + ":" + minStart;
			;
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
	int countTime(String time_start, String time_end) {
		String time_startnew[] = time_start.split(":");
		int hourStart = Integer.parseInt(time_startnew[0]);
		int minStart = Integer.parseInt(time_startnew[1]);

		String time_endnew[] = time_end.split(":");
		int hourEnd = Integer.parseInt(time_endnew[0]);
		int minEnd = Integer.parseInt(time_endnew[1]);

		int n = (hourEnd - hourStart + 1) * 2 - 1;
		if (minStart > 0)
			n -= 1;
		if (minEnd > 0)
			n += 1;
		return n;
	}

	public int numberOf(int id, int type, String date, int ordnalnumber) {
		int numberAll = er.findCountStoreandType(id, type);
		List<Equipment> eqs = er.findByStoreandType(id, type);
		List<Equipment_timeline> ets = etr.findAll();

		for (Equipment item : eqs) {
			for (Equipment_timeline item1 : ets) {
				if (item.getId() == item1.getEquipments().getId() && item1.getOrdinalnumber() == ordnalnumber
						&& item1.getDate().equals(date)) {
					numberAll--;
				}
			}
		}

		return numberAll;
	}

	public void createService(int id, ServiceHairDTO servicedto) {
		Store_Service storeservice = new Store_Service();
		storeservice.setStores(sr.findOne(id));
		storeservice.setServicehairs(serr.findOne(servicedto.getId()));
		storeservice.setPrice(servicedto.getPrice());
		storeservice.setImage(servicedto.getImage());
		ssr.save(storeservice);
	}

	public void updateService(int id, ServiceHairDTO servicedto) {
		Store_Service storeservice = ssr.findOne(id);
		storeservice.setPrice(servicedto.getPrice());
		storeservice.setImage(servicedto.getImage());
		ssr.save(storeservice);
	}

	public void deleteService(int idstore_service) {
		Store_Service storeservice = ssr.findOne(idstore_service);
		ssr.delete(storeservice);
	}

	public void createEquipment(int id, EquipmentDTO equipmentdto) {
		for (int i = 0; i < equipmentdto.getNumberOf(); i++) {
			Equipment equipment = new Equipment();
			equipment.setStores(sr.findOne(id));
			equipment.setType(equipmentdto.getType());
			equipment.setStatus(1);
			if (equipmentdto.getType() == 1)
				equipment.setName("ghe loai 1");
			else
				equipment.setName("ghe loai 2");
			er.save(equipment);
		}

	}
	public String deleteEquiment(int id, EquipmentDTO equipmentdto) {
		int dem = 0;
		for (int i = 0; i < equipmentdto.getNumberOf(); i++) {
			List<Integer> et = er.findIdetBystoreanDate(id, equipmentdto.getType());
			List<Equipment> ets = er.findByStoreandType(id, equipmentdto.getType());
			for (Equipment item : ets) {
				int kt = 0;
				for (int j = 0; j < et.size(); j++) {
					if (et.get(j) == item.getId()) {
						kt = 1;
						break;
					}
				}
				if (kt == 0) {
					item.setStatus(2);
					dem += 1;
					er.save(item);
					break;
				}
			}
		}
		if (dem == 0)
			return "fail";
		else
			return "success";
	}

	public StoreCommentDTO findComment(int id) {
		StoreCommentDTO storecommentdto = new StoreCommentDTO();
		storecommentdto.setListcomment(sr.findByComment(id));
		return storecommentdto;
	}

	public List<BookingDTO> findbooking(int id, String date) {
		List<BookingDTO> bookingdtos = new ArrayList();
		Store store = sr.findbyAccount(id);
		List<Booking> bookings = br.findByIdstore(store.getId());
		for (int i = 0; i < bookings.size(); i++) {
			List<DetailbookingDTO> detailbookingdtos = new ArrayList();
			List<Detail_Booking> detailbookings = dbr.findbyBookingandDate(bookings.get(i).getId(), date);
			for (int j = 0; j < detailbookings.size(); j++) {
				Store_Service store_service = ssr.findOne(detailbookings.get(j).getStore_services().getId());
				Timeline timeline = tlr.findByStore(store_service.getStores().getId());
				Equipment_timeline equimenttime = etr.findOne(detailbookings.get(j).getEquipment_timelines().getId());
				DetailbookingConverter db = new DetailbookingConverter();
				DetailbookingDTO detailbookingdto = new DetailbookingDTO();
				db.mapEntityToDTO(detailbookings.get(j), equimenttime, store_service, detailbookingdto);
				detailbookingdto.setTimebooking(converTime(timeline.getTime_start(), detailbookingdto.getTime()));
				detailbookingdtos.add(detailbookingdto);
			}
			if (detailbookingdtos.size() != 0) {
				BookingConverter bc = new BookingConverter();
				BookingDTO bookingdto = new BookingDTO();
				bookingdto.setListdetail(detailbookingdtos);
				bc.mapEntityToDTO(bookings.get(i), bookingdto, detailbookingdtos);
				bookingdtos.add(bookingdto);
			}

		}
		return bookingdtos;
	}

	public StoreDTO getonebyAccount(int id) {
		Store store = sr.findbyAccount(id);
		StoreDTO storedto = new StoreDTO();
		StoreConverter sc = new StoreConverter();
		sc.mapEntityToDTO(store, storedto, tr.findByStore(store.getId()), citr.findByIdCity(store.getId()));
		return storedto;
	}

	public List<EquipmentDTO> countEquipment(int id) {
		List<EquipmentDTO> Equipmentdtos = new ArrayList<>();
		for (int i = 1; i <= 2; i++) {
			EquipmentDTO Equipmentdto = new EquipmentDTO();
			Equipmentdto.setType(i);
			Equipmentdto.setNumberOf(er.findCountStoreandType(id, i));
			Equipmentdtos.add(Equipmentdto);
		}

		return Equipmentdtos;
	}

	public void updateStore(int id, StoreDTO storedto) {
		Store store = sr.findOne(id);
		Timeline timeline = tr.findByStore(store.getId());
		StoreConverter sc = new StoreConverter();
		sc.mapUpdatestore(store, storedto, timeline);
		sr.save(store);
		tr.save(timeline);
	}

	public List<Report> reportbooking(int id, reportDTO reportdto) {
		int count=0;
		String[] date = reportdto.getDate().split("-");
		int year=Integer.parseInt(date[0]);
		int month=Integer.parseInt(date[1]);
		List<Report> list =new ArrayList<>();
		if (reportdto.getType()==1) {
			list =  br.findByIdandDate(id,month,year);
		}
		else if (reportdto.getType()==2) {
			list = br.findByIdandMonth(id,year);
		}
		return list;
	}
}
