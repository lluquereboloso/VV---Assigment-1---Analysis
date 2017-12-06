package agendalista;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;


public class Agenda2Test extends TestCase {

	private static final String DIRECCION = "calle";
	private static final String PROVINCIA = "Madrid";

	Agenda2 agenda;
	Persona p1;
	Persona p2;
	Persona p3;
	Persona p4;
	Persona p5;
	Path path = Paths.get("archivo.txt");
	
	/* Gestor de log de errores requerido para el tratamiento de excepciones según SonarQube. */
	private static final Logger LOGGER = Logger.getLogger( Agenda2.class.getName() );
	private static final String EXC = "Exception!";
	
	@Before
	protected void setUp() throws Exception {
		agenda = new Agenda2();
		p1 = new Persona();
		p2 = new Persona();
		p3 = new Persona();
		p4 = new Persona();
		p5 = new Persona();
		Files.createFile(path);
		
		p1.ponerNombre("Luis");
		p1.ponerApellidos("Luque");
		p1.ponerAnioNacim(1993);
		p1.ponerCodPostal("28032");
		p1.ponerDireccion(DIRECCION);
		p1.ponerPoblacion(PROVINCIA);
		p1.ponerProvincia(PROVINCIA);
		p1.ponerTelefono("91");
		
		p2.ponerNombre("Pablo");
		p2.ponerApellidos("Martin");
		p2.ponerAnioNacim(1996);
		p2.ponerCodPostal("28022");
		p2.ponerDireccion(DIRECCION);
		p2.ponerPoblacion(PROVINCIA);
		p2.ponerProvincia(PROVINCIA);
		p2.ponerTelefono("650321823");
		
		p4.ponerNombre("Ruben");
		p4.ponerApellidos("Almaraz");
		p4.ponerAnioNacim(1996);
		p4.ponerCodPostal("28030");
		p4.ponerDireccion(DIRECCION);
		p4.ponerPoblacion(PROVINCIA);
		p4.ponerProvincia(PROVINCIA);
		p4.ponerTelefono("647026575");
	
		p5.ponerNombre("Razvan");
		p5.ponerApellidos("Alungei");
		p5.ponerAnioNacim(1996);
		p5.ponerCodPostal("28804");
		p5.ponerDireccion(DIRECCION);
		p5.ponerPoblacion(PROVINCIA);
		p5.ponerProvincia(PROVINCIA);
		p5.ponerTelefono("624741234");
	}

	@After
	protected void tearDown() throws Exception {
		agenda = null;
		Files.delete(path);
	}

	
	// --- Constructor Agenda2() ----------------------------------
	@Test
	public void testAgenda2() {
		   try {
			      new Agenda2();
			    } 
		   catch (Exception e) {
			      fail(e.getMessage());
			    }
	}
	
	
	// --- Método aniadirPersona() --------------------------------
	@Test
	public void testAniadirPersonaListaVacia() {
		assertTrue(agenda.aniadirPersona(p1));
	}
	@Test
	public void testAniadirPersonaListaNoVaciaFinal(){
		agenda.aniadirPersona(p1);
		assertTrue(agenda.aniadirPersona(p2));
	}
	@Test
	public void testAniadirPersonaListaNoVaciaMedio(){
		agenda.aniadirPersona(p1);
		agenda.aniadirPersona(p4);
		assertTrue(agenda.aniadirPersona(p2));
	}
	@Test
	public void testAniadirPersonaMismoNombre(){
		agenda.aniadirPersona(p1);
		agenda.aniadirPersona(p2);
		agenda.aniadirPersona(p4);
		assertFalse(agenda.aniadirPersona(p2));
	}
	@Test
	public void testAniadirPersonaMedio(){
		agenda.aniadirPersona(p1);
		agenda.aniadirPersona(p2);
		agenda.aniadirPersona(p4);
		assertTrue(agenda.aniadirPersona(p5));
	}
	@Test
	public void testAniadirPersonaPrincipio(){
		agenda.aniadirPersona(p2);
		agenda.aniadirPersona(p4);
		assertTrue(agenda.aniadirPersona(p1));
		
	}

	
	// --- Método eliminarPersona() -------------------------------
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
	
	
	// --- Método quitarPrimero() ---------------------------------
	@Test
	public void testQuitarPrimeroNoVacia() {
		agenda.aniadirPersona(p1);
		assertTrue( p1.equals(agenda.quitarPrimero()));
	}
	@Test
	public void testQuitarPrimeroVacia() {
		assertFalse(p1.equals(agenda.quitarPrimero()));
	}
	
	
	// --- Método estaVacia() ---------------------------------
	@Test
	public void testEstaVacia() {
		assertTrue(agenda.estaVacia());
	}
	
	@Test
	public void testNoEstaVacia() {
		agenda.aniadirPersona(p1);
		assertFalse(agenda.estaVacia());
	}
	
	
	// --- Método numeroPersonas() --------------------------------
	@Test
	public void testNumeroPersonasCero() {
		assertEquals(agenda.numeroPersonas(), 0);
	}
	@Test
	public void testNumeroPersonasUno() {
		agenda.aniadirPersona(p1);
		assertEquals(agenda.numeroPersonas(), 1);
	}
	@Test
	public void testNumeroPersonasDos() {
		agenda.aniadirPersona(p1);
		agenda.aniadirPersona(p2);
		assertEquals(agenda.numeroPersonas(), 2);
	}
	
	
	// --- Método guardarAgenda() ---------------------------------
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
	public void testGuardarAgendaException() {

		try
		{
			// Borrar el fichero 'archivo.txt' que se supone creado por SetUp.
			Files.delete(path);
			
			// Crear un directorio llamado 'archivo.txt', bloqueando ese nombre para su uso como fichero.
			// Cuando 'guardarAgenda' trate de crear un fichero de escritura con el mismo nombre, fallará.
			File directory = new File("archivo.txt");
			directory.mkdir();
			
			// Comprobar fallo, con una agenda que disponía de contenidos y debería haberse escrito bien.
			agenda.aniadirPersona(p1);
			assertFalse(agenda.guardarAgenda());
			
			// Borrar directorio 'archivo.txt' usado para la prueba.
			directory.delete();
			
			// Restituir el fichero 'archivo.txt' como lo dejó el SetUp.
			Files.createFile(path);
		}
		catch(IOException e)
		{
	    	LOGGER.log(Level.ALL, EXC);
		}
	}
	
	
	// --- Método recuperarAgenda() -------------------------------
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
		agenda.aniadirPersona(p3);
		agenda.guardarAgenda();
		assertFalse(agenda.recuperarAgenda());

	}
	
}
