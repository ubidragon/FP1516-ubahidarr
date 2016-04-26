package fp.grados.tipos.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import fp.grados.excepciones.ExcepcionAlumnoNoValido;
import fp.grados.excepciones.ExcepcionAlumnoOperacionNoPermitida;
import fp.grados.tipos.Alumno;
import fp.grados.tipos.AlumnoImpl;
import fp.grados.tipos.Asignatura;
import fp.grados.tipos.AsignaturaImpl;
import fp.grados.tipos.TipoAsignatura;
import fp.grados.utiles.Grados;

public class TestAlumno {

	static String ubidragon = "   	                                    $,  $,     ,             "
			+ "\n     Powered                            ss.$ss. .s'      "
			+ "\n                                ,     .ss$$$$$$$$$$s,               "
			+ "\n              by                $. s$$$$$$$$$$$$$$`$$Ss        "
			+ "\n                                 $$$$$$$$$$$$$$$$$$o$$$       ,        "
			+ "\n                               s$$$$$$$$$$$$$$$$$$$$$$$$s,  ,s   "
			+ "\n                              s$$$$$$$$$'$$$$$$''''$$$$$$'$$$$$,      "
			+ "\n                              s$$$$$$$$$$s''$$$$ssssss'$$$$$$$$'    "
			+ "\n                             s$$$$$$$$$$'         `'''ss'$'$s''       "
			+ "\n                             s$$$$$$$$$$,              `''''$  .s$$s "
			+ "\n                             s$$$$$$$$$$$$s,...               `s$$'  ` "
			+ "\n                         `ssss$$$$$$$$$$$$$$$$$$$$####s.     .$$'$.   , s- "
			+ "\n                           `''''$$$$$$$$$$$$$$$$$$$$#####$$$$$$'     $.$' "
			+ "\n                                 '$$$$$$$$$$$$$$$$$$$$$####s'''     .$$$| "
			+ "\n                                  '$$$$$$$$$$$$$$$$$$$$$$$$##s    .$$' $  "
			+ "\n                                   $$''$$$$$$$$$$$$$$$$$$$$$$$$$$$$$'   ` "
			+ "\n                                  $$'  '$'$$$$$$$$$$$$$$$$$$$$S'''''  "
			+ "\n                             ,   ,'     '  $$$$$$$$$$$$$$$$####s   "
			+ "\n                             $.          .s$$$$$$$$$$$$$$$$$####' "
			+ "\n                 ,           '$s.   ..ssS$$$$$$$$$$$$$$$$$$$####' "
			+ "\n                 $           .$$$S$$$$$$$$$$$$$$$$$$$$$$$$#####' "
			+ "\n                 Ss     ..sS$$$$$$$$$$$$$$$$$$$$$$$$$$$######'' "
			+ "\n                  '$$sS$$$$$$$$$$$$$$$$$$$$$$$$$$$########' "
			+ "\n           ,      s$$$$$$$$$$$$$$$$$$$$$$$$#########''' "
			+ "\n           $    s$$$$$$$$$$$$$$$$$$$$$#######'''      s'         , "
			+ "\n           $$..$$$$$$$$$$$$$$$$$$######''       ....,$$....    ,$ "
			+ "\n            '$$$$$$$$$$$$$$$######'' ,     .sS$$$$$$$$$$$$$$$$s$$ "
			+ "\n              $$$$$$$$$$$$#####'     $, .s$$$$$$$$$$$$$$$$$$$$$$$$s. "
			+ "\n   )          $$$$$$$$$$$#####'      `$$$$$$$$$###########$$$$$$$$$$$. "
			+ "\n  ((          $$$$$$$$$$$#####       $$$$$$$$###'       '####$$$$$$$$$$  "
			+ "\n  ) (         $$$$$$$$$$$$####.     $$$$$$###'             '###$$$$$$$$$   s' "
			+ "\n (   )        $$$$$$$$$$$$$####.   $$$$$###'                ####$$$$$$$$s$$' "
			+ "\n )  ( (       $$'$$$$$$$$$$$#####.$$$$$###'  Ubidragon     .###$$$$$$$$$$' "
			+ "\n (  )  )   _,$'   $$$$$$$$$$$$######.$$##'                .###$$$$$$$$$$ "
			+ "\n ) (  ( ).         '$$$$$$$$$$$$$#######,,,.          ..####$$$$$$$$$$$' "
			+ "\n(   )$ )  )        ,$$$$$$$$$$$$$$$$$$####################$$$$$$$$$$$'         "
			+ "\n(   ($$  ( )     _sS'  `'$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$S$$,        "
			+ "\n )  )$$$s ) )  .      .   `$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$''  `$$    "
			+ "\n  (   $$$Ss/  .$,    .$,,s$$$$$$##S$$$$$$$$$$$$$$$$$$$$$$$$S''        '  "
			+ "\n    ))_$$$$$$$$$$$$$$$$$$$$$$$##'  $$        `$$.        `$$. "
			+ "\n        `'S$$$$$$$$$$$$$$$$$#'      $          `$          `$ "
			+ "\n            `''''''''''''''         '           '           '  ";

	public static void main(String[] args) throws InterruptedException {

		noPlagio();

		casoDePrueba1();
		casoDePrueba2();
		casoDePrueba3();
		casoDePrueba4();
		casoDePrueba5();
		casoDePrueba6();
		// casoDePrueba7();
		// casoDePrueba8();
		// casoDePrueba9();
		// casoDePrueba10();
		// casoDePrueba11();
		// casoDePrueba12();
		// casoDePrueba13();
	}

	private static void noPlagio() throws InterruptedException {

		for (int i = 0; i < ubidragon.length(); i++) {
			Thread.sleep(2);
			System.out.print(ubidragon.charAt(i));
		}
	}

	/*
	 * CASO GENERICO DE PRUEBA
	 * 
	 * private static void casoDePruebaX() { System.out.println(
	 * "\n\n Caso de prueba X <==============> Ubidragon" + "\n CASO" +
	 * "\n DESCRIPCION DEL CASO\n");
	 * 
	 * 
	 * }
	 */

	private static void casoDePrueba1() {

		System.out.println("\n\n Caso de prueba 1 <==============> Ubidragon" + "\n CONSTRUCTOR"
				+ "\n constructor sin meteduras de pata\n");
		Alumno alum = new AlumnoImpl("04717453S", "Juan", "Perez Gomez", LocalDate.of(1992, 5, 28),
				"alumno1@alum.us.es");
		mostrarAlumno(alum);
	}

	private static void casoDePrueba2() {

		System.out.println(
				"\n\n Caso de prueba 4 <==============> Ubidragon" + "\n Constructor" + "\n Testo de constructor\n");

		System.out.println("Constructor sin excepciones");

		System.out.println("constructor 1");
		testConstructor("12345678Z", "Antonio", "Hidalgo Garcia", LocalDate.of(1990, 9, 25), "anthidgar@alum.us.es");

		System.out.println("constructor 2");
		testConstructor("19271059A", "Juan", "Perez Gonzalez", LocalDate.of(1950, 9, 15), "juapergon@alum.us.es");

		System.out.println("constructor 3");
		testConstructor("61844079T", "Eduardo", "Hidalgo Perez", LocalDate.of(1990, 3, 25), "eduhidper@alum.us.es");

		System.out.println("constructor 4");
		testConstructor("50146713C", "Jose", "Gonzalez Diaz", LocalDate.of(1980, 1, 15), "josgondia@alum.us.es");

		System.out.println("constructor 5");
		testConstructor("58127020V", "Eustaquio", "Hidalgo Gonzalez", LocalDate.of(1990, 9, 15),
				"eushidgon@alum.us.es");

		System.out.println("constructor 6");
		testConstructor("40560724V", "Joaquin", "Arriaga Garcia", LocalDate.of(1965, 3, 25), "joaarrgar@alum.us.es");

		System.out.println("constructor 7");
		testConstructor("01742665R", "Miguel", "Hidalgo Corchuelo", LocalDate.of(1990, 7, 8), "mighidcor@alum.us.es");

		System.out.println("\n Constructor con excepciones");

		System.out.println("constructor 1");
		testConstructor("12345678Z", "Antonio", "Hidalgo Garcia", LocalDate.of(1990, 9, 25), "anthidgar@alum.uses");

		System.out.println("constructor 2");
		testConstructor("19271059A", "Juan", "Perez Gonzalez", LocalDate.of(1950, 9, 15), "juapergon@alumus.es");

		System.out.println("constructor 3");
		testConstructor("61844079T", "Eduardo", "Hidalgo Perez", LocalDate.of(1990, 3, 25), "eduhidper@alum.es");

		System.out.println("constructor 4");
		testConstructor("50146713C", "Jose", "Gonzalez Diaz", LocalDate.of(1980, 1, 15), "josgondia@us.es");

	}

	private static void casoDePrueba3() {

		System.out.println("\n\n Caso de prueba 2 <==============> Ubidragon" + "\n cambio de email"
				+ "\n cambiar email sin que salte excepcion\n");

		Alumno alum = new AlumnoImpl("12345678Z", "Antonio", "Hidalgo Garcia", LocalDate.of(1990, 9, 25),
				"anthidgar@alum.us.es");

		Alumno alum2 = new AlumnoImpl("19271059A", "Juan", "Perez Gonzalez", LocalDate.of(1950, 9, 15),
				"juapergon@alum.us.es");

		Alumno alum3 = new AlumnoImpl("61844079T", "Eduardo", "Hidalgo Perez", LocalDate.of(1990, 3, 25),
				"eduhidper@alum.us.es");

		Alumno alum4 = new AlumnoImpl("50146713C", "Jose", "Gonzalez Diaz", LocalDate.of(1980, 1, 15),
				"josgondia@alum.us.es");

		Alumno alum5 = new AlumnoImpl("58127020V", "Eustaquio", "Hidalgo Gonzalez", LocalDate.of(1990, 9, 15),
				"eushidgon@alum.us.es");

		Alumno alum6 = new AlumnoImpl("40560724V", "Joaquin", "Arriaga Garcia", LocalDate.of(1965, 3, 25),
				"joaarrgar@alum.us.es");

		Alumno alum7 = new AlumnoImpl("01742665R", "Miguel", "Hidalgo Corchuelo", LocalDate.of(1990, 7, 8),
				"mighidcor@alum.us.es");

		setEmailUniversitario(alum, "prueba_de_cambio_de_email@alum.us.es");

		setEmailUniversitario(alum2, "prueba_de_cambio_de_email2@alum.us.es");

		setEmailUniversitario(alum3, "prueba_de_cambio_de_email3@alum.us.es");

		setEmailUniversitario(alum4, "prueba_de_cambio_de_email4@alum.us.es");

		setEmailUniversitario(alum5, "prueba_de_cambio_de_email5@alum.us.es");

		setEmailUniversitario(alum6, "prueba_de_cambio_de_email6@alum.us.es");

		setEmailUniversitario(alum7, "prueba_de_cambio_de_email7@alum.us.es");

	}

	private static void casoDePrueba4() {

		System.out.println("\n\n Caso de prueba 3 <==============> Ubidragon" + "\n cambio de email"
				+ "\n cambiar email haciendo que salte excepcion\n");

		Alumno alum = new AlumnoImpl("12345678Z", "Antonio", "Hidalgo Garcia", LocalDate.of(1990, 9, 25),
				"anthidgar@alum.us.es");

		Alumno alum2 = new AlumnoImpl("19271059A", "Juan", "Perez Gonzalez", LocalDate.of(1950, 9, 15),
				"juapergon@alum.us.es");

		Alumno alum3 = new AlumnoImpl("61844079T", "Eduardo", "Hidalgo Perez", LocalDate.of(1990, 3, 25),
				"eduhidper@alum.us.es");

		Alumno alum4 = new AlumnoImpl("50146713C", "Jose", "Gonzalez Diaz", LocalDate.of(1980, 1, 15),
				"josgondia@alum.us.es");

		Alumno alum5 = new AlumnoImpl("58127020V", "Eustaquio", "Hidalgo Gonzalez", LocalDate.of(1990, 9, 15),
				"eushidgon@alum.us.es");

		Alumno alum6 = new AlumnoImpl("40560724V", "Joaquin", "Arriaga Garcia", LocalDate.of(1965, 3, 25),
				"joaarrgar@alum.us.es");

		Alumno alum7 = new AlumnoImpl("01742665R", "Miguel", "Hidalgo Corchuelo", LocalDate.of(1990, 7, 8),
				"mighidcor@alum.us.es");

		setEmailUniversitario(alum, "prueba_de_cambio_de_email@alum.uses");

		setEmailUniversitario(alum2, "prueba_de_cambio_de_email2@alumus.es");

		setEmailUniversitario(alum3, "prueba_de_cambio_de_email3alum.us.es");

		setEmailUniversitario(alum4, "prueba_de_cambio_de_email4@alu.us.es");

		setEmailUniversitario(alum5, "prueba_de_cambio_de_email5@us.es");

		setEmailUniversitario(alum6, "prueba_de_cambio_de_email6@alum.us");

		setEmailUniversitario(alum7, "prueba_de_cambio_de_email7@lum.us.es");

	}

	private static void casoDePrueba5() {

		System.out.println("\n\n Caso de prueba 5 <==============> Ubidragon" + "\n matricula asignatura"
				+ "\n en todas sus variantes\n");
		Alumno alum = new AlumnoImpl("12345678Z", "Antonio", "Hidalgo Garcia", LocalDate.of(1990, 9, 25),
				"anthidgar@alum.us.es");

		Asignatura as = new AsignaturaImpl("Algebra Lineal y Numerica", "2050001", 6.0, TipoAsignatura.ANUAL, 2);
		Asignatura as1 = new AsignaturaImpl("Introduccion a las Matematicas Discretas", "2060901", 18.0,
				TipoAsignatura.PRIMER_CUATRIMESTRE, 1);
		Asignatura as2 = new AsignaturaImpl("Fundamentos Fisicos de la Informatica", "2050801", 12.0,
				TipoAsignatura.ANUAL, 4);
		Asignatura as3 = new AsignaturaImpl("Diseño y Prueba", "2057801", 18.0, TipoAsignatura.SEGUNDO_CUATRIMESTRE,
				2);
		Asignatura as4 = new AsignaturaImpl("Fisica Molecular", "2650001", 6.0, TipoAsignatura.PRIMER_CUATRIMESTRE, 4);
		Asignatura as5 = new AsignaturaImpl("Estructura de Computadores", "2050601", 12.0,
				TipoAsignatura.SEGUNDO_CUATRIMESTRE, 1);

		System.out.println("matricula asignaturas sin excepciones");

		matriculaAsignatura(alum, as);
		matriculaAsignatura(alum, as1);
		matriculaAsignatura(alum, as2);
		matriculaAsignatura(alum, as3);
		matriculaAsignatura(alum, as4);
		matriculaAsignatura(alum, as5);

		System.out.println("Matriculas duplicadas");

		matriculaAsignatura(alum, as);
		matriculaAsignatura(alum, as1);

	}

	private static void casoDePrueba6() {

		System.out.println("\n\n Caso de prueba 6 <==============> Ubidragon" + "\n elimina asignatura"
				+ "\n en todas sus variantes\n");
		Alumno alum = new AlumnoImpl("12345678Z", "Antonio", "Hidalgo Garcia", LocalDate.of(1990, 9, 25),
				"anthidgar@alum.us.es");
		Asignatura as = new AsignaturaImpl("Algebra Lineal y Numerica", "2050001", 6.0, TipoAsignatura.ANUAL, 2);
		Asignatura as1 = new AsignaturaImpl("Introduccion a las Matematicas Discretas", "2060901", 18.0,
				TipoAsignatura.PRIMER_CUATRIMESTRE, 1);
		Asignatura as2 = new AsignaturaImpl("Fundamentos Fisicos de la Informatica", "2050801", 12.0,
				TipoAsignatura.ANUAL, 4);
		Asignatura as3 = new AsignaturaImpl("Diseño y Prueba", "2057801", 18.0, TipoAsignatura.SEGUNDO_CUATRIMESTRE,
				2);
		Asignatura as4 = new AsignaturaImpl("Fisica Molecular", "2650001", 6.0, TipoAsignatura.PRIMER_CUATRIMESTRE, 4);
		Asignatura as5 = new AsignaturaImpl("Estructura de Computadores", "2050601", 12.0,
				TipoAsignatura.SEGUNDO_CUATRIMESTRE, 1);

		alum.matriculaAsignatura(as);
		alum.matriculaAsignatura(as1);
		alum.matriculaAsignatura(as2);
		alum.matriculaAsignatura(as3);

		System.out.println("elimina asignatura");

		eliminaAsignatura(alum, as);
		eliminaAsignatura(alum, as1);
		eliminaAsignatura(alum, as2);
		eliminaAsignatura(alum, as3);

		System.out.println("elimina asignatura inexistente");

		eliminaAsignatura(alum, as4);
		eliminaAsignatura(alum, as5);

	}

	/* CONSTRUCTOR MEDIEANTE FICHERO */
	public static List<Alumno> create(String nombreFichero) {
		List<Alumno> res = Grados.leeFichero("res/alumnos.txt", s -> new AlumnoImpl(s));
		return res;
	}

	/***************************************************
	 * METODOS AUXILIARES
	 *************************************************/

	private static void testConstructor(String dni, String nombre, String apellidos, LocalDate fechaNacimiento,
			String email) {

		try {

			Alumno alum = new AlumnoImpl(dni, nombre, apellidos, fechaNacimiento, email);

			mostrarAlumno(alum);

		} catch (ExcepcionAlumnoNoValido e) {

			System.out.println("\n Ha devuelto correctamente la excepcion");

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println(
					"\n ERROR!!!! ERROR!!! LA EXCEPCION LANZADA NO ES LA REGISTRADA \n GILIPOLLAS REVISA EL CODIGO");

		}
	}

	private static void setEmailUniversitario(Alumno alum, String email) {

		// Alumno alum = new AlumnoImpl(String dni, String nombre, String
		// apellidos, LocalDate fechaNacimiento,
		// String email);
		try {

			System.out.println("\n El correo antes de la operacion es: " + alum.getEmail());
			System.out.println("El nuevo correo es: " + email + "");
			alum.setEmail(email);
			System.out.println("El correo tras la modificacion es: " + alum.getEmail());

		} catch (ExcepcionAlumnoNoValido e) {

			System.out.println("\n Ha devuelto correctamente la excepcion");

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println(
					"\n ERROR!!!! ERROR!!! LA EXCEPCION LANZADA NO ES LA REGISTRADA \n GILIPOLLAS REVISA EL CODIGO");

		}
	}

	private static void matriculaAsignatura(Alumno a, Asignatura as) {

		try {

			a.matriculaAsignatura(as);
			System.out.println("la nueva asignatura es: " + as);
			System.out.println("las asignaturas son: " + a.getAsignaturas());

		} catch (ExcepcionAlumnoOperacionNoPermitida e) {

			System.out.println("\n Ha devuelto correctamente la excepcion");

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println(
					"\n ERROR!!!! ERROR!!! LA EXCEPCION LANZADA NO ES LA REGISTRADA \n GILIPOLLAS REVISA EL CODIGO");

		}
	}

	private static void eliminaAsignatura(Alumno a, Asignatura as) {

		try {
			System.out.println("Las asignaturas son: " + a.getAsignaturas());
			System.out.println("Las asignatura a eliminar es: " + as);
			a.eliminaAsignatura(as);
			System.out.println("Las asignaturas tras la eliminacion: " + a.getAsignaturas());

		} catch (ExcepcionAlumnoOperacionNoPermitida e) {

			System.out.println("\n Ha devuelto correctamente la excepcion");

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println(
					"\n ERROR!!!! ERROR!!! LA EXCEPCION LANZADA NO ES LA REGISTRADA \n GILIPOLLAS REVISA EL CODIGO");

		}

	}

	// private static void getCurso(){
	// try {
	// System.out.println("Las asignaturas son: " + a.getAsignaturas());
	// System.out.println("Las asignatura a eliminar es: " + as);
	// a.eliminaAsignatura(as);
	// System.out.println("Las asignaturas tras la eliminacion: "
	// +a.getAsignaturas());
	//
	// } catch (ExcepcionAlumnoOperacionNoPermitida e) {
	//
	// System.out.println("\n Ha devuelto correctamente la excepcion");
	//
	// } catch (Exception e) {
	//
	// e.printStackTrace();
	// System.out.println(
	// "\n ERROR!!!! ERROR!!! LA EXCEPCION LANZADA NO ES LA REGISTRADA \n
	// GILIPOLLAS REVISA EL CODIGO");
	//
	// }
	//
	// }

	private static void evaluaAlumno() {

		try {

		} catch (ExcepcionAlumnoNoValido e) {

			System.out.println("\n Ha devuelto correctamente la excepcion");

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println(
					"\n ERROR!!!! ERROR!!! LA EXCEPCION LANZADA NO ES LA REGISTRADA \n GILIPOLLAS REVISA EL CODIGO");

		}

	}

	private static void evaluaAlumno2() {

		try {

		} catch (ExcepcionAlumnoNoValido e) {

			System.out.println("\n Ha devuelto correctamente la excepcion");

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println(
					"\n ERROR!!!! ERROR!!! LA EXCEPCION LANZADA NO ES LA REGISTRADA \n GILIPOLLAS REVISA EL CODIGO");

		}

	}

	/***************************************************
	 * MOSTRAR
	 *************************************************/

	private static void mostrarAlumno(Alumno alum) {

		System.out.println("\tAlumno  : < " + alum + " >");
		System.out.println("\n\t\tDni: < " + alum.getDNI() + " >");
		System.out.println("\t\tNombre: < " + alum.getNombre() + " >");
		System.out.println("\t\tApellidos: < " + alum.getApellidos() + " >");
		System.out.println("\t\tFecha Nacimiento: < "
				+ alum.getFechaNacimiento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " >");
		System.out.println("\n\t\tEdad: <" + alum.getEdad() + ">");
		System.out.println("\n\t\tEmail: <" + alum.getEmail() + ">");
		System.out.println("\n\t\tAsignaturas: <" + alum.getAsignaturas() + ">");
		System.out.println("\n\t\tExpediente academico: <" + alum.getExpediente() + ">");

	}

}
