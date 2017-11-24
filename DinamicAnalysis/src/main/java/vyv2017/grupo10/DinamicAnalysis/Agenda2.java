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
		
		public Agenda2 () {
			cent = new NodoAgenda (null, null);
			cab = new NodoAgenda (null, cent);
		}
		
		public boolean aniadirPersona (Persona p) {
			return aniadir (p);
		}
		
		private boolean aniadir (Persona p) {
		    NodoAgenda nuevo;
			NodoAgenda anterior = this.cab;
			NodoAgenda actual = this.cab.sig;
			boolean resul = false;
			
			while(actual.info.obtenerNombreCompleto().compareTo(p.obtenerNombreCompleto()) < 0) {
				anterior = actual;
				actual = actual.sig;
			}
			
			if (actual.info.obtenerNombreCompleto().compareTo(p.obtenerNombreCompleto()) > 0 || actual == this.cent) {
				nuevo = new NodoAgenda(p, actual);
				anterior.sig = nuevo;
				resul= true;
			}
			else
				resul = false;
			
			return resul;
		}
		
		public boolean eliminarPersona (String nombre) {
			return elim (nombre);
		}
		
		private boolean elim (String nom){
			NodoAgenda anterior = this.cab;
			NodoAgenda actual = cab.sig;
			boolean resul = false;
		    while (actual.info.obtenerNombreCompleto().compareTo(nom) < 0) {
		    		anterior = actual;
		    		actual = actual.sig;
		    }
		    if (actual.info.obtenerNombreCompleto().compareTo(nom) > 0 || actual == this.cent) {
		    		resul = false;
		    }
		    else {
		    		anterior.sig = actual.sig;
		    		resul = true;
		    }
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
			if (cab.sig == cent){
				/* Las listas con cabecera y centinela se consideran vacías cuando el siguiente elemento a
				 * la cabecera ficticia, es el centinela de fin de lista (sin elementos útiles intermedios).
				 */
				return true;
			}
			else {
				return false;
			}
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
		
		public boolean recuperarAgenda (){
		    boolean resultado = false;
		    
		    BufferedReader input;
		    Parser pars = new Parser();
		    String cad;
		    Persona p;
		    
		    try {
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
		    		
		    		input.close();
		    } catch(IOException e) { };
		    
		    return resultado;
		}
}

