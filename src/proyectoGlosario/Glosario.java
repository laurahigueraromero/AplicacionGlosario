package proyectoGlosario;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Glosario {
	private Map<String, String> terminos;
	private Map<String, String> contenidos = new HashMap<>();

	public Glosario() {
		terminos = new HashMap<>();
		cargarTerminos();

	}

	public void cargarTerminos() {

		terminos.put("Java",
				"Java es un lenguaje de programación orientado a objetos, de alto nivel y ampliamente utilizado.");
		terminos.put("SQL", "SQL (Structured Query Language) es un lenguaje estándar para gestionar bases de datos.");
		terminos.put("JavaScript",
				"JavaScript es un lenguaje de programación que se usa principalmente para la creación de páginas web interactivas.");
		terminos.put("HTML",
				"HTML (HyperText Markup Language) es el lenguaje estándar para crear y diseñar páginas web.");
	}

	public void TerminosIncluidos(String termino, String definicion) {

		incluirTerminos();
		System.out.println("Definición de " + termino + ": " + definicion);
	}

	public String obtenerDefinicion(String termino) {
		return terminos.get(termino);
	}

	public void definiciones() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Escriba el lenguaje del que quiera saber(Java, SQL, JavaScript, HTML)");
		String termino = sc.nextLine().trim();

		String definicion = obtenerDefinicion(termino);

		System.out.println("Definición de " + termino + ": " + definicion);

	}

	public void incluirTerminos() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Escribir término:");
		String termino = sc.nextLine();
		System.out.println("Escribir definición:");
		String definicion = sc.nextLine();

		contenidos.put(termino, definicion); // Agregar al mapa global
		System.out.println("Definición de " + termino + ": " + definicion);

	}

	public void nuevosTerminos() {
		Scanner sc = new Scanner(System.in);
		incluirTerminos();

		System.out.println("Exportar? ");
		String respuesta = sc.nextLine();
		if (respuesta.equalsIgnoreCase("si")) {
			exportarGlosario();
		}
	}

	private void exportarGlosario() {
		String rutaArchivo = "/Users/laurahigueraromero/Desktop/proyectosTochos/Glosario/glosario.txt";

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo, true))) {
			for (Map.Entry<String, String> entry : contenidos.entrySet()) {
				writer.write("Definición de "+entry.getKey() + ": " + entry.getValue()); // Escribir término y definición
				writer.newLine();
				writer.write("----------------------Concepto glosario:------------------------------");
				writer.newLine();
			}
			System.out.println("Concepto guardado en el archivo.");
		} catch (IOException e) {
			System.out.println("Error al guardar el archivo: " + e.getMessage());
		}

	}

}
