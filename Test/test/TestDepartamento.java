package fp.grados.tipos.test;

import java.time.LocalDate;

import fp.grados.tipos.Asignatura;
import fp.grados.tipos.AsignaturaImpl;
import fp.grados.tipos.Categoria;
import fp.grados.tipos.Departamento;
import fp.grados.tipos.DepartamentoImpl;
import fp.grados.tipos.Profesor;
import fp.grados.tipos.ProfesorImpl;
import fp.grados.tipos.TipoAsignatura;


public class TestDepartamento {

	public static void main(String[] args) {

		testConstructorNormal();
		
		testDepartamentoAsignatura();
		testDepartamentoProfesor();
		testnuevaAsignatura();
		testeliminaAsignatura();
		testnuevoProfesor();
		testeliminaProfesor();
		testborraTutorias();
		testExisteProfesorAsignado();
		testEstanTodasAsignaturasAsignadas();
		testEliminaAsignacionProfesorado();
		
		testIgualdad();
		testComparable();
		
	}
	/****************************BIDIRECCIONALIDAD***************************************/
	private static void testDepartamentoProfesor() {
		
		System.out.println("\nBIDIRECCIONALIDAD --------------------- DepartamentoProfesor");
		
		Departamento d1 = new DepartamentoImpl("Lenguajes y Sistemas Informaticos");
		Departamento d2 = new DepartamentoImpl ("Ciencias de la Computacion e " + 
		"Inteligencia Artificial");
		Profesor prof = new ProfesorImpl("12345678Z", "Juan", "Nadie Nadie", LocalDate.of(1959, 6, 2),
				"juan.nadie@gmail.es", Categoria.COLABORADOR, d1);
		System.out.println("---------------------------------------------------");
		
		System.out.println("Profesor " + prof + " en " + prof.getDepartamento());
		System.out.println("Añadimos el profesor " + " al departamento " + d2);
		d2.nuevoProfesor(prof);
		System.out.println("---------------------------------------------------");
		
		System.out.println("Cambiamos el departamento" + " del profesor ...");
		prof.setDepartamento(d1);
		System.out.println("---------------------------------------------------");
		muestraDepartamentos (d1, d2);

	}
	private static void testDepartamentoAsignatura() {

		System.out.println("\nBIDIRECCIONALIDAD ----- DepartamentoAsignatura");
		
		Departamento d1 = new DepartamentoImpl("Lenguajes y Sistemas Informaticos");
		Departamento d2 = new DepartamentoImpl ("Ciencias de la Computacion e " + "Inteligencia Artificial");
		Asignatura fp = new AsignaturaImpl ("Fundamentos" + " de Programacion", "2050001", 12.0, 
				TipoAsignatura.ANUAL, 1, d1);
		System.out.println("---------------------------------------------------");
		
		System.out.println("Asignatura " + fp + " en " + fp.getDepartamento());
		System.out.println("Añadimos la asignatura FP " + " al departamento d2");
		d2.nuevaAsignatura(fp);
		System.out.println("---------------------------------------------------");
		
		System.out.println("Cambiamos el departamento" + " de la asignatura FP...");
		fp.setDepartamento(d1);
		System.out.println("---------------------------------------------------");
		muestraDepartamentos (d1, d2);
	
	}
	private static void muestraDepartamentos(Departamento d1, Departamento d2) {
		
		System.out.println(d1 + ":" + d1.getAsignaturas());
		System.out.println(d2 + ":" + d2.getAsignaturas());
		
		System.out.println(d1 + ":" + d1.getProfesores());
		System.out.println(d2 + ":" + d2.getProfesores());
	}
	
	
	private static void testConstructorNormal() {

		System.out.println("TestConstructorNormal");
		
		testConstructor("Lenguajes y Sistemas Informaticos");
		
	}
	private static void testComparable() {
		Departamento d1 = new DepartamentoImpl("Lenguajes y Sistemas Informaticos");
		Departamento d2 = new DepartamentoImpl("Matematica Aplicada");
		
		testComparable(d1,d2);
	}
	private static void testIgualdad() {
		Departamento d1 = new DepartamentoImpl("Lenguajes y Sistemas Informaticos");
		Departamento d2 = new DepartamentoImpl("Matematica Aplicada");
		
		testIgualdad(d1,d2);
	}
	private static void testnuevaAsignatura() {
		
	}

	private static void testeliminaAsignatura() {
		
	}
	
	/****************************BIDIRECCIONALIDAD*************************************/

	private static void testnuevoProfesor() {
		System.out.println("\nAñadir un profesor al departamento");
			
		Departamento d = new DepartamentoImpl("Lenguajes y Sistemas Informaticos");
		
		Profesor prof = new ProfesorImpl("12345678Z", "Juan", "Nadie nadie", LocalDate.of(1959, 6, 2),
				"juan.nadie@us.es", Categoria.COLABORADOR, null);
		
		testnuevoProfesor(d, prof);
		
	}

	private static void testnuevoProfesor(Departamento d,Profesor prof) {

		try{
		System.out.println("El departamento antes de añadir profesor es : " + d);
		System.out.println("El profesor antes de añadirlo al departamento es : " + prof);
		System.out.println("Añadir profesor al departamento : "); d.nuevoProfesor(prof);
		System.out.println("Actualiza la informacion del departamento : " ); prof.setDepartamento(d);
		System.out.println("El profesor" + " < " + d.getProfesores() + " > " + " pertenece al departamento " + " < " + d + " > ");
		} catch (Exception e){
			System.out.println("Excepcion Inesperada");
		}
		
	}
	private static void testeliminaProfesor() {
		System.out.println("\nElimina un profesor al departamento");
			
		Departamento d = new DepartamentoImpl("Lenguajes y Sistemas Informaticos");
		
		Profesor prof = new ProfesorImpl("12345678Z", "Juan", "Nadie nadie", LocalDate.of(1959, 6, 2),
				"juan.nadie@us.es", Categoria.COLABORADOR, null);
		
		Profesor prof2 = new ProfesorImpl("12345678Z", "Maria", "Sola nadie", LocalDate.of(1959, 6, 2),
				"maria.nadie@us.es", Categoria.COLABORADOR, null);
		
		testeliminaProfesor(d, prof, prof2);
	}

	private static void testeliminaProfesor(Departamento d, Profesor prof,
			Profesor prof2) {
		try{
			System.out.println("El departamento antes de añadir profesor es : " + d);
			
			System.out.println("\nAñadir al departamento: " ); d.nuevoProfesor(prof);
			System.out.println("\nEl profesor" + " < " + d.getProfesores() + " > " +
					" pertenece al departamento " + " < " + d + " > ");
			
			System.out.println("\nActualizar departamento : ");prof.setDepartamento(d);
			System.out.println("\nEliminar del departamento profesor asignado: " ); d.eliminaProfesor(prof);
			
			
			System.out.println("\nAñadir otro profesor al departamento"); d.nuevoProfesor(prof2);
			System.out.println("\nEl profesor" + " < " + d.getProfesores() + " > " +
			" pertenece al departamento " + " < " + d + " > ");
			
			} catch (Exception e){
				System.out.println("Excepcion Inesperada");
			}
		
	}
	private static void testborraTutorias() {
		
	}

	private static void testExisteProfesorAsignado() {
		
	}

	private static void testEstanTodasAsignaturasAsignadas() {
		
	}

	private static void testEliminaAsignacionProfesorado() {
		
		
	}

	

	private static void testConstructor(String nombre) {
		try{
		Departamento d = new DepartamentoImpl(nombre);
		mostrarDepartamento(d);
		} catch (Exception e){
			System.out.println("Excecpcion Inesperada");
		}
	}

	private static void testComparable(Departamento d1, Departamento d2) {
		System.out.println("\nDepartamento 1:" + d1);
		System.out.println("\nDepartamento 2:" + d2);
		if(d1.compareTo(d2) == 0){
			System.out.println("Los departamentos son iguales");
			
		} else if (d1.compareTo(d2)<0){
			System.out.println("El departamento " + d1 + " va antes que el departamento " + d2);
		} else {
			System.out.println("El departamento " + "<" + d1 + ">" + " va despues que el departamento " + "<" + d2 + ">");
		}
	}

	private static void testIgualdad(Departamento d1, Departamento d2) {
		System.out.println("\nDepartamento 1:" + d1);
		System.out.println("\nDepartamento 2:" + d2);
		if(d1.equals(d2)){
			System.out.println("Los departamentos son iguales");
			
		} else {
			System.out.println("Los departamentos son distintos");
		}
	}
	


	private static void mostrarDepartamento(Departamento d) {

		System.out.println("Departamento:" + "<" + d + ">");
		
		System.out.println("\nNombre:" + d.getNombre());
		
	}
}
