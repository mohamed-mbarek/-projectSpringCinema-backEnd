package com.example.demo.servicve;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entites.Cinema;
import com.example.demo.entites.Ville;
import com.example.demo.reposirtory.CinemaRepository;
import com.example.demo.reposirtory.VilleRepository;

@Service
public class VilleServiceImp  implements VilleService{

	@Autowired
	VilleRepository repository;
	
	
	public Ville saveVille(Ville ville) {
		String aa = ville.getImage();
		String bb = ville.copy(aa);
		ville.setImage(bb);
		return repository.save(ville) ;
	}

	public Ville updateVille(Ville ville) {
		String aa = ville.getImage();
		String bb = ville.copy(aa);
		ville.setImage(bb);
		return repository.save(ville);
	}

	public void deleteVilleById(Long id) {
		repository.deleteById(id);
	}

	public Ville getVille(Long id) {
		return repository.findVilleByidVille(id);
	}

	public List<Ville> getAllVilles() {
		return repository.findAll();
	}



}
