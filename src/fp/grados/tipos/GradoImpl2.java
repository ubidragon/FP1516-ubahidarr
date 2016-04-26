package fp.grados.tipos;

import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GradoImpl2 extends GradoImpl {

	public GradoImpl2(String nombre, Set<Asignatura> asigObligatorias, Set<Asignatura> asigOptativas,
			Double creditosMinimos) {

		super(nombre, asigObligatorias, asigOptativas, creditosMinimos);

	}

	public Double getNumeroTotalCreditos() {
		return getAsignaturasObligatorias().stream().mapToDouble(a -> a.getCreditos()).sum()
				+ getNumeroMinimoCreditosOptativas();
	}

	public Set<Asignatura> getAsignaturas(Integer curso) {
		return Stream.concat(getAsignaturasObligatorias().stream(), getAsignaturasOptativas().stream())
				.filter(a -> a.getCurso().equals(curso)).collect(Collectors.toSet());
	}

	public Asignatura getAsignatura(String codigo) {

		return Stream.concat(getAsignaturasObligatorias().stream(), getAsignaturasOptativas().stream())
				.filter(x -> x.getCodigo().equals(codigo)).findFirst().get();

	}

	public Set<Departamento> getDepartamentos() {

		return Stream.concat(getAsignaturasObligatorias().stream(), getAsignaturasOptativas().stream())
				.map(x -> x.getDepartamento()).collect(Collectors.toSet());

	}

	public Set<Profesor> getProfesores() {

		return getDepartamentos().stream().flatMap(x -> x.getProfesores().stream()).collect(Collectors.toSet());

	}

	public SortedMap<Asignatura, Double> getCreditosPorAsignatura() {

		return Stream.concat(getAsignaturasObligatorias().stream(), getAsignaturasOptativas().stream())
				.collect(Collectors.toMap(x -> x, x -> x.getCreditos(), (x1, x2) -> x1, TreeMap::new));

	}

}
