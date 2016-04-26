package fp.grados.tipos.test;

import fp.grados.tipos.Espacio;
import fp.grados.tipos.EspacioImpl;

import java.util.List;

import fp.grados.excepciones.ExcepcionEspacioNoValido;
import fp.grados.tipos.TipoEspacio;
import fp.grados.utiles.Grados;

public class TestEspacio {

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
		// casoDePrueba18();

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
		System.out.println("\n\n Caso 1 de prueba ============== Constructor" + "\n DI A QUE CO�O TESTEAS IMBECIL "
				+ "\n Este caso testea el constructor sin ningun error o excepcion");

		Espacio esp = new EspacioImpl(TipoEspacio.OTRO, "A0.11", 5, 2);
		mostrarEspacio(esp);

	}

	private static void casoDePrueba2() {
		System.out.println("\n\n Caso 2 de prueba ============== Constructor" + "\n CAPACIDAD "
				+ "\n EXCEPCION DE CAPACIDAD INFERIOR O IGUAL A 0");
		testConstructor(TipoEspacio.OTRO, "A0.12", 0, 2);

	}

	private static void casoDePrueba3() {
		System.out.println("\n\n Caso 3 de prueba ============== Constructor" + "\n SET_CAPACIDAD "
				+ "\n test de modificacion de la capacidad");
		Espacio esp = new EspacioImpl(TipoEspacio.OTRO, "A0.13", 5, 2);
		testSetCapacidad(esp, 15);

	}

	private static void casoDePrueba4() {
		System.out.println("\n\n Caso 1 de prueba ============== Constructor" + "\n SET_CAPACIDAD "
				+ "\n test de modificacion de la capacidad con valor negativo");
		Espacio esp = new EspacioImpl(TipoEspacio.OTRO, "A0.12", 5, 2);
		testSetCapacidad(esp, -15);

	}

	private static void casoDePrueba5() {
		System.out.println("\n\n Caso 1 de prueba ============== Constructor" + "\n SET_CAPACIDAD "
				+ "\n test de modificacion de la capacidad con valor nulo");
		Espacio esp = new EspacioImpl(TipoEspacio.OTRO, "A0.12", 5, 2);
		testSetCapacidad(esp, 0);

	}

	// private static void casoDePrueba6() {
	// System.out.println("\n\n Caso 1 de prueba ============== Constructor" +
	// "\n DI A QUE CO�O TESTEAS IMBECIL "
	// + "\n Este caso testea el constructor sin ningun error o excepcion");

	// }

	private static void testIgualdad() {

		System.out.println("\n\n Caso de prueba <==============> Ubidragon" + "\n\t hashCode() & equals()\n");

		Espacio esp1 = new EspacioImpl(TipoEspacio.OTRO, "A0.12", 5, 2);
		Espacio esp2 = new EspacioImpl(TipoEspacio.OTRO, "A0.12", 5, 2);
		Espacio esp3 = new EspacioImpl(TipoEspacio.OTRO, "A2.13", 5, 2);
		Espacio esp4 = new EspacioImpl(TipoEspacio.OTRO, "A0.12", 5, 3);

		System.out.println("C�digo hash del objeto esp1 (" + esp1 + "): " + esp1.hashCode());
		System.out.println("C�digo hash del objeto esp2 (" + esp2 + "): " + esp2.hashCode());
		System.out.println("C�digo hash del objeto esp3 (" + esp3 + "): " + esp3.hashCode());
		System.out.println("C�digo hash del objeto esp4 (" + esp4 + "): " + esp4.hashCode());

		System.out.println("�Es esp1 igual a esp2? (debe ser true): " + esp1.equals(esp2));
		System.out.println("�Es esp1 distinto de esp3? (debe ser true): " + !esp1.equals(esp3));
		System.out.println("�Es esp1 distinto de esp4? (debe ser true): " + !esp1.equals(esp4));

	}

	private static void testOrden() {

		System.out.println("\n\n Caso de prueba <==============> Ubidragon" + "\n\t compareTo()\n");
		// Creamos cuatro objetos tales que menor < igual1 == igual2 < mayor
		Espacio menor = new EspacioImpl(TipoEspacio.OTRO, "A0.12", 5, 1);
		Espacio igual1 = new EspacioImpl(TipoEspacio.OTRO, "A0.12", 5, 3);
		Espacio igual2 = new EspacioImpl(TipoEspacio.OTRO, "A0.12", 5, 3);
		Espacio mayor = new EspacioImpl(TipoEspacio.OTRO, "A0.10", 5, 3);

		System.out.print("(debe ser ANTES) ");
		compara(menor, igual1);

		System.out.print("(debe ser MISMA POSICI�N) ");
		compara(igual1, igual2);

		System.out.print("(debe ser ANTES) ");
		compara(igual2, mayor);

	}

	/* CONSTRUCTOR MEDIEANTE FICHERO */
	public static List<Espacio> create(String nombreFichero) {
		List<Espacio> res = Grados.leeFichero("res/espacios.txt", s -> new EspacioImpl(s));
		return res;
	}

	/***************************************************
	 * METODOS AUXILIARES
	 *************************************************/
	private static void testConstructor(TipoEspacio tipo, String nombre, Integer capacidad, Integer planta) {

		try {

			Espacio esp = new EspacioImpl(tipo, nombre, capacidad, planta);

			mostrarEspacio(esp);

		} catch (ExcepcionEspacioNoValido e) {

			System.out.println("\n\t\t\t Ha devuelto correctamente la excepcion");

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println(
					"\n ERROR!!!! \nERROR!!!  \nERROR!!!  \nERROR!!! \nLA EXCEPCION LANZADA NO ES LA REGISTRADA \n GILIPOLLAS REVISA EL CODIGO");

		}

	}

	private static void compara(Espacio esp1, Espacio esp2) {

		System.out.print("El objeto <" + esp1 + ">");

		if (esp1.compareTo(esp2) == 0) {

			System.out.print(" va en la MISMA POSICI�N que el objeto ");

		}

		else if (esp1.compareTo(esp2) > 0) {

			System.out.print(" va DESPU�S que el objeto ");
		} else {

			System.out.print(" va ANTES que el objeto ");

		}

		System.out.println("<" + esp2 + ">");

	}

	private static void testSetCapacidad(Espacio esp, Integer capacidad) {

		try {

			System.out.println("\n\tLa capacidad antes de la operaci�n es: " + esp.getCapacidad());
			System.out.println("\tEl nuevo valor es: " + capacidad);
			esp.setCapacidad(capacidad);
			System.out.println("\tLa capacidad despu�s de la operaci�n es: " + esp.getCapacidad());

		} catch (ExcepcionEspacioNoValido e) {

			System.out.println("\n\t\t\t Ha devuelto correctamente la excepcion");

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println(
					"\n ERROR!!!! \nERROR!!!  \nERROR!!!  \nERROR!!! \nLA EXCEPCION LANZADA NO ES LA REGISTRADA \n GILIPOLLAS REVISA EL CODIGO");

		}
	}

	/***************************************************
	 * MOSTRAR
	 *************************************************/

	private static void mostrarEspacio(Espacio esp) {

		System.out.println("Espacio--> <" + esp + ">");
		System.out.println("\n\t\tNombre: <" + esp.getNombre() + ">");
		System.out.println("\t\tPlanta: <" + esp.getPlanta() + ">");

	}
}
