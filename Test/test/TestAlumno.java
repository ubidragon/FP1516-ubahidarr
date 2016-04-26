package fp.grados.tipos.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.SortedMap;

import fp.grados.excepciones.ExcepcionAlumnoNoValido;
import fp.grados.excepciones.ExcepcionAlumnoOperacionNoPermitida;
import fp.grados.tipos.Alumno;
import fp.grados.tipos.AlumnoImpl;
import fp.grados.tipos.Asignatura;
import fp.grados.tipos.AsignaturaImpl;
import fp.grados.tipos.Calificacion;
import fp.grados.tipos.Convocatoria;
import fp.grados.tipos.DepartamentoImpl;
import fp.grados.tipos.Expediente;
import fp.grados.tipos.ExpedienteImpl;
import fp.grados.tipos.Nota;
import fp.grados.tipos.NotaImpl;
import fp.grados.tipos.TipoAsignatura;

public class TestAlumno {

	public static void main(String[] args) {

		testConstructorNormal();
		testConstructorExcepcion();
		testConstructorExcepcion2();

		testSetEmailNormal();
		testSetEmailExcepcion();

		testMatriculaAsignatura();
		testMatriculaAsignaturaExcepcion();

		testEliminaAsignatura();
		testEliminaAsignaturaExcepcion();
		
		testestaMatriculadoEn();
		testestaMatriculadoEnExcepcion();
		
		testevaluaAlumno1();
		testevaluaAlumno2();
		
		testAsignaturaCalificacion();
		
	}
	
	private static void testAsignaturaCalificacion() {
		System.out
		.println("\n==================================Probando Map");
		
		Alumno al = new AlumnoImpl("30254347D", "Angel", "Delgado",
				LocalDate.of(1994, 3, 15), "angdellun@alum.us.es");
		
		Nota n = new NotaImpl((new AsignaturaImpl("Fundamentos de Programacion",
				"0000230", 12., TipoAsignatura.ANUAL, 1, new DepartamentoImpl(
						"Lenguajes y Sistemas Informaticos"))), 2014, Convocatoria.PRIMERA, 10.);
		Nota n1 = new NotaImpl((new AsignaturaImpl("Calculo Infinitesimal", "2050004", 6.,
				TipoAsignatura.PRIMER_CUATRIMESTRE, 1, new DepartamentoImpl
				("Matematica Aplicada I"))), 2014, Convocatoria.PRIMERA, 8.);
		Nota n2 = new NotaImpl(new AsignaturaImpl("Matematicas Discretas", "2050003", 6., TipoAsignatura.PRIMER_CUATRIMESTRE,1, 
				new DepartamentoImpl("Matematica Aplicada I")), 2014, Convocatoria.PRIMERA, 6.);
		
		al.getExpediente().nuevaNota(n);
		al.getExpediente().nuevaNota(n1);
		al.getExpediente().nuevaNota(n2);
		
		SortedMap <Asignatura, Calificacion> map = al.getCalificacionPorAsignatura();
		
		map.put(n.getAsignatura(), n.getCalificacion());
		map.put(n1.getAsignatura(), n1.getCalificacion());
		map.put(n2.getAsignatura(), n2.getCalificacion());
		
		testAsignaturaCalificacion(al);
	}

	private static void testAsignaturaCalificacion(Alumno al) {
		
		System.out.println("Alumno" + al);
		
		System.out.println("Notas: " + al.getExpediente().getNotas());
		
		System.out.println("Introducir asignaturas por calificacion:" + al.getCalificacionPorAsignatura());
		
	}

	private static void testConstructorNormal() {
		System.out
				.println("\n==================================Probando el primer constructor");
		testConstructor("12345678Z", "Juan", "Nadie Nadie",
				LocalDate.of(1994, 3, 15), "juan.nadie@alum.us.es");
	}

	private static void testConstructorExcepcion() {
		System.out
				.println("\n==================================Probando el primer constructor, email incorrecto");
		testConstructor("12345678Z", "Juan", "Nadie Nadie",
				LocalDate.of(1950, 3, 15), "juan.nadie@gmail.com");
	}
	
	private static void testConstructorExcepcion2() {
		System.out
				.println("\n==================================Probando el primer constructor, email incorrecto");
		testConstructor("12345678Z", "Juan", "Nadie Nadie",
				LocalDate.of(1950, 3, 15), "");
	}

	


	private static void testSetEmailNormal() {
		System.out
				.println("\n==================================Probando setEmail");

		Alumno a = new AlumnoImpl("12345678Z", "Juan", "Nadie Nadie",
				LocalDate.of(1950, 3, 15), "juan.nadie@alum.us.es");
		testSetEmail(a, "juan@alum.us.es");
	}

	private static void testSetEmailExcepcion() {
		System.out
				.println("\n==================================Probando setEmail, email incorrecto");

		Alumno a = new AlumnoImpl("12345678Z", "Juan", "Nadie Nadie",
				LocalDate.of(1950, 3, 15), "juan.nadie@alum.us.es");
		testSetEmail(a, "juan@gmail.com");
	}

	private static void testMatriculaAsignatura() {
		System.out
				.println("\n==================================Probando matriculaAsignatura");
		Alumno a = new AlumnoImpl("12345678Z", "Juan", "Nadie Nadie",
				LocalDate.of(1950, 3, 15), "juan.nadie@alum.us.es");
		Asignatura asig = new AsignaturaImpl("Fundamentos de Programación",
				"2050001", 12.0, TipoAsignatura.ANUAL, 1, new DepartamentoImpl("Lenguajes y Sistemas Informaticos"));
		testMatriculaAsignatura(a, asig);
	}

	private static void testMatriculaAsignaturaExcepcion() {
		System.out
				.println("\n==================================Probando matriculaAsignatura, matricula doble en una asignatura");
		Alumno a = new AlumnoImpl("12345678Z", "Juan", "Nadie Nadie",
				LocalDate.of(1950, 3, 15), "juan.nadie@alum.us.es");
		Asignatura asig = new AsignaturaImpl("Fundamentos de Programación",
				"2050001", 12.0, TipoAsignatura.ANUAL, 1, new DepartamentoImpl("Lenguajes y Sistemas Informaticos"));
		a.matriculaAsignatura(asig);
		testMatriculaAsignatura(a, asig);
	}

	private static void testEliminaAsignatura() {
		System.out
				.println("\n==================================Probando eliminaAsignatura");
		Alumno a = new AlumnoImpl("12345678Z", "Juan", "Nadie Nadie",
				LocalDate.of(1950, 3, 15), "juan.nadie@alum.us.es");
		Asignatura asig = new AsignaturaImpl("Fundamentos de Programación",
				"2050001", 12.0, TipoAsignatura.ANUAL, 1, new DepartamentoImpl("Lenguajes y Sistemas Informaticos"));
		a.matriculaAsignatura(asig);
		testEliminaAsignatura(a, asig);
	}

	private static void testEliminaAsignaturaExcepcion() {
		System.out
				.println("\n==================================Probando eliminaAsignatura, asignatura no matriculada");
		Alumno a = new AlumnoImpl("12345678Z", "Juan", "Nadie Nadie",
				LocalDate.of(1950, 3, 15), "juan.nadie@alum.us.es");
		Asignatura asig = new AsignaturaImpl("Fundamentos de Programación",
				"2050001", 12.0, TipoAsignatura.ANUAL, 1, new DepartamentoImpl("Lenguajes y Sistemas Informaticos"));
		testEliminaAsignatura(a, asig);
	}
	
	private static void testestaMatriculadoEn() {
		System.out
		.println("\n==================================MatriculadoEN-----------TRUE");
		Asignatura asig = new AsignaturaImpl("Fundamentos de Programacion", "2050001", 12.0, 
				TipoAsignatura.ANUAL, 1,new DepartamentoImpl("Lenguajes y Sistemas Informaticos"));
	
		Alumno a = new AlumnoImpl("12345678Z", "Juan", "Nadie nadie", LocalDate.of(1996, 3, 2), "juan.nadie@alum.us.es");
		a.matriculaAsignatura(asig);
		a.estaMatriculadoEn(asig);
		testestaMatriculadoEn(asig,a);
		
	}
	
	private static void testestaMatriculadoEnExcepcion() {
		System.out
		.println("\n==================================EstaMatriculadoEN ---- FALSE");
		Asignatura asig = new AsignaturaImpl("Fundamentos de Programacion", "2050001", 12.0, 
				TipoAsignatura.ANUAL, 1,new DepartamentoImpl("Lenguajes y Sistemas Informaticos"));
		Alumno a = new AlumnoImpl("12345678Z", "Juan", "Nadie nadie", LocalDate.of(1996, 3, 2), "juan.nadie@alum.us.es");
		a.estaMatriculadoEn(asig);
		testestaMatriculadoEn(asig,a);
	}

	private static void testevaluaAlumno1() {
		System.out
		.println("\n=================================="
				+ "evaluaAlumno con mencion honor");
		Nota n = new NotaImpl(new AsignaturaImpl("Fundamentos de Programacion", "2050001", 12.0, 
				TipoAsignatura.ANUAL, 1, new DepartamentoImpl("Lenguajes y Sistemas Informaticos")), 2014, Convocatoria.PRIMERA, 9.0, false);
		Expediente exp = new ExpedienteImpl();	
		testevaluaAlumno1(n, exp);
	}

	
	
	private static void testevaluaAlumno2() {
		System.out
		.println("\n=================================="
				+ "evaluaAlumno sin mencion honor ");
		
		Nota n2 = new NotaImpl(new AsignaturaImpl("Fundamentos de Programacion", "2050001", 12.0, 
				TipoAsignatura.ANUAL, 1, new DepartamentoImpl("Lenguajes y Sistemas Informaticos")), 2014, Convocatoria.SEGUNDA, 8.0);
		Expediente exp = new ExpedienteImpl();		
		testevaluaAlumno2(n2, exp);
	}

	private static void testevaluaAlumno1(Nota n, Expediente exp) {
		try {
			System.out.println("Nota a agregar al expediente:" + "<" + n + ">");
			System.out.println("Expediente antes de agregar:" + "<" + exp + ">");
			System.out.println("Se agrega la nota al expediente:" 
			); exp.nuevaNota(n);
			System.out.println("Expediente despues del agregado" + "<" + exp + ">");
		} catch (ExcepcionAlumnoNoValido e) {
			System.out
					.println("******************** Se ha capturado la excepción ExcepcionAlumnoNoValido");
		} catch (Exception e) {
			System.out
					.println("******************** Se ha capturado una excepción inesperada.");
		}

	}
	
	
	private static void testevaluaAlumno2(Nota n2, Expediente exp) {
		try {
			System.out.println("Nota a agregar al expediente:" + "<" + n2 + ">");
			System.out.println("Expediente antes de agregar:" + "<" + exp + ">");
			System.out.println("Se agrega la nota al expediente:" 
			+ "<" + exp.getNotas().add(n2) + ">");
			System.out.println("Expediente despues del agregado" + "<" + exp + ">");
		} catch (ExcepcionAlumnoNoValido e) {
			System.out
					.println("******************** Se ha capturado la excepción ExcepcionAlumnoNoValido");
		} catch (Exception e) {
			System.out
					.println("******************** Se ha capturado una excepción inesperada.");
		}

	}
	private static void testConstructor(String dni, String nombre,
			String apellidos, LocalDate fechaNacimiento, String email) {

		try {
			Alumno a = new AlumnoImpl(dni, nombre, apellidos, fechaNacimiento,
					email);
			mostrarAlumno(a);
		} catch (ExcepcionAlumnoNoValido e) {
			System.out
					.println("******************** Se ha capturado la excepción ExcepcionAlumnoNoValido");
		} catch (Exception e) {
			System.out
					.println("******************** Se ha capturado una excepción inesperada.");
		}

	}

	private static void testSetEmail(Alumno a, String nuevoEmail) {

		try {
			System.out.println("El email antes de la operación es: "
					+ a.getEmail());
			System.out.println("El nuevo email es: " + nuevoEmail);
			a.setEmail(nuevoEmail);
			System.out.println("El email después de la operación es: "
					+ a.getEmail());
		} catch (ExcepcionAlumnoNoValido e) {
			System.out
					.println("******************** Se ha capturado la excepción ExcepcionAlumnoNoValido");
		} catch (Exception e) {
			System.out
					.println("******************** Se ha capturado una excepción inesperada.");
		}
	}

	private static void testMatriculaAsignatura(Alumno a, Asignatura asig) {

		try {
			System.out.println("Las asignaturas antes de la operación son: "
					+ a.getAsignaturas());
			System.out.println("Nueva asignatura a matricular: " + asig);
			a.matriculaAsignatura(asig);
			System.out.println("Las asignaturas después de la operación son: "
					+ a.getAsignaturas());
		} catch (ExcepcionAlumnoOperacionNoPermitida e) {
			System.out
					.println("******************** Se ha capturado la excepción ExcepcionAlumnoOperacionNoPermitida");
		} catch (Exception e) {
			System.out
					.println("******************** Se ha capturado una excepción inesperada.");
		}
	}

	private static void testEliminaAsignatura(Alumno a, Asignatura asig) {

		try {
			System.out.println("Las asignaturas antes de la operación son: "
					+ a.getAsignaturas());
			System.out.println("Asignatura a eliminar: " + asig);
			a.eliminaAsignatura(asig);
			System.out.println("Las asignaturas después de la operación son: "
					+ a.getAsignaturas());
		} catch (ExcepcionAlumnoOperacionNoPermitida e) {
//			e.printStackTrace(); //Traza de la excepcion, desde donde empieza el error del codigo hasta donde se ha cortado
			System.out
					.println("******************** Se ha capturado la excepción ExcepcionAlumnoOperacionNoPermitida");
		} catch (Exception e) {
			System.out
					.println("******************** Se ha capturado una excepción inesperada.");
		}
	}
	private static void testestaMatriculadoEn(Asignatura asig, Alumno a) {
		
			System.out.println("Alumno: " + "<" + a + ">");
			System.out.println("Asignatura:" + asig);
			System.out.println("Comprobacion de que este matriculado:" + "<" + a.estaMatriculadoEn(asig) + ">");
			
			if(a.estaMatriculadoEn(asig) == true) { 
				System.out.println("El alumno: " + "<" + a + ">" + 
			" esta matriculado en la asignatura " + "<" + asig + ">");} 
			else {
				System.out.println("El alumno no esta matriculado en la asignatura");
			}
			}
	
	private static void mostrarAlumno(Alumno a) {
		System.out.println("\tAlumno --> <" + a + ">");
		System.out.println("\tDNI: <" + a.getDNI() + ">");
		System.out.println("\tNombre: <" + a.getNombre() + ">");
		System.out.println("\tApellidos: <" + a.getApellidos() + ">");
		System.out.println("\tFecha Nacimiento: <"
				+ a.getFechaNacimiento().format(
						DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ">");
		System.out.println("\tEdad: <" + a.getEdad() + ">");
		System.out.println("\tEmail:  <" + a.getEmail() + ">");
		System.out.println("\tAsignaturas:  <" + a.getAsignaturas() + ">");
		System.out.println("\tCurso: <" + a.getCurso() + ">");
	}
}
