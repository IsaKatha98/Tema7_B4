package ejercicio02;

import java.util.Arrays;
import java.util.Scanner;

import ejercicio01.Alumno;

public class MainAlmacen {

	static Gestisimal[] almacen = new Gestisimal[1];

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		Gestisimal art1 = new Gestisimal(01, "Lata de tomate", 1.85, 1.95, 10);

		System.out.println(art1.toString());

		// Declaramos las variables necesarias.
		int opcion = 0;
		int cod;

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
				listado();

			}

			case 2 -> {

				// Función que crea un artículo nuevo.
				altaArticulo();
			}

			case 3 -> {

				System.out.println("Introduzca el código del artículo a eliminar:");
				cod = sc.nextInt();

				// Función que eliminar un artículo.
				bajaArticulo(cod);
			}

			case 4 -> {

				// Modifica los datos de un articulo.
				System.out.println("Introduzca el código del artículo a modificar:");
				cod = sc.nextInt();

				modificaArticulo(cod);
			}

			case 5 -> {

				// Función de entrada de mercancía.
				System.out.println("Introduzca el código del artículo a del que quiere ingresar stock:");
				cod = sc.nextInt();

				entradaStock(cod);
			}

			case 6 -> {

				// Función de salida de mercancía.

				System.out.println("Introduzca el código del artículo a del que quiere retirar stock:");
				cod = sc.nextInt();

				salidaStock(cod);
			}

			case 7 -> {

				System.out.println("Ha salido del programa.");
			}

			default -> {

				System.err.println("Opción introducida incorrecta");
			}
			}

		} while (opcion != 7);
	}

	private static void menu() {

		System.out.println("Almacén" + "" + "\n===================" + "\n1. Listado" + "\n2. Alta (crear artículo)"
				+ "\n3. Baja (borrar artículo)" + "\n4. Modificación" + "\n5. Entrada de mercancía"
				+ "\n6. Salida de mercancía" + "\n7. Salir");

	}

	private static void listado() {

		// Recorremos el array
		for (Gestisimal articulo : almacen) {

			// Imprimimos las posiciones que no sea null.
			if (articulo != null) {

				System.out.println(articulo);

			}
		}

	}

	private static int posicionLibre() {

		int cod = 0;

		// Debemos buscar si hay una posición libre.
		for (int i = 0; i < almacen.length; i++) {

			// Si encuentra una posición libre, se la asigna a cod.
			if (almacen[i] == null) {

				cod = i;

				// Creamos una posición nueva y se la asignamos a cod.
			} else {

				almacen = Arrays.copyOf(almacen, almacen.length + 1);

				cod = almacen.length - 1;

			}
		}

		return cod;

	}

	private static void altaArticulo() {

		int cod;
		String descripcion;
		double precioCompra;
		double precioVenta;
		int stock;

		// Llamamos a la función posición libre.
		cod = posicionLibre();

		sc.nextLine();
		System.out.println("Introduzca una descripcion del artículo: ");
		descripcion = sc.nextLine();

		System.out.println("Introduzca el precio de compra: ");
		precioCompra = sc.nextDouble();

		System.out.println("Introduzca el precio de venta: ");
		precioVenta = sc.nextDouble();

		System.out.println("Introduzca la cantidad de unidades en stock: ");
		stock = sc.nextInt();

		almacen[cod] = new Gestisimal(cod, descripcion, precioCompra, precioVenta, stock);

		System.out.println("Se ha creado un registro con éxito.");

	}

	/**
	 * Función que busca una posición concreta en el array almacén.
	 * 
	 * @param cod
	 * @return
	 */
	public static int indexArticulo(int cod) {

		int index = 0;

		// En caso de que nos introduzcan un número más grande o igual que el tamaño del
		// array.
		if (cod <= almacen.length) {

			// Si el codigo está en el array, pero es null, ponemos index a -1.
			if (almacen[cod] == null) {

				index = -1;

			} else {

				// Buscamos la posición del array donde esté el nombre introducido.
				while (index < almacen.length && almacen[index].getCodigo() != cod) {
					index++;
				}

			}

		} else {

			index = -1;
		}

		return index;

	}

	public static void bajaArticulo(int cod) {

		// Llamamos a la función index.
		int index = indexArticulo(cod);

		if (index >= 0) {

			almacen[index] = null;

			System.out.println("El borrado se ha completado con éxito.");

		} else {

			System.out.println("El código introducido no existe.");
		}

	}

	public static void modificaArticulo(int cod) {

		int index;

		// Llamamos a la función index.
		index = indexArticulo(cod);

		// Si el codigo existe.
		if (index >= 0) {

			sc.nextLine();

			// Setteamos todos los datos de nuevo.
			System.out.println("Introduzca una descripcion del artículo: ");
			almacen[cod].setDescripcion(sc.nextLine());

			System.out.println("Introduzca el precio de compra: ");
			almacen[cod].setPrecioCompra(sc.nextDouble());

			System.out.println("Introduzca el precio de venta: ");
			almacen[cod].setPrecioVenta(sc.nextDouble());

			System.out.println("Introduzca la cantidad de unidades en stock: ");
			almacen[cod].setStock(sc.nextInt());

			System.out.println("Se ha modificado un registro con éxito.");

		} else {

			System.err.println("El código introducido no existe.");
		}

	}

	public static void entradaStock(int cod) {

		// Comprobamos que el código existe.
		int index;
		int udStock;

		// Llamamos a la función index.
		index = indexArticulo(cod);

		// Si el codigo existe.
		if (index >= 0) {

			sc.nextLine();
			System.out.println("Introduzca la cantidad de stock: ");
			udStock = sc.nextInt();

			// Se lo sumamos a la cantidad de stock que ya hay.
			almacen[cod].setStock(udStock + almacen[cod].getStock());

			System.out.println("Se ha actualizado el stock a " + almacen[cod].getStock() + " cantidades.");

		} else {

			System.err.println("El código introducido no existe.");
		}
	}

	public static void salidaStock(int cod) {

		// Comprobamos que el código existe.
		int index;
		int udStock;

		// Llamamos a la función index.
		index = indexArticulo(cod);

		// Si el codigo existe.
		if (index >= 0) {

			sc.nextLine();
			System.out.println("Introduzca la cantidad de stock a retirar: ");
			udStock = sc.nextInt();

			// Comprobamos que la cantidad a salir es menor que la que hay en existencias.
			if (almacen[cod].getStock() >= udStock && almacen[cod].getStock() != 0) {

				// Se lo restamos.
				almacen[cod].setStock(almacen[cod].getStock() - udStock);

				System.out.println("Se ha actualizado el stock a " + almacen[cod].getStock() + " cantidades.");

			} else {

				System.out.println("No hay tantas cantidades en stock");
			}

		} else {

			System.err.println("El código introducido no existe.");
		}

	}

}
