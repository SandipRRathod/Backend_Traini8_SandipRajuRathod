package com.trainingcenter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trainingcenter.entity.TrainingCenter;
import com.trainingcenter.service.TrainingCenterService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/center")
public class TrainingCenterController {

	@Autowired
	private TrainingCenterService service;
	
	@PostMapping
	public ResponseEntity<?> saveCenter(@Valid @RequestBody TrainingCenter center){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(center)); //returning newly saved training center 
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<TrainingCenter>> getCenters(){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.getAllCenter());
	}
}
