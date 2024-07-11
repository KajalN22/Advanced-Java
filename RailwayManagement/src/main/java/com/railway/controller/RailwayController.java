package com.railway.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.railway.entities.Category;
import com.railway.entities.Railway;
import com.railway.exception.ResourceNotFoundException;
import com.railway.service.RailwayService;

@RestController
@RequestMapping("/railways")
public class RailwayController {

	@Autowired
	private RailwayService railwayService;
	
	@PostMapping
	public Railway  addNewRailway(@RequestBody Railway newRailway) {
		return railwayService.addNewRailway(newRailway);
	}
	

	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteRailway(@PathVariable Long id){
		
		try {
			Railway removedRailway=railwayService.deleteRailway(id);
			return new ResponseEntity<>(removedRailway,HttpStatus.OK);
			
		}catch(ResourceNotFoundException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
		
      }
	
	@GetMapping
	public List<Railway> getAllRailways(){
		return railwayService.getAllRailways();
	}

	
	@PutMapping
	public Railway updateRailwayDetails(@RequestBody   Railway railway) {
		return railwayService.updateRailwayDetails(railway);
	}
	
	@GetMapping("/{id}")
		public Railway getRailwayById(@PathVariable Long id){
		return railwayService.getRailwayById(id);
	}
	
	@GetMapping("/by-category")
	public List<Railway> getRailwayByCategory(@RequestParam Category category ){
		return railwayService.getRailwayByCategory(category);
		
	}
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	