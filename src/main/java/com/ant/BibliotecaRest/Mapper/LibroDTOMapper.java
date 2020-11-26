package com.ant.BibliotecaRest.Mapper;

import com.ant.BibliotecaRest.DTO.LibroDTO;
import com.ant.BibliotecaRest.model.Libro;
public class LibroDTOMapper {
	
	public LibroDTOMapper() {
		
	}
	
	private static void toEntity(LibroDTO libroDTO, Libro libro) {
		libro.setIdLibro(libroDTO.getIdLibro());
		libro.setNombre(libroDTO.getNombre());
		libro.setPrecio(libroDTO.getPrecio());
		libro.setDisponible(libroDTO.isDisponible());
	}
	
	public static Libro toEntity(LibroDTO libroDTO) {
		Libro libro = new Libro();
		toEntity(libroDTO,libro);
		return libro;
		
	}

}
