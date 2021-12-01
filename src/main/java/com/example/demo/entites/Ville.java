package com.example.demo.entites;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Ville {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idVille;
private String nom ;
private Long codePostal ;
private String image;
@OneToMany (mappedBy = "ville" ,cascade = CascadeType.REMOVE)
@JsonIgnore
private Collection<Cinema> cinemas ;

public String copy(String image) {
	String[] array=image.split("\\\\");
	return (array[2]);
}
}
