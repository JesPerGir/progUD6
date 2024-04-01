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
		// TODO Auto-generated method stub
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
	int opcion=0;
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
			
			switch(opcion) {
			case 1: 
			case 2:
			case 3:
			case 4:
			}
		
	}else {
		System.out.println("¡Genial, sigamos!");
	}
}

public static void IncluirEnArrays() {
	
}

public void GuardarEnFichero() throws Exception{
	BufferedWriter out = new BufferedWriter(new FileWriter("/src/Historial.txt"));
}

}
