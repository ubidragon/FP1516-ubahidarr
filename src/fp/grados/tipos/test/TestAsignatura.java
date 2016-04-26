package fp.grados.tipos.test;

import java.util.List;

import fp.grados.excepciones.ExcepcionAsignaturaNoValida;
import fp.grados.tipos.Asignatura;
import fp.grados.tipos.AsignaturaImpl;
import fp.grados.tipos.TipoAsignatura;
import fp.grados.utiles.Grados;

public class TestAsignatura {

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

		testIgualdad();
		testOrden();
		testGetAcronimo();

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

		System.out.println("\n\n Caso de prueba 1 <==============> Ubidragon" + "\n\t CONSTRUCTOR "
				+ "\n\t\t Este caso testea el constructor sin ningun error o excepcion\n");

		Asignatura a = new AsignaturaImpl("Algebra", "0000230", 12.0, TipoAsignatura.ANUAL, 1);

		mostrarAsignatura(a);

	}

	private static void casoDePrueba2() {

		System.out.println("\n\n Caso de prueba 2 <==============> Ubidragon" + "\n\t CONSTRUCTOR"
				+ "\n\t\t Este caso testea el constructor sin ningun error o excepcion\n");

		Asignatura a = new AsignaturaImpl("IMD", "0156214", 12.0, TipoAsignatura.PRIMER_CUATRIMESTRE, 1);

		mostrarAsignatura(a);

	}

	private static void casoDePrueba3() {

		System.out.println("\n\n Caso de prueba 3 <==============> Ubidragon" + "\n\t CODIGO "
				+ "\n\t\t CODIGO ERRONEO LONGITUD ERRONEA DEMASIADO LARGO");

		testConstructor("Fisica", "0002340230", 12.0, TipoAsignatura.ANUAL, 2);

	}

	private static void casoDePrueba4() {

		System.out.println("\n\n Caso de prueba 4 <==============> Ubidragon" + "\n\t CODIGO"
				+ "\n\t\t CODIGO ERRONEO LONGITUD ERRONEA DEMASIADO CORTO");

		testConstructor("Algebra", "009830", 12.0, TipoAsignatura.PRIMER_CUATRIMESTRE, 3);

	}

	private static void casoDePrueba5() {

		System.out.println("\n\n Caso de prueba 5 <==============> Ubidragon" + "\n\t CODIGO"
				+ "\n\t\t CODIGO ERRONEO NO NUMERICO");

		testConstructor("Fisica", "000A230", 12.0, TipoAsignatura.ANUAL, 1);

	}

	private static void casoDePrueba6() {

		System.out.println(
				"\n\n Caso de prueba 6 <==============> Ubidragon" + "\n\t CREDITOS" + "\n\t\t CREDITOS ERRONEOS");

		testConstructor("Algebra", "0058230", 0.0, TipoAsignatura.PRIMER_CUATRIMESTRE, 1);

	}

	private static void casoDePrueba7() {

		System.out.println("\n\n Caso de prueba 7 <==============> Ubidragon" + "\n\t CURSO"
				+ "\n\t\t CURSO ERRONEO // CURSO MENOR QUE 1");

		testConstructor("CED", "0000230", 12.0, TipoAsignatura.ANUAL, 0);

	}

	private static void casoDePrueba8() {
		System.out.println("\n\n Caso de prueba 8 <==============> Ubidragon" + "\n\t CURSO"
				+ "\n\t\t CURSO ERRONEO // CURSO MAYOR QUE 4");

		testConstructor("SSOO", "0025230", 12.0, TipoAsignatura.ANUAL, 6);

	}

	private static void testIgualdad() {
		System.out.println("\n\n Caso de prueba <==============> Ubidragon" + "\n\t hashCode() & equals()\n");
		// Creamos un objeto
		Asignatura a1 = new AsignaturaImpl("Fundamentos de Programaci�n", "2050001", 12.0, TipoAsignatura.ANUAL, 1);
		// Creamos un objeto igual al anterior
		Asignatura a2 = new AsignaturaImpl("Fundamentos de Programaci�n", "2050001", 12.0, TipoAsignatura.ANUAL, 1);
		// Creamos un objeto distinto
		Asignatura a3 = new AsignaturaImpl("Estructura de Computadores", "2050009", 6.0,
				TipoAsignatura.SEGUNDO_CUATRIMESTRE, 1);

		System.out.println("\tC�digo hash del objeto a1 (" + a1 + "): " + a1.hashCode());
		System.out.println("\tC�digo hash del objeto a2 (" + a2 + "): " + a2.hashCode());
		System.out.println("\tC�digo hash del objeto a3 (" + a3 + "): " + a3.hashCode());

		System.out.println("\t�Es a1 igual a a2? (debe ser true): " + a1.equals(a2));
		System.out.println("\t�Es a1 distinto de a3? (debe ser true): " + !a1.equals(a3));

	}

	private static void testOrden() {
		System.out.println("\n\n Caso de prueba <==============> Ubidragon" + "\n\t compareTo()\n");
		// Creamos cuatro objetos tales que menor < igual1 == igual2 < mayor
		Asignatura menor = new AsignaturaImpl("Fundamentos de Programaci�n", "2050001", 12.0, TipoAsignatura.ANUAL,
				1);
		Asignatura igual1 = new AsignaturaImpl("Estructura de Computadores", "2050009", 6.0,
				TipoAsignatura.SEGUNDO_CUATRIMESTRE, 1);
		Asignatura igual2 = new AsignaturaImpl("Estructura de Computadores", "2050009", 6.0,
				TipoAsignatura.SEGUNDO_CUATRIMESTRE, 1);
		Asignatura mayor = new AsignaturaImpl("Ingenier�a de Requisitos", "2050020", 6.0,
				TipoAsignatura.PRIMER_CUATRIMESTRE, 3);

		System.out.print("(debe ser ANTES) ");
		compara(menor, igual1);

		System.out.print("(debe ser MISMA POSICI�N) ");
		compara(igual1, igual2);

		System.out.print("(debe ser ANTES) ");
		compara(igual2, mayor);

	}

	// TODO meter modificaciones de mi cosecha
	private static void testGetAcronimo() {
		System.out.println("\n===============================Probando getAcronimo");
		Asignatura fp = new AsignaturaImpl("Fundamentos de Programaci�n", "2050001", 12.0, TipoAsignatura.ANUAL, 1);

		System.out.println("El acr�nimo para la asignatura " + fp + " es: " + fp.getAcronimo());
	}

	/* CONSTRUCTOR MEDIEANTE FICHERO */
	public static List<Asignatura> create(String nombreFichero) {
		List<Asignatura> res = Grados.leeFichero("res/asignaturas.txt", s -> new AsignaturaImpl(s));
		return res;
	}

	/***************************************************
	 * METODOS AUXILIARES
	 *************************************************/

	private static void testConstructor(String nombre, String codigo, Double creditos, TipoAsignatura tipo,
			Integer curso) {

		try {

			Asignatura a = new AsignaturaImpl(nombre, codigo, creditos, tipo, curso);

			mostrarAsignatura(a);

		} catch (ExcepcionAsignaturaNoValida e) {

			System.out.println("\n\t\t Ha devuelto correctamente la excepcion");

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println(
					"\n ERROR!!!! \nERROR!!!  \nERROR!!!  \nERROR!!! \nLA EXCEPCION LANZADA NO ES LA REGISTRADA \n GILIPOLLAS REVISA EL CODIGO");

		}

	}

	private static void compara(Asignatura a1, Asignatura a2) {

		System.out.print("El objeto <" + a1 + ">");

		if (a1.compareTo(a2) < 0) {

			System.out.print(" va ANTES que el objeto ");

		} else if (a1.compareTo(a2) > 0) {

			System.out.print(" va DESPU�S que el objeto ");

		} else {

			System.out.print(" va en la MISMA POSICI�N que el objeto ");

		}

		System.out.println("<" + a2 + ">");

	}

	/***************************************************
	 * MOSTRAR
	 *************************************************/

	private static void mostrarAsignatura(Asignatura a) {

		System.out.println("Asignatura--> <" + a + ">");

		System.out.println("\n\t\tNombre: <" + a.getNombre() + ">");
		// System.out.println("\t\tAcronimo: <" + a.getAcronimo() + ">");
		System.out.println("\t\tC�digo: <" + a.getCodigo() + ">");
		System.out.println("\t\tCr�ditos: <" + a.getCreditos() + ">");
		System.out.println("\t\tTipo: <" + a.getTipo() + ">");
		System.out.println("\t\tCurso: <" + a.getCurso() + ">");
	}
}
