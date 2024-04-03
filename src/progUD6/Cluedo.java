package progUD6;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Writer;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Cluedo {
	
	private static List<Jugador>  listaJugadores = new ArrayList<>();
	private static Scanner sc = new Scanner(System.in);
	private static String arrayPersonajes[] = {"Amapola","Celeste","Prado","Mora","Rubio","Blanco"};
	private static String arrayArmas[] = {"Bate","Pistola","Candelabro","Cuchillo","Cuerda","Hacha","Pesa","Veneno","Trofeo"};
	private static String arrayLugares[] = {"Casa de invitados","Teatro","Spa","Observatorio","Terraza","Salón","Cocina","Vestíbulo"};
	
	public static void main(String[] args) {
/*
		MostrarBienvenida();
		System.out.println("Los Personajes son los siguientes: ");
		MostrarArrays(arrayPersonajes);
		System.out.println("Las armas son las siguientes: ");
		MostrarArrays(arrayArmas);
		System.out.println("Los lugares son los siguientes: ");
		MostrarArrays(arrayLugares);
		PreguntarSobreIncluir();
		*/
				
		BarajarCartas();
		try {
			GuardarEnFichero();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Ha sucedido un error.");
		}
	}



public static void MostrarBienvenida() {
	
	System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||\n"
								+ "||||| Te doy la bienvenida a CLUEDO |||||\n"
								+ "||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||\n");
	System.out.println("Este programa barajará las cartas de forma aleatoria para jugar a CLUEDO.\n");
}

public static void PreguntarSobreIncluir() {
	String respuesta="", incluir="";
	int opcion=0, inclusiones=0;
		do {
			try {
				System.out.println("¿Deseas añadir algo a alguna de las listas mostradas? Responde (Sí/No):");
				respuesta = sc.next();
			}catch(Exception ex) {
				System.out.println("No has indtroducido un valor válido.");
			}
		if(respuesta.equalsIgnoreCase("Sí")==false && respuesta.equalsIgnoreCase("Si")== false && respuesta.equalsIgnoreCase("No")==false) {
			System.out.println("Esa no es una respuesta válida.");
		}
		}while(respuesta.equalsIgnoreCase("Sí")==false && respuesta.equalsIgnoreCase("Si")== false && respuesta.equalsIgnoreCase("No")==false);
	
	if(respuesta.equalsIgnoreCase("Sí") ||  respuesta.equalsIgnoreCase("Si")) {
		while(incluir.equalsIgnoreCase("No")==false) {
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
					sc.nextLine();
				}
			}while(opcion<1 || opcion>4);
				do {
					try {
						System.out.println("¿Cuántos elementos vas a incluir? (Introduce un número):\n");
						inclusiones=sc.nextInt();
					}catch(Exception ex) {
						System.out.println("Sólo puedes introducir enteros positivos.");
						sc.nextLine();
					}
				}while(inclusiones<1);
				switch(opcion) {
				case 1:
					arrayPersonajes=CrearNuevoArray(arrayPersonajes, inclusiones);
					IncluirEnArray(inclusiones, arrayPersonajes);
					System.out.println("La lista ha quedado de la siguiente forma: ");
					MostrarArrays(arrayPersonajes);
					break;
				case 2:
					arrayArmas=CrearNuevoArray(arrayArmas, inclusiones);
					IncluirEnArray(inclusiones, arrayArmas);
					MostrarArrays(arrayArmas);
					break;
				case 3:
					 arrayLugares=CrearNuevoArray(arrayLugares, inclusiones);
					 IncluirEnArray(inclusiones, arrayLugares);
					 MostrarArrays(arrayLugares);
					 break;
				default:
					System.out.println("No se añadirá nada");
					break;
			}
				do {
					try {
						System.out.println("¿Quieres añadir algo más a alguna lista? Responde (Sí/No):");
						incluir=sc.next();	
						if(incluir.equalsIgnoreCase("Sí")==false && incluir.equalsIgnoreCase("Si")== false && incluir.equalsIgnoreCase("No")==false) {
							System.out.println("Esa no es una respuesta válida");
						}
					}catch(Exception ex){
						System.out.println("Ese no es un valor admitido. (Responde Sí o No.");
					}
				}while(incluir.equalsIgnoreCase("Sí")==false && incluir.equalsIgnoreCase("Si")== false && incluir.equalsIgnoreCase("No")==false);
				
		}
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

public static void IncluirEnArray(int inclusiones, String[] array) {
	int contador=1;
	boolean valido=true;
	sc.nextLine();
	for(int i=array.length-(inclusiones+1); i<array.length-1;i++) {
		System.out.println("Introduce la " + contador + "ª adición que deseas hacer a la lista: ");
		do {
			valido=true;
			try {
				array[i]=sc.nextLine();
			}catch(Exception ex){
				System.out.println("Ese no es un valor permitido");
				valido=false;
			}
		}while(valido==false);	
		contador++;
	}
}

public static void MostrarArrays(String array[]) {
	for(int i=0; i<array.length-1; i++) {
		System.out.println("· " + array[i]);
	}
	System.out.println();
}

public static boolean BarajarCartas() {
	int aleatorioPersonajes, aleatorioArmas, aleatorioLugares;
	
	aleatorioPersonajes=(int)(Math.random()*(arrayPersonajes.length-1));
	aleatorioArmas=(int)(Math.random()*(arrayArmas.length-1));
	aleatorioLugares=(int)(Math.random()*(arrayLugares.length-1));

	Jugador asesino = new Jugador(arrayPersonajes[aleatorioPersonajes], arrayArmas[aleatorioArmas], arrayLugares[aleatorioLugares]);
	
	IncluirEnLista(asesino);
	
	for (Object i : listaJugadores) {
	    System.out.println(i); 
	}
	System.out.println();

	System.out.println(aleatorioPersonajes + " " + aleatorioArmas + " " + aleatorioLugares);
	
	return true;
}

public static void IncluirEnLista(Jugador jugador) {
	//listaJugadores.add();
	listaJugadores.add(jugador);
}

public static void GuardarEnFichero() throws Exception{
	BufferedWriter writer =  new BufferedWriter(new FileWriter("Historial.txt", true));
	writer.write("FECHA DE GENERACIÓN: \n" + LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + "\n");
	writer.newLine();
	for(Jugador jugador : listaJugadores) {
		writer.write(jugador.toString()+"\n");
		writer.newLine();
	}
	writer.close();
	
	
}

}
