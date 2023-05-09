package byanattowersappws.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping("searchTower")
	public List<Tower> getSearchTower(@RequestBody Tower tower){
		return towerService.getSearchTower(tower);
	}
	
	@PostMapping("tower")
	public List<Tower> getTowersByParameter(@RequestBody Tower tower, 
			@PathParam("tower_id") Integer tower_id){
		tower.setTower_id(tower_id);
		return towerService.getSearchTower(tower);
		
	}
	
	

}
