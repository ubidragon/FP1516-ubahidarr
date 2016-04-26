package fp.grados.tipos;

import fp.grados.excepciones.ExcepcionNotaNoValida;

public class NotaImpl implements Nota {

	private Asignatura asig;
	private Integer curso;
	private Convocatoria convocatoria;
	private Boolean mencion;
	private Double valor;

	/***************************************************
	 * CONSTRUCTOR 1
	 *************************************************/
	public NotaImpl(Asignatura asig, Integer curso, Convocatoria convocatoria, Double valor, Boolean mencion) {

		checkValor(valor);
		checkMatricula(valor, mencion);

		this.asig = asig;
		this.curso = curso;
		this.convocatoria = convocatoria;
		this.valor = valor;
		this.mencion = mencion;

	}

	/***************************************************
	 * CONSTRUCTOR 2
	 *************************************************/

	public NotaImpl(Asignatura asig, Integer curso, Convocatoria convocatoria, Double valor) {
		checkValor(valor);

		this.asig = asig;
		this.curso = curso;
		this.convocatoria = convocatoria;
		this.valor = valor;
		this.mencion = false;

	}

	/***************************************************
	 * CONSTRUCTOR APARTIR DE STRING
	 *************************************************/

	public NotaImpl(String s) {

		String[] trozos = s.split(";");

		if (trozos.length != 5) {
			throw new IllegalArgumentException();
		}

		Asignatura asig = new AsignaturaImpl(trozos[0].trim());
		Integer curso = new Integer(trozos[1].trim());
		Convocatoria convocatoria = Convocatoria.valueOf(trozos[2].trim());
		Double valor = new Double(trozos[3].trim());
		Boolean mencion = new Boolean(trozos[4].trim());

		checkValor(valor);
		checkMatricula(valor, mencion);

		this.asig = asig;
		this.curso = curso;
		this.convocatoria = convocatoria;
		this.valor = valor;
		this.mencion = mencion;

	}

	/***************************************************
	 * EXCEPCIONES
	 *************************************************/

	private void checkValor(Double valor) {

		if (valor < 0 || valor > 10) {
			throw new ExcepcionNotaNoValida(
					"Se ha producido un error al calcular la nota, intentelo de nuevo más tarde");
		}
	}

	private void checkMatricula(Double valor, Boolean mencion) {
		if (valor < 9 && mencion == (true)) {
			throw new ExcepcionNotaNoValida("Como vas a tener matricula sino tienes ni un sobresaliente");
		}
	}

	/***************************************************
	 * GETTERS AND SETTERS
	 *************************************************/

	public Asignatura getAsignatura() {

		return asig;
	}

	public Integer getCursoAcademico() {

		return curso;
	}

	public Convocatoria getConvocatoria() {

		return convocatoria;
	}

	public Double getValor() {

		checkValor(valor);
		return valor;
	}

	public Boolean getMencionHonor() {

		return mencion;
	}

	public Calificacion getCalificacion() {

		Calificacion cal = null;

		if (getValor() < 5) {

			cal = Calificacion.SUSPENSO;

		} else if (getValor() >= 5 && getValor() < 7) {

			cal = Calificacion.APROBADO;

		} else if (getValor() >= 7 && getValor() < 9) {

			cal = Calificacion.NOTABLE;

		} else if (getValor() >= 9 && getMencionHonor() == false) {

			cal = Calificacion.SOBRESALIENTE;

		} else if (getValor() >= 9 && getMencionHonor() == (true)) {

			cal = Calificacion.MATRICULA_DE_HONOR;
		}

		return cal;
	}

	/***************************************************
	 * EQUALS HASHCODE COMPARE-TO
	 *************************************************/

	public boolean equals(Object o) {
		boolean res = false;

		if (o instanceof Nota) {

			Nota n = (Nota) o;
			res = getCursoAcademico().equals(n.getCursoAcademico()) && getAsignatura().equals(n.getAsignatura())
					&& getConvocatoria().equals(n.getConvocatoria());

		}

		return res;

	}

	public int hashCode() {

		return getCursoAcademico().hashCode() + getAsignatura().hashCode() * 31
				+ getConvocatoria().hashCode() * 31 * 31;

	}

	public int compareTo(Nota n) {
		int res = getCursoAcademico().compareTo(n.getCursoAcademico());

		if (res == 0) {

			res = getAsignatura().compareTo(n.getAsignatura());

			if (res == 0) {

				res = getConvocatoria().compareTo(n.getConvocatoria());
			}

		}

		return res;

	}

	/***************************************************
	 * toString
	 *************************************************/

	public String toString() {
		Integer a = curso + 1;
		String stringCurso = a.toString(); // convierte el integer a string
		String ano2 = stringCurso.substring(2, 4); // del string genera un nuevo
													// string que
		// pertenece al anterio por lo que es un
		// substring el cual va desde el segundo
		// termino sin incluirlo hasta el cuarto
		// termino de dicho string

		return getAsignatura() + ", " + curso + "-" + ano2 + ", " + getConvocatoria() + ", " + getValor() + ", "
				+ getCalificacion();
	}
}
