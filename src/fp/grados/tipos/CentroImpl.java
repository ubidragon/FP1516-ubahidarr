package fp.grados.tipos;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import fp.grados.excepciones.ExcepcionCentroNoValido;
import fp.grados.excepciones.ExcepcionCentroOperacionNoPermitida;

public class CentroImpl implements Centro {

	private String nombre;
	private String direccion;
	private Integer numeroPlantas;
	private Integer numeroSotanos;
	private Set<Espacio> espacios;

	/***************************************************
	 * CONSTRUCTOR 1
	 *************************************************/

	public CentroImpl(String nombre, String direccion, Integer numeroPlantas, Integer numeroSotanos) {

		checkPlanta(numeroPlantas);
		checkSotano(numeroSotanos);

		this.nombre = nombre;
		this.direccion = direccion;
		this.numeroPlantas = numeroPlantas;
		this.numeroSotanos = numeroSotanos;
		this.espacios = new HashSet<Espacio>();

	}

	/***************************************************
	 * EXCEPCIONES
	 **************************************************/

	private void checkPlanta(Integer numeroPlantas) {
		if (numeroPlantas < 1) {
			throw new ExcepcionCentroNoValido("No hay plantas o es un bunquer y las tiene bajo tierra ;) ");
		}
	}

	private void checkSotano(Integer numeroSotanos) {
		if (numeroSotanos < 0) {
			throw new ExcepcionCentroNoValido("Bunquer no encontrado ;) ");
		}
	}

	/***************************************************
	 * GETTERS AND SETTERS
	 *************************************************/

	public String getNombre() {

		return nombre;

	}

	public String getDireccion() {

		return direccion;

	}

	public Integer getNumeroPlantas() {

		return numeroPlantas;

	}

	public Integer getNumeroSotanos() {

		return numeroSotanos;

	}

	public Set<Espacio> getEspacios() {

		return new HashSet<Espacio>(espacios);

	}

	public void nuevoEspacio(Espacio e) {

		Integer pls = getNumeroPlantas();
		Integer sots = getNumeroSotanos();
		if (e.getPlanta() > pls - 1 || e.getPlanta() < -sots) {
			throw new ExcepcionCentroOperacionNoPermitida("numero de las plantas erroneo");
		}

		espacios.add(e);

	}

	public void eliminaEspacio(Espacio e) {

		espacios.remove(e);
	}

	public Integer[] getConteosEspacios() {
		Integer[] conteos = { 0, 0, 0, 0, 0 };
		/**
		 * Otra forma de hacer el get conteos
		 * 
		 * 
		 * public Integer[] getConteosEspacios() { Integer[] result = new
		 * Integer[TipoEspacio.values().length]; Arrays.fill(result, 0);
		 * 
		 * for (Espacio esp : getEspacios()) {
		 * result[esp.getTipo().ordinal()]++; }
		 * 
		 * return result; }
		 * 
		 * 
		 * 
		 *
		 * 
		 * for (Espacio e : getEspacios()) { switch (e.getTipo()) { case TEORIA:
		 * conteos[0]++; break; case LABORATORIO: conteos[1]++; break; case
		 * SEMINARIO: conteos[2]++; break; case EXAMEN: conteos[3]++; break;
		 * case OTRO: conteos[4]++; break; } }
		 **/
		for (Espacio e : getEspacios()) {
			conteos[e.getTipo().ordinal()]++;
		}

		return conteos;

	}

	public Set<Despacho> getDespachos() {

		Set<Despacho> despachos = new HashSet<Despacho>();

		for (Espacio e : getEspacios()) {
			if (e instanceof Despacho) {
				despachos.add((Despacho) e);
			}
		}

		return despachos;

	}

	public Set<Despacho> getDespachos(Departamento d) {

		Set<Despacho> despachos = new HashSet<Despacho>();

		for (Despacho despacho : getDespachos()) {
			if (existeProfesorDepartamento(despacho.getProfesores(), d)) {
				despachos.add(despacho);
			}
		}

		return despachos;

	}

	private boolean existeProfesorDepartamento(Set<Profesor> profesores, Departamento d) {

		Boolean existe = false;

		for (Profesor p : profesores) {
			if (p.getDepartamento().equals(d)) {
				existe = true;
				break;
			}
		}

		return existe;

	}

	public Set<Profesor> getProfesores() {

		Set<Profesor> p = new HashSet<Profesor>();

		for (Despacho d : getDespachos()) {
			Set<Profesor> pr = d.getProfesores();
			p.addAll(pr);
		}

		return p;

	}

	public Set<Profesor> getProfesores(Departamento d) {
		// TODO getProfesores(Departamento d)
		Set<Profesor> p = new HashSet<Profesor>();

		for (Profesor pr : this.getProfesores()) {
			if (pr.getDepartamento().equals(d)) {
				p.add(pr);
			}
		}

		return p;
	}

	public Espacio getEspacioMayorCapacidad() {

		Espacio capa = null;
		Integer c = 0;

		for (Espacio cap : getEspacios()) {

			Integer capacidad = cap.getCapacidad();

			if (c < capacidad) {
				c = capacidad;
				capa = cap;
			}

		}

		return capa;

	}

	public SortedMap<String, Despacho> getDespachosPorProfesor() {
		SortedMap<String, Despacho> res = new TreeMap<String, Despacho>();

		for (Despacho d : getDespachos()) {

			for (Profesor p : d.getProfesores()) {
				res.put(p.toString(), d);

			}
		}

		return res;
	}

	public SortedSet<Espacio> getEspaciosOrdenadosPorCapacidad() {
		Comparator<Espacio> cmp = Comparator.comparing(Espacio::getCapacidad).reversed()
				.thenComparing(Comparator.naturalOrder());
		SortedSet<Espacio> res = new TreeSet<Espacio>(cmp);
		res.addAll(espacios);
		return res;
	}

	/***************************************************
	 * EQUALS HASHCODE COMPARE-TO
	 *************************************************/
	public boolean equals(Object o) {
		boolean res = false;

		if (o instanceof Centro) {
			Centro c = (Centro) o;
			res = getNombre().equals(c.getNombre());
		}

		return res;
	}

	public int hashCode() {

		return getNombre().hashCode();

	}

	public int compareTo(Centro c) {

		return getNombre().compareTo(c.getNombre());

	}

	/***************************************************
	 * toString
	 *************************************************/
	public String toString() {
		return getNombre();
	}

}
