package com.example.demo.reposirtory;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entites.Cinema;
import com.example.demo.entites.Ville;

public interface CinemaRepository extends JpaRepository<Cinema, Long> {

	List<Cinema> findByNom(String nom);

	List<Cinema> findByNomContains(String nom);

	@Query("select c from Cinema c where c.nom like %?1 and c.nombreSalles > ?2")
	List<Cinema> findByNomNbplace(String nom, int nb);

	@Query("select c from Cinema c where c.nom like %:nom and c.nombreSalles > :nb")
	List<Cinema> findByNbSlles(@Param("nom") String nom, @Param("nb") int nb);

	@Query("select c from Cinema c where c.ville = ?1")
	List<Cinema> findByVille(Ville ville);
	
	List<Cinema> findByVilleIdVille(Long id);
	
	List<Cinema> findByOrderByNomAsc();
	
	@Query("select c from Cinema c order by c.nom ASC, c.nombreSalles DESC")
	List<Cinema> trierProduitsNomsSalles ();


}
