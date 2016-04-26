package fp.grados.tipos.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

import fp.grados.excepciones.ExcepcionCentroNoValido;
import fp.grados.tipos.BecaImpl;
import fp.grados.tipos.Becario;
import fp.grados.tipos.BecarioImpl;
import fp.grados.tipos.Centro;
import fp.grados.tipos.CentroImpl;
import fp.grados.tipos.Departamento;
import fp.grados.tipos.DepartamentoImpl;
import fp.grados.tipos.Espacio;
import fp.grados.tipos.EspacioImpl;
import fp.grados.tipos.TipoBeca;

public class TestCentro {

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
		// TODO
		// casoDePrueba1();
		// casoDePrueba2();
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

		System.out.println("Constructor");
		testConstructor("Facultad de Empresariales", "C/ virgen de Africa", 4, 0);

		System.out.println("\nexcepciones\n numeroPlantas");
		testConstructor("Facultad de Empresariales", "C/ virgen de Africa", 0, 2);

		System.out.println("\nnumeroSotanos");

		testConstructor("Facultad de Empresariales", "C/ virgen de Africa", 2, -1);

	}

	private static void casoDePrueba2() {

		System.out
				.println("\n\n Caso de prueba 2 <==============> Ubidragon" + "\n CASO" + "\n DESCRIPCION DEL CASO\n");

		System.out.println("Sin excepcion");

		System.out.println("\nCon excepcion");

	}

	/***************************************************
	 * METODOS AUXILIARES
	 *************************************************/

	private static void testConstructor(String nombre, String direccion, Integer numeroPlantas, Integer numeroSotanos) {

		try {

			Centro tuto = new CentroImpl(nombre, direccion, numeroPlantas, numeroSotanos);

			mostrarCentro(tuto);

		} catch (ExcepcionCentroNoValido e) {

			System.out.println("\n Ha devuelto correctamente la excepcion");

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println(
					"\n ERROR!!!! ERROR!!! LA EXCEPCION LANZADA NO ES LA REGISTRADA \nGILIPOLLAS REVISA EL CODIGO");

		}

	}

	private static void testNuevoEspacio(Centro c, Espacio es) {

		try {

			c.nuevoEspacio(es);
			System.out.println("El nuevo espacio es: " + es);
			System.out.println("Los Espacios son: " + c.getEspacios());
			System.out.println("");

		} catch (ExcepcionCentroNoValido e) {

			System.out.println("\n Ha devuelto correctamente la excepcion");

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println(
					"\n ERROR!!!! ERROR!!! LA EXCEPCION LANZADA NO ES LA REGISTRADA \nGILIPOLLAS REVISA EL CODIGO");

		}

	}

	private static void testEliminaEspacio() {

		try {

		} catch (ExcepcionCentroNoValido e) {

			System.out.println("\n Ha devuelto correctamente la excepcion");

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println(
					"\n ERROR!!!! ERROR!!! LA EXCEPCION LANZADA NO ES LA REGISTRADA \nGILIPOLLAS REVISA EL CODIGO");

		}

	}

	private static void testConteoEspacio() {

		try {

		} catch (ExcepcionCentroNoValido e) {

			System.out.println("\n Ha devuelto correctamente la excepcion");

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println(
					"\n ERROR!!!! ERROR!!! LA EXCEPCION LANZADA NO ES LA REGISTRADA \nGILIPOLLAS REVISA EL CODIGO");

		}

	}

	private static void testDespachos() {

		try {

		} catch (ExcepcionCentroNoValido e) {

			System.out.println("\n Ha devuelto correctamente la excepcion");

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println(
					"\n ERROR!!!! ERROR!!! LA EXCEPCION LANZADA NO ES LA REGISTRADA \nGILIPOLLAS REVISA EL CODIGO");

		}

	}

	private static void testDespachos(Departamento d) {

		try {

		} catch (ExcepcionCentroNoValido e) {

			System.out.println("\n Ha devuelto correctamente la excepcion");

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println(
					"\n ERROR!!!! ERROR!!! LA EXCEPCION LANZADA NO ES LA REGISTRADA \nGILIPOLLAS REVISA EL CODIGO");

		}

	}

	private static void existeProfesorDepartamento() {

		try {

		} catch (ExcepcionCentroNoValido e) {

			System.out.println("\n Ha devuelto correctamente la excepcion");

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println(
					"\n ERROR!!!! ERROR!!! LA EXCEPCION LANZADA NO ES LA REGISTRADA \nGILIPOLLAS REVISA EL CODIGO");

		}

	}

	private static void getProfesores() {

		try {

		} catch (ExcepcionCentroNoValido e) {

			System.out.println("\n Ha devuelto correctamente la excepcion");

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println(
					"\n ERROR!!!! ERROR!!! LA EXCEPCION LANZADA NO ES LA REGISTRADA \nGILIPOLLAS REVISA EL CODIGO");

		}

	}

	private static void getProfesores(Departamento d) {

		try {

		} catch (ExcepcionCentroNoValido e) {

			System.out.println("\n Ha devuelto correctamente la excepcion");

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println(
					"\n ERROR!!!! ERROR!!! LA EXCEPCION LANZADA NO ES LA REGISTRADA \nGILIPOLLAS REVISA EL CODIGO");

		}

	}

	private static void getEspacioMayorCapacidad() {

		try {

		} catch (ExcepcionCentroNoValido e) {

			System.out.println("\n Ha devuelto correctamente la excepcion");

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println(
					"\n ERROR!!!! ERROR!!! LA EXCEPCION LANZADA NO ES LA REGISTRADA \nGILIPOLLAS REVISA EL CODIGO");

		}

	}

	private static void mostrarCentro(Centro tuto) {

		System.out.println("\tCentro : < " + tuto + " >");
		System.out.println("\n\t\tNombre: < " + tuto.getNombre() + " >");
		System.out.println("\t\tDireccion: < " + tuto.getDireccion() + " >");
		System.out.println("\t\tNumero de Plantas: < " + tuto.getNumeroPlantas() + " >");
		System.out.println("\t\tNumero de Sotanos: < " + tuto.getNumeroSotanos() + " >");

	}

}
