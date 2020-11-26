package com.ant.BibliotecaRest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ant.BibliotecaRest.model.Libro;

public interface BibliotecaRepository extends CrudRepository<Libro, Integer> {

	@Query("FROM Productos WHERE nombre = ?1")
	public List<Libro> findByNombre(String nombre);
	
}
