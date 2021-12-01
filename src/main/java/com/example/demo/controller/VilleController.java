package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entites.Ville;
import com.example.demo.servicve.VilleServiceImp;

@RestController
@RequestMapping("/ville")
@CrossOrigin
public class VilleController {
	
	@Autowired
	VilleServiceImp villeServiceImp;

	@RequestMapping(path = "all",method = RequestMethod.GET)
	public List<Ville> getAllVille() {
		return villeServiceImp.getAllVilles();
	}

	@RequestMapping(value = "find/{id}", method = RequestMethod.GET)
	public Ville getVilleById(@PathVariable("id") Long id) {
		return villeServiceImp.getVille(id);
	}

	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public Ville createVille(@RequestBody Ville Ville) {
		return villeServiceImp.saveVille(Ville);
	}

	@RequestMapping(path = "/update" ,method = RequestMethod.PUT)
	public Ville updateVille(@RequestBody Ville c) {
		return villeServiceImp.updateVille(c);
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	public void deleteVille(@PathVariable("id") Long id) {
		villeServiceImp.deleteVilleById(id);
	}

	
}
