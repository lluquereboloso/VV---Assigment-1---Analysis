package agendalista;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;


class NodoAgenda 
{
		Persona info;
		NodoAgenda sig;
		NodoAgenda (Persona p, NodoAgenda siguiente) 
		{
			info = p;
			sig = siguiente;
		}
}
	
	
public class Agenda2 implements Agenda 
{
		private NodoAgenda cab;
		private NodoAgenda cent;

		/* Gestor de log de errores requerido para el tratamiento de excepciones según SonarQube. */
		private static final Logger LOGGER = Logger.getLogger( Agenda2.class.getName() );
		private static final String EXC = "Exception!";
		
		public Agenda2 () {
			cent = new NodoAgenda (null, null);
			cab = new NodoAgenda (null, cent);
		}
		
		public boolean aniadirPersona (Persona p) {
			
			int result = 0;
			
			NodoAgenda actual = this.cab;
			
			while(result == 0)
			{
				if(actual.sig == cent)
				{
					actual.sig = new NodoAgenda(p, cent);
					result = 1; // Insertado antes del centinela.
				}
				else if(p.obtenerNombreCompleto().compareTo(actual.sig.info.obtenerNombreCompleto()) < 0)
				{
					actual.sig = new NodoAgenda(p, actual.sig.sig);
					result = 1; // Insertado antes de otra persona.
				}
				else if(p.obtenerNombreCompleto().compareTo(actual.sig.info.obtenerNombreCompleto()) == 0)
				{
					result = -1; // No insertado, ya existe.
				}
				else
					actual = actual.sig;
			}
			
			return result == 1;
		}
		
		public boolean eliminarPersona (String nombre) {
			NodoAgenda anterior = this.cab;
			NodoAgenda actual = cab.sig;
			boolean resul = false;
			
			if (actual.info != null) {
				while (actual.info.obtenerNombreCompleto().compareTo(nombre) < 0) {
					anterior = actual;
					actual = actual.sig;
				}
				if (actual.info.obtenerNombreCompleto().compareTo(nombre) > 0 || actual == this.cent) {
					resul = false;
				}
				else {
					anterior.sig = actual.sig;
					resul = true;
				}
			}
			else 
				resul = false;
			
			return resul;
		}
		
		public Persona quitarPrimero () {
			Persona p;
		    if (estaVacia()) {
		    		p = null;
		    }
		    else {
		    		p = cab.sig.info;
		    		cab.sig = cab.sig.sig;
		    }
		    return p;
		}
		
		public boolean estaVacia (){
			/* Las listas con cabecera y centinela se consideran vacías cuando el siguiente elemento a
			 * la cabecera ficticia, es el centinela de fin de lista (sin elementos útiles intermedios).
			 */
			return cab.sig == cent;
		}
		
		public int numeroPersonas (){
			NodoAgenda aux = cab;
			int i = 0;
			
			while (aux.sig != cent){
				i++;
				aux = aux.sig;
			}
			
			return i;
		}		
		
		public boolean guardarAgenda (){
		    boolean resultado = false;
		    
		    PrintWriter output = null;
		    Parser pars = new Parser();
		    NodoAgenda aux = cab;
		    
		    try
		    {
		    	output = new PrintWriter(new BufferedWriter(new FileWriter("archivo.txt")));
				
		    	while(aux.sig != cent)
		    	{
		    		aux = aux.sig;
		    		pars.ponerPersona(aux.info);
		    		output.println(pars.obtenerLinea());
		    		resultado = true;
		    	}
		    }
		    catch(IOException e)
		    {
		    	LOGGER.log(Level.ALL, EXC);
		    }
		    finally
		    {
		    	if(output != null)
		    		output.close();
		    }
		    
		    return resultado;
		}
		
		public boolean recuperarAgenda (){
		    boolean resultado = false;
		    
		    BufferedReader input = null;
		    Parser pars = new Parser();
		    String cad;
		    Persona p;
		    
		    try
		    {
				input = new BufferedReader(new FileReader("archivo.txt"));
				
				do {
					cad = input.readLine();
				
					if(cad != null) {
						pars.ponerLinea(cad);
						p = pars.obtenerPersona();
						if(p.tieneDatos()){
							aniadirPersona(p);
							resultado = true;
						}
					}
				
				}while(cad != null);
		    }
		    catch(IOException e)
		    {
		    	LOGGER.log(Level.ALL, EXC);
		    }
		    finally
		    {
		    	try
		    	{
		    		if(input != null)
		    			input.close();
			    }
			    catch(IOException e)
			    {
					LOGGER.log(Level.ALL, EXC);
			    }
		    }
		    
		    return resultado;
		}

		public static void main(String[] args)
		{
			Agenda2 a = new Agenda2();
			
			Persona p1 = new Persona();
			p1.ponerNombre("Luis");
			p1.ponerApellidos("Luque");
			System.out.println(a.aniadirPersona(p1));
			
			Persona p2 = new Persona();
			p2.ponerNombre("Rafa");
			p2.ponerApellidos("Martin");
			System.out.println(a.aniadirPersona(p2));
			
			Persona p3 = new Persona();
			p3.ponerNombre("Pablo");
			p3.ponerApellidos("Martin");
			System.out.println(a.aniadirPersona(p3));
			
			Persona p4 = new Persona();
			p4.ponerNombre("Alberto");
			p4.ponerApellidos("Ortega");
			System.out.println(a.aniadirPersona(p4));
		}
}
