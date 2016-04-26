package fp.grados.tipos;

import java.time.LocalDate;

public interface Persona extends Comparable<Persona> {
	String getNombre();

	String getApellidos();

	String getDNI();

	LocalDate getFechaNacimiento();

	String getEmail();

	Integer getEdad();

	void setNombre(String nombre);

	void setApellidos(String apellidos);

	void setDNI(String dni);

	void setFechaNacimiento(LocalDate fecha);

	void setEmail(String email);
}
