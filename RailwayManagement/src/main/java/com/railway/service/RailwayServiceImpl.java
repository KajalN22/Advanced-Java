package com.railway.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railway.entities.Category;
import com.railway.entities.Railway;
import com.railway.exception.ResourceNotFoundException;
import com.railway.repository.RailwayRepository;

@Service
@Transactional
public class RailwayServiceImpl implements RailwayService{

	@Autowired
	private RailwayRepository railwayRepository;
	
	@Override
	public Railway addNewRailway(Railway newRailway) {
		if(newRailway.getStart_time()!=null&& newRailway.getEnd_time()!=null) {
			if(newRailway.getStart_time().isAfter(newRailway.getEnd_time())){
				throw new ResourceNotFoundException("Start time cannot be after end time");
			}
		}
		return railwayRepository.save(newRailway);
	}

	@Override
	public Railway deleteRailway(Long id) {
		Optional<Railway> railway = railwayRepository.findById(id);
		if(railway.isPresent()) {
			railwayRepository.deleteById(id);
			return railway.get();
		}else {
			throw new ResourceNotFoundException("Railway Id Not Found!!");
		}
		
	}

	@Override
	public List<Railway> getAllRailways() {
		
		return railwayRepository.findAll();
	}

	@Override
	public Railway updateRailwayDetails(Railway railway) {
	
    return railwayRepository.save(railway);
	}

	@Override
	public Railway getRailwayById(Long id) {
		Optional<Railway> o=railwayRepository.findById(id);
		
		return o.orElseThrow(()->new ResourceNotFoundException("Invalid railway ID"));
	}

	@Override
	public List<Railway> getRailwayByCategory(Category category) {
		
		return railwayRepository.findByCategory(category);
	}

	
	

}
