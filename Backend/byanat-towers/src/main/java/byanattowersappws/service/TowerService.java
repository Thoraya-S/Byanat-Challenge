package byanattowersappws.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import byanattowersappws.model.Tower;

public interface TowerService {
	public ResponseEntity<Tower> getAllTowers();
	
	public Object getTower();
	
	public ResponseEntity<Tower> getFilterData(Tower tower);

}
