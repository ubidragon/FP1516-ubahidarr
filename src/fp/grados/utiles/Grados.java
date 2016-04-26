package fp.grados.utiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

import fp.grados.tipos.Alumno;
import fp.grados.tipos.AlumnoImpl;
import fp.grados.tipos.AlumnoImpl2;
import fp.grados.tipos.Asignatura;
import fp.grados.tipos.AsignaturaImpl;
import fp.grados.tipos.Beca;
import fp.grados.tipos.BecaImpl;
import fp.grados.tipos.Categoria;
import fp.grados.tipos.Centro;
import fp.grados.tipos.CentroImpl;
import fp.grados.tipos.CentroImpl2;
import fp.grados.tipos.Departamento;
import fp.grados.tipos.DepartamentoImpl;
import fp.grados.tipos.DepartamentoImpl2;
import fp.grados.tipos.Despacho;
import fp.grados.tipos.DespachoImpl;
import fp.grados.tipos.Espacio;
import fp.grados.tipos.EspacioImpl;
import fp.grados.tipos.Grado;
import fp.grados.tipos.GradoImpl;
import fp.grados.tipos.GradoImpl2;
import fp.grados.tipos.Nota;
import fp.grados.tipos.Profesor;
import fp.grados.tipos.ProfesorImpl;
import fp.grados.tipos.ProfesorImpl2;
import fp.grados.tipos.TipoAsignatura;
import fp.grados.tipos.TipoBeca;
import fp.grados.tipos.TipoEspacio;
import fp.grados.tipos.Tutoria;

public class Grados {
	/*
	 * Metodo generico para hacer llamdas a ficheros y hacer el metodo
	 * creacional apartir de un fichero
	 */
	public static <T> List<T> leeFichero(String nombreFichero, Function<String, T> funcion_deString_aT) {
		List<T> res = null;
		try {
			res = Files.lines(Paths.get(nombreFichero)).map(funcion_deString_aT).collect(Collectors.toList());
		} catch (IOException e) {
			System.out.println("Error en lectura del fichero: " + nombreFichero);
		}
		return res;
	}

	private static Boolean usarJava8 = true;

	public static void setUsarJava8(Boolean b) {
		usarJava8 = b;
	}

	/********* Tipo "Alumno" ************************/
	private static Set<Alumno> creaAlum = new HashSet<Alumno>();

	public static void actualizaPobsAlumno(Alumno res) {
		creaAlum.add(res);
	}

	// METODO CREACIONAL POR PARAMETRTOS

	public static Alumno createAlumno(String dni, String nombre, String apellidos, LocalDate fechaNacimiento,
			String email) {

		// crear una variable de tipo retorno
		Alumno res;
		// usar el constructor correspondiente
		if (usarJava8) {
			res = new AlumnoImpl2(dni, nombre, apellidos, fechaNacimiento, email);
		} else {
			res = new AlumnoImpl(dni, nombre, apellidos, fechaNacimiento, email);
		}

		// actualiza las propiedades poblacionales
		actualizaPobsAlumno(res);
		// devuelve el objeto
		return res;

	}

	// Metodo creacional copia
	public static Alumno createAlumno(Alumno original) {

		Alumno res = createAlumno(original.getDNI(), original.getNombre(), original.getApellidos(),
				original.getFechaNacimiento(), original.getEmail());

		for (Asignatura a : original.getAsignaturas()) {

			res.matriculaAsignatura(a);

		}

		for (Nota not : original.getExpediente().getNotas()) {

			res.evaluaAlumno(not.getAsignatura(), not.getCursoAcademico(), not.getConvocatoria(), not.getValor());

		}

		return res;

	}

	// Metodo creacional apartir de string
	public static Alumno createAlumno(String s) {

		// Genera un nuevo alumno en base al String
		Alumno res = new AlumnoImpl(s);

		// Añade el alumno al Set por eso se actualiza
		actualizaPobsAlumno(res);

		return res;

	}

	public static List<Alumno> createAlumnos(String file) {

		List<Alumno> res = leeFichero(file, s -> new AlumnoImpl(s));

		return res;

	}

	/** getters factorias **/

	public static Integer getNumAlumnosCreados() {

		return creaAlum.size();

	}

	public static Set<Alumno> getAlumnosCreados() {

		return new HashSet<Alumno>(creaAlum);

	}

	/********* Tipo "Asignatura" ***************/

	// Asignatura: códigos de todas las asignaturas creadas.
	// La implementacion de esta propiedad
	// debe posibilitar el aceso a cualquier
	// asignatura creada apartir de su codigo

	private static Map<String, Asignatura> asignaturasPorCodigo = new HashMap<String, Asignatura>();

	private static void actualizaPoblacionalesAsignatura(Asignatura a) {

		asignaturasPorCodigo.put(a.getCodigo(), a);

	}

	public static Asignatura createAsignatura(String nombre, String codigo, Double creditos, TipoAsignatura tipo,
			Integer curso, Departamento departamento) {

		Asignatura res = new AsignaturaImpl(nombre, codigo, creditos, tipo, curso, departamento);

		actualizaPoblacionalesAsignatura(res);

		return res;

	}

	public static Asignatura createAsignatura(String asignatura) {

		Asignatura res = new AsignaturaImpl(asignatura);

		actualizaPoblacionalesAsignatura(res);

		return res;

	}

	public static List<Asignatura> createAsignaturas(String nombreFichero) {

		List<Asignatura> res = leeFichero(nombreFichero, s -> new AsignaturaImpl(s));

		return res;

	}

	/** getters factorias **/

	public static Integer getNumAsignaturasCreadas() {

		return asignaturasPorCodigo.size();

	}

	public static Set<Asignatura> getAsignaturasCreadas() {

		return new HashSet<Asignatura>(asignaturasPorCodigo.values());

	}

	public static Set<String> getCodigosAsignaturasCreadas() {

		return new HashSet<String>(asignaturasPorCodigo.keySet());

	}

	public static Asignatura getAsignaturaCreada(String codigo) {

		return asignaturasPorCodigo.get(codigo);

	}

	/********* Tipo "Beca" ***************/
	private static Set<Beca> becas = new HashSet<Beca>();

	private static Integer[] numBecasPorTipo = { 0, 0, 0 };

	public static Integer getNumBecasCreadas() {

		return becas.size();

	}

	public static Set<Beca> getBecasCreadas() {

		return new HashSet<Beca>(becas);

	}

	public static Integer getNumBecasTipo(TipoBeca tipo) {

		return numBecasPorTipo[tipo.ordinal()];

	}

	private static void actualizaPoblacionalesBeca(Beca b) {

		becas.add(b);

		numBecasPorTipo[b.getTipo().ordinal()]++;

	}

	public static Beca createBeca(String codigo, Double cuantiaTotal, Integer duracion, TipoBeca tipo) {

		Beca res = new BecaImpl(codigo, cuantiaTotal, duracion, tipo);

		actualizaPoblacionalesBeca(res);

		return res;

	}

	public static Beca createBeca(String codigo, TipoBeca tipo) {

		Beca res = new BecaImpl(codigo, tipo);

		actualizaPoblacionalesBeca(res);

		return res;

	}

	public static Beca createBeca(Beca beca) {

		Beca res = new BecaImpl(beca.getCodigo(), beca.getCuantiaTotal(), beca.getDuracion(), beca.getTipo());

		actualizaPoblacionalesBeca(res);

		return res;
	}

	public static Beca createBeca(String beca) {

		Beca res = new BecaImpl(beca);

		actualizaPoblacionalesBeca(res);

		return res;

	}

	public static List<Beca> createBecas(String nombreFichero) {

		List<Beca> res = leeFichero(nombreFichero, s -> new BecaImpl(s));

		return res;

	}

	/********* Tipo "Centro" ***************/

	private static Set<Centro> centros = new HashSet<Centro>();

	private static void actualizaPoblacionalesCentro(Centro res) {

		centros.add(res);

	}

	public static Centro createCentro(String nombre, String direccion, Integer plantas, Integer sotanos) {

		Centro res;

		if (usarJava8) {

			res = new CentroImpl2(nombre, direccion, plantas, sotanos);

		} else {

			res = new CentroImpl(nombre, direccion, plantas, sotanos);

		}

		actualizaPoblacionalesCentro(res);
		return res;

	}

	public static Centro createCentro(Centro original) {

		Centro res = createCentro(original.getNombre(), original.getDireccion(), original.getNumeroPlantas(),
				original.getNumeroSotanos());

		for (Espacio e : original.getEspacios()) {

			res.nuevoEspacio(e);

		}

		return res;

	}

	public static Integer getNumCentrosCreados() {

		return centros.size();

	}

	public static Integer getMaxPlantas() {

		Integer max = 0;

		for (Centro esp : centros) {

			Integer max1 = esp.getNumeroPlantas();

			if (max.compareTo(max1) < 0) {

				max = max1;

			}

		}

		if (centros.isEmpty()) {

			return null;

		} else {

			return max;

		}

	}

	public static Integer getMaxSotanos() {

		Integer max = 0;

		for (Centro esp : centros) {

			Integer max1 = esp.getNumeroSotanos();

			if (max.compareTo(max1) < 0) {

				max = max1;

			}

		}

		if (centros.isEmpty()) {

			return null;

		} else {

			return max;

		}

	}

	public static Double getMediaPlantas() {

		Double media = 0.;

		for (Centro c : centros) {

			Integer plantas = c.getNumeroPlantas();
			media = media + plantas;

		}

		return media / centros.size();

	}

	public static Double getMediaSotanos() {

		Double media = 0.;

		for (Centro c : centros) {

			Integer sotanos = c.getNumeroSotanos();
			media = media + sotanos;

		}

		return media / centros.size();

	}

	public static Set<Centro> getCentrosCreados() {

		return new HashSet<Centro>(centros);

	}

	/********* Tipo "Despacho" ***************/

	private static SortedSet<Despacho> despachos = new TreeSet<Despacho>();

	private static void actualizaPoblacionalesDespacho(Despacho des) {

		despachos.add(des);

	}

	public static Despacho createDespacho(String despacho) {

		Despacho res = new DespachoImpl(despacho);

		actualizaPoblacionalesDespacho(res);
		actualizaPoblacionalesEspacio(res);

		return res;

	}

	public static List<Despacho> createDespachos(String nombreFichero) {

		List<Despacho> res = leeFichero(nombreFichero, s -> new DespachoImpl(s));

		return res;

	}

	public static Despacho createDespacho(String aula, Integer capacidad, Integer planta) {

		Despacho res = new DespachoImpl(aula, capacidad, planta);

		actualizaPoblacionalesDespacho(res);
		actualizaPoblacionalesEspacio(res);

		return res;

	}

	public static Despacho createDespacho(Despacho original) {

		return createDespacho(original.getNombre(), original.getCapacidad(), original.getPlanta());

	}

	/********* Tipo "Departamento" ***************/

	private static Set<Departamento> departamentos = new HashSet<Departamento>();

	public static Integer getNumDepartamentosCreados() {
		return departamentos.size();
	}

	public static Set<Departamento> getDepartamentosCreados() {
		return new HashSet<Departamento>(departamentos);
	}

	private static void actualizaPoblacionalesDepartamento(Departamento d) {
		departamentos.add(d);
	}

	public static Departamento createDepartamento(String nombre) {
		Departamento res = null;

		if (usarJava8) {

			res = new DepartamentoImpl2(nombre);

		} else {

			res = new DepartamentoImpl(nombre);

		}

		actualizaPoblacionalesDepartamento(res);
		return res;

	}

	/********* Tipo "Espacio" ***************/

	private static SortedSet<Espacio> espacios = new TreeSet<Espacio>();

	private static void actualizaPoblacionalesEspacio(Espacio es) {

		espacios.add(es);

	}

	public static SortedSet<Espacio> getEspaciosCreados() {

		return new TreeSet<Espacio>(espacios);

	}

	public static Integer getNumEspaciosCreados() {

		return espacios.size();

	}

	public static Espacio createEspacio(String s) {

		Espacio res = new EspacioImpl(s);
		actualizaPoblacionalesEspacio(res);

		return res;

	}

	public static List<Espacio> createEspacios(String nombreFichero) {

		List<Espacio> res = leeFichero(nombreFichero, s -> new EspacioImpl(s));

		return res;

	}

	public static Espacio createEspacio(TipoEspacio tipo, String aula, Integer cap, Integer planta) {

		Espacio res = new EspacioImpl(tipo, aula, cap, planta);
		actualizaPoblacionalesEspacio(res);

		return res;

	}

	public static Espacio createEspacio(Espacio o) {

		return createEspacio(o.getTipo(), o.getNombre(), o.getCapacidad(), o.getPlanta());

	}

	public static Integer[] getNumEspaciosCreados2() {

		Integer[] res = new Integer[TipoEspacio.values().length];

		Arrays.fill(res, 0);

		for (Espacio esp : espacios) {

			res[esp.getTipo().ordinal()]++;

		}

		return res;

	}

	public static Integer getPlantaMayorEspacio() {

		if (espacios.isEmpty()) {

			return null;

		} else {

			return espacios.stream().max(Comparator.comparing(Espacio::getPlanta)).get().getPlanta();

		}

	}

	public static Integer getPlantaMenorEspacio() {

		// poseemos un conjunto de espacios que tenemos ordenados(sortedset)
		// necesitamos uno para coger su planta
		// 1º si estan vacio y no hay ningun espacio creado, la plantya tiene
		// que ser null no hay ningun espacio y si hay espacios, cogemos la
		// planta del rpimero que habias cogido redccorremos el espacio le vamos
		// sacando la planta y lo comparamos la planta del primero con las demas
		// 2º si la primera es mas grande que la segunda te tiene que cambiar
		// el
		// ps por la mas pequeña
		if (espacios.isEmpty()) {

			return null;

		} else {

			return espacios.stream().min(Comparator.comparing(Espacio::getPlanta)).get().getPlanta();

		}
	}

	/********* Tipo "Grado" ***************/

	private static Set<Grado> grados = new HashSet<Grado>();

	private static void actualizaPobsGrado(Grado res) {

		grados.add(res);

	}

	public static Set<Grado> getGradosCreados() {

		return new HashSet<Grado>(grados);

	}

	public static Grado createGrado(String nombre, Set<Asignatura> obligatorias, Set<Asignatura> optativas,
			Double creditos) {

		Grado res;

		if (usarJava8) {

			res = new GradoImpl2(nombre, obligatorias, optativas, creditos);

		} else {

			res = new GradoImpl(nombre, obligatorias, optativas, creditos);

		}

		actualizaPobsGrado(res);
		return res;

	}

	public static Integer getNumGradosCreados() {

		return grados.size();

	}

	public static Double getMediaAsignaturasGrados() {

		return getMediaAsignaturasObligatoriasGrados() + getMediaAsignaturasOptativasGrados();

	}

	public static Double getMediaAsignaturasObligatoriasGrados() {

		Double media = 0.;

		for (Grado g : grados) {

			Integer m = g.getAsignaturasObligatorias().size();
			media = media + m;

		}

		if (grados.isEmpty()) {

			return 0.;

		}

		return media / grados.size();
	}

	public static Double getMediaAsignaturasOptativasGrados() {

		Double media = 0.;

		for (Grado g : grados) {

			Integer m = g.getAsignaturasOptativas().size();
			media = media + m;

		}

		if (grados.isEmpty()) {

			return 0.;

		}

		return media / grados.size();
	}

	/********* Tipo "Profesor" ***************/

	private static Boolean usarImplementacionMap = true;

	private static Set<Profesor> profesores = new HashSet<Profesor>();

	public static Integer getNumProfesoresCreados() {
		return profesores.size();
	}

	public static Set<Profesor> getProfesoresCreados() {
		return new HashSet<Profesor>(profesores);
	}

	public static void setUsarImplementacionMapProfesor(Boolean b) {
		usarImplementacionMap = b;
	}

	private static void actualizaPoblacionalesProfesor(Profesor p) {
		profesores.add(p);
	}

	public static Profesor createProfesor(String dni, String nombre, String apellidos, LocalDate fechaNacimiento,
			String email, Categoria categoria, Departamento departamento) {
		Profesor res = null;
		if (usarImplementacionMap) {
			res = new ProfesorImpl2(dni, nombre, apellidos, fechaNacimiento, email, categoria, departamento);
		} else {
			res = new ProfesorImpl(dni, nombre, apellidos, fechaNacimiento, email, categoria, departamento);
		}
		actualizaPoblacionalesProfesor(res);
		return res;
	}

	public static Profesor createProfesor(Profesor profesor) {

		Profesor res = createProfesor(profesor.getDNI(), profesor.getNombre(), profesor.getApellidos(),
				profesor.getFechaNacimiento(), profesor.getEmail(), profesor.getCategoria(),
				profesor.getDepartamento());

		copiaAsignaturasProfesor(res, profesor);
		copiaTutoriasProfesor(res, profesor);

		return res;
	}

	private static void copiaAsignaturasProfesor(Profesor res, Profesor profesor) {

		for (Asignatura a : profesor.getAsignaturas()) {

			res.imparteAsignatura(a, profesor.dedicacionAsignatura(a));

		}

	}

	private static void copiaTutoriasProfesor(Profesor res, Profesor profesor) {

		for (Tutoria t : profesor.getTutorias()) {

			res.nuevaTutoria(t.getHoraComienzo(), t.getDuracion(), t.getDiaSemana());

		}

	}

}
// TODO Metidos los test de los constructores por fichero de alumnos asigaturas
// becas despachos espacios notas personas tutorias
// TODO añadidos TODO a los tests que me faltan por hacer
