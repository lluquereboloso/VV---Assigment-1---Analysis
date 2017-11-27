package agendalista;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class Agenda2Test extends TestCase {

	Agenda2 agenda;
	Persona p1;
	
	@Before
	protected void setUp() throws Exception {
		agenda = new Agenda2();
		p1 = new Persona();

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
		for(int i=0; i<agenda.numeroPersonas(); i++){
			agenda.quitarPrimero();
		}
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

	public void testQuitarPrimero() {
		agenda.aniadirPersona(p1);
		assertTrue( p1 == agenda.quitarPrimero());
	}

	public void testEstaVacia() {
	}

	public void testNumeroPersonas() {
		
		// Test case 1
		assertTrue(agenda.numeroPersonas() == 0);
		
		// Test case 2
		agenda.aniadirPersona(p1);
		assertTrue(agenda.numeroPersonas() == 1);
	}

	public void testGuardarAgenda() {

	}

	public void testRecuperarAgenda() {

	}
}
