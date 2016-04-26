package fp.grados.tipos.test;

import java.util.List;

import fp.grados.excepciones.ExcepcionBecaNoValida;
import fp.grados.tipos.Beca;
import fp.grados.tipos.BecaImpl;
import fp.grados.tipos.TipoBeca;
import fp.grados.utiles.Grados;

public class TestBeca {

	public static void main(String[] args) {

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

		testIgualdad();
		testOrden();

	}

	private static void noPlagio() {

		System.out.println("	                                    $,  $,     ,             ");
		System.out.println("     Powered                            ss.$ss. .s'      ");
		System.out.println("                                ,     .ss$$$$$$$$$$s,               ");
		System.out.println("              by                $. s$$$$$$$$$$$$$$`$$Ss        ");
		System.out.println("                                 $$$$$$$$$$$$$$$$$$o$$$       ,        ");
		System.out.println("                               s$$$$$$$$$$$$$$$$$$$$$$$$s,  ,s   ");
		System.out.println("                              s$$$$$$$$$'$$$$$$''''$$$$$$'$$$$$,      ");
		System.out.println("                              s$$$$$$$$$$s''$$$$ssssss'$$$$$$$$'    ");
		System.out.println("                             s$$$$$$$$$$'         `'''ss'$'$s''       ");
		System.out.println("                             s$$$$$$$$$$,              `''''$  .s$$s ");
		System.out.println("                             s$$$$$$$$$$$$s,...               `s$$'  ` ");
		System.out.println("                         `ssss$$$$$$$$$$$$$$$$$$$$####s.     .$$'$.   , s- ");
		System.out.println("                           `''''$$$$$$$$$$$$$$$$$$$$#####$$$$$$'     $.$' ");
		System.out.println("                                 '$$$$$$$$$$$$$$$$$$$$$####s'''     .$$$| ");
		System.out.println("                                  '$$$$$$$$$$$$$$$$$$$$$$$$##s    .$$' $  ");
		System.out.println("                                   $$''$$$$$$$$$$$$$$$$$$$$$$$$$$$$$'   ` ");
		System.out.println("                                  $$'  '$'$$$$$$$$$$$$$$$$$$$$S'''''  ");
		System.out.println("                             ,   ,'     '  $$$$$$$$$$$$$$$$####s   ");
		System.out.println("                             $.          .s$$$$$$$$$$$$$$$$$####' ");
		System.out.println("                 ,           '$s.   ..ssS$$$$$$$$$$$$$$$$$$$####' ");
		System.out.println("                 $           .$$$S$$$$$$$$$$$$$$$$$$$$$$$$#####' ");
		System.out.println("                 Ss     ..sS$$$$$$$$$$$$$$$$$$$$$$$$$$$######'' ");
		System.out.println("                  '$$sS$$$$$$$$$$$$$$$$$$$$$$$$$$$########' ");
		System.out.println("           ,      s$$$$$$$$$$$$$$$$$$$$$$$$#########''' ");
		System.out.println("           $    s$$$$$$$$$$$$$$$$$$$$$#######'''      s'         , ");
		System.out.println("           $$..$$$$$$$$$$$$$$$$$$######''       ....,$$....    ,$ ");
		System.out.println("            '$$$$$$$$$$$$$$$######'' ,     .sS$$$$$$$$$$$$$$$$s$$ ");
		System.out.println("              $$$$$$$$$$$$#####'     $, .s$$$$$$$$$$$$$$$$$$$$$$$$s. ");
		System.out.println("   )          $$$$$$$$$$$#####'      `$$$$$$$$$###########$$$$$$$$$$$. ");
		System.out.println("  ((          $$$$$$$$$$$#####       $$$$$$$$###'       '####$$$$$$$$$$  ");
		System.out.println("  ) (         $$$$$$$$$$$$####.     $$$$$$###'             '###$$$$$$$$$   s' ");
		System.out.println(" (   )        $$$$$$$$$$$$$####.   $$$$$###'                ####$$$$$$$$s$$' ");
		System.out.println(" )  ( (       $$'$$$$$$$$$$$#####.$$$$$###'  Ubidragon     .###$$$$$$$$$$' ");
		System.out.println(" (  )  )   _,$'   $$$$$$$$$$$$######.$$##'                .###$$$$$$$$$$ ");
		System.out.println(" ) (  ( ).         '$$$$$$$$$$$$$#######,,,.          ..####$$$$$$$$$$$' ");
		System.out.println("(   )$ )  )        ,$$$$$$$$$$$$$$$$$$####################$$$$$$$$$$$'         ");
		System.out.println("(   ($$  ( )     _sS'  `'$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$S$$,        ");
		System.out.println(" )  )$$$s ) )  .      .   `$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$''  `$$    ");
		System.out.println("  (   $$$Ss/  .$,    .$,,s$$$$$$##S$$$$$$$$$$$$$$$$$$$$$$$$S''        '  ");
		System.out.println("    ))_$$$$$$$$$$$$$$$$$$$$$$$##'  $$        `$$.        `$$. ");
		System.out.println("        `'S$$$$$$$$$$$$$$$$$#'      $          `$          `$ ");
		System.out.println("            `''''''''''''''         '           '           '  ");

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

		System.out.println("CONSTRUCTOR 1");
		Beca b2 = new BecaImpl("DEF0002", 1500.0, 1, TipoBeca.MOVILIDAD);
		mostrarBeca(b2);

		System.out.println("\nCONSTRUCTOR 2");
		Beca b1 = new BecaImpl("ABC0001", TipoBeca.ORDINARIA);
		mostrarBeca(b1);

	}

	private static void casoDePrueba2() {
		System.out.println(
				"\n\n Caso de prueba 2 <==============> Ubidragon" + "\n CODIGO" + "\n CODIGO CON LONGITUD MENOR A 7");

		System.out.println("\n referido al constructor 1");
		testConstructor("DEF002", 1500.0, 1, TipoBeca.MOVILIDAD);

		System.out.println("\n referido al constructor 2");
		testConstructor2("ABC001", TipoBeca.ORDINARIA);

	}

	private static void casoDePrueba3() {

		System.out.println(
				"\n\n Caso de prueba 3 <==============> Ubidragon" + "\n CODIGO " + "\n CODIGO CON LONGITUD MAYOR A 7");

		System.out.println("\n referido al constructor 1");
		testConstructor("DEF00002", 1500.0, 1, TipoBeca.MOVILIDAD);

		System.out.println("\n referido al constructor 2");
		testConstructor2("ABC00001", TipoBeca.ORDINARIA);

	}

	private static void casoDePrueba4() {

		System.out.println("\n\n Caso de prueba 4 <==============> Ubidragon" + "\n CODIGO" + "\n CODIGO SIN LETRAS");

		System.out.println("\n referido al constructor 1");
		testConstructor("0000002", 1500.0, 1, TipoBeca.MOVILIDAD);

		System.out.println("\n referido al constructor 2");
		testConstructor2("0000001", TipoBeca.ORDINARIA);

	}

	private static void casoDePrueba5() {

		System.out.println("\n\n Caso de prueba 5 <==============> Ubidragon" + "\n CODIGO" + "\n CODIGO SIN NUMEROS");

		System.out.println("\n referido al constructor 1");
		testConstructor("DEFefgr", 1500.0, 1, TipoBeca.MOVILIDAD);

		System.out.println("\n referido al constructor 2");
		testConstructor2("ABCdefg", TipoBeca.ORDINARIA);

	}

	private static void casoDePrueba6() {

		System.out.println("\n\n Caso de prueba 6 <==============> Ubidragon" + "\n CODIGO"
				+ "\n CODIGO CON MAS LETRAS DE LA CUENTA");

		System.out.println("\n referido al constructor 1");
		testConstructor("DEFd002", 1500.0, 1, TipoBeca.MOVILIDAD);

		System.out.println("\n referido al constructor 2");
		testConstructor2("ABCd001", TipoBeca.ORDINARIA);

	}

	private static void casoDePrueba7() {

		System.out.println("\n\n Caso de prueba 7 <==============> Ubidragon" + "\n CODIGO"
				+ "\n CODIGO CON MENOS LETRAS DE LA CUENTA");

		System.out.println("\n referido al constructor 1");
		testConstructor("DE00002", 1500.0, 1, TipoBeca.MOVILIDAD);

		System.out.println("\n referido al constructor 2");
		testConstructor2("AB00001", TipoBeca.ORDINARIA);

	}

	private static void casoDePrueba8() {

		System.out.println("\n\n Caso de prueba 8 <==============> Ubidragon" + "\n CODIGO"
				+ "\n CODIGO CON MAS NUMEROS DE LA CUENTA");

		System.out.println("\n referido al constructor 1");
		testConstructor("DEFd002", 1500.0, 1, TipoBeca.MOVILIDAD);

		System.out.println("\n referido al constructor 2");
		testConstructor2("ABCd001", TipoBeca.ORDINARIA);

	}

	private static void casoDePrueba9() {

		System.out.println("\n\n Caso de prueba 9 <==============> Ubidragon" + "\n CODIGO"
				+ "\n CODIGO CON MAS NUMEROS DE LA CUENTA");

		System.out.println("\n referido al constructor 1");
		testConstructor("DE00002", 1500.0, 1, TipoBeca.MOVILIDAD);
		testConstructor2("AB00001", TipoBeca.ORDINARIA);

		System.out.println("\n referido al constructor 2");
		testConstructor2("AB00001", TipoBeca.ORDINARIA);

	}

	private static void casoDePrueba10() {

		System.out.println(
				"\n\n Caso de prueba 10 <==============> Ubidragon" + "\n CUANTIA" + "\n cuantia sin modificaciones");

		Beca b1 = new BecaImpl("DEF0002", 1500.0, 1, TipoBeca.MOVILIDAD);
		testSetCuantiaTotal(b1, 10000.0);

	}

	private static void casoDePrueba11() {

		System.out.println(
				"\n\n Caso de prueba 11 <==============> Ubidragon" + "\n CUANTIA" + "\n INFERIOR A LA ESTABLECIDA");

		Beca b1 = new BecaImpl("DEF0002", 1500.0, 1, TipoBeca.MOVILIDAD);
		testSetCuantiaTotal(b1, 200.0);

	}

	private static void casoDePrueba12() {

		System.out.println(
				"\n\n Caso de prueba 12 <==============> Ubidragon" + "\n DURACION" + "\n DURACION sin modificaciones");

		Beca b1 = new BecaImpl("DEF0002", 1500.0, 1, TipoBeca.MOVILIDAD);
		testSetDuracion(b1, 5);

	}

	private static void casoDePrueba13() {

		System.out.println(
				"\n\n Caso de prueba 13 <==============> Ubidragon" + "\n DURACION" + "\n INFERIOR A LA ESTABLECIDA");

		Beca b1 = new BecaImpl("DEF0002", 1500.0, 1, TipoBeca.MOVILIDAD);
		testSetDuracion(b1, -6);

	}

	private static void testIgualdad() {

		System.out.println("\n\n Caso de prueba <==============> Ubidragon" + "\n\t hashCode() & equals()\n");
		// Creamos dos objetos iguales (mismo código, mismo tipo de beca,
		// el resto distinto)
		Beca b1 = new BecaImpl("ABC1234", 2000.0, 12, TipoBeca.EMPRESA);
		Beca b2 = new BecaImpl("ABC1234", 3000.0, 6, TipoBeca.EMPRESA);
		// Creamos objetos distintos (distinto código, distinto tipo de beca)
		Beca b3 = new BecaImpl("ZWQ9877", 2000.0, 12, TipoBeca.EMPRESA);
		Beca b4 = new BecaImpl("ABC1234", 3000.0, 6, TipoBeca.MOVILIDAD);

		System.out.println("Código hash del objeto b1 (" + b1 + "): " + b1.hashCode());
		System.out.println("Código hash del objeto b2 (" + b2 + "): " + b2.hashCode());
		System.out.println("Código hash del objeto b3 (" + b3 + "): " + b3.hashCode());
		System.out.println("Código hash del objeto b4 (" + b4 + "): " + b4.hashCode());

		System.out.println("¿Es b1 igual a b2? (debe ser true): " + b1.equals(b2));
		System.out.println("¿Es b1 distinto de b3? (debe ser true): " + !b1.equals(b3));
		System.out.println("¿Es b1 distinto de b4? (debe ser true): " + !b1.equals(b4));

	}

	private static void testOrden() {

		System.out.println("\n\n Caso de prueba <==============> Ubidragon" + "\n\t compareTo()\n");
		// Creamos cuatro objetos tales que menor < igual1 == igual2 < mayor
		Beca menor = new BecaImpl("ABC1234", 10000.0, 6, TipoBeca.ORDINARIA);
		Beca igual1 = new BecaImpl("ABC1235", 10000.0, 6, TipoBeca.ORDINARIA);
		Beca igual2 = new BecaImpl("ABC1235", 10000.0, 6, TipoBeca.ORDINARIA);
		Beca mayor = new BecaImpl("ABC1235", 10000.0, 6, TipoBeca.EMPRESA);

		System.out.print("(debe ser ANTES) ");
		compara(menor, igual1);

		System.out.print("(debe ser MISMA POSICIÓN) ");
		compara(igual1, igual2);

		System.out.print("(debe ser ANTES) ");
		compara(igual2, mayor);

	}

	/* CONSTRUCTOR MEDIEANTE FICHERO */
	public static List<Beca> create(String nombreFichero) {
		List<Beca> res = Grados.leeFichero("res/becas.txt", s -> new BecaImpl(s));
		return res;
	}

	/***************************************************
	 * METODOS AUXILIARES
	 *************************************************/
	private static void testConstructor(String codigo, Double cuantiaTotal, Integer duracion, TipoBeca tipo) {

		try {

			Beca b = new BecaImpl(codigo, cuantiaTotal, duracion, tipo);

			mostrarBeca(b);

		} catch (ExcepcionBecaNoValida e) {

			System.out.println("\n\t\t\t Ha devuelto correctamente la excepcion");

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println(
					"\n ERROR!!!! \nERROR!!!  \nERROR!!!  \nERROR!!! \nLA EXCEPCION LANZADA NO ES LA REGISTRADA \n GILIPOLLAS REVISA EL CODIGO");

		}

	}

	private static void testConstructor2(String codigo, TipoBeca tipo) {

		try {

			Beca b = new BecaImpl(codigo, tipo);

			mostrarBeca(b);

		} catch (ExcepcionBecaNoValida e) {

			System.out.println("\n\t\t\t Ha devuelto correctamente la excepcion");

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println(
					"\n ERROR!!!! \nERROR!!!  \nERROR!!!  \nERROR!!! \nLA EXCEPCION LANZADA NO ES LA REGISTRADA \n GILIPOLLAS REVISA EL CODIGO");

		}

	}

	private static void testSetCuantiaTotal(Beca b, Double cuantiaTotal) {

		try {

			System.out.println("\n\tLa cuantía total antes de la operación es: " + b.getCuantiaTotal());
			System.out.println("\tEl nuevo valor es: " + cuantiaTotal);
			b.setCuantiaTotal(cuantiaTotal);
			System.out.println("\tLa cuantía total después de la operación es: " + b.getCuantiaTotal());

		} catch (ExcepcionBecaNoValida e) {

			System.out.println("\n\t\t\t Ha devuelto correctamente la excepcion");

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println(
					"\n ERROR!!!! \nERROR!!!  \nERROR!!!  \nERROR!!! \nLA EXCEPCION LANZADA NO ES LA REGISTRADA \n GILIPOLLAS REVISA EL CODIGO");

		}
	}

	private static void testSetDuracion(Beca b, Integer duracion) {

		try {

			System.out.println("\n\tLa duración antes de la operación es: " + b.getDuracion());
			System.out.println("\tEl nuevo valor es: " + duracion);
			b.setDuracion(duracion);
			System.out.println("\tLa duración después de la operación es: " + b.getDuracion());

		} catch (ExcepcionBecaNoValida e) {

			System.out.println("\n\t\t\t Ha devuelto correctamente la excepcion");

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println(
					"\n ERROR!!!! \nERROR!!!  \nERROR!!!  \nERROR!!! \nLA EXCEPCION LANZADA NO ES LA REGISTRADA \n GILIPOLLAS REVISA EL CODIGO");

		}

	}

	private static void compara(Beca b1, Beca b2) {

		System.out.print("El objeto <" + b1 + ">");

		if (b1.compareTo(b2) < 0) {

			System.out.print(" va ANTES que el objeto ");

		}

		else if (b1.compareTo(b2) > 0) {

			System.out.print(" va DESPUÉS que el objeto ");
		} else {

			System.out.print(" va en la MISMA POSICIÓN que el objeto ");

		}

		System.out.println("<" + b2 + ">");

	}

	/***************************************************
	 * MOSTRAR
	 *************************************************/

	private static void mostrarBeca(Beca b) {
		System.out.println("Beca--> < " + b + " >");
		// Aquí se está probando el método toString()
		System.out.println("\t\tCódigo: < " + b.getCodigo() + " >");
		System.out.println("\t\tCuantía Total: < " + b.getCuantiaTotal() + " >");
		System.out.println("\t\tDuración: < " + b.getDuracion() + " >");
		System.out.println("\t\tTipo: < " + b.getTipo() + " >");
		System.out.println("\t\tCuantía Mensual: < " + b.getCuantiaMensual() + " >");
	}
}
