package byanattowersappws.service;


import org.springframework.http.ResponseEntity;
import byanattowersappws.model.Tower;

public interface TowerService {
	public Object getTower();
	public ResponseEntity<Tower> getSearchTower(Tower tower);

}
