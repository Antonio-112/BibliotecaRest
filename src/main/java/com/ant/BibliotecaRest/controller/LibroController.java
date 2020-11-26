package com.ant.BibliotecaRest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ant.BibliotecaRest.model.Libro;
import com.ant.BibliotecaRest.service.LibroService;

@RestController
@RequestMapping(value="api/biblioteca/v1")
public class LibroController {
	
	@Autowired
	LibroService servicio;

	@GetMapping("/listar")
	@ResponseStatus(HttpStatus.OK)
	public List<Libro> listar(){
		return servicio.findAll().getLibro();
		
	}
	
	@PostMapping("/agregar")
	@ResponseStatus(HttpStatus.CREATED)
	public void agregar(@RequestBody Libro libro) {
		servicio.save(libro);
	}
	
	@DeleteMapping("elimina/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void eliminar(@PathVariable Integer id) {
		servicio.delete(id);
	}
	
	@PutMapping(value="/modificar")
	@ResponseStatus(HttpStatus.OK)
	public void modificar(@RequestBody Libro libro) {
		servicio.save(libro);
	}
}
