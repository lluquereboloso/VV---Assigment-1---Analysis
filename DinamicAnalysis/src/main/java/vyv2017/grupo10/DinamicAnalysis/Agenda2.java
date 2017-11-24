package vyv2017.grupo10.DinamicAnalysis;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


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
		private NodoAgenda cab, cent;
		private int numPersonas;
		
		public Agenda2 () 
		{
			cent = new NodoAgenda (null, null);
			cab = new NodoAgenda (null, cent);
			numPersonas = 0;
		}
		
		public boolean aniadirPersona (Persona p)
		{
			return aniadir (p,this);
		}
		private boolean aniadir (Persona p, Agenda2 agen)
		{
			NodoAgenda aux = agen.cab;
			NodoAgenda ant = agen.cab;
			NodoAgenda act = ant.sig;
			aux.info=p;
			boolean resul = false;
		    
		    if (agen.cab.sig==agen.cent) 
		    {
		    	aux.sig=agen.cent;
		    	agen.cab.sig=aux;
		    	resul=true;
		    }
		    else{
		    	while (act!=agen.cent) 
		      		{
		        		act=act.sig;
		        		ant=ant.sig;
		      		}
		        numPersonas++;
		        ant.sig=aux;
		        aux.sig=act;
		        resul = true;
		        }
		    return resul;
		}
		
		public boolean eliminarPersona (String nombre)
		{
			return elim (nombre,this);
		}
		private boolean elim (String nom, Agenda2 agen)
		{
			NodoAgenda ant = agen.cab;
			NodoAgenda act = ant.sig;
		    if (agen.cab.sig != agen.cent)  //Poner siguiente
		    {
		      while (act.info.obtenerNombre()!=nom)
		      {
		    	  act=act.sig;
		    	  ant=ant.sig;
		      }
		      act=act.sig;
		      ant.sig=act;
		      return true;
		    }
		    else return false;
		}
		public Persona quitarPrimero ()
		{
			Persona p;
		    if (estaVacia())
		    {
		    	p = null;
		    }
		    else
		    {
		    	p = cab.sig.info;
		    	cab.sig = cab.sig.sig;
		    	numPersonas--;
		    }
		    return p;
		}
		public boolean estaVacia ()
		{
			if (cab.sig == cent)
			{
				/* Las listas con cabecera y centinela se consideran vacías cuando el siguiente elemento a
				 * la cabecera ficticia, es el centinela de fin de lista (sin elementos útiles intermedios).
				 */
				return true;
			}
			else
			{
				return false;
			}
		}
		public int numeroPersonas ()
		{
			NodoAgenda aux = cab;
			int i = 0;
			
			while (aux.sig != cent)
			{
				i++;
				aux = aux.sig;
			}
			
			numPersonas = i;
			return numPersonas;
		}		
		public boolean guardarAgenda ()
		{
		    boolean resultado = false;
		    
		    PrintWriter output;
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

			    output.close();
		    }
		    catch(IOException e) { };
		    
		    return resultado;
		}
		
		public boolean recuperarAgenda ()
		{
		    boolean resultado = false;
		    
		    BufferedReader input;
		    Parser pars = new Parser();
		    String cad;
		    Persona p;
		    
		    try
		    {
		    	input = new BufferedReader(new FileReader("archivo.txt"));
				
		    	do
		    	{
		    		cad = input.readLine();
		    		
		    		if(cad != null)
		    		{
			    		pars.ponerLinea(cad);
			    		p = pars.obtenerPersona();
			    		if(p.tieneDatos())
			    		{
				    		aniadirPersona(p);
				    		resultado = true;
			    		}
		    		}
		    		
		    	} while(cad != null);

			    input.close();
		    }
		    catch(IOException e) { };
		    
		    return resultado;
		}
}

