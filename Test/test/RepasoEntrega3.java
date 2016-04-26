package fp.grados.tipos.test;

import java.util.Comparator;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

import fp.grados.tipos.Asignatura;
import fp.grados.tipos.Beca;
import fp.grados.tipos.TipoAsignatura;
import fp.grados.tipos.TipoEspacio;
import fp.grados.utiles.Grados;

public class RepasoEntrega3 {

	public static SortedMap<Beca, Integer> duracionesBecas(
			String nombreFichero, Double cuantia) {

		SortedMap<Beca, Integer> map = Grados
				.createBecas(nombreFichero)
				.stream()
				.filter(x -> x.getCuantiaTotal() > cuantia)
				.collect(
						Collectors.toMap(x -> x, Beca::getDuracion,
								(b1, b2) -> b1, TreeMap::new));

		return map;
	}

	public static Integer numeroBecasDuracion(String nombreFichero,
			Integer meses) {
		return Grados.createBecas(nombreFichero).stream()
				.filter(x -> x.getDuracion().equals(meses))
				.collect(Collectors.toList()).size();
	}

	public static Integer capacidadTotalEspaciosTipo(String nombreFichero,
			TipoEspacio tipo) {
		return Grados.createEspacios(nombreFichero).stream()
				.filter(x -> x.getTipo().equals(tipo))
				.mapToInt(x -> x.getCapacidad()).sum();
	}

	public static SortedSet<Asignatura> seleccionaAnuales(String ficheroEntrada) {
		Set<Asignatura> asig = Grados
				.createAsignaturas(ficheroEntrada)
				.stream()
				.filter(x -> x.getTipo() == TipoAsignatura.ANUAL)
				.sorted(Comparator.comparing(Asignatura::getCurso)
						.thenComparing(Comparator.naturalOrder()))
				.collect(Collectors.toSet());
		return new TreeSet<Asignatura>(asig);
	}
}
