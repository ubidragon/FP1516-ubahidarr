package fp.grados.tipos.test;

import fp.grados.excepciones.ExcepcionEspacioNoValido;
import fp.grados.tipos.Espacio;
import fp.grados.tipos.EspacioImpl;
import fp.grados.tipos.TipoEspacio;
import fp.grados.utiles.Grados;

public class TestEspacio {

	public static void main(String[] args) {
		testConstructorNormal();
		testConstructorExcepcion1();
		testConstructorExcepcion2();
		
		testComparable();
		testIgualdad();
		testLeerFichero();
	}

	private static void testLeerFichero() {

		System.out.println("\nLEERFICHERO");
		
		System.out.println(Grados.createEspacios("espacios.txt"));
		
	}

	private static void testIgualdad() {
		System.out.println("\nTestIgualdad");
		Espacio e1 = new EspacioImpl(TipoEspacio.TEORIA, "A3.10", 109, 3);
		Espacio e2 = new EspacioImpl(TipoEspacio.TEORIA, "A2.10", 109, 3);
		testIgualdad(e1,e2);
	}

	private static void testComparable(){
		System.out.println("\nTestComparable");
		Espacio e1 = new EspacioImpl(TipoEspacio.TEORIA, "A3.10", 109, 3);
		Espacio e2 = new EspacioImpl(TipoEspacio.TEORIA, "A1.10", 109, 3);
		testComparable(e1,e2);
	}
	
	private static void testComparable(Espacio e1, Espacio e2) {
		System.out.println("Espacio 1 " + e1);
		System.out.println("Espacio 2 " + e2);
		if(e1.compareTo(e2) == 0){
			System.out.println("Los espacios son iguales");
		} else if (e1.compareTo(e2) < 0){
			System.out.println("El espacio " + e1 + " va antes que el espacio " + e2);
		} else{
			System.out.println("El espacio " + e1 + " va despues que el espacio " + e2);
		}
	}

	private static void testIgualdad(Espacio e1, Espacio e2) {
		System.out.println("Espacio 1 " + e1);
		System.out.println("Espacio 2 " + e2);
		if(e1.equals(e2)){
			System.out.println("Los espacios son iguales");
		} else {
			System.out.println("Los espacios son distintos");
		}
	}

	private static void testConstructorNormal() {

		testConstructorNormal(TipoEspacio.TEORIA, "A3.10", 109, 3);

	}

	private static void testConstructorExcepcion1() {
		System.out.println("\nProbado capacidad menor que 0");
		testConstructorNormal(TipoEspacio.TEORIA, "A3.10", 109, -1);

	}

	private static void testConstructorExcepcion2() {
		System.out.println("\nProbado capacidad igual a 0");

		testConstructorNormal(TipoEspacio.TEORIA, "A3.10", 109, 0);

	}

	private static void testConstructorNormal(TipoEspacio type, String name,
			Integer stage, Integer capacity) {

		try {

			Espacio espacio = new EspacioImpl(type, name, capacity, stage);
			mostrarEspacio(espacio);

		} catch (ExcepcionEspacioNoValido e) {
			System.out.println("Espacio no valido");
		} catch (Exception e) {
			System.out.println("Excepcion Inesperada");
		}

	}


	private static void mostrarEspacio(Espacio p) {

		System.out.println("\tEspacio: " + p);
		
		System.out.println("\tNombre: " + p.getNombre());
		System.out.println("\tTipo: " + p.getTipo());
		System.out.println("\tPlanta: " + p.getPlanta());
		System.out.println("\tCapacidad: " + p.getCapacidad());
		

	}

}
