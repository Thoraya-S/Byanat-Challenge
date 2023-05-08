package byanattowersappws.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import byanattowersappws.model.Tower;


@Service
public class TowerServiceImpl implements TowerService{
	
	ObjectMapper mapper;
	
	//@Autowired
	//OrikaBeanMapper mapper;
	
	@PersistenceContext 
	private EntityManager em;
	
	 public static List<Tower> towerListSt;

	
	@Override
	public Object getTower() {
		
		String url = "https://byanat.wiremockapi.cloud/api/v3/towers";
		RestTemplate restTemplate = new RestTemplate();
		Object result = restTemplate.getForObject(url, String.class);
		return result;
	}

	@Override
	public ResponseEntity<Tower> getSearchTower(Tower tower) {
		String url = "https://byanat.wiremockapi.cloud/api/v3/towers";
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		HttpEntity request = new HttpEntity(headers);
		
		ResponseEntity<List<Tower>> response= restTemplate.exchange(url, HttpMethod.GET,request,
		new ParameterizedTypeReference<List<Tower>>(){}); 

		List<Tower> towerList = response.getBody();

		
		towerListSt = towerList;
		towerListSt.stream().collect(Collectors.toList());
		System.out.print(towerListSt.size());
		
		Predicate<Tower> towerIdFilter = tower_id -> tower_id.equals(tower.getTower_id());
		List<Tower> resultList = towerListSt.stream().filter(f -> f.getTower_id()== tower.getTower_id()).collect(Collectors.toList());
		System.out.print(resultList.stream().collect(Collectors.toList()));
//		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,request, String.class);
//		System.out.print(response.getBody().toString());
		
		
		return null;
	
	}

	

	

}
