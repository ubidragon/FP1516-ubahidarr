package fp.grados.tipos.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

import fp.grados.tipos.Asignatura;
import fp.grados.tipos.AsignaturaImpl;
import fp.grados.tipos.Categoria;
import fp.grados.tipos.Departamento;
import fp.grados.tipos.DepartamentoImpl;
import fp.grados.tipos.DepartamentoImpl2;
import fp.grados.tipos.Profesor;
import fp.grados.tipos.ProfesorImpl;
import fp.grados.tipos.ProfesorImpl2;
import fp.grados.tipos.TipoAsignatura;
import fp.grados.tipos.Tutoria;
import fp.grados.tipos.TutoriaImpl;

public class TestDepartamento2 {

	public static void main(String[] args) {
		testExisteProfesorAsignado();
		testCompleto();
	}

	private static void testCompleto() {
		Departamento d = new DepartamentoImpl2("MA1");
		Asignatura a1 = new AsignaturaImpl("Calculo Infinitesimal", "2050004", 6.,
				TipoAsignatura.PRIMER_CUATRIMESTRE, 1, d);
		Asignatura a2 = new AsignaturaImpl("Matematicas Discretas", "2050003", 6., TipoAsignatura.PRIMER_CUATRIMESTRE,1, 
				d);
		Profesor p = new ProfesorImpl2("28200400P", "María", "MartinOviedo", LocalDate.of(1964, 12, 1), 
				"maria.martin@us.es", 
				Categoria.TITULAR, d);
		Profesor p2 = new ProfesorImpl2("28200400P", "Jose", "Martin", LocalDate.of(1964, 11, 1), 
				"jose.martin@us.es", 
				Categoria.AYUDANTE, d);
		
		Tutoria t1 = new TutoriaImpl(DayOfWeek.WEDNESDAY, LocalTime.of(10, 30),
				LocalTime.of(12, 30));
		
		Tutoria t2 = new TutoriaImpl(DayOfWeek.THURSDAY, LocalTime.of(11, 30),
				120);
		d.nuevoProfesor(p);
		d.nuevoProfesor(p2);
		d.nuevaAsignatura(a1);
		d.nuevaAsignatura(a2);
		p.nuevaTutoria(LocalTime.of(10, 30),
				45, DayOfWeek.WEDNESDAY);
		p2.nuevaTutoria(LocalTime.of(10, 30),
				60, DayOfWeek.FRIDAY);
		p.imparteAsignatura(a1, 6.0);
		p2.imparteAsignatura(a2, 6.0);
		
		System.out.println("\nDepartamento: " + d.getNombre());
		System.out.println("\nAsignaturasDepartamento: " + d.getAsignaturas());
		System.out.println("\nProfesores: " + d.getProfesores());
		System.out.println("\nExiste Profesor Asignatura a la asignatura a1: " + d.existeProfesorAsignado(a1));
		System.out.println("\nExiste Profesor Asignatura a la asignatura a2: " + d.existeProfesorAsignado(a2));
		System.out.println("\nLista de asignaturas del profesor p: " + p.getAsignaturas());
		System.out.println("\nLista de asignaturas del profesor p2: "+  p2.getAsignaturas());
		System.out.println("\nTodasAsignaturasAsignadas: " + d.estanTodasAsignaturasAsignadas());
		System.out.println("\nProfesoresPorAsignaturas: " + d.getProfesoresPorAsignatura());
		System.out.println("\nTutoriasPorProfesor: " + d.getTutoriasPorProfesor());
		System.out.println("\nBorrarTutoriasDeUnaCategoria: "); d.borraTutorias(Categoria.AYUDANTE);
		System.out.println("\nTutorias del Departamento: " + d.getTutoriasPorProfesor());
		System.out.println("\nModificar la categoria de un profesor: "); p.setCategoria(Categoria.COLABORADOR);
		System.out.println("\nProfesorConNuevaCategoria: " + p);
		
		System.out.println("\nProfesor p: " + p);
		System.out.println("\nProfesor p2: " + p2);
		System.out.println("\nTutoria t1: " + t1);
		System.out.println("\nTutoria t2: " + t2);
		System.out.println("\nDedicacionTotal p: " + p.getDedicacionTotal());
		System.out.println("\nDedicacionTotal p2: "+  p2.getDedicacionTotal());
//
//		
//		
//		
//		
	}

	private static void testExisteProfesorAsignado() {
		Departamento d = new DepartamentoImpl("MA1");
		
		Asignatura a1 = new AsignaturaImpl("Calculo Infinitesimal", "2050004", 6.,
				TipoAsignatura.PRIMER_CUATRIMESTRE, 1, d);
		Asignatura a2 = new AsignaturaImpl("Matematicas Discretas", "2050003", 6., TipoAsignatura.PRIMER_CUATRIMESTRE,1, 
				d);
		Profesor p = new ProfesorImpl("28200400P", "María", "MartinOviedo", LocalDate.of(1964, 12, 1), 
				"maria.martin@us.es", 
				Categoria.TITULAR, d);
		Profesor p2 = new ProfesorImpl("28200400P", "Jose", "Martin", LocalDate.of(1964, 11, 1), 
				"jose.martin@us.es", 
				Categoria.AYUDANTE, d);
		d.nuevoProfesor(p);
		d.nuevoProfesor(p2);
		
		d.nuevaAsignatura(a1);
		d.nuevaAsignatura(a2);

		
		p.imparteAsignatura(a1, 6.);
		p.imparteAsignatura(a2, 6.0);
		p2.imparteAsignatura(a1, 6.0);
		p2.imparteAsignatura(a2, 6.);
				
//		Boolean r = d.existeProfesorAsignado(a1);
//		Boolean r1 = d.estanTodasAsignaturasAsignadas();
//		System.out.println(r + " " + r1);
		
		
	}

}
