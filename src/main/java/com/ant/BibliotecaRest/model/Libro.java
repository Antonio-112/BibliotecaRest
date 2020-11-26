package com.ant.BibliotecaRest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.ant.BibliotecaRest.DTO.LibroDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Libro {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idLibro;
	private String nombre;
	private int precio;
	private boolean disponible;
	
	
	public LibroDTO toDTO() {
		LibroDTO libro = new LibroDTO();
		libro.setIdLibro(this.idLibro);
		libro.setNombre(this.nombre);
		libro.setPrecio(this.precio);
		libro.setDisponible(this.isDisponible());
		return libro;
	}
	
	
}
