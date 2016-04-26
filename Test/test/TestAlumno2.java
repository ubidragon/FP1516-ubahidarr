package fp.grados.tipos.test;

import java.time.LocalDate;

import fp.grados.tipos.Alumno;
import fp.grados.tipos.AlumnoImpl2;
import fp.grados.tipos.Asignatura;
import fp.grados.tipos.Convocatoria;
import fp.grados.tipos.DepartamentoImpl;
import fp.grados.tipos.TipoAsignatura;
import fp.grados.utiles.Grados;

public class TestAlumno2 {

	public static void main(String[] args) {

		Alumno alum = new AlumnoImpl2("30254347D", "Angel", "Delgado",
				LocalDate.of(1994, 3, 15), "angdellun@alum.us.es");


		Asignatura a = Grados.createAsignatura("Fundamentos de Programación",
				"2050001", 12.0, TipoAsignatura.ANUAL, 4, new DepartamentoImpl(
						"Lenguajes y Sistemas Informaticos"));
		Asignatura a2 = Grados.createAsignatura("Circuitos Electronicos Digitales",
				"2050006", 6.0, TipoAsignatura.PRIMER_CUATRIMESTRE, 3, new DepartamentoImpl(
						"Dte"));
		alum.matriculaAsignatura(a);
		alum.matriculaAsignatura(a2);
	
		alum.evaluaAlumno(a, 2014, Convocatoria.PRIMERA, 8.5);
		alum.evaluaAlumno(a, 2014, Convocatoria.PRIMERA, 9.0);
		alum.evaluaAlumno(a2, 2016, Convocatoria.PRIMERA, 5.0);
		
		
		System.out.println("Curso "
				+ alum.getCurso());
		System.out.println("\nExpediente alumno: " + alum.getExpediente());
		
		System.out.println("\nCalificacionPorAsignatura: " + alum.getCalificacionPorAsignatura());

		System.out.println("\nOrdenadas por curso: " + alum.getAsignaturasOrdenadasPorCurso());
	}

}
