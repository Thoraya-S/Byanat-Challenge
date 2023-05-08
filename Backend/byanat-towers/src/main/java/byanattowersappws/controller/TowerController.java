package byanattowersappws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import byanattowersappws.model.Tower;
import byanattowersappws.service.TowerService;


@RestController
@CrossOrigin(origins="http://localhost:4200")  
public class TowerController {
	
	@Autowired
	private TowerService towerService;
	
	@GetMapping("allTowers")
	public Object getTowers(){
		return towerService.getTower();
	}
	
	//tower id, network operator, technology, and tower type.
	@PostMapping("searchTower")
	public ResponseEntity<Tower> getSearchTower(@RequestBody Tower tower){
		return towerService.getSearchTower(tower);
	}
	
	

}
