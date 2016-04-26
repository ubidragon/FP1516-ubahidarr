package fp.grados.tipos;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;
import java.util.SortedSet;

public interface Profesor extends Persona {

	Categoria getCategoria();

	void setCategoria(Categoria categoria);

	SortedSet<Tutoria> getTutorias();

	void nuevaTutoria(LocalTime horaComienzo, Integer duracionMinutos, DayOfWeek dia);

	void borraTutoria(LocalTime horaComienzo, DayOfWeek dia);

	void borraTutorias();

	List<Asignatura> getAsignaturas();

	List<Double> getCreditos();

	Departamento getDepartamento();

	void setDepartamento(Departamento nuevoDepartamento);

	Double getDedicacionTotal();

	void imparteAsignatura(Asignatura asig, Double dedicacion);

	void eliminaAsignatura(Asignatura asig);

	Double dedicacionAsignatura(Asignatura asig);
}
