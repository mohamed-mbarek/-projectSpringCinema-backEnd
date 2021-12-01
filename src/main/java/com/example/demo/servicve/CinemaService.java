package com.example.demo.servicve;

import java.util.List;

import com.example.demo.entites.Cinema;
import com.example.demo.entites.Ville;


public interface CinemaService {
	Cinema saveCinema(Cinema p);

	Cinema updateCinema(Cinema p);

	void deleteCinema(Cinema p);

	void deleteCinemaById(Long id);

	Cinema getCinema(Long id);

	List<Cinema> getAllCinemas();
	
	List<Cinema> findByNomCinema(String nom);
	List<Cinema> findByNomCinemaContains(String nom);
	List<Cinema> findByNomSalle (String nom, int nbSalles);
	List<Cinema> findByVille (Ville Ville);
	List<Cinema> findByVilleIdVille(Long id);
	List<Cinema> findByOrderByNomCinemaAsc();
	List<Cinema> trierCinemasNomsSalle();
}
