package com.ant.BibliotecaRest.service;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ant.BibliotecaRest.BibliotecaRestApplication;
import com.ant.BibliotecaRest.VO.LibroVO;
import com.ant.BibliotecaRest.model.Libro;
import com.ant.BibliotecaRest.repository.BibliotecaRepository;

@Service
public class LibroServiceImpl implements LibroService {

	
	private static final Logger log = LoggerFactory.getLogger(BibliotecaRestApplication.class);
	
	@Autowired
	BibliotecaRepository dao;
	
	
	com.ant.BibliotecaRest.VO.LibroVO respuesta;
	
	@Override
	public LibroVO findAll() {
		respuesta = new LibroVO("101", "Ha ocurrido un error", new ArrayList<Libro>() );
		try {
			respuesta.setLibro((List<Libro>) dao.findAll());
			respuesta.setMensaje("Se encontraron exitosamente" + respuesta.getLibro().size() + "registros");
			respuesta.setCodigo("0");
		} catch (Exception e) {
			respuesta.setCodigo("1");
			log.trace("Error en Service findAll(): ",e);
		}
		return respuesta;
	}

	@Override
	public LibroVO save(Libro libro) {
		respuesta = new LibroVO("102", "Ha ocurrido un error", new ArrayList<Libro>() );
		try {
			dao.save(libro);
			respuesta.setMensaje("Se a agregado correctamente el libro: " + libro.getNombre());
			respuesta.setCodigo("0");
		} catch (Exception e) {
			log.trace("Error en Service save(): ",e);
		}
		return respuesta;
	}

	@Override
	public LibroVO delete(Integer id) {
		respuesta = new LibroVO("103", "Ha ocurrido un error", new ArrayList<Libro>() );
		try {
			dao.deleteById(id);
			respuesta.setCodigo("0");
			respuesta.setMensaje("Se a eliminado correctamente");
		} catch (Exception e) {
			log.trace("Error en Service delete(): ",e);
		}
		return respuesta;
	}

	@Override
	@Transactional(readOnly = true)
	public LibroVO findById(Integer id) {
		respuesta = new LibroVO("104", "Ha ocurrido un error", new ArrayList<Libro>() );
		try {
			Libro libro = dao.findById(id).get();
			respuesta.getLibro().add(libro);
			respuesta.setCodigo("0");
			respuesta.setMensaje("Se a encontrado correctamente el libro:" + respuesta.getLibro().get(0).getNombre());
		} catch (Exception e) {
			log.trace("Error en Service findById(): ",e);
		}
		return respuesta;
	}

	@Override
	public LibroVO findByNombre(String nombre) {
		respuesta = new LibroVO("105", "Ha ocurrido un error", new ArrayList<Libro>() );
		try {
			//respuesta.setLibro(dao.findByNombre(nombre));
			respuesta.setCodigo("0");
			respuesta.setMensaje("Se a encontrado correctamente el libro: "+ nombre);
		} catch (Exception e) {
			log.trace("Error en Service findByNombre(): ",e);
		}
		return respuesta;
	}

}
