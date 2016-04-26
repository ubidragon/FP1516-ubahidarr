package fp.grados.tipos.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import fp.grados.tipos.Asignatura;
import fp.grados.tipos.Despacho;
import fp.grados.tipos.Grado;
import fp.grados.tipos.TipoAsignatura;
import fp.grados.tipos.TipoBeca;
import fp.grados.tipos.TipoEspacio;
import fp.grados.utiles.Grados;

public class TestGrados {

	public static void main(String[] args) {

		testCentro();
		testDespacholeerFichero();
		testEspacio();
		testGrado();
		testAsignatura();
		testBeca();
	}

	private static void testBeca() {

		Grados.createBeca("ORD1234", TipoBeca.EMPRESA);
		Grados.createBeca("ADC9087", TipoBeca.MOVILIDAD);
		Grados.createBeca("OPC9876", TipoBeca.ORDINARIA);
//		System.out.println("\nCuentame las becas: " + Arrays.toString(Grados.getNumBecasTipo()));
		
	}

	private static void testAsignatura() {

		System.out.println("\nASIGNATURAS");

		Grados.createAsignatura("FP", "2050006", 12.0, TipoAsignatura.ANUAL, 1,
				Grados.createDepartamento("LSI"));
		
		System.out.println("Dame la asignatura de un cierto codigo: " + Grados.getAsignaturaCreada("2050007"));
		System.out.println("Codigos asignaturas creadas: " + Grados.getCodigosAsignaturasCreadas());

	}

	private static void testGrado() {

		System.out.println("\n=================Grado");
		try {

			Set<Asignatura> asigOb = new HashSet<>();
			Set<Asignatura> asigOp = new HashSet<>();
			Set<Asignatura> asigOb1 = new HashSet<>();
			Set<Asignatura> asigOp1 = new HashSet<>();

			Asignatura a1 = Grados.createAsignatura(
					"Arquitectura de computadores", "2060001", 20.,
					TipoAsignatura.ANUAL, 2, Grados.createDepartamento("LSI"));

			Asignatura a2 = Grados.createAsignatura(
					"Fundamentos de Programacion", "2080001", 6.,
					TipoAsignatura.PRIMER_CUATRIMESTRE, 2,
					Grados.createDepartamento("LSI"));

			Asignatura a3 = Grados.createAsignatura(
					"Arquitectura del Software", "2080002", 6.,
					TipoAsignatura.PRIMER_CUATRIMESTRE, 2,
					Grados.createDepartamento("LSI"));

			Asignatura a4 = Grados.createAsignatura("Calculo Infinitesimal",
					"2050004", 6., TipoAsignatura.PRIMER_CUATRIMESTRE, 1,
					Grados.createDepartamento("MA1"));
			Asignatura a5 = Grados.createAsignatura(
					"Administracion de Empresa", "2050003", 6.,
					TipoAsignatura.PRIMER_CUATRIMESTRE, 1,
					Grados.createDepartamento("Organizacion Industrial"));
			Asignatura a6 = Grados.createAsignatura("EDC", "2050009", 6.,
					TipoAsignatura.PRIMER_CUATRIMESTRE, 2,
					Grados.createDepartamento("Electronica Digital"));

			asigOb.add(a1);
			asigOp.add(a2);
			asigOb.add(a3);
			asigOb1.add(a4);
			asigOb1.add(a5);
			asigOp1.add(a6);

			Grado g = Grados.createGrado("Ingenieria del Software", asigOb,
					asigOp, 6.);
			Grado g1 = Grados.createGrado("Ingenieria de Computadores",
					asigOb1, asigOp1, 6.);

			System.out.println("Grado " + g);
			System.out.println("Grado 1 " + g1);
			System.out.println("Asignatura Obligatorias " + asigOb);
			System.out.println("Asignatura Optativas " + asigOp);
			System.out.println("Asignatura Obligatorias 1" + asigOb1);
			System.out.println("Asignatura Optativas 1" + asigOp1);
			System.out.println("Media AsignaturasObligatorias "
					+ Grados.getMediaAsignaturasObligatoriasGrados());
			System.out.println("Media AsignaturasOptativas "
					+ Grados.getMediaAsignaturasOptativasGrados());
			System.out.println("Media Conjunta "
					+ Grados.getMediaAsignaturasGrados());
			System.out.println("Numero de Asignaturas "
					+ Grados.getNumAsignaturasCreadas());
			System.out.println("Numero de Grados "
					+ Grados.getNumGradosCreados());
			System.out.println("Grados creados " + Grados.getGradosCreados());
			System.out.println("Asignaturas Creadas: "
					+ Grados.getAsignaturasCreadas());
			System.out.println("Asignatura creada por codigo: "
					+ Grados.getAsignaturaCreada("2050004"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void testEspacio() {
		System.out.println("\n===========================Espacio");

		Grados.createEspacio(TipoEspacio.EXAMEN, "Aula de Examen", 100, 2);
		Grados.createEspacio(TipoEspacio.EXAMEN, "Aula de Examen", 200, 1);
		Grados.createEspacio(TipoEspacio.EXAMEN, "Aula de Examen", 45, 3);

		System.out.println("Planta mayor Espacio "
				+ Grados.getPlantaMayorEspacio());

		System.out.println("Planta menor Espacio "
				+ Grados.getPlantaMenorEspacio());

		System.out.println("NumEspaciosCreados "
				+ (Grados.getNumEspaciosCreados()));

	}

	private static void testDespacholeerFichero() {

		System.out.println("\n==========================LEERFICHERODESPACHO");

		try {

			List<Despacho> d = Grados.createDespachos("despachos.txt");
			System.out.println(d);

		} catch (Exception e) {

			e.printStackTrace();
			throw new IllegalArgumentException();

		}
	}

	private static void testCentro() {

		System.out.println("\n=====================================CENTRO");

		// Grados.createCentro("Escuela Superior de Ing Informatica",
		// "Reina Mercedes", 2, 3);
		//
		// Grados.createCentro("Escuela Politecnica", "Triana", 7, 5);
		//
		// Grados.createCentro("Escuela de Ingenieros", "La Cartuja",
		// 10, 9);

		System.out.println("PLANTAS " + Grados.getMaxPlantas());
		System.out.println("SOTANOS " + Grados.getMaxSotanos());
		System.out.println("Numero de Centros Creados "
				+ Grados.getNumCentrosCreados());
		System.out.println("Media Plantas " + Grados.getMediaPlantas());
		System.out.println("Media Sotanos " + Grados.getMediaSotanos());

	}
}
