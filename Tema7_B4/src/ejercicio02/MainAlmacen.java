package ejercicio02;

import java.util.Arrays;
import java.util.Scanner;

public class MainAlmacen {

	public static void main(String[] args) {
		
		Gestisimal art1= new Gestisimal (01, "Lata de tomate", 1.85, 1.95, 10);

		System.out.println(art1.toString());
		
		//Creamos un escáner.
		Scanner sc= new Scanner(System.in);
		
		//Declaramos las variables necesarias.
		int opcion=0;
		int contador=0;
		
		Gestisimal[] almacen= new Gestisimal[0];
		
		System.out.println(Arrays.toString(almacen));

		
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
				//listado(almacen);

			}

			case 2 -> {

				// Buscamos la primera posición libre.
				//contador = posicionLibre(almacen);

				// En caso de que no encuentre ninguna posición libre.
				if (contador < 0) {
					System.out.println("No se pueden añadir más discos.");

					// En caso de que haya una posición libre, llamamos a la funcion para añadir un
					// disco nuevo.
				} else {
					//nuevoDisco(almacen, contador);

				}
			}

			case 3 -> {

				//modificar(almacen);
			}

			case 4 -> {

				//borrarDisco(almacen);
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

		System.out.println("Almacén" + "" + "\n===================" + "\n1. Listado" + "\n2. Alta (crear artículo)"
				+ "\n3. Baja (borrar artículo)" + "\n4. Modificación" + "\n5. Entrada de mercancía"+ "\n6. Salida de mercancía"
				+"\n7. Salir");

	}

}
