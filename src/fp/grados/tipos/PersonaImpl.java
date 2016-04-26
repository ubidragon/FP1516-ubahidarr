package fp.grados.tipos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import fp.grados.excepciones.ExcepcionPersonaNoValida;

public class PersonaImpl implements Persona {

	private String nombre;
	private String apellidos;
	private String dni;
	private LocalDate fechaNacimiento;
	private String email;

	/***************************************************
	 * CONSTRUCTOR 1
	 *************************************************/

	public PersonaImpl(String dni, String nombre, String apellidos, LocalDate fechaNacimiento, String email) {

		checkDni(dni);
		checkEmail(email);
		checkFechaNacimiento(fechaNacimiento);

		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.email = email;

	}

	/***************************************************
	 * CONSTRUCTOR 2
	 *************************************************/

	public PersonaImpl(String dni, String nombre, String apellidos, LocalDate fechaNacimiento) {

		this(dni, nombre, apellidos, fechaNacimiento, "");

	}

	/***************************************************
	 * CONSTRUCTOR A PARTIR DE STRING
	 *************************************************/

	public PersonaImpl(String persona) {
		// Ejemplo de formato de la cadena de entrada:
		// 12345678H,Juan,López García,20/01/1998,juan@acmemail.com
		String[] campos = persona.split(",");
		if (campos.length != 5) {
			throw new IllegalArgumentException("El formato de la cadena de entrada no es correcto.");
		}
		String dni = campos[0].trim();
		String email = campos[4].trim();
		LocalDate fechaNacimiento = LocalDate.parse(campos[3].trim(), DateTimeFormatter.ofPattern("d/M/y"));
		checkDni(dni);
		checkFechaNacimiento(fechaNacimiento);
		checkEmail(email);
		this.dni = dni;
		this.nombre = campos[1].trim();
		this.apellidos = campos[2].trim();
		this.fechaNacimiento = fechaNacimiento;
		this.email = email;
	}

	/***************************************************
	 * EXCEPCIONES
	 **************************************************/

	private void checkDni(String dni) {
		boolean esDniCorrecto = checkDniTipoCaracteres(dni) && checkDniLetra(dni);
		if (!esDniCorrecto) {
			throw new ExcepcionPersonaNoValida("DNI incorrecto.");
		}
	}

	private Boolean checkDniTipoCaracteres(String dni) {
		return dni.length() == 9 && Character.isDigit(dni.charAt(0)) && Character.isDigit(dni.charAt(1))
				&& Character.isDigit(dni.charAt(2)) && Character.isDigit(dni.charAt(3))
				&& Character.isDigit(dni.charAt(4)) && Character.isDigit(dni.charAt(5))
				&& Character.isDigit(dni.charAt(6)) && Character.isDigit(dni.charAt(7))
				&& Character.isLetter(dni.charAt(8));
	}

	private Boolean checkDniLetra(String dni) {
		String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
		Integer numeroDni = new Integer(dni.substring(0, 8));
		return dni.charAt(8) == letras.charAt(numeroDni % 23);
	}

	private void checkEmail(String email) {
		if (!(email.isEmpty() || email.contains("@"))) {
			throw new ExcepcionPersonaNoValida("El email debe contener el usuario, una arroba y el servidor.");
		}
	}

	private void checkFechaNacimiento(LocalDate fechaNacimiento) {
		if (!fechaNacimiento.isBefore(LocalDate.now())) {
			throw new ExcepcionPersonaNoValida(
					"La fecha de nacimiento de una persona debe ser anterior " + "a la fecha actual del sistema.");
		}
	}

	/***************************************************
	 * GETTERS AND SETTERS
	 *************************************************/

	public Integer getEdad() {
		// return Period.between(getFechaNacimiento(),
		// LocalDate.now()).getYears();
		return (int) getFechaNacimiento().until(LocalDate.now(), ChronoUnit.YEARS);
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public String getDNI() {
		return dni;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public String getEmail() {
		return email;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public void setDNI(String dni) {
		checkDni(dni);
		this.dni = dni;
	}

	public void setFechaNacimiento(LocalDate fecha) {
		checkFechaNacimiento(fecha);
		this.fechaNacimiento = fecha;
	}

	public void setEmail(String email) {
		checkEmail(email);
		this.email = email;
	}

	/***************************************************
	 * EQUALS HASHCODE COMPARE-TO
	 *************************************************/

	public boolean equals(Object o) {
		boolean res = false;
		if (o instanceof Persona) {
			Persona p = (Persona) o;
			res = getDNI().equals(p.getDNI()) && getNombre().equals(p.getNombre())
					&& getApellidos().equals(p.getApellidos());
		}

		return res;

	}

	public int hashCode() {

		return getDNI().hashCode() + getNombre().hashCode() * 31 + getApellidos().hashCode() * 31 * 31;

	}

	public int compareTo(Persona p) {
		int res = getApellidos().compareTo(p.getApellidos());
		if (res == 0) {
			res = getNombre().compareTo(p.getNombre());
			if (res == 0) {
				res = getDNI().compareTo(p.getDNI());
			}
		}

		return res;
	}

	/***************************************************
	 * toString
	 *************************************************/

	public String toString() {
		return getDNI() + " - " + getApellidos() + ", " + getNombre() + " - "
				+ getFechaNacimiento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
}
