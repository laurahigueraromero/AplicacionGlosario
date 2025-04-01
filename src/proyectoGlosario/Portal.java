package proyectoGlosario;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Portal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int eleccion;

		Glosario glosario = new Glosario();

		do {
			System.out.println("escoja: \n1.Incluir Conceptos al glosario\n2.Visualizar ejemplos de glosario\n3.Salir");

			eleccion = sc.nextInt();
			sc.nextLine();

			switch (eleccion) {
			case 1:
				glosario.nuevosTerminos();
				break;
			case 2:
				glosario.definiciones();
				break;
			case 3:
				System.out.println("Saliendo del programa...");
				break;
			default:
				System.out.println("Opción no válida, intente de nuevo.");
			}

		} while (eleccion != 3);

	}

}
