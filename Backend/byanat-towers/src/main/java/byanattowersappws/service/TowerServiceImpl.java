package byanattowersappws.service;


import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import byanattowersappws.model.Tower;


@Service
public class TowerServiceImpl implements TowerService{
	
	 public static List<Tower> towerListSt;
	 
	
	@Override
	public Object getTower() {
		String url = "https://byanat.wiremockapi.cloud/api/v3/towers";
		RestTemplate restTemplate = new RestTemplate();
		Object result = restTemplate.getForObject(url, String.class);
		return result;
	}

	@Override
	public List<Tower> getSearchTower(Tower tower) {
		String url = "https://byanat.wiremockapi.cloud/api/v3/towers";
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		HttpEntity request = new HttpEntity(headers);
		ResponseEntity<List<Tower>> response= restTemplate.exchange(url, HttpMethod.GET,request,
		new ParameterizedTypeReference<List<Tower>>(){}); 
		List<Tower> towerList = response.getBody();
		
		Predicate<Tower> towerIdFilter = e -> e.getTower_id().equals(e.getTower_id());
		Predicate<Tower> operatoeFilter = e -> e.getOperator().equals(e.getOperator());
		Predicate<Tower> towerTypeFilter = e -> e.getTower_type().equals(e.getTower_type());
		Predicate<Tower> technologyFilter = e -> e.getTechnology().equals(e.getTechnology());
		
		towerListSt = towerList;
		towerListSt.stream().collect(Collectors.toList());
		
		if (tower.getTower_id() != null) {
			towerIdFilter = e -> e.getTower_id().equals(tower.getTower_id());
		}
		
		if (tower.getOperator() != null) {
			operatoeFilter = o -> o.getOperator() != null  && o.getOperator().equals(tower.getOperator());
		}
		
		if (tower.getTower_type() != null) {
			towerTypeFilter = o -> o.getTower_type() != null  && o.getTower_type().equals(tower.getTower_type());
		}
		
		if (tower.getTechnology() != null) {
			technologyFilter = o -> o.getTechnology() != null  && o.getTechnology().equals(tower.getTechnology());
		}
		
		
		List<Tower> resultList = towerListSt.stream()
				.filter(towerIdFilter.and(operatoeFilter).and(towerTypeFilter).and(technologyFilter))
				.collect(Collectors.toList());
	
		
		return resultList;
	
	}

}
