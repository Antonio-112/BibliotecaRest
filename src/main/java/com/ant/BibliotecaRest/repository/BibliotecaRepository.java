package com.ant.BibliotecaRest.repository;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ant.BibliotecaRest.model.Libro;

@Repository
@ComponentScan
public interface BibliotecaRepository extends CrudRepository<Libro, Integer> {

	@Query("FROM Libro WHERE nombre = ?1")
	public List<Libro> findByNombre(String nombre);
	
}
