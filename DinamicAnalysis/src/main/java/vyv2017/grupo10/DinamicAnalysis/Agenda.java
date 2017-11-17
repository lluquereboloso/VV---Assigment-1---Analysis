package vyv2017.grupo10.DinamicAnalysis;

import java.io.IOException;

import Persona.Persona;


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
