package fp.grados.tipos;

import fp.grados.excepciones.ExcepcionAsignaturaNoValida;

public class AsignaturaImpl implements Asignatura {
	private String nombre;
	private String codigo;
	private Double creditos;
	private TipoAsignatura tipo;
	private Integer curso;

	private Departamento departamento;

	/***************************************************
	 * CONSTRUCTOR 1
	 *************************************************/

	public AsignaturaImpl(String nombre, String codigo, Double creditos, TipoAsignatura tipo, Integer curso) {

		checkCodigo(codigo);
		checkCreditos(creditos);
		checkCurso(curso);

		this.nombre = nombre;
		this.codigo = codigo;
		this.creditos = creditos;
		this.tipo = tipo;
		this.curso = curso;
		this.departamento = null;
	}

	/***************************************************
	 * CONSTRUCTOR 2
	 *************************************************/

	public AsignaturaImpl(String nombre, String codigo, Double creditos, TipoAsignatura tipo, Integer curso,
			Departamento departamento) {

		checkCodigo(codigo);
		checkCreditos(creditos);
		checkCurso(curso);

		this.nombre = nombre;
		this.codigo = codigo;
		this.creditos = creditos;
		this.tipo = tipo;
		this.curso = curso;
		setDepartamento(departamento);
	}

	/***************************************************
	 * CONSTRUCTOR APARTIR DE STRING
	 *************************************************/

	public AsignaturaImpl(String asignatura) {
		// Ejemplo de formato de la cadena de entrada:
		// Fundamentos de Programación#1234567# 12.0# ANUAL# 1
		String[] campos = asignatura.split("#");
		if (campos.length != 5) {
			throw new IllegalArgumentException("El formato de la cadena de entrada no es correcto.");
		}
		String codigo = campos[1].trim();
		Double creditos = new Double(campos[2].trim());
		Integer curso = new Integer(campos[4].trim());
		checkCodigo(codigo);
		checkCreditos(creditos);
		checkCurso(curso);
		this.nombre = campos[0].trim();
		this.codigo = codigo;
		this.creditos = creditos;
		this.tipo = TipoAsignatura.valueOf(campos[3].trim());
		this.curso = curso;
		this.departamento = null;
	}

	/***************************************************
	 * EXCEPCIONES
	 **************************************************/

	private void checkCodigo(String codigo) {

		/*
		 * Con esto creamos una variable de tipo Boolean la cual usaremos para
		 * testear el codigo de la asignatura. 1.- testea mediante el
		 * codigo.length() la longitud del codigo es igual a 7 2.-comprueba que
		 * los 7 elementos del codigo son caracteres de tipo numerico
		 * unicamente.
		 */

		Boolean esCorrecto = codigo.length() == 7 && Character.isDigit(codigo.charAt(0))
				&& Character.isDigit(codigo.charAt(1)) && Character.isDigit(codigo.charAt(2))
				&& Character.isDigit(codigo.charAt(3)) && Character.isDigit(codigo.charAt(4))
				&& Character.isDigit(codigo.charAt(5)) && Character.isDigit(codigo.charAt(6));

		if (!esCorrecto) {
			// sino se cumplen las premisas anteriores, es decir el boolean
			// devuelve false, se lanza la excepcion.

			throw new ExcepcionAsignaturaNoValida("El codigo debe estar formado por 7 digitos. \n Ubidragon");

		}

	}

	private void checkCreditos(Double creditos) {

		// Si el valor de los creditos es inferior o igual a 0 lanza la
		// excepcion
		if (creditos <= 0) {

			throw new ExcepcionAsignaturaNoValida(
					"Los créditos deben ser un número positivo distinto de 0. \n Ubidragon");

		}

	}

	private void checkCurso(Integer curso) {

		if (curso < 1 || curso > 4) {

			throw new ExcepcionAsignaturaNoValida("El curso debe estar comprendido entre 1 y 4. \n Ubidragon");
		}

	}

	/***************************************************
	 * GETTERS AND SETTERS
	 *************************************************/

	public String getNombre() {

		return nombre;

	}

	public String getAcronimo() {

		String acronimo = "";

		for (char c : getNombre().toCharArray()) {
			if (Character.isUpperCase(c)) {
				// TODO TEST acronimo= c+acronimo;
				acronimo += c;
			}
		}

		return acronimo;
	}

	public String getCodigo() {

		return codigo;

	}

	public Double getCreditos() {

		return creditos;

	}

	public TipoAsignatura getTipo() {

		return tipo;

	}

	public Integer getCurso() {

		return curso;

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
				 * Si antes la asignatura pertenecía a otro departamento,
				 * tenemos que actualizar ese departamento eliminando a "esta
				 * asignatura"(es decir, a this) de las asignaturas que
				 * conforman el departamento.
				 **/

				antiguoDepartamento.eliminaAsignatura(this);

			}
			if (nuevoDepartamento != null) {

				/**
				 * Si la asignatura pertenece a un nuevo departamento, tenemos
				 * que actualizar este departamento para incluir a "esta
				 * asignatura" (es decir, a this) en las asignaturas que
				 * conforman el departamento.
				 **/

				nuevoDepartamento.nuevaAsignatura(this);

			}
		}
	}

	/***************************************************
	 * EQUALS HASHCODE COMPARE-TO
	 *************************************************/

	public boolean equals(Object o) {
		boolean res = false;

		if (o instanceof Asignatura) {
			Asignatura a = (Asignatura) o;
			res = getCodigo().equals(a.getCodigo());
		}

		return res;

	}

	public int hashCode() {

		return getCodigo().hashCode();

	}

	public int compareTo(Asignatura a) {

		return getCodigo().compareTo(a.getCodigo());

	}

	/***************************************************
	 * toString
	 *************************************************/

	public String toString() {

		return "(" + getCodigo() + ") " + getNombre();

	}

}