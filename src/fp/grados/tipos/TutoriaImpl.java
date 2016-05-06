package fp.grados.tipos;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import fp.grados.excepciones.ExcepcionTutoriaNoValida;

public class TutoriaImpl implements Tutoria {

	private DayOfWeek dia;
	private LocalTime inicio;
	private LocalTime fin;

	/***************************************************
	 * CONSTRUCTOR 1
	 *************************************************/
	public TutoriaImpl(DayOfWeek dia, LocalTime inicio, LocalTime fin) {

		checkDia(dia);
		checkHorario(inicio, fin);

		this.dia = dia;
		this.inicio = inicio;
		this.fin = fin;

		checkDuracion(getDuracion());

	}

	/***************************************************
	 * CONSTRUCTOR 2
	 *************************************************/

	public TutoriaImpl(DayOfWeek dia, LocalTime inicio, Integer duracion) {

		checkDia(dia);

		this.dia = dia;
		this.inicio = inicio;
		this.fin = inicio.plusMinutes(duracion);

		checkDuracion(getDuracion());
		checkHorario(inicio, fin);
	}

	/***************************************************
	 * CONSTRUCTOR APARTIR DE STRING
	 *************************************************/
	public TutoriaImpl(String s) {
		String[] trozos = s.split(",");

		if (trozos.length != 3) {
			throw new IllegalArgumentException();
		}

		String dia = trozos[0].trim();
		DayOfWeek diasemana = transformaDia(dia);
		checkDia(diasemana);
		LocalTime horaCom = LocalTime.parse(trozos[1].trim());
		LocalTime horaFin = LocalTime.parse(trozos[2].trim());

		
		checkDuracion((int) horaCom.until(horaFin, ChronoUnit.MINUTES));
		checkHorario(horaCom,horaFin);

		this.dia = diasemana;
		this.inicio = horaCom;
		this.fin = horaFin;

	}

	/***************************************************
	 * CHECK
	 *************************************************/

	private void checkDuracion(Integer duracion) {
		if (duracion < 30) {
			throw new ExcepcionTutoriaNoValida("La tutoria no cumple la longitud minima");
		}
	}

	private void checkDia(DayOfWeek dia) {
		if (dia.equals(DayOfWeek.SATURDAY) || dia.equals(DayOfWeek.SUNDAY)) {
			throw new ExcepcionTutoriaNoValida("Dia de la tutoria no valida");
		}
	}

	private void checkHorario(LocalTime inicio, LocalTime fin) {

		// if (inicio.isBefore(LocalTime.of(8, 30)) ||
		// fin.isBefore(LocalTime.of(8, 30))
		// || inicio.isAfter(LocalTime.of(21, 30)) ||
		// fin.isAfter(LocalTime.of(21, 30))) {

		if (inicio.isBefore(LocalTime.of(8, 30)) || fin.isAfter(LocalTime.of(21, 30))) {
			throw new ExcepcionTutoriaNoValida("Horario de tutoria no valido");
		}
	}

	/***************************************************
	 * GETTERS AND SETTERS
	 *************************************************/

	public DayOfWeek getDiaSemana() {

		return dia;

	}

	public DayOfWeek transformaDia(String dia) {
		// Sirve para asociar el string del dia con el metodo de DayOfWeek
		DayOfWeek dias;

		if (dia.equals("L")) {

			dias = DayOfWeek.MONDAY;

		} else if (dia.equals("M")) {

			dias = DayOfWeek.TUESDAY;

		} else if (dia.equals("X")) {

			dias = DayOfWeek.WEDNESDAY;

		} else if (dia.equals("J")) {

			dias = DayOfWeek.THURSDAY;

		} else if (dia.equals("V")) {

			dias = DayOfWeek.FRIDAY;

		} else {

			throw new ExcepcionTutoriaNoValida();
		}

		return dias;

	}

	public String getDameDia() {
		String d;

		if (this.dia == DayOfWeek.MONDAY) {

			d = "L";

		} else if (this.dia == DayOfWeek.TUESDAY) {

			d = "M";

		} else if (this.dia == DayOfWeek.WEDNESDAY) {

			d = "X";

		} else if (this.dia == DayOfWeek.THURSDAY) {

			d = "J";

		} else if (this.dia == DayOfWeek.FRIDAY) {

			d = "V";

		} else {

			d = null;

		}

		return d;

	}

	public LocalTime getHoraComienzo() {

		return inicio;

	}

	public LocalTime getHoraFin() {

		return fin;

	}

	public Integer getDuracion() {
		// Al inicio se le resta el final y devuelve el resultado en minutos

		return (int) inicio.until(fin, ChronoUnit.MINUTES);
	}

	/***************************************************
	 * EQUALS HASHCODE COMPARE-TO
	 *************************************************/

	public boolean equals(Object o) {
		boolean res = false;

		if (o instanceof Tutoria) {

			Tutoria t = (Tutoria) o;
			res = getDiaSemana().equals(t.getDiaSemana()) && getHoraComienzo().equals(t.getHoraComienzo());

		}

		return res;

	}

	public int hashCode() {

		return getDiaSemana().hashCode() + getHoraComienzo().hashCode() * 31;

	}

	public int compareTo(Tutoria t) {
		int res = getDiaSemana().compareTo(t.getDiaSemana());

		if (res == 0) {

			res = getHoraComienzo().compareTo(t.getHoraComienzo());

		}

		return res;

	}

	/***************************************************
	 * toString
	 *************************************************/

	public String toString() {
		return getDameDia() + " " + getHoraComienzo() + "-" + getHoraFin();
	}
}
