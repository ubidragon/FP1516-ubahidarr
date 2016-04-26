package fp.grados.tipos;

import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

public interface Departamento extends Comparable<Departamento> {

	String getNombre();

	Set<Asignatura> getAsignaturas();

	Set<Profesor> getProfesores();

	void nuevaAsignatura(Asignatura asig);

	void eliminaAsignatura(Asignatura asig);

	void nuevoProfesor(Profesor prof);

	void eliminaProfesor(Profesor prof);

	void borraTutorias();

	void borraTutorias(Categoria c);

	Boolean existeProfesorAsignado(Asignatura a);

	Boolean estanTodasAsignaturasAsignadas();

	void eliminaAsignacionProfesorado(Asignatura a);

	SortedMap<Asignatura, SortedSet<Profesor>> getProfesoresPorAsignatura();

	SortedMap<String, SortedSet<Tutoria>> getTutoriasPorProfesor();

	Profesor getProfesorMaximaDedicacionMediaPorAsignatura();

}
