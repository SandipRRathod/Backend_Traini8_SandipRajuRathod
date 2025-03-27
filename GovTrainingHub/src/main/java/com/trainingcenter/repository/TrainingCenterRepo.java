package com.trainingcenter.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trainingcenter.entity.TrainingCenter;

@Repository
public interface TrainingCenterRepo extends JpaRepository<TrainingCenter, Long> {

	Optional<TrainingCenter> findByCenterCode(String centerCode); //custom finder method for uniqe cente-rname and center-code
	
	Optional<TrainingCenter> findByCenterName(String centerName);
}
