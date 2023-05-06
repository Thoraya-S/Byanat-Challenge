package byanattowersappws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import byanattowersappws.model.Tower;
import byanattowersappws.service.TowerService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@CrossOrigin(origins="http://localhost:4200")  
public class TowerController {
	
	@Autowired
	private TowerService towerService;
	
	@RequestMapping("/hello")
	public String hello() {
		return "Hello world!";
	}
	
	@GetMapping("/towers")
	public ResponseEntity<Tower> getTowersData(){
		return towerService.getAllTowers();
	}
	
	
	@GetMapping("allTowers")
	public Object getTowers(){
		return towerService.getTower();
	}
	
	@GetMapping("searchTower")
	public ResponseEntity<Tower> getSearchTower(@RequestBody Tower tower){
		return towerService.getFilterData(tower);
		
	}

}
