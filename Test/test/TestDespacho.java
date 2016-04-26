package fp.grados.tipos.test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import fp.grados.excepciones.ExcepcionDespachoNoValido;
import fp.grados.tipos.Categoria;
import fp.grados.tipos.DepartamentoImpl;
import fp.grados.tipos.Despacho;
import fp.grados.tipos.DespachoImpl;
import fp.grados.tipos.Profesor;
import fp.grados.tipos.ProfesorImpl;
import fp.grados.tipos.TipoEspacio;
import fp.grados.utiles.Grados;

public class TestDespacho {

	public static void main(String[] args) {

		
		testConstructorNormal1();
		testConstructorNormal2();
		testConstructorNormal3();

		testConstructorExcepcion1();
		testConstructorExcepcion2();
		testLeeDespacho();
	}

	
	private static void testLeeDespacho() {
		System.out.println("\nLEEME LOS DESPACHOS");
		System.out.println(Grados.createDespachos("despachos.txt"));
	}


	/******************************CASOS DE PRUEBA ***********************************************/
	private static void testConstructorNormal1() {
		System.out.println("-----------------------");
		System.out.println("testConstructorNormal1");
		System.out.println("------------------------");

		Profesor p = new ProfesorImpl("28200400P", "María", "Martín Oviedo",
				LocalDate.of(1985, 05, 21),"maria.oviedo@us.es", Categoria.TITULAR, 
				new DepartamentoImpl("Lenguajes y Sistemas Informaticos"));

		Profesor m = new ProfesorImpl("33123210J", "Jorge",
				"Vegarredonda Ordiales", LocalDate.of(1990, 11, 25),
				"jorge.ordiales@us.es", Categoria.CONTRATADO_DOCTOR, 
				new DepartamentoImpl("Lenguajes y Sistemas Informaticos"));

		Set<Profesor> profesores = new HashSet<Profesor>();
		profesores.add(p);
		profesores.add(m);
		testConstructor("M2.25", 5, 2, profesores);
	}

	private static void testConstructorNormal2() {
		System.out.println("-----------------------");
		System.out.println("testConstructorNormal2");
		System.out.println("------------------------");

		Profesor profesor = new ProfesorImpl("33123210J", "Jorge",
				"Vegarredonda Ordiales", LocalDate.of(1990, 11, 25),
				"jorge.ordiales@us.es", Categoria.CONTRATADO_DOCTOR, 
				new DepartamentoImpl("Lenguajes y Sistemas Informaticos"));
		
		testConstructor("M2.25", 16, 2, profesor);
	}


	private static void testConstructorNormal3() {
		System.out.println("-----------------------");
		System.out.println("testConstructorNormal3");
		System.out.println("------------------------");
		
		testConstructor("M2.25", 16, 2);

	}

	private static void testConstructorExcepcion1() {

		System.out.println("-----------------------");
		System.out
				.println("testConstructorExcepcion1 ======= "
						+ "Si el numero de profesores es mayor que la capacidad del despacho");
		System.out.println("------------------------");

		Profesor p = new ProfesorImpl("28200400P", "María", "Martín Oviedo",
				LocalDate.of(1985, 05, 21),"maria.oviedo@us.es", Categoria.TITULAR, 
				new DepartamentoImpl("Lenguajes y Sistemas Informaticos"));

		Profesor m = new ProfesorImpl("33123210J", "Jorge",
				"Vegarredonda Ordiales", LocalDate.of(1990, 11, 25),
				"jorge.ordiales@us.es", Categoria.CONTRATADO_DOCTOR, 
				new DepartamentoImpl("Lenguajes y Sistemas Informaticos"));
		
		HashSet<Profesor> profesores = new HashSet<Profesor>();
		profesores.add(p);
		profesores.add(m);

		testConstructor("M2.25", 1, 2, profesores);

	}
	

	private static void testConstructorExcepcion2() {
		System.out.println("-----------------------");
		System.out.println("testConstructorExcepcion2");
		System.out.println("------------------------");
		
		Despacho d = new DespachoImpl ("M2.25", 16, 2);
		testSetEspacio(d, TipoEspacio.LABORATORIO);
		
		
	}

	private static void testSetEspacio(Despacho d, TipoEspacio espacio) {

		
		try {
			System.out.println("El despacho anterior es: " + d.getTipo());
			System.out.println("El nuevo despacho es: " + espacio);
			d.setTipo(espacio);
			System.out.println("El despacho despues de la operacion es: " + d.getTipo());
		} catch (UnsupportedOperationException e) {
			System.out.println("ExcepcionDespachoNoValido");
		} catch (Exception e) {
			System.out.println("Excepcion Inesperada");
		}

		
	}

	private static void testConstructor(String name,
			Integer capacity, Integer stage, Set <Profesor> profesores) {

		try {
			Despacho d = new DespachoImpl(name, capacity, stage,
					profesores);
			mostrarDespacho(d);
		} catch (ExcepcionDespachoNoValido e) {
			System.out.println("ExcepcionDespachoNoValido");
		} catch (Exception e) {
			System.out.println("Excepcion Inesperada");
		}

	}
	private static void testConstructor(String name,
			Integer capacity, Integer stage, Profesor profesor) {

		try {
			Despacho d = new DespachoImpl(name, capacity, stage,
					profesor);
			mostrarDespacho(d);
		} catch (ExcepcionDespachoNoValido e) {
			System.out.println("ExcepcionDespachoNoValido");
		} catch (Exception e) {
			System.out.println("Excepcion Inesperada");
		}
		

		
	}
	
	private static void testConstructor(String name, Integer capacity,
			Integer stage) {
		try {
			Despacho d = new DespachoImpl (name, capacity, stage);
			mostrarDespacho(d);
		} catch (ExcepcionDespachoNoValido e) {
			System.out.println("ExcepcionDespachoNoValido");
		} catch (Exception e) {
			System.out.println("Excepcion Inesperada");
		}
		
	}
	
	private static void mostrarDespacho(Despacho d){
		System.out.println(d);
	}

	
}
