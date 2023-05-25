package byanattowersappws.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;

import byanattowersappws.model.SearchCriteria;
import byanattowersappws.model.Tower;


@Service
public class TowerServiceImpl implements TowerService{
	ObjectMapper mapper;
	
	 public static List<Tower> towerListSt;
	 
	 @PersistenceContext
	 private EntityManager entityManager;
	
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
		
		towerListSt = towerList;
		towerListSt.stream().collect(Collectors.toList());
		System.out.print(towerListSt.size());
		
		//Predicate<Tower> towerIdFilter = tower_id -> tower_id.equals(tower.getTower_id());
		
		//of tower id, network operator, technology, and tower type.
		List<Tower> resultList = towerListSt.stream()
				.filter(e->e.getTower_id().equals(tower.getTower_id()) || e.getOperator().equals(tower.getOperator())
						|| e.getTechnology().equals(tower.getTechnology()) || e.getTower_type().equals(tower.getTower_type()))
				.collect(Collectors.toList());
	
		
		return resultList;
	
	}

	@Override
	public List<Tower> getSearchTower2(Tower tower) {
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
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tower> query = builder.createQuery(Tower.class);
        Root root = query.from(Tower.class);
        
        //Predicate predicate = builder.conjunction();
        Integer tower_id = tower.getTower_id();
        String operator = tower.getOperator();
        String tower_type = tower.getTower_type();
        String technology = tower.getTechnology();
        
        List<Predicate> searchCriterias = new ArrayList<>();
        
        if(tower_id != null){
        	searchCriterias.add(builder.like(root.get("tower_id"), "%"+tower_id+"%"));
        }
        if(operator != null && operator!= ""){
        	searchCriterias.add(builder.like(root.get("operator"), "%"+operator+"%"));
        }
        if(tower_type != null && tower_type!= ""){
        	searchCriterias.add(builder.like(root.get("tower_type"), "%"+tower_type+"%"));
        }
        if(technology != null && technology!= ""){
        	searchCriterias.add(builder.like(root.get("technology"), "%"+technology+"%"));
        }
		
        query.select(root).where(builder.and(searchCriterias.toArray(new Predicate[searchCriterias.size()])));
		return entityManager.createQuery(query).getResultList();
	}

	

	

}
