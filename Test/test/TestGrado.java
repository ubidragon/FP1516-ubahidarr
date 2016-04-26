package fp.grados.tipos.test;

import java.util.HashSet;
import java.util.Set;

import fp.grados.excepciones.ExcepcionGradoNoValido;
import fp.grados.tipos.Asignatura;
import fp.grados.tipos.AsignaturaImpl;
import fp.grados.tipos.Departamento;
import fp.grados.tipos.DepartamentoImpl;
import fp.grados.tipos.Grado;
import fp.grados.tipos.GradoImpl;
import fp.grados.tipos.GradoImpl2;
import fp.grados.tipos.TipoAsignatura;

public class TestGrado {

	public static void main(String[] args) {

		testConstructorNormal();
		
		testComparable();
		testIgualdad();
		testCreditosPorAsignaturas();
		testDepartamentoPorAsignaturas();
	}

	private static void testDepartamentoPorAsignaturas() {
		Departamento d1 = new DepartamentoImpl("Matematica Aplicada I");
		Departamento d2 = new DepartamentoImpl("Organización Industrial");

		Set<Asignatura> asignaturasObligatorias = new HashSet<Asignatura>();
		Set<Asignatura> asignaturasOptativas = new HashSet<Asignatura>();
		Asignatura a1 = new AsignaturaImpl("Calculo Infinitesimal", "2050004",
				6., TipoAsignatura.PRIMER_CUATRIMESTRE, 1, null);
		Asignatura a2 = new AsignaturaImpl("Administracion de Empresa",
				"2050003", 6., TipoAsignatura.PRIMER_CUATRIMESTRE, 1, null);
		Asignatura a3 = new AsignaturaImpl("FP", "2050005", 6.,
				TipoAsignatura.PRIMER_CUATRIMESTRE, 2, null);
		Asignatura a4 = new AsignaturaImpl("EDC", "2050009", 6.,
				TipoAsignatura.PRIMER_CUATRIMESTRE, 2, null);
		asignaturasObligatorias.add(a1);
		asignaturasObligatorias.add(a3);
		asignaturasOptativas.add(a4);

		Grado g1 = new GradoImpl2("Ingenieria Informatica del Software",
				asignaturasObligatorias, asignaturasOptativas, 6.);
		
		d1.nuevaAsignatura(a1);
		d2.nuevaAsignatura(a2);
		d1.nuevaAsignatura(a3);
		d1.nuevaAsignatura(a4);
		
		System.out.println("\nDepartamentosPorAsignaturas: " + g1.getDepartamentosOrdenadosPorAsignaturas());
		
	}

	private static void testCreditosPorAsignaturas() {
		System.out.println("\nTestCreditosPorAsignaturas");
		
		
		Set <Asignatura> asignaturasObligatorias = new HashSet <Asignatura>();
		Set <Asignatura> asignaturasOptativas = new HashSet <Asignatura>();
		Asignatura a = new AsignaturaImpl("Fundamentos de Programación","2050001",12.0, TipoAsignatura.ANUAL, 1, 
				new DepartamentoImpl("Lenguajes y Sistemas Informaticos"));
		
		Asignatura a1 = new AsignaturaImpl("Matematicas II","2050003",60., TipoAsignatura.PRIMER_CUATRIMESTRE, 1, 
				new DepartamentoImpl("MA1"));
		
		asignaturasOptativas.add(a);
		asignaturasOptativas.add(a1);
		
		
		Grado g1 = new GradoImpl("Ingenieria Informatica del Software", asignaturasObligatorias, asignaturasOptativas, 6.);
		
		
		
		System.out.println(g1.getCreditosPorAsignatura());
		
		
	}

	private static void testComparable() {
		System.out.println("\nTestComparables");
		
		Set <Asignatura> asignaturasObligatorias = new HashSet <Asignatura>();
		Set <Asignatura> asignaturasOptativas = new HashSet <Asignatura>();
		
		Grado g1 = new GradoImpl("Ingenieria Informatica del Software", asignaturasObligatorias, asignaturasOptativas, 6.);
		Grado g2 = new GradoImpl("Ingenieria Informatica de Computadores", asignaturasObligatorias, asignaturasOptativas, 6.);

		testComparable(g1,g2);
	}

	

	private static void testComparable(Grado g1, Grado g2) {
		System.out.println("Grado 1:" + g1);
		System.out.println("Grado 2:" + g2);
		
		if(g1.compareTo(g2) == 0){
			System.out.println("Los grados son iguales");
		} else if (g1.compareTo(g2) <0) {
			System.out.println("El grado " + g1 + "va antes que el grado" + g2);
			
		} else {
			System.out.println("El grado " + g1 + "va despues que el grado" + g2);
		}
	}

	private static void testIgualdad() {
		System.out.println("\nTestIgualdad");
		Set <Asignatura> asignaturasObligatorias = new HashSet <Asignatura>();
		Set <Asignatura> asignaturasOptativas = new HashSet <Asignatura>();
		
		Grado g1 = new GradoImpl("Ingenieria Informatica del Software", asignaturasObligatorias, asignaturasOptativas, 60.);
		Grado g2 = new GradoImpl("Ingenieria Informatica del Software", asignaturasObligatorias, asignaturasOptativas, 60.);

		testIgualdad(g1,g2);
	}

	private static void testIgualdad(Grado g1, Grado g2) {

		System.out.println("Grado 1:" + g1);
		System.out.println("Grado 2:" + g2);
		
		if(g1.equals(g2)){
			System.out.println("Los grados son iguales");
		} else {
			System.out.println("Los grados son distintos");
		}
	}

	private static void testConstructorNormal() {
		System.out.println("\n=======================================Probando Constructor");
		
		Set <Asignatura> asignaturasObligatorias = new HashSet <Asignatura>();
		Set <Asignatura> asignaturasOptativas = new HashSet <Asignatura>();
		
		testConstructor("Ingenieria Informatica del Software", asignaturasObligatorias, asignaturasOptativas, 60.);
		
	}

	private static void testConstructor(String nombre,
			Set<Asignatura> asignaturasObligatorias,
			Set<Asignatura> asignaturasOptativas, Double numerominimocreditos) {

		try{
			Grado g = new GradoImpl(nombre, asignaturasOptativas, asignaturasOptativas, numerominimocreditos);
			mostrarGrado(g);
		} catch (ExcepcionGradoNoValido e) {
			System.out.println("Excepcion Grado No Valido");
		} catch (Exception e){
			System.out.println("Excepcion inesperada");
		}
		
	}

	private static void mostrarGrado(Grado g) {
		System.out.println("\tGrado: " + g);
		System.out.println("\tNombre:" + g.getNombre());
		System.out.println("\tAsignaturasObligatorias: " + g.getAsignaturasObligatorias());
		System.out.println("\nAsignaturasOptativas: " + g.getAsignaturasOptativas());
		System.out.println("\tProfesores: " + g.getProfesores());
		System.out.println("\tTotalCreditos: " + g.getNumeroTotalCreditos());
		System.out.println("\tNumeroMinimoCreditosOptativas:" + g.getNumeroMinimoCreditosOptativas());
		System.out.println("\tDepartamentos" + g.getDepartamentos());
	}

}
