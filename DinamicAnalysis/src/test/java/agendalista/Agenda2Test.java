package agendalista;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;


public class Agenda2Test extends TestCase {


	Agenda2 agenda;
	Persona p1;
	Persona p2;
	Path path = Paths.get("archivo.txt");
	
	@Before
	protected void setUp() throws Exception {
		agenda = new Agenda2();
		p1 = new Persona();
		p2 = new Persona();
		Files.createFile(path);
		
		p1.ponerNombre("Luis");
		p1.ponerApellidos("Luque");
		p1.ponerAnioNacim(1993);
		p1.ponerCodPostal("28032");
		p1.ponerDireccion("calle");
		p1.ponerPoblacion("Madrid");
		p1.ponerProvincia("Madrid");
		p1.ponerTelefono("91");
		
		p2.ponerNombre("Pablo");
		p2.ponerApellidos("Martin");
		p2.ponerAnioNacim(1996);
		p2.ponerCodPostal("28022");
		p2.ponerDireccion("calle");
		p2.ponerPoblacion("Madrid");
		p2.ponerProvincia("Madrid");
		p2.ponerTelefono("650321823");
	}

	@After
	protected void tearDown() throws Exception {
		agenda = null;
		Files.delete(path);
	}

	public void testAgenda2() {
	}

	@Test
	public void testAniadirPersona() {
		assertTrue(agenda.aniadirPersona(p1));
	}

	@Test
	public void testEliminarPersonaListaVacia() {
		assertFalse(agenda.eliminarPersona(p1.obtenerNombreCompleto()));
	}
	@Test
	public void testEliminarPersonaNoVaciaNombreMenor() {
		agenda.aniadirPersona(p1);
		agenda.aniadirPersona(p2);
		assertFalse(agenda.eliminarPersona("Maria Garcia"));
	}
	@Test
	public void testEliminarPersonaUnNodoNombreDesigual() {
		agenda.aniadirPersona(p1);
		assertFalse(agenda.eliminarPersona(p2.obtenerNombreCompleto()));
	}
	@Test
	public void testEliminarPersonaVariosNodosNombreIgualSegundo() {
		agenda.aniadirPersona(p1);
		agenda.aniadirPersona(p2);
		assertTrue(agenda.eliminarPersona(p2.obtenerNombreCompleto()));
	}
	@Test
	public void testEliminarPersonaNoVaciaNombreIgualPrimero() {
		agenda.aniadirPersona(p1);
		assertTrue(agenda.eliminarPersona(p1.obtenerNombreCompleto()));
	}
	@Test
	public void testQuitarPrimeroNoCacia() {
		agenda.aniadirPersona(p1);
		assertTrue( p1.equals(agenda.quitarPrimero()));
	}
	@Test
	public void testQuitarPrimeroVacia() {
		assertFalse(p1.equals(agenda.quitarPrimero()));
	}
	@Test
	public void testEstaVacia() {
		assertTrue(agenda.estaVacia());
	}

	@Test
	public void testNumeroPersonas() {
		
		// Test case 1
		assertTrue(agenda.numeroPersonas() == 0);
		
		// Test case 2
		agenda.aniadirPersona(p1);
		assertTrue(agenda.numeroPersonas() == 1);
	}
	@Test
	public void testGuardarAgendaNoVacia() {
		agenda.aniadirPersona(p1);
		assertTrue(agenda.guardarAgenda());
	}
	@Test
	public void testGuardarAgendaVacia() {
		assertFalse(agenda.guardarAgenda());
	}
	@Test
	public void testRecuperarAgendaNoVacia() {
		agenda.aniadirPersona(p1);
		agenda.guardarAgenda();
		assertTrue(agenda.recuperarAgenda());

	}
	@Test
	public void testRecuperarAgendaVacia() {
		agenda.guardarAgenda();
		assertFalse(agenda.recuperarAgenda());

	}
	@Test
	public void testRecuperarAgendaPersonaVacia() {
		agenda.aniadirPersona(p2);
		agenda.guardarAgenda();
		assertFalse(agenda.recuperarAgenda());

	}
	
}
