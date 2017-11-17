package Persona;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Persona 
{
	private String nombre;
	private String apellidos;
	private String direccion;
	private String poblacion;
	private String provincia;
	private String codigoPostal;
	private String telefono;
	private int anioNacim;
	
	public Persona () 
	{
		nombre = "";
		apellidos = "";
		direccion = "";
		poblacion = "";
		provincia = "";
		codigoPostal = "";
		telefono = "";
		anioNacim = 0;
	}
	public boolean tieneDatos ()
	{
		if (!nombre.equals("") && !apellidos.equals("") && !telefono.equals(""))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void ponerNombre (String nombreNuevo)
	{
		Scanner teclado = new Scanner (System.in);
		nombreNuevo = teclado.next();
	}
	
	public void ponerApellidos (String apellidosNuevo)
	{
		Scanner teclado = new Scanner (System.in);
		apellidosNuevo = teclado.next();
	}
	
	public void ponerDireccion (String calle)
	{
		Scanner teclado = new Scanner (System.in);
		calle = teclado.next();
	}
	
	public void ponerPoblacion (String poblacionNueva)
	{
		Scanner teclado = new Scanner (System.in);
		poblacionNueva = teclado.next();
	}
	
	public void ponerProvincia (String provinciaNueva)
	{
		Scanner teclado = new Scanner (System.in);
		provinciaNueva = teclado.next();
	}
	
	public void ponerCodPostal (String codPostal)
	{
		Scanner teclado = new Scanner (System.in);
		codPostal = teclado.next();
	}
	
	public void ponerTelefono (String tfno)
	{
		Scanner teclado = new Scanner (System.in);
		tfno = teclado.next();
	}
	
	public void ponerAnioNacim (int anio)
	{
		Scanner teclado = new Scanner (System.in);
		anio = teclado.nextInt();
	}
	
	public String obtenerNombre ()
	{
		return nombre;
	}
	
	public String obtenerApellidos ()
	{
		return apellidos;
	}
	
	public String obtenerDireccionCompleta ()
	{
		String x = (direccion + " " + poblacion + " " + provincia + " " + codigoPostal);
		return x;
	}
	
	public String obtenerDireccion ()
	{
		return direccion;
	}
	
	public String obtenerPoblacion ()
	{
		return poblacion;
	}
	
	public String obtenerProvincia ()
	{
		return provincia;
	}
	
	public String obtenerCodigo ()
	{
		return codigoPostal;
	}
	
	public String obtenerTelefono ()
	{
		return telefono;
	}
	
	public int obtenerEdad ()
	{
		Calendar fecha = new GregorianCalendar();
		int año = fecha.get(Calendar.YEAR);
		return (año-anioNacim);		
	}
	
	public int obtenerAnioNacim ()
	{
		return anioNacim;
	}
	
	Persona copiarPersona ()
	{
		Persona p = new Persona ();
		
		p.nombre = this.nombre;
		p.apellidos = this.apellidos;
		p.direccion = this.direccion;
		p.codigoPostal = this.codigoPostal;
		p.provincia = this.provincia;
		p.anioNacim = this.anioNacim;
		p.poblacion = this.poblacion;
		p.telefono = this.telefono;
		
		return p;
	}
}
