package fp.grados.tipos.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import fp.grados.excepciones.ExcepcionPersonaNoValida;
import fp.grados.tipos.Persona;
import fp.grados.tipos.PersonaImpl;
import fp.grados.utiles.Grados;

public class TestPersona {

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
		casoDePrueba7();
		casoDePrueba8();
		casoDePrueba9();
		casoDePrueba10();
		casoDePrueba11();
		casoDePrueba12();
		casoDePrueba13();
		casoDePrueba14();
		casoDePrueba15();
		casoDePrueba16();
		casoDePrueba17();
		casoDePrueba18();

		testIgualdad();
		testOrden();

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

		System.out.println("\n\n Caso de prueba 1 <==============> Ubidragon" + "\n CONSTRUCTORES"
				+ "\n TESTEO DE CONSTRUCTORES SIN EXCEPCIONES\n");

		System.out.println("\t CONSTRUCTOR 1");
		Persona pers1 = new PersonaImpl("14309595F", "Francisco", "Garzon", LocalDate.of(1994, 9, 15),
				"ubahidarr@alum.us.es");
		mostrarPersona(pers1);

		System.out.println("\n\tCONSTRUCTOR 2");
		Persona pers2 = new PersonaImpl("87939647K", "Pedro", "Hidalgo", LocalDate.of(1994, 9, 15));
		mostrarPersona(pers2);

	}

	private static void casoDePrueba2() {

		System.out.println("\n\n Caso de prueba <==============> Ubidragon" + "\n FECHA DE NACIMIENTO"
				+ "\n la fecha de nacimiento es posterior a la actual");

		System.out.println("\n\t referido al CONSTRUCTOR 1");
		testConstructor("14309595F", "Francisco", "Garzon", LocalDate.of(2016, 9, 15), "ubahidarr@alum.us.es");
		System.out.println("\n\t referido al CONSTRUCTOR 2");
		testConstructor2("87939647K", "Pedro", "Hidalgo", LocalDate.of(2016, 9, 15));

	}

	private static void casoDePrueba3() {

		System.out.println("\n\n Caso de prueba <==============> Ubidragon" + "\n EMAIL "
				+ "\n Compruebo si la cadena esta vacia");

		testConstructor("14309595F", "Francisco", "Garzon", LocalDate.of(1990, 9, 15), " ");

	}

	private static void casoDePrueba4() {

		System.out.println("\n\n Caso de prueba <==============> Ubidragon" + "\n EMAIL "
				+ "\n Compruebo si la cadena no contiene @");

		testConstructor("14309595F", "Francisco", "Garzon", LocalDate.of(1990, 9, 15), "ubahidarr alum.us.es");

	}

	private static void casoDePrueba5() {

		System.out.println(
				"\n\n Caso de prueba <==============> Ubidragon" + "\n D.N.I.: LONGITUD" + "\n demasiado corto");

		System.out.println("\n\t referido al CONSTRUCTOR 1");
		testConstructor("1430995F", "Francisco", "Garzon", LocalDate.of(1990, 9, 15), "ubahidarr@alum.us.es");
		System.out.println("\n\t referido al CONSTRUCTOR 2");
		testConstructor2("8799647K", "Pedro", "Hidalgo", LocalDate.of(1990, 9, 15));

	}

	private static void casoDePrueba6() {

		System.out.println(
				"\n\n Caso de prueba <==============> Ubidragon" + "\n D.N.I.: LONGITUD" + "\n demasiado largo ");

		System.out.println("\n\t referido al CONSTRUCTOR 1");
		testConstructor("145309595F", "Francisco", "Garzon", LocalDate.of(1990, 9, 15), "ubahidarr@alum.us.es");
		System.out.println("\n\t referido al CONSTRUCTOR 2");
		testConstructor2("874939647K", "Pedro", "Hidalgo", LocalDate.of(1990, 9, 15));

	}

	private static void casoDePrueba7() {

		System.out.println("\n\n Caso de prueba <==============> Ubidragon" + "\n D.N.I.: CARACTERES"
				+ "\n mas letras de la cuenta y menos numeros");

		System.out.println("\n\t referido al CONSTRUCTOR 1");
		testConstructor("14309595AF", "Francisco", "Garzon", LocalDate.of(1990, 9, 15), "ubahidarr@alum.us.es");
		System.out.println("\n\t referido al CONSTRUCTOR 2");
		testConstructor2("87939647QK", "Pedro", "Hidalgo", LocalDate.of(1990, 9, 15));
	}

	private static void casoDePrueba8() {

		System.out.println("\n\n Caso de prueba <==============> Ubidragon" + "\n D.N.I.: Letra"
				+ "\n letra introducida erroneamente");

		System.out.println("\n\t referido al CONSTRUCTOR 1");
		testConstructor("14309595P", "Francisco", "Garzon", LocalDate.of(1990, 9, 15), "ubahidarr@alum.us.es");
		System.out.println("\n\t referido al CONSTRUCTOR 2");
		testConstructor2("87939647J", "Pedro", "Hidalgo", LocalDate.of(1990, 9, 15));

	}

	private static void casoDePrueba9() {

		System.out.println(
				"\n\n Caso de prueba <==============> Ubidragon" + "\n D.N.I.: Letra" + "\n letra en lugar no valido");

		System.out.println("\n\t referido al CONSTRUCTOR 1");
		testConstructor("143095F95", "Francisco", "Garzon", LocalDate.of(1990, 9, 15), "ubahidarr@alum.us.es");
		System.out.println("\n\t referido al CONSTRUCTOR 2");
		testConstructor2("87939Q647", "Pedro", "Hidalgo", LocalDate.of(1990, 9, 15));

	}

	private static void casoDePrueba10() {

		System.out
				.println("\n\n Caso de prueba <==============> Ubidragon" + "\n Probando metodo SET" + "\n setNombre");

		System.out.println("\t CONSTRUCTOR 1");
		Persona pers1 = new PersonaImpl("14309595F", "Francisco", "Garzon", LocalDate.of(1994, 9, 15),
				"ubahidarr@alum.us.es");
		testSetNombre(pers1, "Ubaldo");

		System.out.println("\n\tCONSTRUCTOR 2");
		Persona pers2 = new PersonaImpl("87939647K", "Pedro", "Hidalgo", LocalDate.of(1994, 9, 15));
		testSetNombre(pers2, "Ubaldo");

	}

	private static void casoDePrueba11() {

		System.out.println(
				"\n\n Caso de prueba <==============> Ubidragon" + "\n Probando metodo SET" + "\n setApellidos");

		System.out.println("\t CONSTRUCTOR 1");
		Persona pers1 = new PersonaImpl("14309595F", "Francisco", "Garzon", LocalDate.of(1994, 9, 15),
				"ubahidarr@alum.us.es");
		testSetApellidos(pers1, "Arriaga");

		System.out.println("\n\tCONSTRUCTOR 2");
		Persona pers2 = new PersonaImpl("87939647K", "Pedro", "Hidalgo", LocalDate.of(1994, 9, 15));
		testSetApellidos(pers2, "Arriaga");

	}

	private static void casoDePrueba12() {

		System.out.println("\n\n Caso de prueba <==============> Ubidragon" + "\n Probando metodo SET" + "\n setDNI");

		System.out.println("\t CONSTRUCTOR 1");
		Persona pers1 = new PersonaImpl("14309595F", "Francisco", "Garzon", LocalDate.of(1994, 9, 15),
				"ubahidarr@alum.us.es");
		testSetDNI(pers1, "07503602J");

		System.out.println("\n\tCONSTRUCTOR 2");
		Persona pers2 = new PersonaImpl("87939647K", "Pedro", "Hidalgo", LocalDate.of(1994, 9, 15));
		testSetDNI(pers2, "81674273P");

	}

	private static void casoDePrueba13() {

		System.out.println("\n\n Caso de prueba <==============> Ubidragon" + "\n Probando metodo SET"
				+ "\n setDNI metiendo un nuevo dni mal");

		System.out.println("\t CONSTRUCTOR 1");
		Persona pers1 = new PersonaImpl("14309595F", "Francisco", "Garzon", LocalDate.of(1994, 9, 15),
				"ubahidarr@alum.us.es");
		testSetDNI(pers1, "07503608J");

		System.out.println("\n\tCONSTRUCTOR 2");
		Persona pers2 = new PersonaImpl("87939647K", "Pedro", "Hidalgo", LocalDate.of(1994, 9, 15));
		testSetDNI(pers2, "81674278P");

	}

	private static void casoDePrueba14() {

		System.out.println(
				"\n\n Caso de prueba <==============> Ubidragon" + "\n Probando metdo set" + "\n setFechaNacimiento");

		System.out.println("\t CONSTRUCTOR 1");
		Persona pers1 = new PersonaImpl("14309595F", "Francisco", "Garzon", LocalDate.of(1994, 9, 15),
				"ubahidarr@alum.us.es");
		testSetFechaNacimiento(pers1, LocalDate.of(1994, 9, 8));

		System.out.println("\n\tCONSTRUCTOR 2");
		Persona pers2 = new PersonaImpl("87939647K", "Pedro", "Hidalgo", LocalDate.of(1994, 9, 15));
		testSetFechaNacimiento(pers2, LocalDate.of(1994, 9, 8));

	}

	private static void casoDePrueba15() {

		System.out.println("\n\n Caso de prueba <==============> Ubidragon" + "\n Probando metdo set"
				+ "\n setFechaNacimiento poniendo una feca que es posterior a la actual");

		System.out.println("\t CONSTRUCTOR 1");
		Persona pers1 = new PersonaImpl("14309595F", "Francisco", "Garzon", LocalDate.of(1994, 9, 15),
				"ubahidarr@alum.us.es");
		testSetFechaNacimiento(pers1, LocalDate.of(2050, 9, 8));

		System.out.println("\n\tCONSTRUCTOR 2");
		Persona pers2 = new PersonaImpl("87939647K", "Pedro", "Hidalgo", LocalDate.of(1994, 9, 15));
		testSetFechaNacimiento(pers2, LocalDate.of(2050, 9, 8));

	}

	private static void casoDePrueba16() {

		System.out.println("\n\n Caso de prueba <==============> Ubidragon" + "\n Probando metdo set" + "\n setEmail ");

		System.out.println("\t CONSTRUCTOR 1");
		Persona pers1 = new PersonaImpl("14309595F", "Francisco", "Garzon", LocalDate.of(1994, 9, 15),
				"ubahidarr@alum.us.es");
		testSetEmail(pers1, "ubahidarr@alum.us.es");

	}

	private static void casoDePrueba17() {

		System.out.println("\n\n Caso de prueba <==============> Ubidragon" + "\n Probando metdo set"
				+ "\n setEmail conjunto vacio");

		System.out.println("\t CONSTRUCTOR 1");
		Persona pers1 = new PersonaImpl("14309595F", "Francisco", "Garzon", LocalDate.of(1994, 9, 15),
				"ubahidarr@alum.us.es");
		testSetEmail(pers1, " ");

	}

	private static void casoDePrueba18() {

		System.out.println("\n\n Caso de prueba <==============> Ubidragon" + "\n Probando metdo set"
				+ "\n setEmail conjunto sin @ ");

		System.out.println("\t CONSTRUCTOR 1");
		Persona pers1 = new PersonaImpl("14309595F", "Francisco", "Garzon", LocalDate.of(1994, 9, 15),
				"ubahidarr@alum.us.es");
		testSetEmail(pers1, "ubahidarr alum.us.es");

	}

	private static void testIgualdad() {

		System.out.println("\n\n Caso de prueba <==============> Ubidragon" + "\n\t hashCode() & equals()\n");
		// Creamos dos objetos iguales (mismo código, mismo tipo de beca,
		// el resto distinto)
		Persona pers1 = new PersonaImpl("14309595F", "Francisco", "Garzon", LocalDate.of(1994, 9, 15),
				"ubahidarr@alum.us.es");
		Persona pers2 = new PersonaImpl("14309595F", "Francisco", "Garzon", LocalDate.of(1994, 9, 15),
				"ubahidarr@alum.us.es");
		Persona pers3 = new PersonaImpl("87939647K", "Francisco", "Garzon", LocalDate.of(1994, 9, 15),
				"ubahidarr@alum.us.es");
		Persona pers4 = new PersonaImpl("14309595F", "Pedro", "Garzon", LocalDate.of(1994, 9, 15),
				"ubahidarr@alum.us.es");
		Persona pers5 = new PersonaImpl("87939647K", "Francisco", "Hidalgo", LocalDate.of(1994, 9, 15),
				"ubahidarr@alum.us.es");

		System.out.println("Código hash del objeto pers1 (" + pers1 + "): " + pers1.hashCode());
		System.out.println("Código hash del objeto pers2 (" + pers2 + "): " + pers2.hashCode());
		System.out.println("Código hash del objeto pers3 (" + pers3 + "): " + pers3.hashCode());
		System.out.println("Código hash del objeto pers4 (" + pers4 + "): " + pers4.hashCode());
		System.out.println("Código hash del objeto pers5 (" + pers4 + "): " + pers5.hashCode());

		System.out.println("¿Es pers1 igual a pers2? (debe ser true): " + pers1.equals(pers2));
		System.out.println("¿Es pers1 distinto de pers3? (debe ser true): " + !pers1.equals(pers3));
		System.out.println("¿Es pers1 distinto de pers4? (debe ser true): " + !pers1.equals(pers4));
		System.out.println("¿Es pers1 distinto de pers5? (debe ser true): " + !pers1.equals(pers5));

	}

	private static void testOrden() {

		System.out.println("\n\n Caso de prueba <==============> Ubidragon" + "\n\t compareTo()\n");
		// Creamos cuatro objetos tales que menor < igual1 == igual2 < mayor
		Persona pers1 = new PersonaImpl("14309595F", "Francisco", "Garzon", LocalDate.of(1994, 9, 15),
				"ubahidarr@alum.us.es");
		Persona pers2 = new PersonaImpl("14309595F", "Francisco", "Garzon", LocalDate.of(1994, 9, 15),
				"ubahidarr@alum.us.es");
		Persona pers3 = new PersonaImpl("87939647K", "Francisco", "Garzon", LocalDate.of(1994, 9, 15),
				"ubahidarr@alum.us.es");
		Persona pers4 = new PersonaImpl("14309595F", "Pedro", "Garzon", LocalDate.of(1994, 9, 15),
				"ubahidarr@alum.us.es");
		Persona pers5 = new PersonaImpl("87939647K", "Francisco", "Hidalgo", LocalDate.of(1994, 9, 15),
				"ubahidarr@alum.us.es");

		System.out.println("\tIGUALES");
		compara(pers1, pers2);
		System.out.println("\n\tA igualdad de objeto se ordena por APELLIDOS");
		compara(pers5, pers1);
		System.out.println("\n\tA igualdad de APELLIDOS, se ordena por NOMBRE");
		compara(pers4, pers1);
		System.out.println("\n\tA igualdad de APELLIDOS y de NOMBRE,se ordena por DNI");
		compara(pers3, pers1);

	}

	/* CONSTRUCTOR MEDIEANTE FICHERO */
	public static List<Persona> create(String nombreFichero) {
		List<Persona> res = Grados.leeFichero("res/personas.txt", s -> new PersonaImpl(s));
		return res;
	}

	/***************************************************
	 * METODOS AUXILIARES
	 *************************************************/

	private static void testConstructor(String dni, String nombre, String apellidos, LocalDate fechaNacimiento,
			String email) {

		try {

			Persona pers = new PersonaImpl(dni, nombre, apellidos, fechaNacimiento, email);

			mostrarPersona(pers);

		} catch (ExcepcionPersonaNoValida e) {

			System.out.println("\n\t\t\t Ha devuelto correctamente la excepcion");

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println(
					"\n ERROR!!!! \nERROR!!!  \nERROR!!!  \nERROR!!! \nLA EXCEPCION LANZADA NO ES LA REGISTRADA \n GILIPOLLAS REVISA EL CODIGO");

		}

	}

	private static void testConstructor2(String dni, String nombre, String apellidos, LocalDate fechaNacimiento) {

		try {

			Persona pers = new PersonaImpl(dni, nombre, apellidos, fechaNacimiento);

			mostrarPersona(pers);

		} catch (ExcepcionPersonaNoValida e) {

			System.out.println("\n\t\t\t Ha devuelto correctamente la excepcion");

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println(
					"\n ERROR!!!! \nERROR!!!  \nERROR!!!  \nERROR!!! \nLA EXCEPCION LANZADA NO ES LA REGISTRADA \n GILIPOLLAS REVISA EL CODIGO");

		}
	}

	private static void testSetNombre(Persona per, String nombre) {

		try {

			System.out.println("\n\tEl nombre antes de la operación es: " + per.getNombre());
			System.out.println("\tEl nuevo nombre es: " + nombre);
			per.setNombre(nombre);
			System.out.println("\tEl nombre después de la operación es: " + per.getNombre());

		} catch (ExcepcionPersonaNoValida e) {

			System.out.println("\n\t\t\t Ha devuelto correctamente la excepcion");

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println(
					"\n ERROR!!!! \nERROR!!!  \nERROR!!!  \nERROR!!! \nLA EXCEPCION LANZADA NO ES LA REGISTRADA \n GILIPOLLAS REVISA EL CODIGO");

		}

	}

	private static void testSetApellidos(Persona per, String apellidos) {

		try {

			System.out.println("\n\tEl apellido antes de la operación es: " + per.getApellidos());
			System.out.println("\tEl nuevo apellido es: " + apellidos);
			per.setApellidos(apellidos);
			System.out.println("\tEl apellido después de la operación es: " + per.getApellidos());

		} catch (ExcepcionPersonaNoValida e) {

			System.out.println("\n\t\t\t Ha devuelto correctamente la excepcion");

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println(
					"\n ERROR!!!! \nERROR!!!  \nERROR!!!  \nERROR!!! \nLA EXCEPCION LANZADA NO ES LA REGISTRADA \n GILIPOLLAS REVISA EL CODIGO");

		}

	}

	private static void testSetDNI(Persona per, String dni) {

		try {

			System.out.println("\n\tEl DNI antes de la operación es: " + per.getDNI());
			System.out.println("\tEl nuevo DNI es: " + dni);
			per.setDNI(dni);
			System.out.println("\tEl DNI después de la operación es: " + per.getDNI());

		} catch (ExcepcionPersonaNoValida e) {

			System.out.println("\n\t\t\t Ha devuelto correctamente la excepcion");

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println(
					"\n ERROR!!!! \nERROR!!!  \nERROR!!!  \nERROR!!! \nLA EXCEPCION LANZADA NO ES LA REGISTRADA \n GILIPOLLAS REVISA EL CODIGO");

		}

	}

	private static void testSetFechaNacimiento(Persona per, LocalDate fecha) {

		try {

			System.out.println("\n\tLa fecha antes de la operación es: " + per.getFechaNacimiento());
			System.out.println("\tLa nueva fecha es: " + fecha);
			per.setFechaNacimiento(fecha);
			System.out.println("\tLa fecha después de la operación es: " + per.getFechaNacimiento());

		} catch (ExcepcionPersonaNoValida e) {

			System.out.println("\n\t\t\t Ha devuelto correctamente la excepcion");

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println(
					"\n ERROR!!!! \nERROR!!!  \nERROR!!!  \nERROR!!! \nLA EXCEPCION LANZADA NO ES LA REGISTRADA \n GILIPOLLAS REVISA EL CODIGO");

		}

	}

	private static void testSetEmail(Persona per, String email) {

		try {

			System.out.println("\n\tEl email antes de la operación es: " + per.getEmail());
			System.out.println("\tEl nuevo email es: " + email);
			per.setEmail(email);
			System.out.println("\tEl email después de la operación es: " + per.getEmail());

		} catch (ExcepcionPersonaNoValida e) {

			System.out.println("\n\t\t\t Ha devuelto correctamente la excepcion");

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println(
					"\n ERROR!!!! \nERROR!!!  \nERROR!!!  \nERROR!!! \nLA EXCEPCION LANZADA NO ES LA REGISTRADA \n GILIPOLLAS REVISA EL CODIGO");

		}

	}

	private static void compara(Persona pers1, Persona pers2) {

		System.out.print("El objeto <" + pers1 + ">");

		if (pers1.compareTo(pers2) < 0) {

			System.out.print(" va ANTES que el objeto ");

		}

		else if (pers1.compareTo(pers2) > 0) {

			System.out.print(" va DESPUÉS que el objeto ");

		} else {

			System.out.print(" va en la MISMA POSICIÓN que el objeto ");

		}

		System.out.println("<" + pers2 + ">");

	}

	/***************************************************
	 * MOSTRAR
	 *************************************************/

	private static void mostrarPersona(Persona p) {
		System.out.println("Persona--> <" + p + ">");
		// Aquí se está probando el método toString()
		System.out.println("\n\t\tNombre: <" + p.getNombre() + ">");
		System.out.println("\n\t\tApellidos: <" + p.getApellidos() + ">");
		System.out.println("\n\t\tDNI: <" + p.getDNI() + ">");
		System.out.println("\n\t\tFecha Nacimiento: <"
				+ p.getFechaNacimiento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ">");
		System.out.println("\n\t\tEdad: <" + p.getEdad() + ">");
		System.out.println("\n\t\tEmail: <" + p.getEmail() + ">");
	}
}
