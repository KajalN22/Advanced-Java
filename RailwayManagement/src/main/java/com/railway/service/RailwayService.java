package com.railway.service;

import java.util.List;

import com.railway.entities.Category;
import com.railway.entities.Railway;

public interface RailwayService {

	Railway addNewRailway(Railway newrailway);
	
	Railway deleteRailway(Long id);
	
	
	List<Railway> getAllRailways();
	
	Railway updateRailwayDetails(Railway railway);
	
	Railway getRailwayById(Long id);
	
	 List<Railway> getRailwayByCategory(Category category);
}
