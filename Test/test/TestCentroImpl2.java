package fp.grados.tipos.test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.SortedMap;

import fp.grados.tipos.Categoria;
import fp.grados.tipos.Centro;
import fp.grados.tipos.CentroImpl2;
import fp.grados.tipos.Departamento;
import fp.grados.tipos.DepartamentoImpl;
import fp.grados.tipos.Despacho;
import fp.grados.tipos.DespachoImpl;
import fp.grados.tipos.Espacio;
import fp.grados.tipos.Profesor;
import fp.grados.tipos.TipoEspacio;
import fp.grados.utiles.Grados;

public class TestCentroImpl2 {

	public static void main(String[] args) {
		testEspacioMayorCapacidad();
		testNumEspaciosCentro();
		testProfesorPorDespacho();
		testProfesoresdeundepartamento();

	}

	private static void testProfesoresdeundepartamento() {

		Centro c = new CentroImpl2("Ingenieria Informatica", "Reina Mercedes",
				4, 1);
		Departamento d1 = new DepartamentoImpl("Matematicas II");
		Profesor p1 = Grados.createProfesor("30254347D", "Angel", "Delgado",
				LocalDate.of(1996, 03, 12), "nadie@gmail.com",
				Categoria.CATEDRATICO,
				null);
		Despacho desp1 = new DespachoImpl("I2.89", 1, 3);
		c.nuevoEspacio(desp1);
		
		d1.nuevoProfesor(p1);
		
		desp1.getProfesores().add(p1);
		
		System.out.println("Profesores del centro en un departamento especifico: " + c.getProfesores(d1));
		 
	}

	private static void testProfesorPorDespacho() {

		System.out.println("\n========================PROFESOR POR DESPACHO");
		Centro c = new CentroImpl2("Ingenieria Informatica", "Reina Mercedes",
				3, 1);

		Profesor p1 = Grados.createProfesor("30254347D", "Angel", "Delgado",
				LocalDate.of(1996, 03, 12), "nadie@gmail.com",
				Categoria.CATEDRATICO,
				Grados.createDepartamento("Matematicas II"));

		Despacho d1 = Grados.createDespacho("I2.89", 1, 3);

		SortedMap<Profesor, Despacho> map;

		map = c.getDespachosPorProfesor();

		map.put(p1, d1);

		System.out.println(map);

	}

	private static void testNumEspaciosCentro() {
		Centro c = new CentroImpl2("Ingenieria Informatica", "Reina Mercedes",
				3, 1);

		Espacio e1 = Grados.createEspacio(TipoEspacio.EXAMEN, "A3.10", 200, 2);
		Espacio e2 = Grados.createEspacio(TipoEspacio.EXAMEN, "A2.10", 100, 2);
		Espacio e3 = Grados.createEspacio(TipoEspacio.LABORATORIO, "A3.11",
				200, 2);
		Espacio e4 = Grados.createEspacio(TipoEspacio.LABORATORIO, "A1.11",
				200, 2);
		Espacio e5 = Grados.createEspacio(TipoEspacio.LABORATORIO, "A0.11",
				200, 2);
		Espacio e6 = Grados.createEspacio(TipoEspacio.SEMINARIO, "A0.10", 140,
				1);

		c.nuevoEspacio(e1);
		c.nuevoEspacio(e2);
		c.nuevoEspacio(e3);
		c.nuevoEspacio(e4);
		c.nuevoEspacio(e5);
		c.nuevoEspacio(e6);
		
		System.out.println("Conteo Espacios "
				+ Arrays.toString(c.getConteosEspacios()));
	}

	private static void testEspacioMayorCapacidad() {

		Centro c = new CentroImpl2("Ingenieria Informatica", "Reina Mercedes",
				3, 1);
		c.nuevoEspacio(Grados.createEspacio(TipoEspacio.LABORATORIO, "LAB1", 10,
				1));
		c.nuevoEspacio(Grados.createEspacio(TipoEspacio.SEMINARIO, "LAB2", 300, 2));
		c.nuevoEspacio(Grados.createEspacio(TipoEspacio.TEORIA, "A0.12", 150, 2));

		System.out.println("Espacio Mayor Capacidad "
				+ c.getEspacioMayorCapacidad());
	}

}
