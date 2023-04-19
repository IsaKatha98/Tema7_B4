package ejercicio04;

import java.util.Arrays;
import java.util.Scanner;

import ejercicio03.Pizza;

public class MainCuenta {

	static CuentaCorriente[] clientes = new CuentaCorriente[1];
	static CuentaCorriente[] saldos= new CuentaCorriente[1];

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		// Declaramos las variables necesarias.
		int opcion = 0;
		String dni = "";

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

				// Función de presentar el listado de clientes.
				listado();

			}

			case 2 -> {

				// Función que crea un cliente nuevo.
				altaCliente();
			}

			case 3 -> {

				System.out.println("Introduzca el dni del cliente a eliminar:");
				dni = sc.nextLine();

				// Función que eliminar un artículo.
				// bajaCliente(dni);
			}

			case 4 -> {

				// Muestra el saldo disponible.
				System.out.println("Introduzca el DNI del cliente:");
				dni = sc.nextLine();

				muestraSaldo(dni);
			}

			case 5 -> {

				// Función que ingresa dinero.
				System.out.println("Introduzca el DNI del cliente:");
				dni = sc.nextLine();

				ingresarDinero(dni);
			}

			case 6 -> {

				// Función que retira dinero.
				System.out.println("Introduzca el DNI del cliente:");
				dni = sc.nextLine();

				retirarDinero(dni);
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

		System.out.println(
				"Banco" + "" + "\n===================" + "\n1. Listado" + "\n2. Alta Cliente" + "\n3. Baja Cliente"
						+ "\n4. Ver saldo" + "\n5. Ingresar dinero." + "\n6. Retirar dinero" + "\n7. Salir");

	}

	private static void listado() {

		// Recorremos el array
		for (CuentaCorriente cliente : clientes) {

			// Imprimimos las posiciones que no sea null.
			if (cliente != null) {

				System.out.println(cliente);

			}
		}

	}

	private static int posicionLibre() {

		int index = 0;

		// Debemos buscar si hay una posición libre.
		for (int i = 0; i < clientes.length; i++) {

			// Si encuentra una posición libre, se la asigna a cod.
			if (clientes[i] == null) {

				index = i;

				// Creamos una posición nueva y se la asignamos a cod.
			} else {

				clientes = Arrays.copyOf(clientes, clientes.length + 1);

				index = clientes.length - 1;

			}
		}

		return index;

	}
	
	private static boolean posicionLibre(String dni, int indexCliente) {

		boolean copia= false;
		
		//Tenemos que comprobar el dni de la persona en el array saldos.
		
		int indexSaldo = 0;

		while (indexSaldo < saldos.length && !saldos[indexSaldo].getdNI().equals(dni)) {
			indexSaldo++;	
			
			
		}
	
		//Comprobamos que ambas posiciones son iguales.
		if (clientes[indexCliente].getdNI().equals(dni)&&saldos[indexSaldo].getdNI().equals(dni)) {
			
			copia= true;
		}

		//En caso de que no la encuentre, tenemos que hacer una copia y asignarle 
		//el index correspondiente.
		else  if (indexSaldo==saldos.length) {
			
			saldos= Arrays.copyOf(saldos, saldos.length + 1);

			indexSaldo = saldos.length - 1;
			
			//Comprobamos que ambas posiciones son iguales.
			if (clientes[indexCliente]==saldos[indexSaldo]) {
				
				copia= true;
			}
		}

		return copia;

	}


	private static void altaCliente() {

		int index;
		boolean indexS;
		String dni, nombre;
		int saldo;

		// Llamamos a la función posición libre.
		index = posicionLibre();

		sc.nextLine();
		System.out.println("Introduzca el DNI del nuevo cliente: ");
		dni = sc.nextLine();

		System.out.println("Introduzca el nombre del nuevo cliente: ");
		nombre = sc.nextLine();

		clientes[index] = new CuentaCorriente(dni, nombre, eligeGenero());
		
		System.out.println("Introduzca una cantidad de saldo incial: ");
		saldo= sc.nextInt();
		
		
		
			
			saldos[index]= new CuentaCorriente(dni, saldo);

			//Llamamos a una función que copiará el index de clientes a saldos.
			indexS= posicionLibre (dni, index);
			
			if (indexS) {
				
				System.out.println("Se ha creado un registro con éxito.");
				
			}
			
	}

	private static String eligeGenero() {

		String genero = "";
		boolean error = false;

		do {

			sc.nextLine();
			System.out.println("Indique su género si femenino o masculino: ");
			genero = sc.nextLine();

			if (genero.equals("femenino")) {

				// Se iguala el string al tipo del enum.
				genero = String.valueOf(CuentaCorriente.Sexo.femenino);

			} else if (genero.equals("masculino")) {

				// Se iguala al enum.
				genero = String.valueOf(CuentaCorriente.Sexo.masculino);

			} else {

				error = true;
				System.out.println("Esa opción no está contemplada.");
			}

			// Que se repita mientras error sea true.
		} while (error);

		return genero;
	}

	/**
	 * Función que busca una posición concreta en el array.
	 * 
	 * @param dni
	 * @return
	 */
	public static int indexArray(String dni) {

		int index = 0;

		// Buscamos la posición del array donde esté el nombre introducido.
		while (index < clientes.length && !clientes[index].getdNI().equals(dni)) {
			index++;
		}

		// En caso de que no lo encuentre, index será -1
		if (index == clientes.length) {
			index = -1;
		}

		return index;

	}

	public static void bajaCliente(String dni) {

		// Llamamos a la función index.
		int index = indexArray(dni);

		if (index >= 0) {

			clientes[index] = null;
			saldos[index]=null;

			System.out.println("El borrado se ha completado con éxito.");

		} else {

			System.out.println("El DNI introducido no existe.");
		}

	}

	public static void muestraSaldo(String dni) {

		int index;

		// Llamamos a la función index.
		index = indexArray(dni);

		// Si el codigo existe.
		if (index >= 0) {

			System.out.println("El saldo de su cuenta actual es: "+ saldos[index].getSaldo()+" euros.");

		} else {

			System.err.println("El DNI introducido no existe.");
		}

	}

	public static void ingresarDinero(String dni) {

		// Comprobamos que el código existe.
		int index;
		int dinero;

		// Llamamos a la función index.
		index = indexArray(dni);

		// Si el dni existe.
		if (index >= 0) {

			sc.nextLine();
			System.out.println("Introduzca la cantidad de dinero a ingresar: ");
			dinero = sc.nextInt();

			// Se lo sumamos al saldo que ya hay en la cuenta.
			saldos[index].setSaldo(dinero + saldos[index].getSaldo());

			System.out.println("Se ha actualizado el saldo a " + saldos[index].getSaldo() + " euros.");

		} else {

			System.err.println("El DNI introducido no existe.");
		}
	}

	public static void retirarDinero(String dni) {

		// Comprobamos que el código existe.
		int index;
		int dinero;

		// Llamamos a la función index.
		index = indexArray(dni);

		// Si el codigo existe.
		if (index >= 0) {

			sc.nextLine();
			System.out.println("Introduzca la cantidad de dinero a retirar: ");
			dinero = sc.nextInt();

			// Comprobamos que la cantidad a salir es menor que la que hay en el saldo.
			if (saldos[index].getSaldo() >= dinero && saldos[index].getSaldo() != 0) {

				// Se lo restamos.
				saldos[index].setSaldo(saldos[index].getSaldo() - dinero);

				System.out.println("Se ha actualizado el saldo a " + saldos[index].getSaldo() + " euros.");

			} else {

				System.out.println("No puede retirar más dinero que el saldo que hay en la cuenta.");
			}

		} else {

			System.err.println("El DNI introducido no existe.");
		}

	}

}
