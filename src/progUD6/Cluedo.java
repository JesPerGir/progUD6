package progUD6;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Cluedo {
	List listaJugadores = new ArrayList<>();
	
	public static void main(String[] args) {

		String arrayPersonajes[] = {"Amapola","Celeste","Prado","Mora","Rubio","Blanco"};
		String arrayArmas[] = {"Bate","Pistola","Candelabro","Cuchillo","Cuerda","Hacha","Pesa","Veneno","Trofeo"};
		String arrayLugares[] = {"Casa de invitados","Teatro","Spa","Observatorio","Terraza","Salón","Cocina","Vestíbulo"};
		
		MostrarBienvenida();
		System.out.println("Los Personajes son los siguientes: ");
		MostrarArrays(arrayPersonajes);
		System.out.println("Las armas son las siguientes: ");
		MostrarArrays(arrayArmas);
		System.out.println("Los lugares son los siguientes: ");
		MostrarArrays(arrayLugares);
		PreguntarSobreIncluir();
		
	}

public void AñadirALista(Jugador jugador) {
	listaJugadores.add(LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
	listaJugadores.add(jugador);
}

public static void MostrarBienvenida() {
	
	System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||\n"
								+ "||||| Te doy la bienvenida a CLUEDO |||||\n"
								+ "||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||\n");
	System.out.println("Este programa barajará las cartas de forma aleatoria para jugar a CLUEDO.\n");
}

public static void MostrarArrays(String array[]) {
	for(int i=0; i<array.length; i++) {
		System.out.println("· " + array[i]);
	}
	System.out.println();
}

public static void PreguntarSobreIncluir() {
	Scanner sc = new Scanner(System.in);
	String respuesta="";
	int opcion=0, inclusiones;
		do {
			try {
				System.out.println("¿Deseas añadir algo más a alguna de las listas mostradas? Responde (Sí/No):");
				respuesta = sc.next();
			}catch(Exception ex) {
				System.out.println("No has indtroducido un valor válido.");
			}
		if(respuesta.equalsIgnoreCase("Sí")==false && respuesta.equalsIgnoreCase("Si")== false && respuesta.equalsIgnoreCase("No")==false) {
			System.out.println("Esa no es una respuesta válida.");
		}
		}while(respuesta.equalsIgnoreCase("Sí")==false && respuesta.equalsIgnoreCase("Si")== false && respuesta.equalsIgnoreCase("No")==false);
	
	if(respuesta.equalsIgnoreCase("Sí") ||  respuesta.equalsIgnoreCase("Si")) {
			do {
				try {
					System.out.println("¿A qué lista deseas añadir algo? (Introduce el número):\n"
													+ "1. Personajes\n"
													+ "2. Armas\n"
													+ "3. Habitaciones\n"
													+ "4. No añadir nada\n");
					
						opcion=sc.nextInt();
				}catch(Exception ex) {
					System.out.println("Sólo puedes introducir valores del 1 al 4");
				}
			}while(opcion<0 || opcion>4);
			
			sc.close();	
	}else{
		System.out.println("¡Genial, sigamos!");
		}
}

public static String[] CrearNuevoArray(String[] array, int inclusiones) {
	String nuevoArray[] = new String[array.length+inclusiones];
	for(int i=0; i<array.length; i++) {
		nuevoArray[i]=array[i];
	}
	return nuevoArray;
}

public static int NumeroDeInclusiones() {
	Scanner sc = new Scanner(System.in);
	int inclusiones=0;
	System.out.println("¿Cúantos quieres añadir?");
	do {
		try {
			inclusiones = sc.nextInt();
		}catch(Exception ex) {
			System.out.println("Ese no es un valor válido.");
		}
	}while(inclusiones<1);
	sc.close();
	return inclusiones;
}

public static void PreguntarInclusiones(String[] array, int repeticiones) {
	Scanner sc = new Scanner(System.in);
	String inclusion;
	do {
		try {
			System.out.println("Introduce lo que quieras incluir en la lista:");
			inclusion = sc.next();
		}catch(Exception ex) {
			System.out.println("Ese no es un valor válido");
		}
		
		repeticiones--;
	}while(repeticiones<0);
	
}

public static void IncluirEnArray(int opcion, String[] arrayPersonajes, String[] arrayArmas, String[] arrayLugares) {
	int inclusiones;
	switch(opcion) {
		case 1:
			inclusiones=NumeroDeInclusiones();
			CrearNuevoArray(arrayPersonajes, inclusiones);
			break;
		case 2:
			inclusiones=NumeroDeInclusiones();
			CrearNuevoArray(arrayArmas, inclusiones);
			break;
		case 3:
			inclusiones=NumeroDeInclusiones();
			CrearNuevoArray(arrayLugares, inclusiones);
			break;
		case 4:
			System.out.println("No se añadirá nada.");
			break;
	}
}

public void GuardarEnFichero() throws Exception{
	BufferedWriter out = new BufferedWriter(new FileWriter("/src/Historial.txt"));
}

}
