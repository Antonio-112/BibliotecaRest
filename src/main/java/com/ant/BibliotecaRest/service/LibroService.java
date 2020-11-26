package com.ant.BibliotecaRest.service;

import com.ant.BibliotecaRest.model.Libro;
import com.ant.BibliotecaRest.VO.LibroVO;

public interface LibroService {

	public LibroVO findAll();
	public LibroVO save(Libro libro);
	public LibroVO delete(Integer id);
	public LibroVO findById(Integer id);
	public LibroVO findByNombre(String nombre);
	
}
