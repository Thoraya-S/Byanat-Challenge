package byanattowersappws.service;

import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import byanattowersappws.model.Response;
import byanattowersappws.model.Tower;

@Service
public class TowerServiceImpl implements TowerService{
	

	@Override
	public ResponseEntity<Tower> getAllTowers() {
		
		String url = "https://byanat.wiremockapi.cloud/api/v3/towers";
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
			
		//Tower towersEntity = new Tower();
		HttpEntity request = new HttpEntity(headers);
			//HttpEntity<Tower> request = new HttpEntity<>(towersEntity, headers);
		//	Tower tower = restTemplate.postForObject(url, request, Tower.class);
		//	System.out.print(tower);
			
		//	ResponseEntity<Tower> response = restTemplate.postForEntity(url, request, Tower.class);
		ResponseEntity<Tower[]> response = restTemplate.exchange(url, HttpMethod.GET,request,Tower[].class);
		Tower[] towerlist = response.getBody();
		System.out.print(towerlist[0]);
			if (response.getStatusCode() == HttpStatus.OK) {
			    System.out.println("Request Successful");
			} else {
				System.out.println("Request Failed");
			}
		return null;
	}

	@Override
	public Object getTower() {
		
		String url = "https://byanat.wiremockapi.cloud/api/v3/towers";
		RestTemplate restTemplate = new RestTemplate();
		Object result = restTemplate.getForObject(url, String.class);
		System.out.print(result);
		
		return result;
	}

}
