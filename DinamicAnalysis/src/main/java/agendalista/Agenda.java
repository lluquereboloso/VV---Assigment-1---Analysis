package agendalista;

import java.io.IOException;


	public interface Agenda 
	{
		boolean aniadirPersona (Persona p);
		boolean eliminarPersona (String nombre);
		Persona quitarPrimero ();
		boolean estaVacia ();
		int numeroPersonas ();
		boolean guardarAgenda () throws IOException;
		boolean recuperarAgenda () throws IOException;
		
	}
