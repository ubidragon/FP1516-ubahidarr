package fp.grados.tipos.test;

import fp.grados.excepciones.ExcepcionNotaNoValida;
import fp.grados.tipos.Asignatura;
import fp.grados.tipos.AsignaturaImpl;
import fp.grados.tipos.Convocatoria;
import fp.grados.tipos.DepartamentoImpl;
import fp.grados.tipos.NotaImpl;
import fp.grados.tipos.Nota;
import fp.grados.tipos.TipoAsignatura;
import fp.grados.utiles.Grados;

public class TestNota {

	public static void main(String[] args) {

		testConstructor1();
		testConstructor2();

		testConstructorNormal1();

		testConstructorNormal2();

		testConstructor1Excepcion1();

		testConstructor1Excepcion2();

		testConstructor1Excepcion3();

		testConstructor2Excepcion1();

		testConstructor2Excepcion2();
		testLeerFichero();
	}

	private static void testLeerFichero() {

		System.out.println("\nLEERFICHERO");
		
		System.out.println(Grados.leeFichero("notas.txt", x-> new NotaImpl(x)));
	}

	private static void testConstructor1() {

		System.out.println("------------------");
		System.out.println("Test constructor 1");
		System.out.println("------------------");

		// “(0000230) Fundamentos de Programación, 2014-15, PRIMERA, 7.5,
		// NOTABLE”.

		Asignatura as = new AsignaturaImpl("Fundamentos de Programacion",
				"0000230", 12., TipoAsignatura.ANUAL, 1, new DepartamentoImpl(
						"Lenguajes y Sistemas Informaticos"));

		Nota n = new NotaImpl(as, 2014, Convocatoria.PRIMERA, 9., false);
		mostrarNota(n);

	}

	private static void testConstructor2() {

		System.out.println("------------------");
		System.out.println("Test constructor 2");
		System.out.println("------------------");

		Asignatura as = new AsignaturaImpl("Fundamentos de Programacion",
				"0000230", 12., TipoAsignatura.ANUAL, 1, new DepartamentoImpl(
						"Lenguajes y Sistemas Informaticos"));

		Nota n = new NotaImpl(as, 2014, Convocatoria.PRIMERA, 7.5);
		mostrarNota(n);

		System.out.println("Asignatura: " + n.getAsignatura());
		System.out.println("Curso Academico: " + n.getCursoAcademico() + " - "
				+ (n.getCursoAcademico() + 1));
		System.out.println("Convocatoria: " + n.getConvocatoria());
		System.out.println("Valor: " + n.getValor());
		System.out.println("Calificacion: " + n.getCalificacion());
		System.out.println("Mencion de Honor:" + n.getMencionHonor());

	}

	private static void testConstructorNormal1() {

		System.out.println("------------------");
		System.out.println("TestConstructorNormal");
		System.out.println("------------------");

		Asignatura as = new AsignaturaImpl("Fundamentos de Programacion",
				"0000230", 12., TipoAsignatura.ANUAL, 1, new DepartamentoImpl(
						"Lenguajes y Sistemas Informaticos"));
		testConstructorNormal1(as, 2014, Convocatoria.PRIMERA, 9., false);

	}

	private static void testConstructorNormal1(Asignatura as, Integer Course,
			Convocatoria convocatory, Double value, Boolean mencionhonor) {

		try {
			Nota n = new NotaImpl(as, Course, convocatory, value, mencionhonor);
			mostrarNota(n);
		} catch (ExcepcionNotaNoValida e) {
			System.out.println("Nota no valida");
		} catch (Exception e) {
			System.out.println("Excepcion inesperada");
		}

	}

	private static void testConstructorNormal2() {

		System.out.println("------------------");
		System.out.println("TestConstructorNormal2");
		System.out.println("------------------");

		Asignatura as = new AsignaturaImpl("Fundamentos de Programacion",
				"0000230", 12., TipoAsignatura.ANUAL, 1, new DepartamentoImpl(
						"Lenguajes y Sistemas Informaticos"));

		testConstructorNormal2(as, 2014, Convocatoria.PRIMERA, 7.5);

	}

	private static void testConstructorNormal2(Asignatura as, Integer Course,
			Convocatoria convocatory, Double value) {

		try {
			Nota n = new NotaImpl(as, Course, convocatory, value);
			mostrarNota(n);
		} catch (ExcepcionNotaNoValida e) {
			System.out.println("Nota no valida");
		} catch (Exception e) {
			System.out.println("Excepcion inesperada");
		}

	}

	private static void testConstructor1Excepcion1() {
		System.out.println("------------------");
		System.out.println("Si el valor es menor que 0");
		Asignatura as = new AsignaturaImpl("Fundamentos de Programacion",
				"0000230", 12., TipoAsignatura.ANUAL, 1, new DepartamentoImpl(
						"Lenguajes y Sistemas Informaticos"));
		testConstructorNormal1(as, 2014, Convocatoria.PRIMERA, -1., false);

	}

	private static void testConstructor1Excepcion2() {
		System.out.println("------------------");
		System.out.println("Si el valor es mayor que 10");
		Asignatura as = new AsignaturaImpl("Fundamentos de Programacion",
				"0000230", 12., TipoAsignatura.ANUAL, 1, new DepartamentoImpl(
						"Lenguajes y Sistemas Informaticos"));
		testConstructorNormal1(as, 2014, Convocatoria.PRIMERA, 999., false);
	}

	private static void testConstructor1Excepcion3() {
		System.out.println("------------------");
		System.out.println("Si Boolean se inicia con un valor true");
		Asignatura as = new AsignaturaImpl("Fundamentos de Programacion",
				"0000230", 12., TipoAsignatura.ANUAL, 1, new DepartamentoImpl(
						"Lenguajes y Sistemas Informaticos"));
		testConstructorNormal1(as, 2014, Convocatoria.PRIMERA, 5., true);

	}

	private static void testConstructor2Excepcion1() {
		System.out.println("------------------");
		System.out.println("Si el valor es menor que 0");
		Asignatura as = new AsignaturaImpl("Fundamentos de Programacion",
				"0000230", 12., TipoAsignatura.ANUAL, 1, new DepartamentoImpl(
						"Lenguajes y Sistemas Informaticos"));
		testConstructorNormal1(as, 2014, Convocatoria.PRIMERA, -1., false);

	}

	private static void testConstructor2Excepcion2() {
		System.out.println("------------------");
		System.out.println("Si el valor es mayor que 10");
		Asignatura as = new AsignaturaImpl("Fundamentos de Programacion",
				"0000230", 12., TipoAsignatura.ANUAL, 1, new DepartamentoImpl(
						"Lenguajes y Sistemas Informaticos"));
		testConstructorNormal1(as, 2014, Convocatoria.PRIMERA, 999., false);

	}

	private static void mostrarNota(Nota n) {
		System.out.println("------------------");
		System.out.println(n);

	}

}
