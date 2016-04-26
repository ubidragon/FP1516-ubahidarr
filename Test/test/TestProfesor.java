package fp.grados.tipos.test;

import java.time.LocalDate;

import fp.grados.excepciones.ExcepcionProfesorNoValido;
import fp.grados.tipos.Categoria;
import fp.grados.tipos.Departamento;
import fp.grados.tipos.DepartamentoImpl;
import fp.grados.tipos.Profesor;
import fp.grados.tipos.ProfesorImpl;

public class TestProfesor {

	public static void main(String[] args) {
		
		testConstructorNormal();
		
		testConstructorExcepcion();
		
//		testDepartamento();

	}


	private static void testConstructorNormal() {

		System.out.println("-----------------------");
		System.out.println("TestConstructorNormal");
		System.out.println("-----------------------");
		
		testConstructor("28200400P", "María", "MartinOviedo", 
				LocalDate.of(1985, 05, 21),"maria.martin@us.es", Categoria.TITULAR, 
				new DepartamentoImpl("LSI"));
		
	}
	private static void testConstructorExcepcion() {

		System.out.println("-----------------------");
		System.out.println("Probar edad menor que 18");
		System.out.println("-----------------------");
		
		
		testConstructor("28200400P", "María", "MartinOviedo", LocalDate.of(1999, 12, 1), 
				"maria.martin@us.es", 
				Categoria.TITULAR, new DepartamentoImpl("LSI"));
		
	}

	private static void testConstructor(String dni, String nombre,
			String apellidos, LocalDate FechaNacimiento, String email, Categoria categoria, Departamento departamento) {
		
		try{
			
		Profesor p = new ProfesorImpl(dni, nombre, apellidos, FechaNacimiento, email, categoria, departamento);
		mostrarProfesor(p);
		
		} catch (ExcepcionProfesorNoValido e) {
			
			System.out.println("Excepcion Profesor No Valido");
			
		} catch (Exception e){
			
			System.out.println("Excepcion Inesperada");
		}
	}

	private static void mostrarProfesor(Profesor p) {


		System.out.println(p);
		
	}

}
