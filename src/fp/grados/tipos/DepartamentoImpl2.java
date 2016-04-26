package fp.grados.tipos;

import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class DepartamentoImpl2 extends DepartamentoImpl {

	public DepartamentoImpl2(String nombre) {

		super(nombre);

	}

	public void borraTutorias() {
		getProfesores().stream().forEach(Profesor::borraTutorias);

	}

	public void borraTutorias(Categoria categoria) {
		getProfesores().stream().filter(p -> p.getCategoria().equals(categoria)).forEach(Profesor::borraTutorias);

	}

	public SortedMap<String, SortedSet<Tutoria>> getTutoriasPorProfesor() {

		return new TreeMap<String, SortedSet<Tutoria>>(
				getProfesores().stream().collect(Collectors.toMap(p -> p.toString(), p -> p.getTutorias())));

	}

	public Boolean existeProfesorAsignado(Asignatura a) {

		return getProfesores().stream().anyMatch(x -> x.getAsignaturas().contains(a));

	}

	public Boolean estanTodasAsignaturasAsignadas() {

		return getProfesores().stream().flatMap(x -> x.getAsignaturas().stream()).collect(Collectors.toSet())
				.containsAll(getAsignaturas());

	}

	public void eliminaAsignacionProfesorado(Asignatura a) {

		if (getAsignaturas().contains(a)) {

			getProfesores().stream().forEach(x -> x.getCreditos().remove(x.getAsignaturas().indexOf(a)));
			getProfesores().stream().forEach(x -> x.eliminaAsignatura(a));

		}

	}

}
