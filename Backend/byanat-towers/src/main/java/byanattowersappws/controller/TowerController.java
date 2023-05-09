package byanattowersappws.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping("searchTower")
	public List<Tower> getSearchTower(@RequestBody Tower tower){
		return towerService.getSearchTower(tower);
	}
	
	

}
