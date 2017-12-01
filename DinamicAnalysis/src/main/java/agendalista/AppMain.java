package agendalista;

public class AppMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Agenda2 agenda = new Agenda2();
		Persona p1 = new Persona();
		Persona p2 = new Persona();
		Persona p3 = new Persona();
		p1.ponerNombre("Luis");
		p1.ponerApellidos("Luque");
		p1.ponerAnioNacim(1993);
		p1.ponerCodPostal("28032");
		p1.ponerDireccion("calle");
		p1.ponerPoblacion("Madrid");
		p1.ponerProvincia("Madrid");
		p1.ponerTelefono("91");
		p2.ponerNombre("Belen");
		p2.ponerApellidos("Luque");
		p2.ponerAnioNacim(1993);
		p2.ponerCodPostal("28030");
		p2.ponerDireccion("calle");
		p2.ponerPoblacion("Barcelona");
		p2.ponerProvincia("Barcelona");
		p3.ponerNombre("Rafa");
		p3.ponerApellidos("Luque");
		System.out.println("Añadimos Luis Luque: "+agenda.aniadirPersona(p1));
		System.out.println("Añadimos Belen Luque: "+agenda.aniadirPersona(p2));
		System.out.println("Añadimos Rafa Luque: "+agenda.aniadirPersona(p3));
		
		//--------------------------------------
		System.out.println("Eliminamos Luis Luque: "+agenda.eliminarPersona("Luis Luque"));
		System.out.println("Eliminamos Belen Luque: "+agenda.eliminarPersona("Belen Luque"));
		System.out.println("Eliminamos Rafa Luque: "+agenda.eliminarPersona("Rafa Luque"));
		System.out.println("Eliminamos Zafa Luque: "+agenda.eliminarPersona("Zafa Luque"));
		System.out.println("Añadimos Luis Luque: "+agenda.aniadirPersona(p1));
		System.out.println("Añadimos Belen Luque: "+agenda.aniadirPersona(p2));
		//--------------------------------------
		
		System.out.println("Numero de personas (esperamos 2): "+agenda.numeroPersonas());
		System.out.println("Probamos quitar primeros (deberia salir Belen luque)");
		Persona p4;
		p4 = agenda.quitarPrimero();
		System.out.println(p4.obtenerNombreCompleto());
		System.out.println("Numero de personas (esperamos 1): "+agenda.numeroPersonas());
		System.out.println("Añadimos a belen de nuevo: " + agenda.aniadirPersona(p2));
		//---------------------------------------
		System.out.println("Guardamos en Agenda: " + agenda.guardarAgenda());
		
		System.out.println(agenda.eliminarPersona("Luis Luque"));
		
		System.out.println("Recuperamos de Agenda: " + agenda.recuperarAgenda());
		System.out.println("Sacamos el primero porque no hay formar de mostrar en esta mierda de aplicacion.");
		Persona p5;
		p5 = agenda.quitarPrimero();
		System.out.println(p5.obtenerNombreCompleto());
		System.out.println(p5.obtenerDireccionCompleta());

	}

}
