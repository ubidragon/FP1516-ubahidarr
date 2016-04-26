package fp.grados.tipos;

import fp.grados.excepciones.ExcepcionEspacioNoValido;

public class EspacioImpl implements Espacio {

	private TipoEspacio tipo;
	private String nombre;
	private Integer capacidad;
	private Integer planta;

	/***************************************************
	 * CONSTRUCTOR 1
	 *************************************************/
	public EspacioImpl(TipoEspacio tipo, String nombre, Integer capacidad, Integer planta) {

		checkCapacidad(capacidad);

		this.tipo = tipo;
		this.nombre = nombre;
		this.capacidad = capacidad;
		this.planta = planta;
	}

	/***************************************************
	 * CONSTRUCTOR APARTIR DE STRING
	 *************************************************/

	public EspacioImpl(String s) {

		String[] trozos = s.split(",");

		if (trozos.length != 4) {
			throw new IllegalArgumentException();
		}

		TipoEspacio tipo = TipoEspacio.valueOf(trozos[3].trim());
		String nombre = trozos[0].trim();
		Integer planta = new Integer(trozos[1].trim());
		Integer capacidad = new Integer(trozos[2].trim());

		checkCapacidad(capacidad);

		this.tipo = tipo;
		this.nombre = nombre;
		this.capacidad = capacidad;
		this.planta = planta;

	}

	/***************************************************
	 * EXCEPCIONES
	 *************************************************/

	private void checkCapacidad(Integer capacidad) {
		if (capacidad <= 0) {
			throw new ExcepcionEspacioNoValido("Estas to burlao si quieres que algo no tenga pa meter na' ");
		}
	}

	/***************************************************
	 * GETTERS AND SETTERS
	 *************************************************/

	public TipoEspacio getTipo() {

		return tipo;
	}

	public String getNombre() {

		return nombre;
	}

	public Integer getCapacidad() {

		return capacidad;
	}

	public Integer getPlanta() {

		return planta;
	}

	public void setNombre(String nombre) {

		this.nombre = nombre;
	}

	public void setCapacidad(Integer capacidad) {

		checkCapacidad(capacidad);
		this.capacidad = capacidad;

	}

	public void setTipo(TipoEspacio tipo) {

		this.tipo = tipo;

	}

	/***************************************************
	 * EQUALS HASHCODE COMPARE-TO
	 *************************************************/

	public boolean equals(Object o) {
		boolean res = false;
		if (o instanceof Espacio) {
			Espacio esp = (Espacio) o;
			res = this.getNombre().equals(esp.getNombre()) && getPlanta().equals(esp.getPlanta());
		}

		return res;

	}

	public int hashCode() {

		return getNombre().hashCode() * 31 + getPlanta().hashCode() * 31 * 31;

	}

	public int compareTo(Espacio esp) {
		int res = getPlanta().compareTo(esp.getPlanta());

		if (res == 0) {

			res = this.getNombre().compareTo(esp.getNombre());
		}
		return res;

	}

	/***************************************************
	 * toString
	 *************************************************/

	public String toString() {
		return getNombre() + " (planta " + getPlanta() + ")";
	}

}
