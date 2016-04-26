package fp.grados.tipos;

import java.util.Comparator;
import java.util.Optional;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

import fp.grados.excepciones.ExcepcionCentroOperacionNoPermitida;

public class CentroImpl2 extends CentroImpl {

	public CentroImpl2(String nombre, String direccion, Integer numeroPlantas, Integer numeroSotanos) {

		super(nombre, direccion, numeroPlantas, numeroSotanos);

	}

	public Espacio getEspacioMayorCapacidad() {

		Optional<Espacio> res = getEspacios().stream().max(Comparator.comparing(Espacio::getCapacidad));

		if (!res.isPresent()) {

			throw new ExcepcionCentroOperacionNoPermitida("El centro no dispone aún de espacios.");

		}

		return res.get();

	}

	public Integer[] getConteosEspacios() {

		Integer[] conteos = { 0, 0, 0, 0, 0 };
		getEspacios().stream().forEach(e -> conteos[e.getTipo().ordinal()]++);

		return conteos;
	}

	public Set<Despacho> getDespachos() {

		return getEspacios().stream().filter(x -> x instanceof Despacho).map(x -> (Despacho) x)
				.collect(Collectors.toSet());

	}

	public Set<Despacho> getDespachos(Departamento des) {

		return getDespachos().stream().filter(x -> x.getProfesores().equals(des.getProfesores()))
				.collect(Collectors.toSet());

	}

	public Set<Profesor> getProfesores() {
		return getDespachos().stream().flatMap(d -> d.getProfesores().stream()).collect(Collectors.toSet());
	}

	public Set<Profesor> getProfesores(Departamento dep) {

		return getDespachos().stream().flatMap(d -> d.getProfesores().stream())
				.filter(p -> p.getDepartamento().equals(dep)).collect(Collectors.toSet());
		/*
		 * Solución alternativa: return getProfesores().stream() .filter(p ->
		 * p.getDepartamento().equals(dep)) .collect(Collectors.toSet());
		 */
	}

	public SortedMap<String, Despacho> getDespachosPorProfesor() {

		return new TreeMap<String, Despacho>(
				getProfesores().stream().collect(Collectors.toMap(p -> p.toString(), p -> buscaDespacho(p))));

	}

	private Despacho buscaDespacho(Profesor p) {

		return getDespachos().stream().filter(d -> d.getProfesores().contains(p)).findFirst().get();

	}

}
