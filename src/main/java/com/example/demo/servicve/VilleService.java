package com.example.demo.servicve;

import java.util.List;

import com.example.demo.entites.Ville;

public interface VilleService {
	
	Ville saveVille(Ville p);

	Ville updateVille(Ville p);

	void deleteVilleById(Long id);

	Ville getVille(Long id);

	List<Ville> getAllVilles();
	

}
