package ejercicio01;

import java.util.Arrays;
import java.util.Scanner;

public class MainAlumno {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int opcion = 0;
		String nombre;
		int index;

		Alumno[] grupo = new Alumno[30];


		// Hacemos un bucle que se repita hasta que nos salgamos del programa.
		do {

			// Presentamos el menú.
			menu();

			// Preguntamos la opción que quiere el usuario.
			System.out.println("Introduzca la opción que desea: ");
			opcion = sc.nextInt();

			// Hacemos un switch.
			switch (opcion) {

			case 1 -> {

				// Función de presentar el listado.
				listado(grupo);

			}

			case 2 -> {

				// Llamamos a la función.
				nuevoAlumno(grupo);

			}

			case 3 -> {

				sc.nextLine();
				// Preguntamos por el nombre de la persona que se quiere modificar.
				System.out.println("Introduzca el nombre del/la alumno/a: ");
				nombre = sc.nextLine();

				// Hay que buscar la posición en la que está esa persona.
				index = indexAlumno(nombre, grupo);

				modificar(grupo, index);

			}

			case 4 -> {

				sc.nextLine();
				// Preguntamos por el nombre de la persona que se quiere eliminar.
				System.out.println("Introduzca el nombre del/la alumno/a a borrar: ");
				nombre = sc.nextLine();

				// Hay que buscar la posición en la que está esa persona.
				// index = indexAlumno(nombre, grupo);

				borrar(grupo, nombre);
			}

			case 5 -> {

				System.out.println("Ha salido del programa.");
			}

			default -> {

				System.err.println("Opción introducida incorrecta");
			}
			}

		} while (opcion != 5);
	}

	private static void menu() {

		System.out.println("ALUMNOS/AS" + "" + "\n===================" + "\n1. Listado" + "\n2. Nuevo alumno"
				+ "\n3. Modificar" + "\n4. Borrar" + "\n5. Salir");

	}

	private static void listado(Alumno[] grupo) {

		// Recorremos el array
		for (Alumno alumno : grupo) {

			// Imprimimos las posiciones que no sea null.
			if (alumno != null) {

				System.out.println(alumno);
			}
		}

	}

	private static void nuevoAlumno(Alumno[] grupo) {

		String nombre;
		double notaMedia;
		int index=0;

		// Recorremos el array.Esto tiene que ser un while
		for (int i = 0; i < grupo.length; i++) {

			// En caso de que una posición sea igual a null, es que está libre.
			if (grupo[i] == null) {

				sc.nextLine();
				System.out.println("Introduzca el nombre del alumno/a: ");
				nombre = sc.nextLine();

				System.out.println("Introduzca la nota media: ");
				notaMedia = sc.nextDouble();

				// Creamos un alumno nuevo en esa posición.
				grupo[i] = new Alumno(nombre, notaMedia);

				System.out.println("Se ha creado un registro con éxito.");

				break;

			} else if (i>=grupo.length){

				System.out.println("No pueden añadirse más alumnos.");
			}

		}
	}

	private static void modificar(Alumno[] grupo, int index) {

		// Si el alumno existe
		if (index >= 0) {

			System.out.println("Introduzca la nota modificada: ");
			grupo[index].setNotaMedia(sc.nextDouble());

		} else {

			System.err.println("El nombre introducido no existe.");
		}
	}

	private static int indexAlumno(String nombre, Alumno[] grupo) {

		int index = 0;

		// Buscamos la posición del array donde esté el nombre introducido.
		while (index < grupo.length && !grupo[index].getNombre().equals(nombre)) {
			index++;
		}

		// En caso de que no lo encuentre, index será -1
		if (index == grupo.length) {
			index = -1;
		}

		return index;

	}

	private static void borrar(Alumno[] grupo, String nombre) {

		// Llamamos a la función index.
		int index = indexAlumno(nombre, grupo);

		if (index >= 0) {

			grupo[index] = null;

			System.out.println("El borrado se ha completado con éxito.");

		} else {

			System.out.println("El nombre introducido no existe.");
		}

	}

}
