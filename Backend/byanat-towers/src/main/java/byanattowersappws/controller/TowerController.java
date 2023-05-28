package byanattowersappws.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import byanattowersappws.model.Tower;
import byanattowersappws.service.TowerService;
import jakarta.websocket.server.PathParam;


@RestController
@CrossOrigin(origins="http://localhost:4200")  
public class TowerController {
	
	@Autowired
	private TowerService towerService;
	
	@GetMapping("allTowers")
	public Object getTowers(){
		return towerService.getTower();
	}
	

	@PostMapping("tower")
	public List<Tower> getTowersByParameter(
			@PathParam("tower_id") Integer tower_id,
			@PathParam("operator") String operator, 
			@PathParam("tower_type") String tower_type,
			@PathParam("technology") String technology){
		Tower towerObj = new Tower();
		towerObj.setTower_id(tower_id);
		towerObj.setOperator(operator);
		towerObj.setTower_type(tower_type);
		towerObj.setTechnology(technology);
		return towerService.getSearchTower(towerObj);
		
	}

}
