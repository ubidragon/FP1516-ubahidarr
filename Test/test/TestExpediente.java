package fp.grados.tipos.test;


import java.time.LocalDate;

import fp.grados.excepciones.ExcepcionExpedienteOperacionNoPermitida;
import fp.grados.tipos.Alumno;
import fp.grados.tipos.AlumnoImpl;
import fp.grados.tipos.Asignatura;
import fp.grados.tipos.AsignaturaImpl;
import fp.grados.tipos.Convocatoria;
import fp.grados.tipos.Departamento;
import fp.grados.tipos.DepartamentoImpl;
import fp.grados.tipos.Expediente;
import fp.grados.tipos.ExpedienteImpl;
import fp.grados.tipos.ExpedienteImpl2;
import fp.grados.tipos.Nota;
import fp.grados.tipos.NotaImpl;
import fp.grados.tipos.TipoAsignatura;

public class TestExpediente {

	public static void main(String[] args) {
		testConstructorNormal();
		testnuevaNota();
		testNotaMedia();
		testnuevaNotaExcepcion1();
		testnuevaNotaExcepcion2();
		testNotaMediaExcepcion();
		testIgualdad();
//		testCambiarNota();
		testMejorNota();
	}
	
	private static void testMejorNota() {

		System.out.println("\nMejorNota");
		
		Expediente ex = new ExpedienteImpl();
		Alumno al = new AlumnoImpl("30254347D", "Angel", "Delgado",
				LocalDate.of(1994, 3, 15), "angdellun@alum.us.es");
		Departamento d = new DepartamentoImpl("Lenguajes y Sistemas Informaticos");
		Asignatura asig = new AsignaturaImpl("Fundamentos de Programacion", "2050011", 12., TipoAsignatura.ANUAL, 1, 
				null);
		d.nuevaAsignatura(asig);
		Asignatura asig2 = new AsignaturaImpl("ADDA", "2050012", 12., TipoAsignatura.ANUAL, 1, 
				null);
		d.nuevaAsignatura(asig2);
		
		Nota n1 = new NotaImpl(asig, 2014, Convocatoria.PRIMERA, 10., true);
		
		Nota n2 = new NotaImpl(asig2, 2014, Convocatoria.SEGUNDA, 10., false);
		al.matriculaAsignatura(asig);
		
		ex.nuevaNota(n1);
		ex.nuevaNota(n2);
		
		
		System.out.println("Enseñame nota 1: " + n1);
		System.out.println("Enseñame nota 2: " + n2);
		System.out.println("Enseñame las notas del expediente: " + ex.getNotas());
		System.out.println("Mejor nota: " + ex.getMejorNota());
		System.out.println("Asignaturas ordenadas por asignatura: " + ex.getNotasOrdenadasPorAsignatura());
		
		
	}

	private static void testIgualdad() {

		System.out.println("\n==========================TestIgualdad");
		
		Expediente e1 = new ExpedienteImpl();
		Expediente e2 = new ExpedienteImpl();
		
		testIgualdad(e1,e2);
		
	}
	private static void testIgualdad(Expediente e1, Expediente e2) {

		mostrarExpediente(e1);
		System.out.println("\n");
		mostrarExpediente(e2);
		if(e1.equals(e2)){
			System.out.println("Los expedientes son iguales");
		} else {
			System.out.println("Los expedientes son distintos");
		}
		
	}
	
	
	private static void testnuevaNotaExcepcion1() {
		System.out.println("\n========================Nota de distinas asignaturas");
		Nota n1 = new NotaImpl(new AsignaturaImpl("Fundamentos de Programacion", "2050011", 12., TipoAsignatura.ANUAL, 1, 
				new DepartamentoImpl("Lenguajes y Sistemas Informaticos")), 2014, Convocatoria.PRIMERA, 9.);
		
		Nota n2 = new NotaImpl(new AsignaturaImpl("Matematicas Discretas", "2050001", 12., TipoAsignatura.ANUAL, 1, 
				new DepartamentoImpl("Matematicas Aplicadas 1")), 2014, Convocatoria.SEGUNDA, 8.);
		Nota n3 = new NotaImpl(new AsignaturaImpl("Fundamentos de Programacion", "2050111", 12., TipoAsignatura.ANUAL, 1, 
				new DepartamentoImpl("Lenguajes y Sistemas Informaticos")), 2014, Convocatoria.TERCERA, 6.);
		
		testnuevaNota(n1, n2, n3);
	}


	private static void testnuevaNotaExcepcion2() {
		System.out.println("\n=========================Nota de distintos cursos academicos");
		Nota n1 = new NotaImpl(new AsignaturaImpl("Fundamentos de Programacion", "2050011", 12., TipoAsignatura.ANUAL, 1, 
				new DepartamentoImpl("Lenguajes y Sistemas Informaticos")), 2015, Convocatoria.PRIMERA, 9.);
		
		Nota n2 = new NotaImpl(new AsignaturaImpl("Fundamentos de Programacion", "2050001", 12., TipoAsignatura.ANUAL, 1, 
				new DepartamentoImpl("Lenguajes y Sistemas Informaticos")), 2015, Convocatoria.SEGUNDA, 8.);
		
		Nota n3 = new NotaImpl(new AsignaturaImpl("Fundamentos de Programacion", "2050111", 12., TipoAsignatura.ANUAL, 1, 
				new DepartamentoImpl("Lenguajes y Sistemas Informaticos")), 2014, Convocatoria.TERCERA, 6.);
		
		testnuevaNota(n1, n2, n3);
	}
	
	private static void testConstructorNormal() {

		testConstructor();
		
	}

	private static void testnuevaNota() {
		
		System.out.println("\n===================================NuevanotaTest");
		
		Nota n1 = new NotaImpl(new AsignaturaImpl("Fundamentos de Programacion", "2050011", 12., TipoAsignatura.ANUAL, 1, 
				new DepartamentoImpl("Lenguajes y Sistemas Informaticos")), 2014, Convocatoria.PRIMERA, 9.);
		
		Nota n2 = new NotaImpl(new AsignaturaImpl("Fundamentos de Programacion", "2050011", 12., TipoAsignatura.ANUAL, 1, 
				new DepartamentoImpl("Lenguajes y Sistemas Informaticos")), 2014, Convocatoria.SEGUNDA, 9.);
		
		
		Nota n3 = null;
		
		testnuevaNota(n1, n2, n3);
		
	}

	
	private static void testNotaMedia() {
	
		System.out.println("\n=====================================NotaMediaTest");		

		
		Nota n = new NotaImpl(new AsignaturaImpl("Fundamentos de Programacion", "2050011", 12., TipoAsignatura.ANUAL, 1, 
				new DepartamentoImpl("Lenguajes y Sistemas Informaticos")), 2014, Convocatoria.PRIMERA, 9.);
		Nota n2 = new NotaImpl(new AsignaturaImpl("Fundamentos de Programacion", "2050011", 12., TipoAsignatura.ANUAL, 1, 
				new DepartamentoImpl("Lenguajes y Sistemas Informaticos")), 2014, Convocatoria.SEGUNDA, 8.5);
		
		testNotaMedia(n,n2);
	}
	
	private static void testNotaMediaExcepcion() {
		System.out.println("\n=====================================NotaMediaTestExcepcion");		

		
		Nota n = new NotaImpl(new AsignaturaImpl("Fundamentos de Programacion", "2050011", 12., TipoAsignatura.ANUAL, 1, 
				new DepartamentoImpl("Lenguajes y Sistemas Informaticos")), 2014, Convocatoria.PRIMERA, 9.);
		Nota n2 = new NotaImpl(new AsignaturaImpl("Matematicas Discretas", "2050012", 12., TipoAsignatura.ANUAL, 1, 
				new DepartamentoImpl("Lenguajes y Sistemas Informaticos")), 2014, Convocatoria.SEGUNDA, 3.5);
		
		testNotaMedia(n,n2);
	}
	
	private static void testConstructor() {
		try{
		Expediente e = new ExpedienteImpl();
		mostrarExpediente(e); 
		} catch (Exception e){
			System.out.println("Excepcion Inesperada");
		}
	}
	private static void testnuevaNota(Nota n, Nota n2, Nota n3) {

		try{
			Expediente ex = new ExpedienteImpl();
			System.out.println("La nota antes de la operacion es: " + n);
			System.out.println("La segunda nota antes de la operacion es:" + n2);
			System.out.println("Agregar la nota a la lista de notas : " + ex.getNotas().add(n));
			System.out.println("Agregar la nota a la lista de notas : " + ex.getNotas().add(n2));
			System.out.println("");
			System.out.println("La lista de notas se queda como:" + ex.getNotas());
		} catch (ExcepcionExpedienteOperacionNoPermitida e) {
			System.out.println("No se permite realizar esta operacion");
		} catch (Exception e){
			System.out.println("Excepcion Inesperada");
		}
		
	}
	private static void testNotaMedia(Nota n, Nota n2) {
		
		Expediente ex = new ExpedienteImpl2();
		System.out.println("Primera Nota : " + n);
		System.out.println("Segunda Nota : " + n2);
		
		System.out.println("Añadir nota : "); ex.nuevaNota(n);
		
		System.out.println("Añadir segunda nota : "); ex.nuevaNota(n2);
		
		System.out.println("Numero de elementos en la lista: " + ex.getNotas().size());
		
		System.out.println("\nNota media comun : " + ex.getNotaMedia());
		
		
		
	}
	
	private static void mostrarExpediente(Expediente ex) {

		System.out.println("\tExpediente: " + ex);
		System.out.println("\tNota Media: " + ex.getNotaMedia());
		System.out.println("\tNotas del Expediente:" + ex.getNotas());
	}

}
