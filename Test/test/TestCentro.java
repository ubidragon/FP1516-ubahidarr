package fp.grados.tipos.test;


import java.time.LocalDate;

import fp.grados.excepciones.ExcepcionCentroNoValido;
import fp.grados.tipos.Categoria;
import fp.grados.tipos.Centro;
import fp.grados.tipos.CentroImpl;
import fp.grados.tipos.DepartamentoImpl;
import fp.grados.tipos.Despacho;
import fp.grados.tipos.DespachoImpl;
import fp.grados.tipos.Profesor;
import fp.grados.tipos.ProfesorImpl;

public class TestCentro {

	public static void main(String[] args) {
		testConstructorNormal();
		testIgualdad();
		testComparable();
		testConstructorSotanosExcepcion();
		testConstructorPlantasExcepcion();

//		testnuevoEspacio();
//		testeliminaEspacio();
//
//		testConteosEspacios();
//
//		testDespachos();
//		testDespachosDepartamento();
//
//		testProfesores();
//		testProfesoresDepartamento();
//
//		testEspacioMayorCapacidad();
		testDespachoPorProfesor();
	}

	private static void testDespachoPorProfesor() {
		
		System.out.println("\ntestDespachoporProfesor");
		
		Centro c = new CentroImpl("Escuela Superior de Ingenieria Informatica", 
				"Avenida Reina Mercedes", 6,3);

		
		Profesor p1 = new ProfesorImpl("52758896R", "María", "MartinOviedo", 
				LocalDate.of(1985, 05, 21),"maria.martin@us.es", Categoria.TITULAR, 
				new DepartamentoImpl("LSI"));
		Profesor p2 = new ProfesorImpl("97454425K", "Luisa", "Martin", LocalDate.of(1964, 1, 1), 
				"maria.martin@us.es", 
				Categoria.TITULAR, new DepartamentoImpl("LSI"));
		Profesor p3 = new ProfesorImpl("70529664A", "Pepa", "Oviedo", LocalDate.of(1964, 2, 1), 
				"maria.martin@us.es", 
				Categoria.COLABORADOR,new DepartamentoImpl("MA1"));
		Despacho d1 = new DespachoImpl("I3.25", 5, 2, c.getProfesores());
		Despacho d2 = new DespachoImpl("M4.25", 5, 2, c.getProfesores());
		
		c.nuevoEspacio(d1);
		c.nuevoEspacio(d2);
		
		d1.getProfesores().add(p1);
		d2.getProfesores().add(p2);
		d1.getProfesores().add(p3);
		
		testDespachoPorProfesor(c);
	}

	private static void testDespachoPorProfesor(Centro c) {
		
		System.out.println("Centro " + c);
		
		System.out.println("\nDespachosporprofesor " + c.getDespachosPorProfesor());
		
	}

	private static void testConstructorNormal() {
		System.out.println("Test Constructor Normal");

		testConstructor("Escuela Superior de Ingenieria Informatica",
				"Avenida Reina Mercedes", 3, 1);
	}

	private static void testComparable() {
		System.out.println("\nTestComparable");

		Centro c1 = new CentroImpl(
				"Escuela Superior de Ingenieria Informatica",
				"Avenida Reina Mercedes", 3, 1);
		Centro c2 = new CentroImpl("Escuela Politecnica de Ingenieros",
				"La Cartuja", 3, 1);

		testComparable(c1, c2);

	}

	private static void testIgualdad() {
		System.out.println("\nTestIgualdad");

		Centro c1 = new CentroImpl(
				"Escuela Superior de Ingenieria Informatica",
				"Avenida Reina Mercedes", 3, 1);
		Centro c2 = new CentroImpl(
				"Escuela Superior de Ingenieria Informatica",
				"Avenida Reina Mercedes", 3, 1);

		testIgualdad(c1, c2);
	}

	private static void testConstructorSotanosExcepcion() {
		System.out
				.println("\n===========================Probando Sotanos Mayores que 0");
		testConstructor("Escuela Superior de Ingenieria Informatica",
				"Avenida Reina Mercedes", 3, 4);

	}

	private static void testConstructorPlantasExcepcion() {
		System.out
				.println("\n===========================Probando Plantas Menores que 0");
		testConstructor("Escuela Superior de Ingenieria Informatica",
				"Avenida Reina Mercedes", -2, 1);
	}

	private static void testConstructor(String nombre, String direccion,
			Integer numeroPlantas, Integer numeroSotanos) {
		try {
			Centro c = new CentroImpl(nombre, direccion, numeroPlantas,
					numeroSotanos);
			mostrarCentro(c);
		} catch (ExcepcionCentroNoValido e) {
			System.out.println("Excepcion Centro No Valido");
		} catch (Exception e) {
			System.out.println("Excepcion Inesperada");
		}
	}

	private static void testIgualdad(Centro c1, Centro c2) {

		System.out.println("Centro 1:" + "<" + c1 + ">");
		System.out.println("Centro 2:" + "<" + c2 + ">");
		System.out.println("¿Son iguales?:" + "<" + c1.equals(c2) + ">");

		if (c1.equals(c2)) {
			System.out.println("Los centros son iguales");
		} else {

			System.out.println("Los centros no son iguales");

		}
	}

	private static void testComparable(Centro c1, Centro c2) {
		System.out.println("Centro 1:" + "<" + c1 + ">");
		System.out.println("Centro 2:" + "<" + c2 + ">");

		if (c1.compareTo(c2) == 0) {
			System.out.println("Los centros son iguales");
		} else if (c1.compareTo(c2) < 0) {
			System.out.println("El centro: " + c1 + "\nva antes que el centro:"
					+ c2);
		} else {
			System.out.println("El centro: " + c1
					+ "\nva despues que el centro:" + c2);
		}
	}

	private static void mostrarCentro(Centro c) {
		System.out.println("\tCentro:" + "<" + c + ">");
		System.out.println("\n");
		System.out.println("\tNombre:" + "<" + c.getNombre() + ">");
		System.out.println("\tDireccion:" + "<" + c.getDireccion() + ">");
		System.out.println("\tNumeroDePlantas:" + "<" + c.getNumeroPlantas()
				+ ">");
		System.out.println("\tNumeroDeSotanos:" + "<" + c.getNumeroSotanos()
				+ ">");
	}
}
