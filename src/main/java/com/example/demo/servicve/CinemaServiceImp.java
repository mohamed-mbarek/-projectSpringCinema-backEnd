package com.example.demo.servicve;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entites.Cinema;
import com.example.demo.entites.Ville;
import com.example.demo.reposirtory.CinemaRepository;

@Service
public class CinemaServiceImp implements CinemaService {

	@Autowired
	CinemaRepository cinemaRepository;

	@Override
	public Cinema saveCinema(Cinema cinema) {
		String aa=cinema.getImage();
		String bb=cinema.copy(aa);
		cinema.setImage(bb);
		return cinemaRepository.save(cinema);
	}

	@Override
	public Cinema updateCinema(Cinema cinema) {
		 int x=cinema.getImage().indexOf("\\");
		 if(x>0) {
		String aa=cinema.getImage();
		String bb=cinema.copy(aa);
		cinema.setImage(bb);
		}
		return cinemaRepository.save(cinema);
	}

	@Override
	public void deleteCinema(Cinema c) {
		cinemaRepository.delete(c);

	}

	@Override
	public void deleteCinemaById(Long id) {
		cinemaRepository.deleteById(id);
	}

	@Override
	public Cinema getCinema(Long id) {
		return cinemaRepository.findById(id).get();
	}

	@Override
	public List<Cinema> getAllCinemas() {
		return cinemaRepository.findAll();
	}

	@Override
	public List<Cinema> findByNomCinema(String nom) {
		return cinemaRepository.findByNom(nom);
	}

	@Override
	public List<Cinema> findByNomCinemaContains(String nom) {
		// TODO Auto-generated method stub
		return cinemaRepository.findByNomContains(nom);
	}

	@Override
	public List<Cinema> findByNomSalle(String nom, int nbSalles) {
		return cinemaRepository.findByNomNbplace(nom, nbSalles);
	}

	@Override
	public List<Cinema> findByVille(Ville ville) {
		return cinemaRepository.findByVille(ville);
	}

	@Override
	public List<Cinema> findByVilleIdVille(Long id) {
		return cinemaRepository.findByVilleIdVille(id);
	}

	@Override
	public List<Cinema> findByOrderByNomCinemaAsc() {
		return cinemaRepository.findByOrderByNomAsc();
	}

	@Override
	public List<Cinema> trierCinemasNomsSalle() {
		return cinemaRepository.trierProduitsNomsSalles();
	}

}
