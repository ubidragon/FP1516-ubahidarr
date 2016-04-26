package fp.grados.tipos;

import fp.grados.excepciones.ExcepcionBecaNoValida;

public class BecaImpl implements Beca {
	/* Declaramos propiedades basicas o finales, NUNCA DERIVADAS */
	private static final Double CUANTIA_MINIMA = 1500.0;
	private String codigo;
	private Double cuantiaTotal;
	private Integer duracion;
	private TipoBeca tipo;

	/***************************************************
	 * CONSTRUCTOR 1
	 *************************************************/

	public BecaImpl(String codigo, Double cuantiaTotal, Integer duracion, TipoBeca tipo) {
		/* Chequeamos atributos */
		checkCodigo(codigo);
		checkCuantiaTotal(cuantiaTotal);
		checkDuracion(duracion);

		/* Inicializamos atributos */
		this.codigo = codigo;
		this.tipo = tipo;
		this.cuantiaTotal = cuantiaTotal;
		this.duracion = duracion;
	}

	/***************************************************
	 * CONSTRUCTOR 2
	 *************************************************/
	public BecaImpl(String codigo, TipoBeca tipo) {

		checkCodigo(codigo);

		this.codigo = codigo;
		this.tipo = tipo;
		this.cuantiaTotal = CUANTIA_MINIMA;
		this.duracion = 1;
	}

	/***************************************************
	 * CONSTRUCTOR APARTIR DE STRING
	 *************************************************/

	public BecaImpl(String s) {

		// Troceamos la cadena
		String[] trozos = s.split(",");

		// Chequeamos que el numero de valores es correcto
		if (trozos.length != 4) {
			throw new IllegalArgumentException();
		}

		/*
		 * Copiar y transformar cada subcadena al atributo correspondiente
		 */
		String codigo = trozos[0].trim();
		Double cuantiaTotal = new Double(trozos[1].trim());
		/* Se usa para transformar el String en Double */
		Integer duracion = new Integer(trozos[2].trim());
		/* Se usa para transformar el String en Integer */
		TipoBeca tipo = TipoBeca.valueOf(trozos[3].trim());
		/* Se usa para transformar el String en TipoBeca */

		/* Chequeamos las restricciones */
		checkCodigo(codigo);
		checkCuantiaTotal(cuantiaTotal);
		checkDuracion(duracion);

		/* copiamos los atributos */
		this.codigo = codigo;
		this.tipo = tipo;
		this.cuantiaTotal = cuantiaTotal;
		this.duracion = duracion;

	}

	/***************************************************
	 * EXCEPCIONES
	 **************************************************/

	private void checkCodigo(String codigo) {
		boolean esCorrecto = codigo.length() == 7 && Character.isLetter(codigo.charAt(0))
				&& Character.isLetter(codigo.charAt(1)) && Character.isLetter(codigo.charAt(2))
				&& Character.isDigit(codigo.charAt(3)) && Character.isDigit(codigo.charAt(4))
				&& Character.isDigit(codigo.charAt(5)) && Character.isDigit(codigo.charAt(6));
		if (!esCorrecto) {
			throw new ExcepcionBecaNoValida("El código debe estar formado por 3 letras y 4 dígitos.");
		}
	}

	private void checkCuantiaTotal(Double cuantiaTotal) {
		if (cuantiaTotal < CUANTIA_MINIMA) {
			throw new ExcepcionBecaNoValida("La cuantía total debe ser como mínimo " + CUANTIA_MINIMA + " euros.");
		}
	}

	private void checkDuracion(Integer duracion) {
		if (duracion < 1) {
			throw new ExcepcionBecaNoValida("La duración debe ser de al menos un mes.");
		}
	}

	/***************************************************
	 * GETTERS AND SETTERS
	 *************************************************/

	public String getCodigo() {
		return codigo;
	}

	public Double getCuantiaTotal() {
		return cuantiaTotal;
	}

	public Integer getDuracion() {
		return duracion;
	}

	public TipoBeca getTipo() {
		return tipo;
	}

	public Double getCuantiaMensual() {
		return getCuantiaTotal() / getDuracion();
	}

	public void setCuantiaTotal(Double cuantiaTotal) {
		checkCuantiaTotal(cuantiaTotal);
		this.cuantiaTotal = cuantiaTotal;
	}

	public void setDuracion(Integer duracion) {
		checkDuracion(duracion);
		this.duracion = duracion;
	}

	/***************************************************
	 * EQUALS HASHCODE COMPARE-TO
	 *************************************************/
	public boolean equals(Object o) {
		boolean res = false;

		if (o instanceof Beca) {

			Beca b = (Beca) o;
			res = getCodigo().equals(b.getCodigo()) && getTipo().equals(b.getTipo());

		}

		return res;

	}

	public int hashCode() {

		return getCodigo().hashCode() * 31 + getTipo().hashCode() * 31 * 31;

	}

	public int compareTo(Beca b) {

		int res = getCodigo().compareTo(b.getCodigo());

		if (res == 0) {

			res = getTipo().compareTo(b.getTipo());

		}

		return res;

	}

	/***************************************************
	 * toString
	 *************************************************/

	public String toString() {

		return "[" + getCodigo() + ", " + getTipo() + "]";

	}

}
