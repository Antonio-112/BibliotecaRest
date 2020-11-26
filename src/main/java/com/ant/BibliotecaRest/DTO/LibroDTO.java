package com.ant.BibliotecaRest.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LibroDTO {
	
	private Integer idLibro;
	private String nombre;
	private Integer precio;
	private boolean disponible;

}
