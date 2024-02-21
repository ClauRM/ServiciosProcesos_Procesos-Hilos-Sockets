import java.util.Scanner;

public class llavero {

	// variables
	static char valor = ' ';
	static Scanner teclado = new Scanner(System.in);

	// metodos
	static char menu() {
		
		char opcion = ' ';
		System.out.println("Menú de claves:");
		System.out.println("--------------------");
		System.out.println("1-Encriptar mensaje");
		System.out.println("2-Desecriptar mensaje");
		System.out.println("3-Firmar mensaje");
		System.out.println("4-Comprobar firma del mensaje");
		System.out.println("5-Añadir contacto");
		System.out.println("6-Salir");
		System.out.println("\n Escoge una opción (y return):");
		valor = teclado.next().charAt(0);

		System.out.println("Opción " + valor);

		return opcion;
	};

	static void escogerOpcion(char opcion) {
		switch (opcion) {
		case '1': // Encriptar mensaje

			break;
		case '2': // Desecriptar mensaje

			break;
		case '3': // Firmar mensaje

			break;
		case '4': // Comprobar firma del mensaje

			break;
		case '5': // Añadir contacto

			break;
		case '6': // Salir

			break;
		default:
			System.out.println("Opción no válida.");
			break;
		}// Fin del switch

	}// Fin del metodo escogerOpcion

	// main
	public static void main(String[] args) {

		valor = menu();
		escogerOpcion(valor);

	}// Fin metodo main

}// Fin clase llavero
