package byanattowersappws.service;

import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import byanattowersappws.model.TestModel;

@Service
public class TestServiceImpl implements TestService{

	@Override
	public List<TestModel> getAllTowers() {
		String url = "https://byanat.wiremockapi.cloud/api/v3/towers";
		RestTemplate restTemplate = new RestTemplate();
	
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
			
		TestModel towersEntity = new TestModel();
			
			HttpEntity<TestModel> request = new HttpEntity<>(towersEntity, headers);
			
			ResponseEntity<TestModel> response = restTemplate.postForEntity(url, request, TestModel.class);
			
			if (response.getStatusCode() == HttpStatus.OK) {
			    System.out.println("Request Successful");
			} else {
			    System.out.println("Request Failed");
			}
		return null;
	}

}
