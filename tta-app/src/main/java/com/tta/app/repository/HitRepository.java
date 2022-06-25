package com.tta.app.repository;

import com.tta.app.model.training.Hit;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HitRepository extends JpaRepository<Hit, Long> {

}
