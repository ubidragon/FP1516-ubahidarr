package fp.grados.tipos.test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import fp.grados.tipos.Asignatura;
import fp.grados.tipos.AsignaturaImpl;
import fp.grados.tipos.Categoria;
import fp.grados.tipos.Departamento;
import fp.grados.tipos.DepartamentoImpl;
import fp.grados.tipos.Grado;
import fp.grados.tipos.GradoImpl;
import fp.grados.tipos.GradoImpl2;
import fp.grados.tipos.Profesor;
import fp.grados.tipos.TipoAsignatura;
import fp.grados.utiles.Grados;

public class TestGrado2 {

	public static void main(String[] args) {

		testGeneral();

	}

	private static void testGeneral() {

		System.out.println("\nGeneral");

		Departamento d1 = new DepartamentoImpl("Matematica Aplicada I");
		Departamento d2 = new DepartamentoImpl("Organización Industrial");
		Departamento d3 = new DepartamentoImpl("LSI");
		Departamento d4 = new DepartamentoImpl("TECNOLOGIA DIGITAL");

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
		asignaturasOptativas.add(a2);
		asignaturasObligatorias.add(a3);
		asignaturasOptativas.add(a4);

		Grado g1 = new GradoImpl2("Ingenieria Informatica del Software",
				asignaturasObligatorias, asignaturasOptativas, 6.);
		Grado g2 = new GradoImpl("Ingenieria Informatica del Software",
				asignaturasObligatorias, asignaturasOptativas, 6.);
		
		Profesor p1 = Grados.createProfesor("30254347D", "Angel", "Delgado",
				LocalDate.of(1996, 03, 12), "nadie@gmail.com",
				Categoria.CATEDRATICO,
				null);
		Profesor p2 = Grados.createProfesor("12345678Z", "Julio", "Nadie",
				LocalDate.of(1996, 03, 10), "nadiemio@gmail.com",
				Categoria.CONTRATADO_DOCTOR,
				null);
		

		Profesor p3 = Grados.createProfesor("55841805J", "Nadie", "Nadie",
				LocalDate.of(1995, 03, 12), "nadiepelota@gmail.com",
				Categoria.AYUDANTE,
				null);
		Profesor p4 = Grados.createProfesor("12345678Z", "Jo", "Nadie",
				LocalDate.of(1996, 03, 1), "nadieid@gmail.com",
				Categoria.INTERINO,
				null);
		
		d1.nuevoProfesor(p1);
		d2.nuevoProfesor(p2);
		d3.nuevoProfesor(p3);
		d4.nuevoProfesor(p4);
		
		
		
		d1.nuevaAsignatura(a1);
		d2.nuevaAsignatura(a2);
		d3.nuevaAsignatura(a3);
		d4.nuevaAsignatura(a4);
		
		p1.imparteAsignatura(a1, 6.0);
		p2.imparteAsignatura(a2, 6.0);
		p3.imparteAsignatura(a3, 6.0);
		p4.imparteAsignatura(a4, 6.0);

		System.out.println("\nAsignaturas optativas: " + asignaturasOptativas);
		System.out.println("\nAsignaturas obligatorias: "
				+ asignaturasObligatorias);
		System.out.println("\nEncontrar asignatura por codigo: "
				+ g1.getAsignatura("2050004"));
		System.out.println("\nEncontrar asignatura por codigo en IMPL: "
				+ g2.getAsignatura("2050004"));
		System.out.println("\nEncontrar asignaturas por curso academico: "
				+ g1.getAsignaturas(1));
		System.out
				.println("\nEncontrar asignaturas por cuso academico en IMPL: "
						+ g2.getAsignaturas(2));
		System.out.println("\nAsignatura por codigo: "
				+ g1.getCreditosPorAsignatura());
		System.out.println("\nAsignatura por codigo en IMPL: "
				+ g2.getCreditosPorAsignatura());
		System.out.println("\nTotal de Creditos: "
				+ g1.getNumeroTotalCreditos());
		System.out.println("\nTotal de Creditos en Impl: "
				+ g2.getNumeroTotalCreditos());
		System.out.println("\nDepartamentos: " + g1.getDepartamentos());
		System.out.println("\nDepartamentos en Impl: " + g2.getDepartamentos());
		System.out.println("\nProfesores Departamento: " + g1.getProfesores());
		System.out.println("\nProfesores Departamento en Impl: "
				+ g2.getProfesores());

	}

}
