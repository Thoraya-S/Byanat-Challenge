package byanattowersappws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import byanattowersappws.model.TestModel;
import byanattowersappws.service.TestService;

@RestController
public class TestController {
	
	@Autowired
	private TestService testService;
	
	@RequestMapping("/helloooo")
	public String hello() {
		return "Hello world from secound APPPddd";
	}
	
	@GetMapping("/towers")
	public List<TestModel> getTowersData(){
		return testService.getAllTowers();
	}
	

}
