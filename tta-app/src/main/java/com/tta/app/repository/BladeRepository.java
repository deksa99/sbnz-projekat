package com.tta.app.repository;

import com.tta.app.model.racket.Blade;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BladeRepository extends JpaRepository<Blade, Long> {

}
