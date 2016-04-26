package fp.grados.tipos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class DepartamentoImpl implements Departamento {

	private String nombre;
	private Set<Asignatura> asignaturas;
	private Set<Profesor> profesores;

	/***************************************************
	 * CONSTRUCTOR 1
	 *************************************************/

	public DepartamentoImpl(String nombre) {
		this.nombre = nombre;
		this.asignaturas = new HashSet<Asignatura>();
		this.profesores = new HashSet<Profesor>();
	}

	/***************************************************
	 * GETTERS AND SETTERS
	 *************************************************/

	public String getNombre() {

		return nombre;

	}

	public Set<Asignatura> getAsignaturas() {

		return new HashSet<Asignatura>(asignaturas);

	}

	public Set<Profesor> getProfesores() {

		return new HashSet<Profesor>(profesores);
	}

	public void nuevaAsignatura(Asignatura asig) {

		asignaturas.add(asig);
		asig.setDepartamento(this);

	}

	public void eliminaAsignatura(Asignatura asig) {

		if (asignaturas.contains(asig)) {

			asignaturas.remove(asig);
			asig.setDepartamento(null);

		}

	}

	public void nuevoProfesor(Profesor prof) {

		profesores.add(prof);
		prof.setDepartamento(this);

	}

	public void eliminaProfesor(Profesor prof) {

		if (profesores.contains(prof)) {

			profesores.remove(prof);
			prof.setDepartamento(null);

		}
	}

	public void borraTutorias(Categoria categoria) {

		for (Profesor prof : getProfesores()) {
			if (prof.getCategoria().equals(categoria)) {
				prof.borraTutorias();
			}

		}

	}

	public Boolean existeProfesorAsignado(Asignatura a) {

		Boolean res = false;

		for (Profesor p : getProfesores()) {
			if (p.getAsignaturas().contains(a)) {
				res = true;
				break;
			}
		}

		return res;

	}

	public void borraTutorias() {

		for (Profesor prof : getProfesores()) {
			prof.borraTutorias();
		}

	}

	public Boolean estanTodasAsignaturasAsignadas() {

		Boolean asignada = false;
		List<Asignatura> asignatura = new ArrayList<Asignatura>();

		for (Profesor prof : getProfesores()) {
			/**
			 * primero recorre y mete las asignaturas de un profesor en la lista
			 * asignatura
			 **/
			asignatura = prof.getAsignaturas();
		}
		if (asignatura.containsAll(getAsignaturas())) {
			/**
			 * y aqui comprueba que sean las mismas asignaturas en ambos lados y
			 * va fuera del for porque es para comprobar lo anterior si es
			 * cierto devuelve true
			 **/

			asignada = true;
		}

		return asignada;
	}

	public void eliminaAsignacionProfesorado(Asignatura a) {

		for (Profesor prof : getProfesores()) {
			if (prof.getAsignaturas().contains(a)) {
				prof.eliminaAsignatura(a);
			}
		}
	}

	/*
	 * public SortedMap<Asignatura, SortedSet<Profesor>>
	 * getProfesoresPorAsignatura(){
	 * 
	 * SortedMap<Asignatura, SortedSet<Profesor>> res = new TreeMap<Asignatura,
	 * SortedSet<Profesor>>(); for(Profesor p: getProfesores()){ for(Asignatura
	 * a: p.getAsignaturas()){ SortedSet<Profesor> s = new TreeSet<Profesor>();
	 * res.containsKey(a) ? res.get(a).add(p): res.put(a, s.add(p)); } } return
	 * res; }
	 */

	public SortedMap<Asignatura, SortedSet<Profesor>> getProfesoresPorAsignatura() {

		SortedMap<Asignatura, SortedSet<Profesor>> res = new TreeMap<Asignatura, SortedSet<Profesor>>();

		for (Profesor p : getProfesores()) {

			anyadeAsignaturas(p, res);

		}

		return res;

	}

	private void anyadeAsignaturas(Profesor p, SortedMap<Asignatura, SortedSet<Profesor>> res) {

		for (Asignatura a : p.getAsignaturas()) {

			if (res.containsKey(a)) {

				res.get(a).add(p);

			} else {

				SortedSet<Profesor> s = new TreeSet<Profesor>();
				s.add(p);
				res.put(a, s);

			}

		}
	}

	public SortedMap<String, SortedSet<Tutoria>> getTutoriasPorProfesor() {

		SortedMap<String, SortedSet<Tutoria>> res = new TreeMap<String, SortedSet<Tutoria>>();
		SortedSet<Tutoria> t = new TreeSet<Tutoria>();

		for (Profesor p : this.getProfesores()) {

			t.addAll(p.getTutorias());
			res.put(p.toString(), t);

		}

		return res;

	}

	public Profesor getProfesorMaximaDedicacionMediaPorAsignatura() {
		Comparator<Profesor> cmp = Comparator
				.comparing(profesor -> profesor.getDedicacionTotal() / profesor.getAsignaturas().size());
		return getProfesores().stream().filter(profesor -> !profesor.getAsignaturas().isEmpty()).max(cmp).get();
	}

	/***************************************************
	 * EQUALS HASHCODE COMPARE-TO
	 *************************************************/

	public int compareTo(Departamento d) {

		return getNombre().compareTo(d.getNombre());

	}

	public boolean equals(Object o) {
		boolean res = false;

		if (o instanceof Departamento) {
			Departamento d = (Departamento) o;
			res = getNombre().equals(d.getNombre());
		}

		return res;

	}

	public int hashCode() {

		return getNombre().hashCode();

	}

	/***************************************************
	 * toString
	 *************************************************/

	public String toString() {

		return getNombre();

	}

}
