package progUD6;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Cluedo {
	
	//Variables e instancias de clase que son usadas por los distintos métodos para llevar a cabo el cometido de la aplicación.
	private static Scanner sc = new Scanner(System.in);
	private static List<Jugador>  listaJugadores = new ArrayList<>();
	private static String arrayPersonajes[] = {"Amapola","Celeste","Prado","Mora","Rubio","Blanco"};
	private static String arrayArmas[] = {"Bate","Pistola","Candelabro","Cuchillo","Cuerda","Hacha","Pesa","Veneno","Trofeo"};
	private static String arrayLugares[] = {"Casa de invitados","Teatro","Spa","Observatorio","Terraza","Salón","Cocina","Vestíbulo"};
	
	public static void main(String[] args) {
		
		MostrarBienvenida(); //Muestra la bienvenida.
		do {
			System.out.println("Los Personajes son los siguientes: ");			
			MostrarArrays(arrayPersonajes);		//Se muestran por consola los personajes..
			System.out.println("Las armas son las siguientes: ");				
			MostrarArrays(arrayArmas);		//Se muestran por consola las armas.
			System.out.println("Los lugares son los siguientes: ");
			MostrarArrays(arrayLugares);		//Se muestran por consola los lugares.
			PreguntarSobreIncluir();		//Pregunta al usuario si quiere incluir algo en alguno de los arrays.
			while(BarajarCartas()==false);		//Baraja las cartas, lo repite si ha sucedido una excepción y por tanto devuelve false.
			preguntarSobreMostrarCartas();		//Pregunta si quieres ver las cartas que han salido y te pide una clave.
		}while(preguntarSobreSeguir());		//Pregunta si quieres volver a generar combinaciones de cartas y en ese caso reinicia el flujo del do-while.
		GuardarEnFichero();			//Guarda en el fichero Historial.txt los datos generados en esta sesión.
		mostrarDespedida();		//Muestra un mensaje de despedida.
		sc.close();			//Cierra el Scanner.
		
		
		
	}
	
	//Muestra un mensaje de bienvenida e información sobre el programa.
	public static void MostrarBienvenida() { 
		
		System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||\n"
									+ "||||| Te doy la bienvenida a CLUEDO |||||\n"
									+ "||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||\n");
		System.out.println("Este programa barajará las cartas de forma aleatoria para jugar a CLUEDO.\n");
	}
	//Pregunta al usuario por todas las cosas de vital importancia para la ejecución del programa.
	public static void PreguntarSobreIncluir() {
		String respuesta="", incluir="";
		int opcion=0, inclusiones=0;
			do {
				try {
					System.out.println("¿Deseas añadir algo a alguna de las listas mostradas? Responde (Sí/No):");
					respuesta = sc.next();
				}catch(Exception ex) {
					System.out.println("Ha sucedido un error.");
				}
			if(respuesta.equalsIgnoreCase("Sí")==false && respuesta.equalsIgnoreCase("Si")== false && respuesta.equalsIgnoreCase("No")==false) {
				System.out.println("Sólo puedes introducir Sí o No");
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
						if(opcion!=4) {
							 try{
								System.out.println("¿Cuántos elementos vas a incluir? (Introduce un número):\n");
								inclusiones=sc.nextInt();
							 }catch(Exception ex) {
									System.out.println("Sólo puedes introducir enteros positivos.");
									inclusiones=0;
									sc.nextLine();
								}
						}else {
							inclusiones=1;
						}
					}while(inclusiones<1);
					switch(opcion) {
					case 1:
						System.out.println("El estado actual de la lista es el siguiente: ");
						MostrarArrays(arrayPersonajes);
						arrayPersonajes=CrearNuevoArray(arrayPersonajes, inclusiones);
						IncluirEnArray(inclusiones, arrayPersonajes);
						System.out.println("La lista ha quedado de la siguiente forma: ");
						MostrarArrays(arrayPersonajes);
						break;
					case 2:
						System.out.println("El estado actual de la lista es el siguiente: ");
						MostrarArrays(arrayArmas);
						arrayArmas=CrearNuevoArray(arrayArmas, inclusiones);
						IncluirEnArray(inclusiones, arrayArmas);
						MostrarArrays(arrayArmas);
						break;
					case 3:
						System.out.println("El estado actual de la lista es el siguiente: ");
						MostrarArrays(arrayLugares);
						arrayLugares=CrearNuevoArray(arrayLugares, inclusiones);
						IncluirEnArray(inclusiones, arrayLugares);
						MostrarArrays(arrayLugares);
						break;
					default:
						System.out.println("No se añadirá nada");
						break;
				}
					do {
						if(opcion!=4) {
							try {
								System.out.println("¿Quieres añadir algo más a alguna lista? Responde (Sí/No):");
								incluir=sc.next();	
								if(incluir.equalsIgnoreCase("Sí")==false && incluir.equalsIgnoreCase("Si")== false && incluir.equalsIgnoreCase("No")==false) {
									System.out.println("Sólo puedes introducir Sí o No");
								}
							}catch(Exception ex){
								System.out.println("Ha sucedido un error");
							}
						}else {
							incluir="No";
						}
						
					}while(incluir.equalsIgnoreCase("Sí")==false && incluir.equalsIgnoreCase("Si")== false && incluir.equalsIgnoreCase("No")==false);
					
			}
		}else{
			System.out.println("¡Genial, sigamos!");
			}
	}

	//Pregunta al usuario para que introduzca una clave si quiere ver las cartas resultantes.
	public static void preguntarSobreMostrarCartas() {
		String clave;
		System.out.println("Te puedo mostrar las cartas que dan como lugar al asesino, pero sólo si aciertas la clave.");
		System.out.println("Introduce una clave: ");
		clave=sc.next();
		if(clave.equalsIgnoreCase("Shirohige")) {
			System.out.println(listaJugadores.get(listaJugadores.size()-1));
		}else {
			System.out.println("No tienes permiso para ver las cartas.");
		}
	}
	
	//Pregunta al usuario si quiere volver a generar nuevas combinaciones.
	public static boolean preguntarSobreSeguir() {
		String respuesta="";
		do {
			System.out.println("¿Quieres generar nuevas combinaciones? Responde (Sí/No): ");
			respuesta=sc.next();
			if(respuesta.equalsIgnoreCase("Sí")==false && respuesta.equalsIgnoreCase("Si")== false && respuesta.equalsIgnoreCase("No")==false) {
				System.out.println("Sólo puedes introducir Sí o No");
			}
		}while(respuesta.equalsIgnoreCase("Sí")==false && respuesta.equalsIgnoreCase("Si")== false && respuesta.equalsIgnoreCase("No")==false);
			if(respuesta.equalsIgnoreCase("Sí") || respuesta.equalsIgnoreCase("Si")) {
				return true;
			}else {
				return false;
			}
	}
	
	//Muestra un mensaje de despedida antes de finalizar la ejecución del programa.
	public static void mostrarDespedida() {
		System.out.println("\n El programa va a finalizar su ejecución.");
		System.out.println("\n"
									+ "||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||\n"
									+ "|||||              HASTA PRONTO             |||||\n"
									+ "||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||\n");
	}
	
	//Crea un array con la nueva longitus necesaria para incluir lo que introduzca el usuario.
	public static String[] CrearNuevoArray(String[] array, int inclusiones) {
		String nuevoArray[] = new String[array.length+inclusiones];
		for(int i=0; i<array.length; i++) {
			nuevoArray[i]=array[i];
		}
		return nuevoArray;
	}
	
	//Incluye en el nuevo array creado con el método CrearNuevoArray cada una de las cosas que solicite el usuario.
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
					System.out.println("Ha sucedido un error");
					valido=false;
				}
			}while(valido==false);	
			contador++;
		}
	}
	
	//Muestra cada una de las posiciones de los arrays en consola.
	public static void MostrarArrays(String array[]) {
		for(int i=0; i<array.length-1; i++) {
			System.out.println("· " + array[i]);
		}
		System.out.println();
	}
	
	//Genera tres números aleatorios simultáneos para elegir la posición del array e instanciar un objeto Jugador.
	public static boolean BarajarCartas() {
		int aleatorioPersonajes, aleatorioArmas, aleatorioLugares;
		
		aleatorioPersonajes=(int)(Math.random()*(arrayPersonajes.length));
		aleatorioArmas=(int)(Math.random()*(arrayArmas.length));
		aleatorioLugares=(int)(Math.random()*(arrayLugares.length));
		try {
			Jugador asesino = new Jugador(arrayPersonajes[aleatorioPersonajes], arrayArmas[aleatorioArmas], arrayLugares[aleatorioLugares]);
			IncluirEnLista(asesino);
	
			return true;
		}catch(Exception ex) {
			System.out.println("Ha sucedido un error.");
			return false;
		}
	}
	
	//Añade el objeto jugador generado en el método BarajarCartas a la lista (List) listaJugadores.
	public static void IncluirEnLista(Jugador jugador) {
		listaJugadores.add(jugador);
	}
	
	//Antes de finalizar el programa, recorre la lista (List) listaJugadores y la guarda en el archivo Historial.txt.
	public static void GuardarEnFichero() {
		try {
			BufferedWriter writer =  new BufferedWriter(new FileWriter("Historial.txt", true));
			writer.write("FECHA DE GENERACIÓN: \n" + LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + "\n");		//Da formato a la fecha actual para que aparezca en (días-meses-años).
			writer.newLine();
			for(Jugador jugador : listaJugadores) {
				writer.write(jugador.toString()+"\n");
				writer.newLine();
			}
			writer.close();
			System.out.println("\n **Datos guardados con éxito en el historial**");
		}catch(Exception ex) {
			System.out.println("\n Ha sucedido un error.");
		}
	}
}
