package com.ant.BibliotecaRest.VO;

import java.util.List;

import com.ant.BibliotecaRest.model.Libro;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class LibroVO extends GenericVO{
	
	private List<Libro> libro;

	public LibroVO(String mensaje, String codigo, List<Libro> libro) {
		super(mensaje, codigo);
		this.libro = libro;
	}

}
