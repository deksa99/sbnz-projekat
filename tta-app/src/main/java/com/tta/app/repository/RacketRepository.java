package com.tta.app.repository;

import com.tta.app.model.racket.Racket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RacketRepository extends JpaRepository<Racket, Long> {

}
