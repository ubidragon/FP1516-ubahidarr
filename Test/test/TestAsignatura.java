
package fp.grados.tipos.test;

import fp.grados.excepciones.ExcepcionAsignaturaNoValida;
import fp.grados.tipos.Asignatura;
import fp.grados.tipos.AsignaturaImpl;
import fp.grados.tipos.Departamento;
import fp.grados.tipos.DepartamentoImpl;
import fp.grados.tipos.TipoAsignatura;
import fp.grados.utiles.Grados;

public class TestAsignatura {

	public static void main(String[] args) {
		testConstructorNormal();
		testConstructorExcepcion1();
		testConstructorExcepcion2();
		testConstructorExcepcion3();
		testConstructorExcepcion4();
		testConstructorExcepcion5();
		testConstructorExcepcion6();
		testConstructorExcepcion7();
		testIgualdad();
		testComparable();
		testLeerFichero();
	}
	

	private static void testLeerFichero() {

		System.out.println("\nLeerFichero");
		
		System.out.println(Grados.createAsignaturas("asignaturas.txt"));
		
	}


	/******************************** CASOS DE PRUEBA **************************/
	
	private static void testComparable() {
		System.out.println("\nTestComparables");
		Asignatura a1 = new AsignaturaImpl("Calculo Infinitesimal", "2050004", 6.,
				TipoAsignatura.PRIMER_CUATRIMESTRE, 1, new DepartamentoImpl("Matematica Aplicada I"));
		Asignatura a2 = new AsignaturaImpl("Matematicas Discretas", "2050003", 6., TipoAsignatura.PRIMER_CUATRIMESTRE,1, 
				new DepartamentoImpl("Matematica Aplicada I"));

		testComparable(a1,a2);
	}

	

	private static void testIgualdad() {
		System.out.println("\nTestIgualdad");
		Asignatura a1 = new AsignaturaImpl("Calculo Infinitesimal", "2050004", 6.,
				TipoAsignatura.PRIMER_CUATRIMESTRE, 1, new DepartamentoImpl("Matematica Aplicada I"));
		Asignatura a2 = new AsignaturaImpl("Matematicas Discretas", "2050003", 6., TipoAsignatura.PRIMER_CUATRIMESTRE,1, 
				new DepartamentoImpl("Matematica Aplicada I"));

		testIgualdad(a1,a2);
	}

	private static void testConstructorNormal() {
		System.out
				.println("\n==================================Probando el constructor");
		testConstructor("Fundamentos de Programación","2050001",12.0, TipoAsignatura.ANUAL, 1, 
				new DepartamentoImpl("Lenguajes y Sistemas Informaticos"));
	}

	private static void testConstructorExcepcion1() {
		System.out
		.println("\n==================================Probando el constructor, código de asignatura más largo");
		testConstructor("Fundamentos de Programación","20500010",12.0, TipoAsignatura.ANUAL, 1,new DepartamentoImpl("Lenguajes y Sistemas Informaticos"));
	}
	
	private static void testConstructorExcepcion2() {
		System.out
		.println("\n==================================Probando el constructor, código de asignatura más corto");
		testConstructor("Fundamentos de Programación","205000",12.0, TipoAsignatura.ANUAL, 1,new DepartamentoImpl("Lenguajes y Sistemas Informaticos"));
	}
	
	private static void testConstructorExcepcion3() {
		System.out
				.println("\n==================================Probando el constructor, código de asignatura no numérico");
		testConstructor("Fundamentos de Programación","2A50001",12.0, TipoAsignatura.ANUAL, 1,new DepartamentoImpl("Lenguajes y Sistemas Informaticos"));
	}
	
	private static void testConstructorExcepcion4() {
		System.out
				.println("\n==================================Probando el constructor, créditos incorrectos (0.0)");
		testConstructor("Fundamentos de Programación","2050001",0.0, TipoAsignatura.ANUAL, 1,new DepartamentoImpl("Lenguajes y Sistemas Informaticos"));
	}
		
	private static void testConstructorExcepcion5() {
		System.out
				.println("\n==================================Probando el constructor, créditos incorrectos (-1.0)");
		testConstructor("Fundamentos de Programación","2050001",-1.0, TipoAsignatura.ANUAL, 1,new DepartamentoImpl("Lenguajes y Sistemas Informaticos"));
	}
	
	
	private static void testConstructorExcepcion6() {
		System.out
				.println("\n==================================Probando el constructor, curso menor de 1");
		testConstructor("Fundamentos de Programación","2050001",12.0, TipoAsignatura.ANUAL, -2,new DepartamentoImpl("Lenguajes y Sistemas Informaticos"));
	}
	
	private static void testConstructorExcepcion7() {
		System.out
				.println("\n==================================Probando el constructor, curso mayor de 4");
		testConstructor("Fundamentos de Programación","2050001",12.0, TipoAsignatura.ANUAL, 5,new DepartamentoImpl("Lenguajes y Sistemas Informaticos"));
	}
	
	/******************************** METODOS AUXILIARES **************************/
	
	private static void testConstructor(String nombre, String codigo, Double creditos,
			TipoAsignatura tipo, Integer curso, Departamento departamento) {
		try {
			Asignatura a = new AsignaturaImpl(nombre, codigo, creditos, tipo, curso, departamento);
			mostrarAsignatura(a);
		} catch (ExcepcionAsignaturaNoValida e) {
			System.out
					.println("******************** Se ha capturado la excepción ExcepcionAsignaturaNoValida");
		} catch (Exception e) {
			System.out
					.println("******************** ¡¡¡Se ha capturado una EXCEPCIÓN INESPERADA!!!");
		}
	}

	private static void testComparable(Asignatura a1, Asignatura a2) {
			System.out.println("Asignatura 1:" + "<" + a1 + ">");
			System.out.println("Asignatura 2:" + "<" + a2 + ">");
		if(a1.compareTo(a2) == 0){
			System.out.println("Las asignaturas son iguales");
		} else if(a1.compareTo(a2) < 0){
			System.out.println("La asignatura: " + a1 + " va antes que " + a2);
		} else {
			System.out.println("La asignatura: " + a1 + " va despues que " + a2);
		}

	}
	private static void testIgualdad(Asignatura a1, Asignatura a2) {

			System.out.println("Asignatura 1:" + "<" + a1 + ">");
			System.out.println("Asignatura 2:" + "<" + a2 + ">");
		if(a1.equals(a2)){ 
			System.out.println("Las asignaturas son iguales"); 
		} else { 
			System.out.println("Las asignaturas no son iguales");}
		}


	private static void mostrarAsignatura(Asignatura a) {		
		System.out.println("Asignatura --> <" + a + ">");
		System.out.println("\tNombre: <" + a.getNombre() + ">");
		System.out.println("\tCódigo: <" + a.getCodigo() + ">");
		System.out.println("\tCréditos: <" + a.getCreditos() + ">");
		System.out.println("\tTipo: <" + a.getTipo() + ">");
		System.out.println("\tCurso: <" + a.getCurso() + ">");
		System.out.println("\tAcronimo: " + a.getAcronimo());
	}

}
