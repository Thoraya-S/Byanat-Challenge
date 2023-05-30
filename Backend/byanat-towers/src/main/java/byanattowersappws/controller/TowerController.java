package byanattowersappws.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import byanattowersappws.model.Tower;
import byanattowersappws.service.TowerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.models.media.MediaType;
import jakarta.websocket.server.PathParam;


@RestController
@CrossOrigin(origins="http://localhost:4200")  
public class TowerController {
	
	@Autowired
	private TowerService towerService;
	
	
	@GetMapping("allTowers")
	@Operation(tags = {"Towers APIs"},
			summary = "To find all towers",
			description = "This endpoint returns all towers details"
	)
	public Object getTowers(){
		return towerService.getTower();
	}
	

	@PostMapping("tower")
	@Operation(tags = {"Towers APIs"},
			summary = "Search towers",
			//content = @Content(schema = @Schema(implementation = Tower.class)),
			description = "This endpoint returns towers details filtered by tower id, network operator, technology, and tower type.",
			parameters = {@Parameter(name = "tower_id", description = "Tower Id", example = "1234", required = false),
					@Parameter(name = "operator", description = "Find towers by operator", example = "Verizon", required = false), 
					@Parameter(name = "tower_type", description = "Find towers by tower type", example = "TOWER", required = false), 
					@Parameter(name = "technology", description = "Find towers by technology", example = "5G", required = false), 
					},
			responses = {@ApiResponse(responseCode = "200", 
									content = @Content(schema = @Schema(implementation = Tower.class),
									mediaType = org.springframework.http.MediaType.APPLICATION_JSON_VALUE), 
									description = "Success Response" )}
			//security = {@SecurityRequirement(name = "BearerJWT")}
			
		
	)
	public List<Tower> getTowersByParameter(
			@PathParam("tower_id") Integer tower_id,
			@PathParam("operator") String operator, 
			@PathParam("tower_type") String tower_type,
			@PathParam("technology") String technology){
		Tower towerObj = new Tower();
		towerObj.setTower_id(tower_id);
		towerObj.setOperator(operator);
		towerObj.setTower_type(tower_type);
		towerObj.setTechnology(technology);
		return towerService.getSearchTower(towerObj);
		
	}

}
