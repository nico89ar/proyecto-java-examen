package ejercicios;

import java.time.LocalDate;
import java.time.Month;

/**
 * A. Crear una clase Persona con los siguientes campos
 * (con sus respectivos getters, setters y constructor)
 *
 * TipoDocumento - enum (dni/libretacivica)
 * NroDocumento - Integer
 * Nombre - String
 * Apellido - String
 * FechaNacimiento - Date
 *
 * B. En el método main de la clase "Ejercicio2" crear una nueva instancia
 * de la clase persona y settearle valores reales con tus datos
 *
 *
 * C. En el método main de la clase "Ejercicio 2" imprimir los valores en
 * consola
 * (crear método main e imprimir valores)
 *
 * @author examen
 *
 */
public class Ejercicio2 {

	/**
	 *
	 */
	public Ejercicio2() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Persona persona = new Persona(TipoDocumento.DNI,
				34795529,
				"Nicolas",
				"Balbuena",
				//new GregorianCalendar(1989, 12 - 1, 17).getTime());
				LocalDate.of(1989, Month.DECEMBER, 17));

		System.out.println("tipo de documento: " + persona.getTipoDocumento());
		System.out.println("nùmero de documento: " + persona.getNroDocumento());
		System.out.println("nombre: " + persona.getNombre());
		System.out.println("apellido: " + persona.getApellido());
		System.out.println("fecha de nacimiento: " + persona.getFechaNacimiento());

	}

}
