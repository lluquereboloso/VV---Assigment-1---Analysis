package agendalista;

import java.util.Calendar;
import java.util.GregorianCalendar;

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
		return (!nombre.equals("") && !apellidos.equals("") && !telefono.equals(""));
	}
	
	public void ponerNombre (String nombreNuevo)
	{
		this.nombre = nombreNuevo;
	}
	
	public void ponerApellidos (String apellidosNuevo)
	{
		this.apellidos = apellidosNuevo;
	}
	
	public void ponerDireccion (String calle)
	{
		this.direccion = calle;
	}
	
	public void ponerPoblacion (String poblacionNueva)
	{
		this.poblacion = poblacionNueva;
	}
	
	public void ponerProvincia (String provinciaNueva)
	{
		this.provincia = provinciaNueva;
	}
	
	public void ponerCodPostal (String codPostal)
	{
		this.codigoPostal = codPostal;
	}
	
	public void ponerTelefono (String tfno)
	{
		this.telefono = tfno;
	}
	
	public void ponerAnioNacim (int anio)
	{
		this.anioNacim = anio;
	}
	
	public String obtenerNombre ()
	{
		return this.nombre;
	}
	
	public String obtenerApellidos ()
	{
		return this.apellidos;
	}
	
	public String obtenerNombreCompleto()
	{
		return (this.nombre + " " + this.apellidos);
	}
	
	public String obtenerDireccionCompleta ()
	{
		return (this.direccion + " " + this.poblacion + " " + this.provincia + " " + this.codigoPostal);
	}
	
	public String obtenerDireccion ()
	{
		return this.direccion;
	}
	
	public String obtenerPoblacion ()
	{
		return this.poblacion;
	}
	
	public String obtenerProvincia ()
	{
		return this.provincia;
	}
	
	public String obtenerCodigo ()
	{
		return this.codigoPostal;
	}
	
	public String obtenerTelefono ()
	{
		return this.telefono;
	}
	
	public int obtenerEdad ()
	{
		Calendar fecha = new GregorianCalendar();
		int anio = fecha.get(Calendar.YEAR);
		return (anio-anioNacim);		
	}
	
	public int obtenerAnioNacim ()
	{
		return this.anioNacim;
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
