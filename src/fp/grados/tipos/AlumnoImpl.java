package fp.grados.tipos;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import fp.grados.excepciones.ExcepcionAlumnoNoValido;
import fp.grados.excepciones.ExcepcionAlumnoOperacionNoPermitida;

public class AlumnoImpl extends PersonaImpl implements Alumno {

	private Set<Asignatura> asignaturas;
	private Expediente expediente;

	/***************************************************
	 * CONSTRUCTOR
	 *************************************************/

	public AlumnoImpl(String dni, String nombre, String apellidos, LocalDate fechaNacimiento, String email) {

		super(dni, nombre, apellidos, fechaNacimiento, email);
		checkEmailUniversidad(email);
		expediente = new ExpedienteImpl();
		this.asignaturas = new HashSet<Asignatura>();

	}

	/***************************************************
	 * CONSTRUCTOR APARTIR DE STRING
	 *************************************************/

	public AlumnoImpl(String s) {
		super(s);

		checkEmailUniversidad(getEmail());

		asignaturas = new HashSet<Asignatura>();
		expediente = new ExpedienteImpl();

	}

	/***************************************************
	 * EXCEPCIONES
	 **************************************************/

	private void checkEmailUniversidad(String email) {
		if (!email.endsWith("@alum.us.es")) {
			throw new ExcepcionAlumnoNoValido("El email de un alumno debe terminar en @alum.us.es.");
		}
	}

	private void checkEstaMatriculado(Asignatura a) {

		if (estaMatriculadoEn(a)) {

			throw new ExcepcionAlumnoOperacionNoPermitida("El alumno ya esta matriculado");

		}

	}

	private void checkNoEstaMatriculado(Asignatura a) {

		if (!estaMatriculadoEn(a)) {

			throw new ExcepcionAlumnoOperacionNoPermitida("El alumno ya esta matriculado");

		}

	}

	/***************************************************
	 * GETTERS AND SETTERS
	 *************************************************/

	public Set<Asignatura> getAsignaturas() {

		return new HashSet<Asignatura>(asignaturas);

	}

	public void setEmail(String email) {

		checkEmailUniversidad(email);
		super.setEmail(email);

	}

	public void matriculaAsignatura(Asignatura a) {

		checkEstaMatriculado(a);
		asignaturas.add(a);

	}

	public void eliminaAsignatura(Asignatura a) {

		checkNoEstaMatriculado(a);
		asignaturas.remove(a);

	}

	public Boolean estaMatriculadoEn(Asignatura a) {

		return asignaturas.contains(a);

	}

	public Integer getCurso() {
		Integer curso = 0;
		for (Asignatura a : getAsignaturas()) {
			// Recorre las asignaturas contenidas en Set<Asignatura>
			if (a.getCurso() > curso) {
				curso = a.getCurso();
			}
		}

		return curso;
	}

	public Expediente getExpediente() {

		return expediente;

	}

	public void evaluaAlumno(Asignatura a, Integer curso, Convocatoria convocatoria, Double nota,
			Boolean mencionHonor) {

		if (!asignaturas.contains(a)) {
			throw new ExcepcionAlumnoOperacionNoPermitida();
		}

		Nota n = new NotaImpl(a, curso, convocatoria, nota, mencionHonor);
		expediente.nuevaNota(n);

	}

	public void evaluaAlumno(Asignatura a, Integer curso, Convocatoria convocatoria, Double nota) {

		if (!asignaturas.contains(a)) {
			throw new ExcepcionAlumnoOperacionNoPermitida();
		}

		Nota n = new NotaImpl(a, curso, convocatoria, nota);
		expediente.nuevaNota(n);

	}

	public SortedMap<Asignatura, Calificacion> getCalificacionPorAsignatura() {
		/*
		 * Devuelve un SortedMap<Asignatura, Calificacion> que hace corresponder
		 * a cada asignatura que aparece en el expediente del alumno con la
		 * calificaciï¿½n mï¿½xima obtenida en ella. Para construir el
		 * SortedMap, comience por recorrer las notas del expediente del alumno
		 * y, para cada una, aï¿½ada al SortedMap la pareja formada por la
		 * asignatura y su calificaciï¿½n. Antes de hacerlo, compruebe si el
		 * SortedMap ya contiene una calificaciï¿½n para dicha asignatura, en
		 * cuyo caso deberï¿½ sustituirla por la nueva si ï¿½sta supera a la
		 * existente.
		 */

		// TODO comentar este metodo poco a poco
		SortedMap<Asignatura, Calificacion> res = new TreeMap<Asignatura, Calificacion>();

		for (Nota n : getExpediente().getNotas()) {

			if (res.containsKey(n.getAsignatura())) {

				if (res.get(n.getAsignatura()).ordinal() < n.getCalificacion().ordinal()) {

					res.replace(n.getAsignatura(), n.getCalificacion());

				}

			} else {
				res.put(n.getAsignatura(), n.getCalificacion());
			}

		}

		return res;

	}

	public SortedSet<Asignatura> getAsignaturasOrdenadasPorCurso() {
		Comparator<Asignatura> cmp = Comparator.comparing(Asignatura::getCurso).reversed()
				.thenComparing(Comparator.naturalOrder());
		SortedSet<Asignatura> res = new TreeSet<Asignatura>(cmp);
		res.addAll(asignaturas);
		return res;
	}

	public String toString() {

		return "(" + getCurso() + "º) " + super.toString();

	}

}
