package fp.grados.tipos;

import java.util.HashSet;
import java.util.Set;

import fp.grados.excepciones.ExcepcionDespachoNoValido;

public class DespachoImpl extends EspacioImpl implements Despacho {

	private Set<Profesor> profesores;

	/***************************************************
	 * CONSTRUCTOR 1
	 *************************************************/
	public DespachoImpl(String nombre, Integer capacidad, Integer planta, Set<Profesor> profesores) {

		super(TipoEspacio.OTRO, nombre, capacidad, planta);

		this.profesores = new HashSet<Profesor>();
		this.profesores.addAll(profesores);
		checkProfesores(capacidad, profesores);

	}

	/***************************************************
	 * CONSTRUCTOR 2
	 *************************************************/
	public DespachoImpl(String nombre, Integer capacidad, Integer planta, Profesor profesores) {

		super(TipoEspacio.OTRO, nombre, capacidad, planta);

		this.profesores = new HashSet<Profesor>();
		this.profesores.add(profesores);
		checkProfesores(capacidad, getProfesores());

	}

	/***************************************************
	 * CONSTRUCTOR 3
	 *************************************************/
	public DespachoImpl(String nombre, Integer capacidad, Integer planta) {

		super(TipoEspacio.OTRO, nombre, capacidad, planta);

		this.profesores = new HashSet<Profesor>();

	}

	/***************************************************
	 * CONSTRUCTOR APARTIR DE STRING
	 *************************************************/
	public DespachoImpl(String s) {

		super(s + "," + TipoEspacio.OTRO);

		this.profesores = new HashSet<Profesor>();

		checkProfesores(getCapacidad(), profesores);

	}

	/***************************************************
	 * EXCEPCIONES
	 **************************************************/
	private void checkProfesores(Integer capacidad, Set<Profesor> profesores) {

		if (profesores.size() > capacidad) {
			throw new ExcepcionDespachoNoValido("Demasiados profesores para el despacho");
		}

	}

	public void setTipo() {

		throw new UnsupportedOperationException();

	}

	/***************************************************
	 * GETTERS AND SETTERS
	 *************************************************/
	public Set<Profesor> getProfesores() {

		return new HashSet<Profesor>(profesores);

	}

	public void setProfesores(Set<Profesor> profesores) {

		this.profesores = profesores;
		checkProfesores(getCapacidad(), profesores);

	}

	public void setTipo(TipoEspacio espacio) {

		throw new UnsupportedOperationException();

	}

	public void setCapacidad(Integer capacidad) {

		checkProfesores(capacidad, getProfesores());
		super.setCapacidad(capacidad);

	}

	/***************************************************
	 * toString
	 *************************************************/

	public String toString() {
		return super.toString() + profesores;
	}

}
