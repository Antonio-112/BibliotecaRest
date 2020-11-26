package com.ant.BibliotecaRest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ant.BibliotecaRest.model.Libro;
import com.ant.BibliotecaRest.service.LibroService;

@SpringBootTest
class BibliotecaRestApplicationTests {

	@Autowired
	LibroService svcL;
	
	@Test
	void JpaTest() {
		Libro libro = new Libro(2,"Juejue",3400,true);
		assertEquals("0", svcL.findAll().getCodigo());
		assertEquals(1,svcL.findAll().getLibro().size());
		//assertEquals("0",svcL.delete(2).getCodigo());
		assertEquals("0", svcL.save(libro).getCodigo());
	}

}
