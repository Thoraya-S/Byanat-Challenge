package byanattowersappws.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import byanattowersappws.model.Response;
import byanattowersappws.model.Tower;
import byanattowersappws.repository.TowerRepository;

@Service
public class TowerServiceImpl implements TowerService{
	
	ObjectMapper mapper;
	
//	@Autowired
//	private TowerRepository towerRepository;
	
	
	@Override
	public Object getTower() {
		
		String url = "https://byanat.wiremockapi.cloud/api/v3/towers";
		RestTemplate restTemplate = new RestTemplate();
		Object result = restTemplate.getForObject(url, String.class);
		System.out.print(result);
		
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
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,request, String.class);
		
		System.out.print(response.getBody().toString());
		if (tower != null) {
			//response.
		}
		return null;
		//return towerRepository.findBy(tower, tower.getTower_id());
	}

}
