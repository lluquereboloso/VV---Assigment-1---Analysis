package agendalista;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.Parameterized;
//import org.junit.runners.Parameterized.Parameter;
//import org.junit.runners.Parameterized.Parameters;

import junit.framework.TestCase;


public class Agenda2Test extends TestCase {


	Agenda2 agenda;
	Persona p1;
	Persona p2;
	File fichero;
	
	@Before
	protected void setUp() throws Exception {
		agenda = new Agenda2();
		p1 = new Persona();
		p2 = new Persona();
		fichero = new File("archivo.txt");
		
		p1.ponerNombre("Luis");
		p1.ponerApellidos("Luque");
		p1.ponerAnioNacim(1993);
		p1.ponerCodPostal("28032");
		p1.ponerDireccion("calle");
		p1.ponerPoblacion("Madrid");
		p1.ponerProvincia("Madrid");
		p1.ponerTelefono("91");
	}

	@After
	protected void tearDown() throws Exception {
		agenda = null;
		fichero.delete();
	}

	public void testAgenda2() {
	}

	@Test
	public void testAniadirPersona() {
		assertTrue(agenda.aniadirPersona(p1));
	}

	@Test
	public void testEliminarPersona() {
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
	@Test
	public void testRecuperarAgendaPersonaNoFichero() {
		
		fichero.delete();
		assertFalse(agenda.recuperarAgenda());

	}
	
}
