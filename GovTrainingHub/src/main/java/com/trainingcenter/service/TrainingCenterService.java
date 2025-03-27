package com.trainingcenter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trainingcenter.GlobalExceptionHandler;
import com.trainingcenter.entity.TrainingCenter;
import com.trainingcenter.repository.TrainingCenterRepo;

@Service
public class TrainingCenterService {
	
	@Autowired
	private TrainingCenterRepo centerRepo;

	
	public TrainingCenter save(TrainingCenter center) {
		
		if (centerRepo.findByCenterCode(center.getCenterCode()).isPresent() || 
		        centerRepo.findByCenterName(center.getCenterName()).isPresent()) {
		        throw new RuntimeException("Center Code Or Center Name must be unique!"); //if any of the from both center code or name is present then shows error 
		    }  
		
		return centerRepo.save(center);
	}
	
	
	public List<TrainingCenter> getAllCenter(){
		return centerRepo.findAll();  //simply return all training centers in list format
	}
}
