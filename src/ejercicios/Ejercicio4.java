package ejercicios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio4 {

	// listas de ejemplo, pueden variarse su contenido, 
	static Integer[] valoresLista1 = {1, 2, 5, 8, 10, 30, 20, 8, 9, 10};
	static Integer[] valoresLista2 = {1, 2, 4, 20, 5, 10, 7, 8, 10, 9};

	/**
	 * Para ejecutar el método main se debe hacer boton derecho sobre la clase
	 * "Run As --> Java Application" 
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("**** inicializando datos ****");

		List<Integer> lista1 = new ArrayList<Integer>(Arrays.asList(valoresLista1));
		List<Integer> lista2 = new ArrayList<Integer>(Arrays.asList(valoresLista2));

		System.out.println("**** inicializacion exitosa ****");

		// EJERCICIO 4.1: explicar salidas y sugerir mejoras
		informacion(lista1, 10);

		// EJERCICIO 4.2: corregir el metodo
		List<Integer> union = unionListas(lista1, lista2);
		System.out.println("union: " + union.toString());

		// EJERCICIO 4.3: implementar
		List<Integer> interseccion = interseccionListas(lista1, lista2);
		System.out.println("interseccion: " + interseccion.toString());

		// EJERCICIO 4.4: implementar
		List<Integer> orden1 = ordenaListaAscendente(lista1);
		System.out.println("orden asc: " + orden1);

		// EJERCICIO 4.5: implementar
		List<Integer> orden2 = ordenaListaDescendente(lista2);
		System.out.println("orden desc: " + orden2);

		// EJERCICIO 4.6: implementar
		boolean b = tienenMismoContenido(lista1, lista2);
		System.out.println("mismo contenido: " + b);

	}

	private static void informacion(List<Integer> lista1, Integer numero) {
		/**
		 * Nota: las mejoras ya se están aplicadas sobre el código
 		 */

		int cantidadPares = 0;
		List<Integer> listaImpares = new ArrayList<>();
		int cantidadMayorANumero = 0;
		for (Integer n: lista1) {
			if (n % 2 == 0) {
				cantidadPares++;
			} else {
				listaImpares.add(n);
			}

			if (n > numero) {
				cantidadMayorANumero++;
			}
		}

		System.out.println("Cantidad de elementos pares: " + cantidadPares);

		System.out.println("Elementos impares: " + listaImpares.toString());

		int p = lista1.size() / 2;

		// Asumiendo que la intención era utilizar indexOf():
		System.out.println("Posición del elemento que representa la mitad de la cantidad de elementos de la lista: "
				+ (lista1.indexOf(p) >= 0 ? lista1.indexOf(p) + 1 : "[no existe en la lista]"));

		//Asumiendo que la intención era utilizar get():
		System.out.println("Elemento en la mitad de la lista: " + lista1.get(p));

		if (cantidadMayorANumero > lista1.size() / 2) {
			System.out.println("Más de la mitad de los elementos de la lista son mayores que " + numero);
		} else if (cantidadMayorANumero > 0) {
			System.out.println("Menos de la mitad de los elementos de la lista son mayores que " + numero);
		} else {
			System.out.println("Ningún elemento de la lista es mayor que " + numero);
		}
	}

	/***
	 * @param lista1
	 * @param lista2
	 *
	 * retornar una lista que contenga los elementos de ambas listas, sin elementos repetidos
	 *
	 */
	private static List<Integer> unionListas(List<Integer> lista1, List<Integer> lista2) {

		List<Integer> union = new ArrayList<>();

		for (Integer m: lista1) {
			if (!union.contains(m)) {
				union.add(m);
			}
		}

		for (Integer m: lista2) {
			if (!union.contains(m)) {
				union.add(m);
			}
		}

		return union;
	}

	/***
	 * @param lista1
	 * @param lista2
	 *
	 * retornar una lista que contenga los elementos que estan presentes en ambas listas, sin elementos repetidos
	 *
	 */
	private static List<Integer> interseccionListas(List<Integer> lista1, List<Integer> lista2) {

		return new ArrayList<>(lista1.stream()
				.filter(lista2::contains)
				.collect(Collectors.toSet()));
	}

	/***
	 * @param lista1
	 *
	 * retornar la lista recibida, ordenada en forma ascendente
	 *
	 */
	private static List<Integer> ordenaListaAscendente(List<Integer> lista1) {

		Collections.sort(lista1);
		return lista1;
	}

	/***
	 * @param lista2
	 *
	 * retornar la lista recibida, ordenada en forma descendente
	 *
	 */
	private static List<Integer> ordenaListaDescendente(List<Integer> lista2) {

		Collections.sort(lista2, Collections.reverseOrder());
		return lista2;
	}

	/***
	 * @param lista1
	 * @param lista2
	 *
	 * devuelve true si contienen los mismos elementos
	 * NO se considera valido que esten en diferente orden
	 * NO se considera valido que la cantidad de repeticiones de los elementos sea diferente
	 *
	 */
	private static boolean tienenMismoContenido(List<Integer> lista1, List<Integer> lista2) {

		return lista1.equals(lista2);
	}

}
