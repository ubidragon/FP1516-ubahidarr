package fp.grados.tipos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import fp.grados.excepciones.ExcepcionExpedienteOperacionNoPermitida;

public class ExpedienteImpl implements Expediente {

	private List<Nota> notas;

	/***************************************************
	 * CONSTRUCTOR 1
	 *************************************************/
	public ExpedienteImpl() {

		notas = new ArrayList<Nota>();

	}

	/***************************************************
	 * EXCEPCIONES
	 **************************************************/

	private void checkNota(Nota nots) {
		int not = 0;
		for (Nota no : getNotas()) {

			if (nots.getAsignatura().equals(no.getAsignatura())
					&& nots.getCursoAcademico().equals(no.getCursoAcademico())) {
				not++;
			}

		}
		if (not == 2) {
			throw new ExcepcionExpedienteOperacionNoPermitida("Se ha producido un error de conteo");
		}
	}

	/***************************************************
	 * GETTERS AND SETTERS
	 *************************************************/

	public List<Nota> getNotas() {

		return new ArrayList<Nota>(notas);

	}

	public Double getNotaMedia() {
		/**
		 * Inicializa una nueva cadena vacia de notas, donde meteras las notas
		 * mayores o iguales a 5 despues hay que recorrerla(esto es el for
		 * cojonudo) para hacer el calculo a partir del valor de la nota si no
		 * se hace asi, cogera el total de las notas al hacer el size y no el
		 * numero de notas mayores o iguales a 5
		 **/

		List<Nota> no = new ArrayList<Nota>();
		Double nMedia = 0.0;

		for (Nota n1 : getNotas()) {
			Double not = n1.getValor();

			if (not >= 5) {
				no.add(n1);
			}

		}

		for (Nota n2 : no) {
			Double nota = n2.getValor();
			nMedia = nMedia + (nota / no.size());
		}

		return nMedia;
	}

	public void nuevaNota(Nota n) {

		checkNota(n);

		for (Nota niet : getNotas()) {

			if (n.equals(niet)) {
				notas.remove(niet);
			}

		}

		notas.add(n);

	}

	public List<Nota> getNotasOrdenadasPorAsignatura() {

		Comparator<Nota> cmp = Comparator.comparing(Nota::getAsignatura).thenComparing(Comparator.naturalOrder());

		List<Nota> n = new ArrayList<Nota>(getNotas());
		Collections.sort(n, cmp);

		return n;

	}

	public Nota getMejorNota() {

		Comparator<Nota> cmp = Comparator.comparing(Nota::getCalificacion).thenComparing(Nota::getValor).reversed()
				.thenComparing(Nota::getConvocatoria).thenComparing(Nota::getCursoAcademico);

		SortedSet<Nota> n = new TreeSet<>(cmp);
		n.addAll(getNotas());

		return n.first();
	}

	/***************************************************
	 * EQUALS HASHCODE COMPARE-TO
	 *************************************************/

	public boolean equals(Object o) {
		boolean res = false;

		if (o instanceof Expediente) {
			Expediente ex = (Expediente) o;
			res = getNotas().equals(ex.getNotas());
		}
		return res;

	}

	public int hashCode() {

		return getNotas().hashCode();

	}

	/***************************************************
	 * toString
	 *************************************************/

	public String toString() {

		return notas.toString();

	}

}
