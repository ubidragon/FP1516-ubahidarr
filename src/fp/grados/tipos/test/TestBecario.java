package fp.grados.tipos.test;

import java.time.LocalDate;

import fp.grados.excepciones.ExcepcionBecarioNoValido;
import fp.grados.tipos.Beca;
import fp.grados.tipos.BecaImpl;
import fp.grados.tipos.Becario;
import fp.grados.tipos.BecarioImpl;
import fp.grados.tipos.TipoBeca;

public class TestBecario {
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
		// casoDePrueba3();
		// casoDePrueba4();
		// casoDePrueba5();
		// casoDePrueba6();
		// casoDePrueba7();
		// casoDePrueba8();
		// casoDePrueba9();
		// casoDePrueba10();
		// casoDePrueba11();
		// casoDePrueba12();
		// casoDePrueba13();

	}

	public static void noPlagio() throws InterruptedException {
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

		System.out.println("Constructor");

		testConstructor("12345678Z", "Antonio", "Hidalgo Garcia", LocalDate.of(1990, 9, 25), "anthidgar@alum.us.es",
				new BecaImpl("DEF0002", 1500.0, 1, TipoBeca.MOVILIDAD), LocalDate.of(2016, 9, 9));
		testConstructor("19271059A", "Juan", "Perez Gonzalez", LocalDate.of(1950, 9, 15), "juapergon@alum.us.es",
				new BecaImpl("DEF0002", 1500.0, 1, TipoBeca.MOVILIDAD), LocalDate.of(2016, 9, 9));

		System.out.println("\nExcepcion de fecha");
		testConstructor("61844079T", "Eduardo", "Hidalgo Perez", LocalDate.of(1990, 3, 25), "eduhidper@alum.us.es",
				new BecaImpl("DEF0002", 1500.0, 1, TipoBeca.MOVILIDAD), LocalDate.of(2013, 9, 9));

		System.out.println("\nConstructor 2");

		testConstructor2("58127020V", "Eustaquio", "Hidalgo Gonzalez", LocalDate.of(1990, 9, 15),
				"eushidgon@alum.us.es", "DEF0002", 1500.0, 1, TipoBeca.MOVILIDAD, LocalDate.of(2016, 9, 9));
		testConstructor2("40560724V", "Joaquin", "Arriaga Garcia", LocalDate.of(1965, 3, 25), "joaarrgar@alum.us.es",
				"DEF0002", 1500.0, 1, TipoBeca.MOVILIDAD, LocalDate.of(2018, 9, 9));

		System.out.println("\nExcepcion de fecha");
		testConstructor2("01742665R", "Miguel", "Hidalgo Corchuelo", LocalDate.of(1990, 7, 8), "mighidcor@alum.us.es",
				"DEF0002", 1500.0, 1, TipoBeca.MOVILIDAD, LocalDate.of(2014, 9, 9));

	}

	private static void casoDePrueba2() {

		System.out.println("\n\n Caso de prueba 2 <==============> Ubidragon" + "\n SetFechaComienzo"
				+ "\n Modificacion de la fecha de la beca del alumno\n");

		Becario b = new BecarioImpl("12345678Z", "Antonio", "Hidalgo Garcia", LocalDate.of(1990, 9, 25),
				"anthidgar@alum.us.es", new BecaImpl("DEF0002", 1500.0, 1, TipoBeca.MOVILIDAD),
				LocalDate.of(2016, 9, 9));

		System.out.println("Sin excepcion");

		testSetFecha(b, LocalDate.of(2016, 10, 30));

		System.out.println("\nCon excepcion");

		testSetFecha(b, LocalDate.of(2014, 9, 9));

	}

	// private static void casoDePrueba3() {

	// System.out
	// .println("\n\n Caso de prueba 3 <==============> Ubidragon" + "\n CASO" +
	// "\n DESCRIPCION DEL CASO\n");

	// }

	// private static void casoDePrueba4() {

	// System.out
	// .println("\n\n Caso de prueba 4 <==============> Ubidragon" + "\n CASO" +
	// "\n DESCRIPCION DEL CASO\n");

	// }

	// private static void casoDePrueba5() {

	// System.out
	// .println("\n\n Caso de prueba 5 <==============> Ubidragon" + "\n CASO" +
	// "\n DESCRIPCION DEL CASO\n");

	// }

	// private static void casoDePrueba6() {

	// System.out
	// .println("\n\n Caso de prueba 6 <==============> Ubidragon" + "\n CASO" +
	// "\n DESCRIPCION DEL CASO\n");

	// }

	/***************************************************
	 * METODOS AUXILIARES
	 *************************************************/

	private static void testConstructor(String dni, String nombre, String apellidos, LocalDate fechaNacimiento,
			String email, Beca beca, LocalDate comienzo) {

		try {

			Becario tuto = new BecarioImpl(dni, nombre, apellidos, fechaNacimiento, email, beca, comienzo);

			mostrarBecario(tuto);

		} catch (ExcepcionBecarioNoValido e) {

			System.out.println("\n Ha devuelto correctamente la excepcion");

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println(
					"\n ERROR!!!! ERROR!!! LA EXCEPCION LANZADA NO ES LA REGISTRADA \n GILIPOLLAS REVISA EL CODIGO");

		}
	}

	private static void testConstructor2(String dni, String nombre, String apellidos, LocalDate fechaNacimiento,
			String email, String codigo, Double cuantiaTotal, Integer duracion, TipoBeca tipo, LocalDate comienzo) {

		try {

			Becario tuto = new BecarioImpl(dni, nombre, apellidos, fechaNacimiento, email, codigo, cuantiaTotal,
					duracion, tipo, comienzo);

			mostrarBecario(tuto);

		} catch (ExcepcionBecarioNoValido e) {

			System.out.println("\n Ha devuelto correctamente la excepcion");

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println(
					"\n ERROR!!!! ERROR!!! LA EXCEPCION LANZADA NO ES LA REGISTRADA \n GILIPOLLAS REVISA EL CODIGO");

		}
	}

	private static void testSetFecha(Becario b, LocalDate fecha) {
		try {
			// b.getFechaComienzo();
			System.out.println("La fecha es: " + b.getFechaComienzo());

			System.out.println("La nueva fecha es: " + fecha);
			b.setFechaComienzo(fecha);
			System.out.println("La fecha es: " + b.getFechaComienzo());

		} catch (ExcepcionBecarioNoValido e) {

			System.out.println("\n Ha devuelto correctamente la excepcion");

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println(
					"\n ERROR!!!! ERROR!!! LA EXCEPCION LANZADA NO ES LA REGISTRADA \n GILIPOLLAS REVISA EL CODIGO");

		}
	}

	private static void testSetEmail(Becario b, String email) {
		try {

			System.out.println("\n\tEl email antes de la operación es: " + b.getEmail());
			System.out.println("\tEl nuevo email es: " + email);
			b.setEmail(email);
			System.out.println("\tEl email después de la operación es: " + b.getEmail());

		} catch (UnsupportedOperationException e) {

			System.out.println("\n Ha devuelto correctamente la excepcion");

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println(
					"\n ERROR!!!! ERROR!!! LA EXCEPCION LANZADA NO ES LA REGISTRADA \n GILIPOLLAS REVISA EL CODIGO");

		}
	}

	private static void mostrarBecario(Becario tuto) {

		System.out.println("\tBecario : < " + tuto + " >");
		System.out.println("\n\t\tBeca: < " + tuto.getBeca() + " >");
		System.out.println("\t\tFecha de Comienzo: < " + tuto.getFechaComienzo() + " >");
		System.out.println("\t\tFecha de Fin: < " + tuto.getFechaFin() + " >");

	}

}
