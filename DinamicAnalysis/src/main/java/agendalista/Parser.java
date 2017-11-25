package agendalista;

public class Parser {
	static final String NOM = "NOMBRE="; //7
	static final String APE = "APELLIDOS="; //11
	static final String DIR = "DIRECCION=";//11
	static final String POB = "POBLACION=";//11
	static final String PRO = "PROVINCIA=";//11
	static final String COD = "CODIGO=";//7
	static final String TFN = "TELEFONO=";//9
	static final String ANIO = "ANIONACIM=";//10
	
	private String linea;
	private Persona persona;
	public Parser () {
		linea = null;
		persona = new Persona ();
	}
	
	public void ponerPersona (Persona p) {
		persona = p;
		linea = this.crearLinea ();
	}

	public void ponerLinea (String l) {
		linea = l;
		persona = this.crearPersona ();
	}
	public Persona obtenerPersona () {
		return persona;
	}

	public String obtenerLinea () {
		return linea;
	}
	private Persona crearPersona () {
		String nombre = "";
		String apellido = "";
		String direccion = "";
		String poblacion = "";
		String provincia = "";
		String codigo = "";
		String telefono = "";
		int anio = 0;
		int posNom;
		int posApe;
		int posDir;
		int posPob;
		int posProv;
		int posCod;
		int posTfno;
		int posAnio;
		int longitud;
		boolean auxb = true;
		Persona auxp = new Persona ();

		longitud = linea.length ();
		posNom = linea.indexOf (NOM);
		posApe = linea.indexOf (APE);
		posDir = linea.indexOf (DIR);
		posPob = linea.indexOf (POB);
		posProv = linea.indexOf (PRO);
		posCod = linea.indexOf (COD);
		posTfno = linea.indexOf (TFN);
		posAnio = linea.indexOf (ANIO);
  
		if ((posNom != -1) && (posApe != -1) && (posDir != -1) && (posPob != -1) && (posCod != -1) && (posTfno != -1) && (posAnio != -1)) {
			nombre = linea.substring (posNom+7, posApe-2).trim ();
			apellido = linea.substring (posApe+11, posDir-2).trim ();
			direccion = linea.substring (posDir+11, posPob-2).trim ();
			poblacion = linea.substring (posPob+11, posProv-2).trim ();
			provincia = linea.substring (posProv+11, posCod-2).trim ();
			codigo = linea.substring (posCod+7, posTfno-2).trim ();
			telefono = linea.substring (posTfno+9, posAnio-2).trim ();
			anio = Integer.parseInt (linea.substring (posAnio+10,longitud-1).trim ());
			auxb = true;
		}
        else auxb = false;
		if (auxb) {
			auxp.ponerNombre (nombre);
			auxp.ponerApellidos (apellido);
			auxp.ponerDireccion (direccion);
			auxp.ponerPoblacion (poblacion);
			auxp.ponerProvincia (provincia);
			auxp.ponerCodPostal (codigo);
			auxp.ponerTelefono (telefono);
			auxp.ponerAnioNacim (anio);
		}
		return auxp;
	}
	private String crearLinea() {
		String nombre = persona. obtenerNombre ();
		String apellido = persona.obtenerApellidos ();
		String direccion = persona.obtenerDireccion ();
		String poblacion = persona.obtenerPoblacion ();
		String provincia = persona.obtenerProvincia ();
		String codigo = persona.obtenerCodigo ();
		String telefono = persona.obtenerTelefono ();
		int anio = persona.obtenerAnioNacim ();
		String aux2 = "";

		if (persona.tieneDatos()) {
			aux2 = NOM + " " + nombre + ". " + APE + " " + apellido + ". " + DIR + " " + direccion + ". ";
			aux2 = aux2 + POB + " " + poblacion + ". " + PRO + " " + provincia + ". " + COD + " "  + codigo + ". " ;
			aux2 = aux2 + TFN + " "  + telefono + ". " + ANIO + " " + anio;
		}
		return aux2;
	}

}