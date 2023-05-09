package byanattowersappws.service;


import java.util.List;
import byanattowersappws.model.Tower;

public interface TowerService {
	public Object getTower();
	public List<Tower> getSearchTower(Tower tower);

}
