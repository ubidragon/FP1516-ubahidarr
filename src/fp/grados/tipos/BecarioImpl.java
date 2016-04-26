package fp.grados.tipos;

import java.time.LocalDate;

import fp.grados.excepciones.ExcepcionBecarioNoValido;

public class BecarioImpl extends AlumnoImpl implements Becario {

	private Beca beca;
	private LocalDate comienzo;

	/***************************************************
	 * CONSTRUCTOR 1
	 *************************************************/

	public BecarioImpl(String dni, String nombre, String apellidos, LocalDate fechaNacimiento, String email, Beca beca,
			LocalDate comienzo) {
		super(dni, nombre, apellidos, fechaNacimiento, email);

		checkComienzo(comienzo);

		this.beca = beca;
		this.comienzo = comienzo;

	}

	/***************************************************
	 * CONSTRUCTOR 2
	 *************************************************/

	public BecarioImpl(String dni, String nombre, String apellidos, LocalDate fechaNacimiento, String email,
			String codigo, Double cuantiaTotal, Integer duracion, TipoBeca tipo, LocalDate comienzo) {
		super(dni, nombre, apellidos, fechaNacimiento, email);

		checkComienzo(comienzo);

		this.beca = new BecaImpl(codigo, cuantiaTotal, duracion, tipo);
		this.comienzo = comienzo;

	}

	/***************************************************
	 * EXCEPCIONES
	 **************************************************/
	private void checkComienzo(LocalDate comienzo) {

		if (!comienzo.isAfter(LocalDate.now())) {
			throw new ExcepcionBecarioNoValido("la fecha introducida debe ser posterior a la actual");
		}

	}

	/***************************************************
	 * GETTERS AND SETTERS
	 *************************************************/

	public Beca getBeca() {

		return beca;

	}

	public LocalDate getFechaComienzo() {

		return comienzo;
	}

	public void setFechaComienzo(LocalDate fecha) {

		checkComienzo(fecha);
		comienzo = fecha;

	}

	public LocalDate getFechaFin() {

		return getFechaComienzo().plusMonths(getBeca().getDuracion());

	}

	public void setEmail(String email) {
		// Redefinimos setEmail para no permitir usar esta operacion,
		// es decir, esta propiedad pasa a ser solo consultable

		throw new UnsupportedOperationException("no se permite modificar el email de un becario");

	}

	/***************************************************
	 * toString
	 **************************************************/

	public String toString() {

		return super.toString() + " " + getBeca().toString();

	}
}
