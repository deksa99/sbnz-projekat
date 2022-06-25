package com.tta.app.repository;

import com.tta.app.model.racket.Rubber;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RubberRepository extends JpaRepository<Rubber, Long> {

}
