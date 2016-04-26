package fp.grados.tipos;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import fp.grados.excepciones.ExcepcionProfesorNoValido;
import fp.grados.excepciones.ExcepcionProfesorOperacionNoPermitida;

public class ProfesorImpl2 extends PersonaImpl implements Profesor {
	private Categoria categoria;
	private SortedSet<Tutoria> tutorias;
	private Map<Asignatura, Double> asigCred;
	private Departamento departamento;
	private static final Double PROFESOR = 32.0;
	private static final Double AYUDANTE = 6.0;

	/***************************************************
	 * CONSTRUCTOR 1
	 *************************************************/

	public ProfesorImpl2(String dni, String nombre, String apellidos, LocalDate fechaNacimiento, String email,
			Categoria categoria) {
		super(dni, nombre, apellidos, fechaNacimiento, email);

		checkEdad(getEdad());
		checkFechaNacimiento(fechaNacimiento);
		this.tutorias = new TreeSet<Tutoria>();

		asigCred = new HashMap<Asignatura, Double>();

		this.departamento = null;
		this.categoria = categoria;

	}

	/***************************************************
	 * CONSTRUCTOR 2
	 *************************************************/

	public ProfesorImpl2(String dni, String nombre, String apellidos, LocalDate fechaNacimiento, String email,
			Categoria categoria, Departamento departamento) {
		super(dni, nombre, apellidos, fechaNacimiento, email);

		checkEdad(getEdad());
		checkFechaNacimiento(fechaNacimiento);
		this.tutorias = new TreeSet<Tutoria>();

		asigCred = new HashMap<Asignatura, Double>();

		setDepartamento(departamento);
		this.categoria = categoria;

	}

	/***************************************************
	 * EXCEPCIONES
	 **************************************************/
	private void checkFechaNacimiento(LocalDate fecha) {
		if (!fecha.isBefore(LocalDate.now())) {
			throw new ExcepcionProfesorNoValido();
		}
	}

	private void checkEdad(Integer edad) {

		if (edad < 18) {
			throw new ExcepcionProfesorNoValido("Un profesor no puede ser menor de edad");
		}

	}

	private void checkAsignaturaDepartamento(Asignatura asig) {
		if (getDepartamento() == null || !getDepartamento().getAsignaturas().contains(asig)) {
			throw new ExcepcionProfesorOperacionNoPermitida(
					"Un profesor no puede impartir una asignatura " + "de otro departamento.");
		}
	}

	private void checkCreditosAsignatura(Asignatura asig, Double dedicacion) {
		if (dedicacion <= 0 || asig.getCreditos() < dedicacion) {
			throw new ExcepcionProfesorOperacionNoPermitida("La dedicación debe ser mayor que 0 y menor o igual "
					+ "que el número de créditos de la asignatura.");
		}
	}

	private void checkDedicacion(Double dedicacion, Categoria cat) {

		if ((getCategoria() == Categoria.AYUDANTE && dedicacion > AYUDANTE) || (dedicacion > PROFESOR)) {

			throw new ExcepcionProfesorOperacionNoPermitida("ERROR en la dedicacion AYUDANTE");
		}
	}

	/***************************************************
	 * GETTERS AND SETTERS
	 *************************************************/

	public Categoria getCategoria() {

		return categoria;

	}

	public void setCategoria(Categoria categoria) {

		this.categoria = categoria;
		checkDedicacion(getDedicacionTotal(), categoria);

	}

	public void setFechaNacimiento(LocalDate fecha) {

		checkFechaNacimiento(fecha);
		super.setFechaNacimiento(fecha);

		checkEdad(super.getEdad());

	}

	public Departamento getDepartamento() {

		return departamento;

	}

	public void setDepartamento(Departamento nuevoDepartamento) {
		// Si el nuevo departamento es el mismo que ya había no haríamos nada.
		if (nuevoDepartamento != this.departamento) {
			Departamento antiguoDepartamento = this.departamento;
			this.departamento = nuevoDepartamento;

			if (antiguoDepartamento != null) {

				/**
				 * Si antes el profesor pertenecía a otro departamento, tenemos
				 * que actualizar ese departamento eliminando a "este profesor"
				 * (es decir, a this) de los profesores que conforman el
				 * departamento.
				 **/

				antiguoDepartamento.eliminaProfesor(this);

			}
			if (nuevoDepartamento != null) {

				/**
				 * Si el profesor pertenece a un nuevo departamento, tenemos que
				 * actualizar este departamento para incluir a "este profesor"
				 * (es decir, a this) en los profesores que conforman el
				 * departamento.
				 **/

				nuevoDepartamento.nuevoProfesor(this);

			}
		}
	}

	public Double getDedicacionTotal() {

		/*
		 * la dedicacion se hace a partir de los creditos que vienen dados en la
		 * lista por lo que no hay que sacarle los creditos a las asignaturas,
		 * los cuales pueden ser diferentes es decir, recorres los creditos, no
		 * las asignaturas, y haces la suma
		 */

		Double dedic = 0.0;

		for (Double ded : getCreditos()) {
			dedic = dedic + ded;
		}
		checkDedicacion(dedic, categoria);
		return dedic;
	}

	public SortedSet<Tutoria> getTutorias() {
		// crea un conjunto
		return new TreeSet<Tutoria>(tutorias);
	}

	public void nuevaTutoria(LocalTime horaComienzo, Integer duracionMinutos, DayOfWeek dia) {
		/**
		 * Crea un nuevo objeto de tipo Tutoria y se lo añade al conjunto
		 **/
		Tutoria t = new TutoriaImpl(dia, horaComienzo, duracionMinutos);
		tutorias.add(t);

	}

	public void borraTutoria(LocalTime horaComienzo, DayOfWeek dia) {

		tutorias.remove(this);

	}

	public void borraTutorias() {

		tutorias.removeAll(tutorias);

	}

	public List<Asignatura> getAsignaturas() {

		// Creamos copias de la lista
		return new ArrayList<Asignatura>(asigCred.keySet());

	}

	public List<Double> getCreditos() {

		// Creamos copias de la lista
		return new ArrayList<Double>(asigCred.values());

	}

	public void imparteAsignatura(Asignatura asig, Double dedicacion) {

		checkAsignaturaDepartamento(asig);
		checkCreditosAsignatura(asig, dedicacion);

		if (asigCred.containsKey(asig)) {
			/**
			 * El profesor ya imparte esta asignatura: hay que actualizar la
			 * dedicación
			 **/
			actualizaDedicacion(asig, dedicacion);
		} else {
			/**
			 * El profesor no imparte aún esta asignatura: hay que añadirla a
			 * ambas listas
			 **/
			nuevaAsignatura(asig, dedicacion);
		}
		checkDedicacion(getDedicacionTotal(), categoria);
	}
	/*
	 * TODO DAFACK?!?!?! no me convence nada de nada
	 */

	// Modifica la posición correspondiente de la lista de dedicaciones
	private void actualizaDedicacion(Asignatura asig, Double nuevaDedicacion) {
		checkCreditosAsignatura(asig, nuevaDedicacion);
		asigCred.put(asig, nuevaDedicacion);
	}

	// Añadimos la asignatura y la dedicación al final de sendas listas
	private void nuevaAsignatura(Asignatura asig, Double dedicacion) {
		checkDedicacion(dedicacion, categoria);
		asigCred.put(asig, dedicacion);
	}

	public void eliminaAsignatura(Asignatura asig) {

		asigCred.remove(asig);

	}

	public Double dedicacionAsignatura(Asignatura asig) {

		Double res = 0.0;

		if (asigCred.containsKey(asig)) {
			res = asigCred.get(asig);
		}
		return res;

	}

	/***************************************************
	 * toString
	 *************************************************/

	public String toString() {

		return super.toString() + " (" + getCategoria() + ")";

	}

}
