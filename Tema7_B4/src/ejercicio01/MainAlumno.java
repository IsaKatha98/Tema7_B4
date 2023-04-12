package ejercicio01;

import java.util.Arrays;
import java.util.Scanner;


public class MainAlumno {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int opcion = 0;
		int contador = 0;
		String nombre;
		int index;

		Alumno[] grupo = new Alumno[30];

		// Recorremos el array y creamos un objeto por cada posición del array.
		for (int i = 0; i < grupo.length; i++) {

			grupo[i] = new Alumno();
			
		}
		
		System.out.println(Arrays.toString(grupo));

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

				// Buscamos la primera posición libre.
				contador = posicionLibre(grupo);

				// En caso de que no encuentre ninguna posición libre.
				if (contador < 0) {
					System.out.println("No se pueden añadir más alumnos.");

					// En caso de que haya una posición libre, llamamos a la funcion para añadir un
					// disco nuevo.
				} else {
					nuevoAlumno(grupo, contador);

				}
			}

			case 3 -> {

				// Preguntamos por el nombre de la persona que se quiere modificar.
				System.out.println("Introduzca el nombre del/la alumno/a: ");
				nombre = sc.nextLine();

				// Hay que buscar la posición en la que está esa persona.
				index = indexAlumno(nombre, grupo);

				modificar(grupo, index);

			}

			case 4 -> {
				
				// Preguntamos por el nombre de la persona que se quiere modificar.
				System.out.println("Introduzca el nombre del/la alumno/a a borrar: ");
				nombre = sc.nextLine();

				// Hay que buscar la posición en la que está esa persona.
				index = indexAlumno(nombre, grupo);

				borrar(grupo, index, nombre);
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

			// Imprimimos las posiciones cuyo nombre sea distinto de null.
			if (!alumno.getNombre().equals(null)) {

				System.out.println(alumno);
			}
		}

	}

	private static int posicionLibre(Alumno[] grupo) {

		int index = 0;

		// Buscamos la primera posición que sea null.
		while (index < grupo.length && !grupo[index].getNombre().equals(null)) {
			index++;
		}

		// En caso de que no lo encuentre, index será -1
		if (index == grupo.length) {
			index = -1;
		}

		// Devolvemos index.
		return index;
	}

	private static void nuevoAlumno(Alumno[] grupo, int contador) {

		String nombre;
		double notaMedia;

		System.out.println("Introduzca el nombre del alumno/a: ");
		nombre = sc.nextLine();
		System.out.println("Introduzca la nota media: ");
		notaMedia = sc.nextDouble();

		// Asiganmos todo a esa posición
		grupo[contador] = new Alumno(nombre, notaMedia);
	}

	private static void modificar(Alumno[] grupo, int index) {

		// Si el alumno existe
		if (index > 0) {

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
	
	private static void borrar(Alumno[] grupo, int index, String nombre) {

		// Buscamos esa posición y si existe lo cambiamos a null.
		if (index >= 0 && index < grupo.length && !grupo[index].getNombre().equals(nombre)) {

			grupo[index].setNombre(null);

		} else {

			System.out.println("El nombre introducido no existe.");
		}
	}

}
