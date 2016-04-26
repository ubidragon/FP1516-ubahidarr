package fp.grados.tipos.test;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

import fp.grados.excepciones.ExcepcionTutoriaNoValida;
import fp.grados.tipos.Tutoria;
import fp.grados.tipos.TutoriaImpl;
import fp.grados.utiles.Grados;

public class TestTutoria {

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
		casoDePrueba4();
		casoDePrueba5();
		// casoDePrueba6();
		// casoDePrueba7();
		// casoDePrueba8();
		// casoDePrueba9();
		// casoDePrueba10();
		// casoDePrueba11();
		// casoDePrueba12();
		// casoDePrueba13();
		//
		// testIgualdad();
		// testOrden();

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
				+ "\n TESTEO DE CONSTRUCTORES SIN EXCEPCIONES");
		System.out.println("CONSTRUCTOR 1");
		Tutoria t = new TutoriaImpl(DayOfWeek.MONDAY, LocalTime.of(10, 30), LocalTime.of(11, 00));
		mostrarTutoria(t);
		System.out.println("\nCONSTRUCTOR 2");
		Tutoria t2 = new TutoriaImpl(DayOfWeek.FRIDAY, LocalTime.of(10, 30), 40);
		mostrarTutoria(t2);

	}

	private static void casoDePrueba2() {
		System.out.println(
				"\n\n Caso de prueba <==============> Ubidragon" + "\n DIA" + "\n\t Dia fuera del rango de tutoria");

		System.out.println("CONSTRUCTOR 1");
		testConstructor(DayOfWeek.SUNDAY, LocalTime.of(10, 30), LocalTime.of(11, 00));
		System.out.println("\nCONSTRUCTOR 2");
		testConstructor2(DayOfWeek.SUNDAY, LocalTime.of(10, 30), 35);

	}

	private static void casoDePrueba3() {
		System.out.println("\n\n Caso de prueba <==============> Ubidragon" + "\n DURACION "
				+ "\n duracion inferior a 30 minutos ");

		System.out.println("CONSTRUCTOR 1");
		testConstructor(DayOfWeek.FRIDAY, LocalTime.of(10, 30), LocalTime.of(10, 40));
		System.out.println("\nCONSTRUCTOR 2");
		testConstructor2(DayOfWeek.FRIDAY, LocalTime.of(10, 30), 25);
	}

	private static void casoDePrueba4() {
		System.out.println("\n\n Caso de prueba <==============> Ubidragon" + "\n HORARIO"
				+ "\n tutoria fuera del horario establecido");

		System.out.println("\n Antes de las 8'30");
		System.out.println("CONSTRUCTOR 1");
		testConstructor(DayOfWeek.FRIDAY, LocalTime.of(7, 30), LocalTime.of(8, 00));
		System.out.println("\nCONSTRUCTOR 2");
		testConstructor2(DayOfWeek.FRIDAY, LocalTime.of(7, 30), 35);

		System.out.println("\n Despues de las 21'30");
		System.out.println("CONSTRUCTOR 1");
		testConstructor(DayOfWeek.FRIDAY, LocalTime.of(21, 20), LocalTime.of(21, 50));
		System.out.println("\nCONSTRUCTOR 2");
		testConstructor2(DayOfWeek.FRIDAY, LocalTime.of(22, 30), 35);

	}

	private static void casoDePrueba5() {
		System.out.println("\n\n Caso de prueba <==============> Ubidragon" + "\n " + "\n ");

		testConstructor(DayOfWeek.SUNDAY, LocalTime.of(10, 30), LocalTime.of(11, 00));
		testConstructor2(DayOfWeek.SUNDAY, LocalTime.of(10, 30), 35);

	}

	/*
	 * private static void testIgualdad() {
	 * 
	 * System.out.println("\n\n Caso de prueba <==============> Ubidragon" +
	 * "\n\t hashCode() & equals()\n"); // Creamos dos objetos iguales (mismo
	 * código, mismo tipo de beca, // el resto distinto) Beca b1 = new
	 * BecaImpl("ABC1234", 2000.0, 12, TipoBeca.EMPRESA); Beca b2 = new
	 * BecaImpl("ABC1234", 3000.0, 6, TipoBeca.EMPRESA); // Creamos objetos
	 * distintos (distinto código, distinto tipo de beca) Beca b3 = new
	 * BecaImpl("ZWQ9877", 2000.0, 12, TipoBeca.EMPRESA); Beca b4 = new
	 * BecaImpl("ABC1234", 3000.0, 6, TipoBeca.MOVILIDAD);
	 * 
	 * System.out.println("Código hash del objeto b1 (" + b1 + "): " +
	 * b1.hashCode()); System.out.println("Código hash del objeto b2 (" + b2 +
	 * "): " + b2.hashCode()); System.out.println("Código hash del objeto b3 ("
	 * + b3 + "): " + b3.hashCode()); System.out.println(
	 * "Código hash del objeto b4 (" + b4 + "): " + b4.hashCode());
	 * 
	 * System.out.println("¿Es b1 igual a b2? (debe ser true): " +
	 * b1.equals(b2)); System.out.println(
	 * "¿Es b1 distinto de b3? (debe ser true): " + !b1.equals(b3));
	 * System.out.println("¿Es b1 distinto de b4? (debe ser true): " +
	 * !b1.equals(b4));
	 * 
	 * }
	 * 
	 * private static void testOrden() {
	 * 
	 * System.out.println("\n\n Caso de prueba <==============> Ubidragon" +
	 * "\n\t compareTo()\n"); // Creamos cuatro objetos tales que menor < igual1
	 * == igual2 < mayor Beca menor = new BecaImpl("ABC1234", 10000.0, 6,
	 * TipoBeca.ORDINARIA); Beca igual1 = new BecaImpl("ABC1235", 10000.0, 6,
	 * TipoBeca.ORDINARIA); Beca igual2 = new BecaImpl("ABC1235", 10000.0, 6,
	 * TipoBeca.ORDINARIA); Beca mayor = new BecaImpl("ABC1235", 10000.0, 6,
	 * TipoBeca.EMPRESA);
	 * 
	 * System.out.print("(debe ser ANTES) "); compara(menor, igual1);
	 * 
	 * System.out.print("(debe ser MISMA POSICIÓN) "); compara(igual1, igual2);
	 * 
	 * System.out.print("(debe ser ANTES) "); compara(igual2, mayor); }
	 */

	/* CONSTRUCTOR MEDIEANTE FICHERO */
	public static List<Tutoria> create(String nombreFichero) {
		List<Tutoria> res = Grados.leeFichero("res/tutorias.txt", s -> new TutoriaImpl(s));
		return res;
	}

	/***************************************************
	 * METODOS AUXILIARES
	 *************************************************/

	private static void testConstructor(DayOfWeek dia, LocalTime inicio, LocalTime fin) {

		try {

			Tutoria tuto = new TutoriaImpl(dia, inicio, fin);

			mostrarTutoria(tuto);

		} catch (ExcepcionTutoriaNoValida e) {

			System.out.println("\n Ha devuelto correctamente la excepcion");

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println(
					"\n ERROR!!!! ERROR!!! LA EXCEPCION LANZADA NO ES LA REGISTRADA \n GILIPOLLAS REVISA EL CODIGO");

		}

	}

	private static void testConstructor2(DayOfWeek dia, LocalTime inicio, Integer duracion) {

		try {

			Tutoria tuto = new TutoriaImpl(dia, inicio, duracion);

			mostrarTutoria(tuto);

		} catch (ExcepcionTutoriaNoValida e) {

			System.out.println("\n Ha devuelto correctamente la excepcion");

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println(
					"\n ERROR!!!! ERROR!!! LA EXCEPCION LANZADA NO ES LA REGISTRADA \n GILIPOLLAS REVISA EL CODIGO");

		}

	}

	/*
	 * private static void compara(Tutoria tut, Tutoria tut2) {
	 * 
	 * System.out.print("El objeto <" + tut + ">");
	 * 
	 * if (tut.compareTo(tut2) < 0) {
	 * 
	 * System.out.print(" va ANTES que el objeto ");
	 * 
	 * }
	 * 
	 * else if (tut.compareTo(tut2) > 0) {
	 * 
	 * System.out.print(" va DESPUÉS que el objeto ");
	 * 
	 * } else {
	 * 
	 * System.out.print(" va en la MISMA POSICIÓN que el objeto ");
	 * 
	 * }
	 * 
	 * System.out.println("<" + tut2 + ">");
	 * 
	 * }
	 */

	/***************************************************
	 * MOSTRAR
	 *************************************************/

	private static void mostrarTutoria(Tutoria tuto) {

		System.out.println("\tTutoria  : < " + tuto + " >");
		System.out.println("\n\t\tDIA: < " + tuto.getDiaSemana() + " >");
		System.out.println("\t\tHora de Comienzo: < " + tuto.getHoraComienzo() + " >");
		System.out.println("\t\tHora de Fin: < " + tuto.getHoraFin() + " >");
		System.out.println("\t\tDuracion: < " + tuto.getDuracion() + " >");

	}

}
