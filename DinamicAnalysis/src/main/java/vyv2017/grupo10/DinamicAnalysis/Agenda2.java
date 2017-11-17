package vyv2017.grupo10.DinamicAnalysis;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import Parser.Parser;
import Persona.Persona;


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
		Agenda agenda = new Agenda2();
		
		public Agenda2 () 
		{
			cent = new NodoAgenda (null, null);
			cab = new NodoAgenda (null, cent);
			numPersonas = 0;
		}
		
		public boolean aniadirPersona (Persona p)
		{
			return aniadir (p,agenda);
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
			return elim (nombre,agenda);
		}
		private boolean elim (String nom, Agenda2 agen)
		{
			NodoAgenda ant = agen.cab;
			NodoAgenda act = ant.sig;
		    if (agen.cab != agen.cent) 
		    {
		      while (act.info.nombre!=nombre)
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
			Persona p = new Persona();
		    if (agenda != null)
		    {
		      p = agen[0];
		      
		      for (int j = 1; j < numPersonas; j++) 
		      {
		        agen[(j - 1)] = agen[j];
		      }
		      
		      numPersonas--;
		    }
		    return p;
		}
		public boolean estaVacia ()
		{
			if (cab.sig == null)
			{
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
			if (aux.sig != null)
			{
				while (aux.sig != cent)
				{
					i++;
					aux = aux.sig;
				}
				return i;
			}
			else
			{
				return 0;
			}
		}
		public boolean guardarAgenda () throws IOException
		{
			FileWriter fichero = new FileWriter("archivo.txt");
		    BufferedWriter bufferescritura = new BufferedWriter(fichero);
		    PrintWriter output = new PrintWriter(bufferescritura);
		    
		    Parser p = new Parser();
		    boolean resultado = false;
		    
		    if (agenda != null) 
		    {
		    	
		      for (int i = 0; i < numPersonas; i++)
		      {
		        p.ponerPersona(agen [i]);
		        String linea = p.obtenerLinea();
		        output.println(linea);
		        resultado = true;
		      }
		      
		    }
		    
		    output.close();
		    return resultado;
		}
		
		public boolean recuperarAgenda () throws IOException
		{
			 	FileReader filein = new FileReader("archivo.txt");
			    BufferedReader bufferentrada = new BufferedReader(filein);
			    boolean resul = false;
			    
			    Parser p = new Parser();
			    String cad;
			    if ((cad = bufferentrada.readLine()) != null)
			    {
			      resul = true;
			      do
			      {
			        System.out.println(cad);
			        p.ponerLinea(cad);
			        Persona auxPersona = p.obtenerPersona();
			        if (auxPersona.tieneDatos()) {
			          aniadirPersona(auxPersona);
			        }
			      } while ((cad = bufferentrada.readLine()) != null);
			      filein.close();
			    }
			    return resul;
		}
}

