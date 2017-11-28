package agendalista;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;


import junit.framework.TestCase;

@RunWith(DataProviderRunner.class)
public class Agenda2Test extends TestCase {

	Agenda2 agenda;
	
	@Before
	public void setUp() throws Exception {
		agenda = new Agenda2();
	}

	@After
	public void tearDown() throws Exception {
		agenda = null;
	}

	public void testAgenda2() {
	}

	@DataProvider
	public static Object[][] dataProviderGeneral() {
		Persona p1 = new Persona();
		p1.ponerNombre("Luis");
		p1.ponerApellidos("Luque");
		p1.ponerAnioNacim(1993);
		p1.ponerCodPostal("28032");
		p1.ponerDireccion("calle");
		p1.ponerPoblacion("Madrid");
		p1.ponerProvincia("Madrid");
		p1.ponerTelefono("91");
	    return new Object[] []{
	      {(Object)p1}
	    };
	}

	@Test
	@UseDataProvider( "dataProviderGeneral" )
	public void testAniadirPersona(Persona p) {
		assertTrue(agenda.aniadirPersona(p));
	}

	@Test
	@UseDataProvider( "dataProviderGeneral" )
	public void testEliminarPersona(Persona p) {
		agenda.aniadirPersona(p);
		assertTrue(agenda.eliminarPersona(p.obtenerNombreCompleto()));
	}

	@Test
	@UseDataProvider( "dataProviderGeneral" )
	public void testQuitarPrimero(Persona p) {
		agenda.aniadirPersona(p);
		assertTrue( p == agenda.quitarPrimero());
	}

	@Test
	public void testEstaVacia() {
		assertTrue(agenda.estaVacia());
	}

	@Test
	@UseDataProvider( "dataProviderGeneral" )
	public void testNumeroPersonas(Persona p) {
		
		// Test case 1
		assertTrue(agenda.numeroPersonas() == 0);
		
		// Test case 2
		agenda.aniadirPersona(p);
		assertTrue(agenda.numeroPersonas() == 1);
	}

	public void testGuardarAgenda() {

	}

	public void testRecuperarAgenda() {

	}
}
