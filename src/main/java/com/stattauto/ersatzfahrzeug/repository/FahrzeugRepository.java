package com.stattauto.ersatzfahrzeug.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stattauto.ersatzfahrzeug.entity.Fahrzeug;

@Repository
public interface FahrzeugRepository extends JpaRepository<Fahrzeug, Long> {
	
	List<Fahrzeug> findAll();

	Fahrzeug findByKennzeichen(String kennzeichen);


}
