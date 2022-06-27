package com.tta.app.repository;

import java.util.List;

import com.tta.app.model.enums.TrainingLevel;
import com.tta.app.model.training.TrainingLevelParams;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingLevelParamsRepository extends JpaRepository<TrainingLevelParams, Long> {

	public List<TrainingLevelParams> findOneByLevel(TrainingLevel level);
}
