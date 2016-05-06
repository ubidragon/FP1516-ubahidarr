package fp.grados.tipos;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import fp.grados.excepciones.ExcepcionGradoNoValido;

public class GradoImpl implements Grado {

	private String nombre;
	private Set<Asignatura> asigObligatorias;
	private Set<Asignatura> asigOptativas;
	private Double creditosMinimos;

	/***************************************************
	 * CONSTRUCTOR 1
	 *************************************************/
	public GradoImpl(String nombre, Set<Asignatura> asigObligatorias, Set<Asignatura> asigOptativas,
			Double creditosMinimos) {

		this.nombre = nombre;
		this.asigObligatorias = new HashSet<Asignatura>(asigObligatorias);
		this.asigOptativas = new HashSet<Asignatura>(asigOptativas);
		this.creditosMinimos = creditosMinimos;

		checkMinimo(creditosMinimos);
		checkAsignaturas(asigOptativas);

	}

	/***************************************************
	 * EXCEPCIONES
	 **************************************************/

	private void checkMinimo(Double creditosMinimos) {
		Double credito = 0.0;

		for (Asignatura asi : getAsignaturasOptativas()) {
			credito = credito + asi.getCreditos();
		}

		if (creditosMinimos < 0 || creditosMinimos > credito) {
			throw new ExcepcionGradoNoValido("Se te fue la mano con los creditos");
		}
	}

	private void checkAsignaturas(Set<Asignatura> optativas) {
		Double cOpt = null;
		Boolean primero = true;

		for (Asignatura asig : optativas) {
			if (asig.getTipo() == TipoAsignatura.ANUAL) {
				throw new ExcepcionGradoNoValido("Las asignaturas no cumplen lo que pide el LSI");
			}
			if (primero) {
				cOpt = asig.getCreditos();
				primero = false;
			} else {
				if (!cOpt.equals(asig.getCreditos())) {
					throw new ExcepcionGradoNoValido("Las asignaturas no cumplen lo que pide el LSI");
				}
			}
		}
		// for(Asignatura a: optativas){
		// TipoAsignatura asig = null;
		// if(!(asig ==TipoAsignatura.PRIMER_CUATRIMESTRE) || !(asig
		// ==TipoAsignatura.SEGUNDO_CUATRIMESTRE) ){
		// //optativas = TipoAsignatura.PRIMER_CUATRIMESTRE;
		// throw new ExcepcionGradoNoValido();
		// }
		// }
	}

	/***************************************************
	 * GETTERS AND SETTERS
	 *************************************************/

	public String getNombre() {

		return nombre;

	}

	public Set<Asignatura> getAsignaturasObligatorias() {

		return new HashSet<Asignatura>(asigObligatorias);

	}

	public Set<Asignatura> getAsignaturasOptativas() {

		return new HashSet<Asignatura>(asigOptativas);

	}

	public Double getNumeroMinimoCreditosOptativas() {

		return creditosMinimos;

	}

	public Double getNumeroTotalCreditos() {

		checkMinimo(creditosMinimos);

		Double total = 0.0;

		for (Asignatura a : getAsignaturasObligatorias()) {
			Double obl = a.getCreditos();
			total = total + obl;
		}

		return total + getNumeroMinimoCreditosOptativas();
	}

	public Set<Departamento> getDepartamentos() {

		Set<Departamento> dpto = new HashSet<Departamento>();

		for (Asignatura asig : getAsignaturasObligatorias()) {

			Departamento asigOblig = asig.getDepartamento();
			dpto.add(asigOblig);

			for (Asignatura asi : getAsignaturasOptativas()) {

				Departamento asigOpt = asi.getDepartamento();
				dpto.add(asigOpt);

			}
		}

		return dpto;

	}

	public Set<Profesor> getProfesores() {

		Set<Profesor> pr = new HashSet<Profesor>();

		for (Departamento dpto : getDepartamentos()) {
			Set<Profesor> prf = dpto.getProfesores();
			pr.addAll(prf);
		}

		return pr;

	}

	public Set<Asignatura> getAsignaturas(Integer curso) {

		Set<Asignatura> aTotal = new HashSet<Asignatura>();

		for (Asignatura asi : getAsignaturasOptativas()) {

			if (asi.getCurso() == curso) {
				aTotal.add(asi);
			}

			for (Asignatura asig : getAsignaturasObligatorias()) {

				if (asig.getCurso() == curso) {
					aTotal.add(asig);
				}
			}

		}

		return aTotal;

	}

	public Asignatura getAsignatura(String codigo) {

		Asignatura as = null;
		for (Asignatura asig : getAsignaturasOptativas()) {
			if (asig.getCodigo() == codigo) {
				asig = as;
			}
		}
		for (Asignatura asigna : getAsignaturasObligatorias()) {
			if (asigna.getCodigo() == codigo) {
				asigna = as;
			}
		}

		return as;
	}

	public SortedMap<Asignatura, Double> getCreditosPorAsignatura() {

		SortedMap<Asignatura, Double> res = new TreeMap<Asignatura, Double>();

		for (Asignatura asi : getAsignaturasObligatorias()) {

			res.put(asi, asi.getCreditos());

		}

		for (Asignatura asig : getAsignaturasOptativas()) {

			res.put(asig, asig.getCreditos());

		}

		return res;

	}

	public SortedSet<Departamento> getDepartamentosOrdenadosPorAsignaturas() {
		Comparator<Departamento> cmp = Comparator.comparing((Departamento d) -> d.getAsignaturas().size()).reversed()
				.thenComparing(Comparator.naturalOrder());
		SortedSet<Departamento> res = new TreeSet<Departamento>(cmp);
		res.addAll(getDepartamentos());
		return res;
	}

	/***************************************************
	 * EQUALS HASHCODE COMPARE-TO
	 *************************************************/
	public boolean equals(Object o) {
		boolean res = false;

		if (o instanceof Grado) {
			Grado grad = (Grado) o;
			res = getNombre().equals(grad.getNombre());
		}

		return res;
	}

	public int hashCode() {

		return getNombre().hashCode();

	}

	public int compareTo(Grado grad) {

		return getNombre().compareTo(grad.getNombre());

	}

	/***************************************************
	 * toString
	 *************************************************/
	public String toString() {
		return getNombre();
	}

}
