package com.ant.BibliotecaRest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name="SQ_LIBRO", initialValue=1,allocationSize=1,sequenceName="SQ_LIBRO")
public class Libro {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SQ_LIBRO")
	private Integer id;
	private String nombre;
	private String precio;
	private boolean disponible;
	
	
}
