package booking.controller;

import java.util.List;

import booking.dto.*;
import booking.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import booking.service.CityService;
import booking.service.StoreService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/store")
public class StoreController {

	@Autowired
	private StoreService ss;

	@GetMapping("")
	public List<StoreDTO> getAll(){
		return (List<StoreDTO>) ss.findAll();
	}
	@GetMapping("/{id}")
	public StoreDTO getone(@PathVariable("id") int id){
		return (StoreDTO) ss.getone(id);
	}

	@PutMapping("/{id}")
	public void updateStore(@PathVariable("id") int id,@RequestBody StoreDTO storedto){
		ss.updateStore(id,storedto);
	}

	@GetMapping("/account/{id}")
	public StoreDTO getonebyAccount(@PathVariable("id") int id){
		return  ss.getonebyAccount(id);
	}


	@GetMapping("/service/{id}")
	public List<ServiceHairDTO> getService(@PathVariable("id") int id){
		return  ss.findService(id);
	}

	@PostMapping("/service/{id}")
	public void createService(@PathVariable("id") int id,@RequestBody ServiceHairDTO servicedto){
		ss.createService(id,servicedto);
	}

	@PutMapping("/service/{id}")
	public void updateService(@PathVariable("id") int id,@RequestBody ServiceHairDTO servicedto){
		ss.updateService(id,servicedto);
	}
	@DeleteMapping("/service/{idstore_service}")
	public void deleteService(@PathVariable("idstore_service") int idstore_service){
		ss.deleteService(idstore_service);
	}
	@GetMapping("/city/{id}")
	public List<StoreDTO> getCity(@PathVariable("id") int id){
		return  ss.findByCity(id);
	}

	@GetMapping("/district/{id}")
	public List<StoreDTO> getDistrict(@PathVariable("id") int id){
		return  ss.findDistrict(id);
	}

	@GetMapping("/oneservice/{id}")
	public List<StoreDTO> getfindOneService(@PathVariable("id") int id){
		return  ss.findOneService(id);
	}

	@GetMapping("/equipment/{id}/{type}/{date}")
	public List<TimelineDTO> getEquipment(@PathVariable("id") int id,@PathVariable("type") int type,@PathVariable("date") String date){
		return  ss.findEquipment(id,type,date);
	}
	@GetMapping("/equipment/{id}")
	public List<EquipmentDTO> countEquipment(@PathVariable("id") int id){
		return  ss.countEquipment(id);
	}


	@PostMapping("/equipment/{id}")
	public void createEquipment(@PathVariable("id") int id,@RequestBody EquipmentDTO equipmentdto){
		  ss.createEquipment(id,equipmentdto);
	}

	@PutMapping("/equipment/{id}")
	public String deleteEquipment(@PathVariable("id") int id,@RequestBody EquipmentDTO equipmentdto) {
		return ss.deleteEquiment(id, equipmentdto);
	}

	@GetMapping("/comment/{id}")
	public ResponseEntity<List<Comment>> getComment(@PathVariable("id") int id){
		return ResponseEntity.ok().body(ss.findComment(id));
	}

	@GetMapping("/booking/{id}/{date}")
	public List<BookingDTO> getBooking(@PathVariable("id") int id,@PathVariable("date") String date){
		return  ss.findbooking(id,date);
	}

	@PostMapping("/report/{id}")
	public List<Report> getReport(@PathVariable("id") int id, @RequestBody reportDTO reportdto){
		return ss.reportbooking(id,reportdto);
	}
}
