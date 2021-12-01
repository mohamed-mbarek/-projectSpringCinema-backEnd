package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entites.Cinema;
import com.example.demo.servicve.CinemaService;
import com.example.demo.servicve.CinemaServiceImp;

@RestController
@RequestMapping("cinema")
@CrossOrigin
public class CinemaRestController {

	@Autowired
	CinemaServiceImp cinemaServiceImp;

	@RequestMapping(path = "all",method = RequestMethod.GET)
	public List<Cinema> getAllCinelas() {
		return cinemaServiceImp.getAllCinemas();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Cinema getCinemaById(@PathVariable("id") Long id) {
		return cinemaServiceImp.getCinema(id);
	}

	@RequestMapping(path = "add", method = RequestMethod.POST)
	public Cinema createCinema(@RequestBody Cinema cinema) {
		return cinemaServiceImp.saveCinema(cinema);
	}

	@RequestMapping(path="update", method = RequestMethod.PUT)
	public Cinema updateCinema(@RequestBody Cinema c) {
		return cinemaServiceImp.updateCinema(c);
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	public void deleteCinema(@PathVariable("id") Long id) {
		cinemaServiceImp.deleteCinemaById(id);
	}

	@RequestMapping(value = "/cinemaVille/{idCat}", method = RequestMethod.GET)
	public List<Cinema> getCinemasByVilleId(@PathVariable("idCat") Long idVille) {
		return cinemaServiceImp.findByVilleIdVille(idVille);
	}

}
