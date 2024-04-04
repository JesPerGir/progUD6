package progUD6;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class Jugador{

	private String nombre, arma, habitacion, horaPartida;
	
	public Jugador(String nombre, String arma, String habitacion) {
		this.nombre=nombre;
		this.arma=arma;
		this.habitacion=habitacion;
		horaPartida=LocalTime.now().truncatedTo(ChronoUnit.MINUTES).toString();		//Da formato a la hora actual para que sólo aparezcan horas y minutos.
	}

	@Override //Sobrescribe el metodo ToString de la clase Object para mostrar la información de las instancias de Jugador en forma de String.
	public String toString() {
		return "Jugador [nombre=" + nombre + ", arma=" + arma + ", habitacion=" + habitacion + ", horaPartida="
				+ horaPartida + "]";
	}

}
