package com.example.demo.reposirtory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entites.Ville;

public interface VilleRepository extends JpaRepository<Ville, Long> {
	Ville findVilleByidVille(Long id);
}
