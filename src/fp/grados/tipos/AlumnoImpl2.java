package fp.grados.tipos;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class AlumnoImpl2 extends AlumnoImpl {

	public AlumnoImpl2(String dni, String nombre, String apellidos, LocalDate fecha, String email) {
		super(dni, nombre, apellidos, fecha, email);

	}

	public AlumnoImpl2(String s) {
		super(s);

	}

	public Integer getCurso() {
		Integer res = 0;

		if (getAsignaturas().isEmpty()) {
			res = 0;
		} else {
			res = getAsignaturas().stream().max(Comparator.comparing(x -> x.getCurso())).get().getCurso();
		}

		return res;

	}

	public SortedMap<Asignatura, Calificacion> getCalificacionPorAsignatura() {

		return getExpediente().getNotas().stream().collect(Collectors.toMap(x -> x.getAsignatura(),
				x -> x.getCalificacion(), (x1, x2) -> calificacion(x1, x2), TreeMap::new));

	}

	private Calificacion calificacion(Calificacion x1, Calificacion x2) {

		Integer cal1 = x1.ordinal();
		Integer cal2 = x2.ordinal();

		Calificacion c = null;

		if (cal2.compareTo(cal1) > 0) {

			c = x2;

		} else {

			c = x1;

		}

		return c;
	}

}
