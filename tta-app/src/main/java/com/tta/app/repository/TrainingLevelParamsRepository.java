package com.tta.app.repository;

import com.tta.app.model.training.TrainingLevelParams;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingLevelParamsRepository extends JpaRepository<TrainingLevelParams, Long> {

}
