package fp.grados.tipos.test;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import fp.grados.excepciones.ExcepcionTutoriaNoValida;
import fp.grados.tipos.Tutoria;
import fp.grados.tipos.TutoriaImpl;
import fp.grados.utiles.Grados;

public class TestTutoria {

	public static void main(String[] args) {
		
		testConstructorNormal1();
		
		testConstructor1Excepcion1();
		
		testConstructorNormal2();
		

		testConstructor2Excepcion1();
		
		testConstructor2Excepcion2();

		testIgualdad1();
		testComparable1();
		
		testIgualdad2();
		testComparable2();
		
		testLeerFichero();
	}
	
	private static void testLeerFichero(){
		System.out.println("\nLeerFichero");
		
		try{
			System.out.println(Grados.leeFichero("res/tutorias.txt", x-> new TutoriaImpl(x)));
		}catch(Exception e){
			e.printStackTrace();
			
		}
		}

	private static void testComparable1() {
		System.out.println("\nTestComparable 1");
		Tutoria t1 = new TutoriaImpl (DayOfWeek.WEDNESDAY, LocalTime.of(10, 30),
				LocalTime.of(12, 30));
		Tutoria t2 = new TutoriaImpl (DayOfWeek.WEDNESDAY, LocalTime.of(11, 30),
				LocalTime.of(12, 30));
		testComparable(t1,t2);
	}

	private static void testIgualdad1() {
		System.out.println("\nTestIgualdad 1");
		Tutoria t1 = new TutoriaImpl (DayOfWeek.WEDNESDAY, LocalTime.of(10, 30),
				LocalTime.of(12, 30));
		Tutoria t2 = new TutoriaImpl (DayOfWeek.WEDNESDAY, LocalTime.of(11, 30),
				LocalTime.of(12, 30));
		testIgualdad(t1,t2);
	}

	private static void testIgualdad2() {
		System.out.println("\nTestIgualdad 2");		
		Tutoria t1 = new TutoriaImpl (DayOfWeek.WEDNESDAY, LocalTime.of(10, 30),
				15);
		Tutoria t2 = new TutoriaImpl (DayOfWeek.WEDNESDAY, LocalTime.of(10, 30),
				45);

		testIgualdad(t1,t2);
		
	}

	private static void testComparable2() {
		System.out.println("\nTestComparable 2");
		LocalTime HoraComienzo = LocalTime.of(10, 30);
		Tutoria t1 = new TutoriaImpl (DayOfWeek.WEDNESDAY, HoraComienzo,
				15);
		Tutoria t2 = new TutoriaImpl (DayOfWeek.WEDNESDAY, HoraComienzo,
				45);

		testComparable(t1,t2);
	}

	

	private static void testComparable(Tutoria t1, Tutoria t2) {
		System.out.println("Tutoria 1:" + "<" + t1 + ">");
		System.out.println("Tutoria 2:" + "<" + t2 + ">"); 
		
		if(t1.compareTo(t2) == 0){
			System.out.println("Las asignaturas son iguales");
		} else if(t1.compareTo(t2) < 0){
			System.out.println("\nLa asignatura: " + t1 + " va antes que " + t2);
		} else {
			System.out.println("\nLa asignatura: " + t1 + " va despues que " + t2);
		}
	}
	
	private static void testIgualdad(Tutoria t1, Tutoria t2) {
		System.out.println("\nTutoria 1:" + "<" + t1 + ">");
		System.out.println("\nTutoria 2:" + "<" + t2 + ">");
	if(t1.equals(t2)){ 
		System.out.println("\nLas tutorias son iguales"); 
	} else { 
		System.out.println("\nLas tutorias no son iguales");}
	}
	
	private static void testConstructorNormal1() {
		
		System.out.println("---------------------------");
		System.out.println("\nTestConstructorNormal1");
		
		LocalTime HoraComienzo = LocalTime.of(10, 30);
		LocalTime HoraFin = LocalTime.of(12, 30);
		
		testConstructorNormal1(DayOfWeek.WEDNESDAY, HoraComienzo,
				HoraFin);
		
	}

	private static void testConstructor1Excepcion1() {
		
		System.out.println("---------------------------");
		
		System.out.println("\nProbar Test DiaSemana Distinto a Lunes...Viernes");
		
		LocalTime HoraComienzo = LocalTime.of(10, 30);
		LocalTime HoraFin = LocalTime.of(12, 30);
		
		testConstructorNormal1(DayOfWeek.SATURDAY, HoraComienzo,
				HoraFin);
		
	}
	
	private static void testConstructorNormal2() {

		System.out.println("---------------------------");
		System.out.println("\nTestConstructorNormal2");
		
		
		testConstructorNormal2(DayOfWeek.WEDNESDAY, LocalTime.of(10, 30),
				45);
		
	}
	private static void testConstructor2Excepcion1() {
		System.out.println("---------------------------");
		System.out.println("\nProbar Test DiaSemana Distinto a Lunes...Viernes");
		
		LocalTime HoraComienzo = LocalTime.of(10, 30);
		LocalTime HoraFin = LocalTime.of(12, 30);
		
		testConstructorNormal1(DayOfWeek.SUNDAY, HoraComienzo,
				HoraFin);
	}

	private static void testConstructor2Excepcion2() {
		
		System.out.println("---------------------------");
		
		System.out.println("\nDuracion menor de 15 minutos");
		
		LocalTime HoraComienzo = LocalTime.of(10, 30);
		LocalTime HoraFin = LocalTime.of(10, 35);
		
		testConstructorNormal2(DayOfWeek.WEDNESDAY, HoraComienzo,
				(int) HoraComienzo
				.until(HoraFin, ChronoUnit.MINUTES));
		
		
	}
	

	private static void testConstructorNormal1(DayOfWeek DiaSemana,
			LocalTime horaComienzo, LocalTime horaFin) {
		
		try {
			
			Tutoria tutoria = new TutoriaImpl (DiaSemana, horaComienzo, horaFin);
			mostrarTutoria(tutoria);
			
		} catch (ExcepcionTutoriaNoValida e){
			System.out.println("Tutoria no valida");
		} catch (Exception e){
			System.out.println("Excepcion inesperada");
		}
		
		
		
	}
	
	private static void testConstructorNormal2(DayOfWeek DiaSemana,
			LocalTime horaComienzo, Integer Duracion) {
		
		try {
			
			Tutoria tutoria = new TutoriaImpl (DiaSemana, horaComienzo, Duracion);
			mostrarTutoria(tutoria);
		} catch (ExcepcionTutoriaNoValida e){
			System.out.println("Tutoria no valida");
		} catch (Exception e){
			System.out.println("Excepcion inesperada");
		}
		
	}
	
	private static void mostrarTutoria(Tutoria tutoria) {
		
		System.out.println("\tTutoria: " + tutoria);
		System.out.println("\tDia de la Semana : "
				+ ((TutoriaImpl) tutoria).getD());
		System.out.println("\tHora de Comienzo : " + tutoria.getHoraComienzo());
		System.out.println("\tHora de Fin : " + tutoria.getHoraFin());
		System.out.println("\tDuracion : " + tutoria.getDuracion() + " Minutos");
	}
}
