package com.ant.BibliotecaRest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ant.BibliotecaRest.model.Libro;
import com.ant.BibliotecaRest.service.LibroService;

@RestController
@RequestMapping(value = "api/biblioteca/v1")
public class LibroController {

	@Autowired
	LibroService servicio;

	@GetMapping("/listar")
	@ResponseStatus(HttpStatus.OK)
	public List<Libro> listar() {
		return servicio.findAll().getLibro();
	}

	@GetMapping("/libro/{idLibro}")
	@ResponseStatus(HttpStatus.OK)
	public List<Libro> getLibro(@PathVariable Integer idLibro) {
		return servicio.findById(idLibro).getLibro();
	}
	
	@GetMapping("/libro/name/{nombre}")
	@ResponseStatus(HttpStatus.OK)
	public List<Libro> getLibroByName(@PathVariable String nombre){
		return servicio.findByNombre(nombre).getLibro();
	}

	@PostMapping("/agregar")
	@ResponseStatus(HttpStatus.CREATED)
	public void agregar(@ModelAttribute Libro libro) {
		servicio.save(libro);
	}

	@DeleteMapping("elimina/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void eliminar(@PathVariable Integer id) {
		servicio.delete(id);
	}

	@PutMapping(value = "/modificar")
	@ResponseStatus(HttpStatus.OK)
	public void modificar(@ModelAttribute Libro libro) {
		servicio.save(libro);
	}
}
