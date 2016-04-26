package fp.grados.tipos.test;

import java.util.List;

import fp.grados.excepciones.ExcepcionNotaNoValida;
import fp.grados.tipos.Nota;
import fp.grados.tipos.NotaImpl;
import fp.grados.tipos.AsignaturaImpl;
import fp.grados.tipos.Asignatura;
import fp.grados.tipos.TipoAsignatura;
import fp.grados.utiles.Grados;
import fp.grados.tipos.Convocatoria;

public class TestNota {

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
		// casoDePrueba5();
		// casoDePrueba6();
		// casoDePrueba7();
		// casoDePrueba8();
		// casoDePrueba9();
		// casoDePrueba10();
		// casoDePrueba11();
		// casoDePrueba12();
		// casoDePrueba13();
		// casoDePrueba14();
		// casoDePrueba15();
		// casoDePrueba16();
		// casoDePrueba17();

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
				+ "\n TESTEO DE CONSTRUCTORES SIN EXCEPCIONES");

		Asignatura asig = new AsignaturaImpl("Diseño y Prueba", "1234567", 12.0, TipoAsignatura.ANUAL, 3);

		System.out.println("CONSTRUCTOR 1");
		Nota not1 = new NotaImpl(asig, 2015, Convocatoria.PRIMERA, 5.75, false);
		mostrarNota(not1);

		System.out.println("\nCONSTRUCTOR 2");
		Nota not2 = new NotaImpl(asig, 2015, Convocatoria.SEGUNDA, 4.85);
		mostrarNota(not2);
		System.out.println("\n ahora probare el metodo de CALIFICACION en ambos constructores");

		Nota n11 = new NotaImpl(asig, 2015, Convocatoria.PRIMERA, 4.50, false);
		Nota n21 = new NotaImpl(asig, 2015, Convocatoria.PRIMERA, 4.50);

		Nota n12 = new NotaImpl(asig, 2015, Convocatoria.PRIMERA, 5.50, false);
		Nota n22 = new NotaImpl(asig, 2015, Convocatoria.PRIMERA, 5.50);

		Nota n13 = new NotaImpl(asig, 2015, Convocatoria.PRIMERA, 7.0, false);
		Nota n23 = new NotaImpl(asig, 2015, Convocatoria.PRIMERA, 7.0);

		Nota n14 = new NotaImpl(asig, 2015, Convocatoria.PRIMERA, 9.50, false);
		Nota n24 = new NotaImpl(asig, 2015, Convocatoria.PRIMERA, 9.50);

		Nota n15 = new NotaImpl(asig, 2015, Convocatoria.PRIMERA, 9.50, true);
		Nota n25 = new NotaImpl(asig, 2015, Convocatoria.PRIMERA, 9.50);

		System.out.println("\t                             " + "CONSTRUCTOR 1" + "                CONSTRUCTOR 2");
		System.out.println("\t SUSPENSO --------------->     " + n11.getCalificacion() + "                |    "
				+ n21.getCalificacion());
		System.out.println("\t APROBADO --------------->     " + n12.getCalificacion() + "                |    "
				+ n22.getCalificacion());
		System.out.println("\t NOTABLE ---------------->     " + n13.getCalificacion() + "                 |    "
				+ n23.getCalificacion());
		System.out.println("\t SOBRESALIENTE ---------->     " + n14.getCalificacion() + "           |    "
				+ n24.getCalificacion());
		System.out.println(
				"\t MATRICULA_DE_HONOR ----->     " + n15.getCalificacion() + "      |    " + n25.getCalificacion());

	}

	private static void casoDePrueba2() {
		System.out.println("\n\n Caso de prueba 2 <==============> Ubidragon" + "\n\t VALOR" + "\n\t inferior a 0");

		Asignatura asig = new AsignaturaImpl("Sociologia", "7654321", 8.0, TipoAsignatura.ANUAL, 1);

		System.out.println("\t\tCONSTRUCTOR 1");
		testConstructor(asig, 2015, Convocatoria.PRIMERA, -1.0, false);

		System.out.println("\n\t\tCONSTRUCTOR 2");
		testConstructor2(asig, 2016, Convocatoria.PRIMERA, -2.0);

	}

	private static void casoDePrueba3() {
		System.out.println("\n\n Caso de prueba 3 <==============> Ubidragon" + "\n VALOR" + "\n mayor que 10 ");

		Asignatura asig = new AsignaturaImpl("Dibujo", "1111111", 6.0, TipoAsignatura.ANUAL, 2);

		System.out.println("\t\tCONSTRUCTOR 1");
		testConstructor(asig, 2015, Convocatoria.PRIMERA, 12.0, false);

		System.out.println("\n\t\tCONSTRUCTOR 2");
		testConstructor2(asig, 2015, Convocatoria.PRIMERA, 13.0);

	}

	private static void casoDePrueba4() {
		System.out.println("\n\n Caso de prueba 4 <==============> Ubidragon" + "\n MENCION"
				+ "\n valor menor que 9 y mencion true");
		Asignatura asig = new AsignaturaImpl("Dibujo", "1111111", 6.0, TipoAsignatura.ANUAL, 2);

		testConstructor(asig, 2015, Convocatoria.PRIMERA, 2.0, true);

	}

	private static void testIgualdad() {

		System.out.println("\n\n Caso de prueba <==============> Ubidragon" + "\n\t hashCode() & equals()\n");
		// Creamos dos objetos iguales (mismo código, mismo tipo de beca,
		// el resto distinto)
		Asignatura asig = new AsignaturaImpl("Dibujo", "1111111", 6.0, TipoAsignatura.ANUAL, 2);
		Asignatura asig1 = new AsignaturaImpl("Algebra", "1110111", 8.0, TipoAsignatura.SEGUNDO_CUATRIMESTRE, 3);

		Nota n11 = new NotaImpl(asig, 2015, Convocatoria.PRIMERA, 4.50, false);
		Nota n12 = new NotaImpl(asig, 2015, Convocatoria.PRIMERA, 7.0, false);
		Nota n13 = new NotaImpl(asig, 2016, Convocatoria.PRIMERA, 5.50, false);
		Nota n14 = new NotaImpl(asig1, 2015, Convocatoria.PRIMERA, 7.0, false);
		Nota n15 = new NotaImpl(asig, 2015, Convocatoria.SEGUNDA, 7.0, false);

		System.out.println("\tCódigo hash del objeto n1 (" + n11 + "): " + n11.hashCode());
		System.out.println("\tCódigo hash del objeto n2 (" + n12 + "): " + n12.hashCode());
		System.out.println("\tCódigo hash del objeto n3 (" + n13 + "): " + n13.hashCode());
		System.out.println("\tCódigo hash del objeto n4 (" + n14 + "): " + n14.hashCode());
		System.out.println("\tCódigo hash del objeto n5 (" + n15 + "): " + n15.hashCode());

		System.out.println("\n\t ¿Es n1 igual a n2? (debe ser true): " + n11.equals(n12));
		System.out.println("\t¿Es n1 distinto de n3? (debe ser true): " + !n11.equals(n13));
		System.out.println("\t¿Es n1 distinto de n4? (debe ser true): " + !n11.equals(n14));
		System.out.println("\t¿Es n1 distinto de n5? (debe ser true): " + !n11.equals(n15));

	}

	private static void testOrden() {

		System.out.println("\n\n Caso de prueba <==============> Ubidragon" + "\n\t compareTo()\n");
		// Creamos cuatro objetos tales que menor < igual1 == igual2 < mayor

		Asignatura asig = new AsignaturaImpl("Dibujo", "0000001", 6.0, TipoAsignatura.ANUAL, 2);
		Asignatura asig1 = new AsignaturaImpl("Algebra", "0000003", 8.0, TipoAsignatura.SEGUNDO_CUATRIMESTRE, 3);

		Nota n11 = new NotaImpl(asig, 2015, Convocatoria.PRIMERA, 4.50, false);
		Nota n12 = new NotaImpl(asig, 2015, Convocatoria.PRIMERA, 7.0, false);
		Nota n13 = new NotaImpl(asig, 2016, Convocatoria.PRIMERA, 5.50, false);
		Nota n14 = new NotaImpl(asig1, 2015, Convocatoria.PRIMERA, 7.0, false);
		Nota n15 = new NotaImpl(asig, 2015, Convocatoria.SEGUNDA, 7.0, false);

		System.out.println("\tIGUALES");
		compara(n11, n12);
		System.out.println("\n\tA igualdad de objeto se ordena por CursoAcademico");
		compara(n13, n11);
		System.out.println("\n\tA igualdad de CURSO_ACADEMICO, se ordena por ASIGNATURA");
		compara(n14, n11);
		System.out.println("\n\tA igualdad de CURSO_ACADEMICO y de ASIGNATURA,se ordena por CONVOCATORIA");
		compara(n15, n11);

	}

	/* CONSTRUCTOR MEDIEANTE FICHERO */
	public static List<Nota> create(String nombreFichero) {
		List<Nota> res = Grados.leeFichero("res/notas.txt", s -> new NotaImpl(s));
		return res;
	}

	/***************************************************
	 * METODOS AUXILIARES
	 *************************************************/

	private static void testConstructor(Asignatura asig, Integer curso, Convocatoria convocatoria, Double valor,
			Boolean mencion) {

		try {

			Nota not = new NotaImpl(asig, curso, convocatoria, valor, mencion);

			mostrarNota(not);

		} catch (ExcepcionNotaNoValida e) {

			System.out.println("\n\t Ha devuelto correctamente la excepcion");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(
					"\n ERROR!!!! \nERROR!!!  \nERROR!!!  \nERROR!!! \nLA EXCEPCION LANZADA NO ES LA REGISTRADA \n GILIPOLLAS REVISA EL CODIGO");

		}

	}

	private static void testConstructor2(Asignatura asig, Integer curso, Convocatoria convocatoria, Double valor) {

		try {

			Nota not = new NotaImpl(asig, curso, convocatoria, valor);

			mostrarNota(not);

		} catch (ExcepcionNotaNoValida e) {

			System.out.println("\n\t\t\t Ha devuelto correctamente la excepcion");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(
					"\n ERROR!!!! \nERROR!!!  \nERROR!!!  \nERROR!!! \nLA EXCEPCION LANZADA NO ES LA REGISTRADA \n GILIPOLLAS REVISA EL CODIGO");

		}

	}

	private static void compara(Nota n1, Nota n2) {

		System.out.print("El objeto <" + n1 + ">");

		if (n1.compareTo(n2) < 0) {

			System.out.print(" va ANTES que el objeto ");

		}

		else if (n1.compareTo(n2) > 0) {

			System.out.print(" va DESPUÉS que el objeto ");

		} else {

			System.out.print(" va en la MISMA POSICIÓN que el objeto ");

		}

		System.out.println("<" + n2 + ">");

	}

	/***************************************************
	 * MOSTRAR
	 *************************************************/

	private static void mostrarNota(Nota not) {

		System.out.println("\tNota  : < " + not + " >");
		System.out.println("\n\t\tAsignatura: < " + not.getAsignatura() + " >");
		System.out.println("\t\tCurso Academico: < " + not.getCursoAcademico() + " >");
		System.out.println("\t\tConvocatoria: < " + not.getConvocatoria() + " >");
		System.out.println("\t\tValor: < " + not.getValor() + " >");
		System.out.println("\t\tMencion: < " + not.getMencionHonor() + " >");
		System.out.println("\t\tCalificacion: < " + not.getCalificacion() + " >");

	}
}
