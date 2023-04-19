package ejercicio03;

import java.util.Arrays;
import java.util.Scanner;

import ejercicio02.Gestisimal;

public class MainPizza {

	// Creamos un array con una posición.
	static Pizza[] servicio = new Pizza[1];

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		// Declaramos las variables necesarias.
		int opcion = 0;
		int cod;

		System.out.println(Arrays.toString(servicio));

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

				// Función de presentar el listado de pizzas.
				listado();

			}

			case 2 -> {

				// Función que crea un pedido nuevo.
				 nuevoPedido();
			}

			case 3 -> {

				System.out.println("Introduzca el código del artículo a eliminar:");
				cod = sc.nextInt();

				// Función que sirve la pizza.
				sirvePizza(cod);
			}

			case 4 -> {

				//Se sale del programa.
				System.out.println("Ha salido del programa.");
			}

			default -> {

				System.err.println("Opción introducida incorrecta");
			}
			}

		} while (opcion != 4);
	}

	private static void menu() {

		System.out.println("Pizzería" + "" + "\n===================" + "\n1. Listado de pizzas" + "\n2. Nuevo pedido"
				+ "\n3. Servir pizza" + "\n4. Salir");

	}

	private static void listado() {

		// Recorremos el array.
		for (Pizza pizza : servicio) {

			// Imprimimos las posiciones que no sean null.
			if (pizza != null) {

				System.out.println(pizza);
			}
		}
	}

	private static int posicionLibre() {

		int cod = 0;

		// Debemos buscar si hay una posición libre.
		for (int i = 0; i < servicio.length; i++) {

			// Si encuentra una posición libre, se la asigna a cod.
			if (servicio[i] == null) {

				cod = i;

				// Creamos una posición nueva y se la asignamos a cod.
			} else {

				servicio = Arrays.copyOf(servicio, servicio.length + 1);

				cod = servicio.length - 1;

			}
		}

		return cod;

	}

	private static void nuevoPedido() {

		int cod;

		// Llamamos a la función posición libre.
		cod = posicionLibre();

		servicio[cod] = new Pizza(cod, eligeSize(), eligeTipo());

		System.out.println("Se ha creado un registro con éxito.");

	}

	private static String eligeSize() {

		String size = "";
		boolean error= false;

		do {

			sc.nextLine();
			System.out.println("Elija el tamaño: Mediana o Familiar. Su opción:");
			size = sc.nextLine();

			if (size.equals("Mediana")) {

				// Se iguala el string al tipo del enum.
				size = String.valueOf(Pizza.Size.Mediana);

			} else if (size.equals("Familiar")) {

				// Se iguala al enum.
				size = String.valueOf(Pizza.Size.Familiar);

			} else {
				
				error= true;
				System.out.println("Esa opción no está contemplada.");
			}

		//Que se repita mientras error sea true.
		} while (error);

		return size;
	}

	private static String eligeTipo() {

		String tipo = "";
		boolean error= false;

		do {

			sc.nextLine();
			System.out.println("Elija el tipo: Margarita, CuatroQuesos o Funghi. Su opción:");
			tipo = sc.nextLine();

			if (tipo.equals("Margarita")) {

				// Se iguala el string al tipo del enum.
				tipo = String.valueOf(Pizza.Tipo.Margarita);

			} else if (tipo.equals("CuatroQuesos")) {

				// Se iguala al enum.
				tipo = String.valueOf(Pizza.Tipo.CuatroQuesos);

			} else if (tipo.equals("Funghi")) {

				// Se iguala al enum.
				tipo = String.valueOf(Pizza.Tipo.Funghi); 
			
			} else {
				
				//Si se equivoca.
				error=true;
				System.out.println("Esa opción no está contemplada.");
			}

		} while (error);

		return tipo;

	}
	
	/**
	 * Función que busca una posición concreta en el array.
	 * 
	 * @param cod
	 * @return
	 */
	public static int indexArray(int cod) {

		int index = 0;

		// En caso de que nos introduzcan un número más grande o igual que el tamaño del
		// array.
		if (cod <= servicio.length) {

			// Si el codigo está en el array, pero es null, ponemos index a -1.
			if (servicio[cod] == null) {

				index = -1;

			} else {

				// Buscamos la posición del array donde esté el nombre introducido.
				while (index < servicio.length && servicio[index].getCodigo() != cod) {
					index++;
				}

			}

		} else {

			index = -1;
		}

		return index;

	}
	
	public static void sirvePizza(int cod) {

		int index;

		// Llamamos a la función index.
		index = indexArray(cod);

		// Si el codigo existe.
		if (index >= 0) {

			//Setteamos el estado de la pizza a servida.
			servicio[index].setEstado("Servida");

			System.out.println("Se ha servido la pizza con código: "+cod);

		} else {

			System.err.println("El código introducido no existe.");
		}

	}

}
