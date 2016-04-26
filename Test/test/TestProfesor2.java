package fp.grados.tipos.test;

import java.time.LocalDate;

import fp.grados.excepciones.ExcepcionProfesorNoValido;
import fp.grados.excepciones.ExcepcionProfesorOperacionNoPermitida;
import fp.grados.tipos.Asignatura;
import fp.grados.tipos.AsignaturaImpl;
import fp.grados.tipos.Categoria;
import fp.grados.tipos.Departamento;
import fp.grados.tipos.DepartamentoImpl;
import fp.grados.tipos.Profesor;
import fp.grados.tipos.ProfesorImpl2;
import fp.grados.tipos.TipoAsignatura;

public class TestProfesor2 {

	public static void main(String[] args) {
		
		testConstructorNormal();
		
		testConstructorExcepcion();
		testImparteAsignaturaExcepcion();
		testImparteAsignatura1();
		testImparteAsignatura2();
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

	private static void testImparteAsignatura1() {
		System.out.println("-----------------------");
		System.out.println("TestConstructorImparteAsignatura");
		System.out.println("-----------------------");
		
		Asignatura asig = new AsignaturaImpl("Calculo Infinitesimal", "2050004", 6.,
				TipoAsignatura.PRIMER_CUATRIMESTRE, 1, 
				new DepartamentoImpl("Matematica Aplicada I"));
		Double dedicacion = 6.0;
		Profesor p = new ProfesorImpl2("28200400P", "María", "MartinOviedo", LocalDate.of(1964, 12, 1), 
				"maria.martin@us.es", 
				Categoria.TITULAR, new DepartamentoImpl("Matematica Aplicada I"));
		testImparteAsignatura(p,asig, dedicacion);
		
		System.out.println("-----------------------");
		System.out.println("TestConstructorELIMINAASIGNATURA");
		System.out.println("-----------------------");
		
		testEliminaAsignatura(p,asig);
		
	}
	
	private static void testEliminaAsignatura(Profesor p,Asignatura asig) {
			
			System.out.println("Asignatura " + asig);
			System.out.println("Se elimina la asignatura ");
			
			p.eliminaAsignatura(asig);
			
			System.out.println("La asignatura se eliminó correctamente");
			
			
			
		
	}
	private static void testImparteAsignaturaExcepcion() {
		System.out.println("-----------------------");
		System.out.println("TestConstructorImparteAsignaturaEXCEPCION");
		System.out.println("-----------------------");
		
		Asignatura asig = new AsignaturaImpl("Calculo Infinitesimal", "2050004", 6.,
				TipoAsignatura.PRIMER_CUATRIMESTRE, 1, 
				new DepartamentoImpl("Matematica Aplicada I"));
		Double dedicacion = 12.0;
		Profesor p = new ProfesorImpl2("28200400P", "María", "MartinOviedo", LocalDate.of(1964, 12, 1), 
				"maria.martin@us.es", 
				Categoria.TITULAR, new DepartamentoImpl("Matematica Aplicada I"));
		testImparteAsignatura(p,asig, dedicacion);
		
	}
	
	private static void testImparteAsignatura(Profesor p, Asignatura asig, Double dedicacion) {
		
		try{
			
			System.out.println("Asignatura " + asig);
			System.out.println("Dedicacion " + dedicacion);
			System.out.println("Se imparte la asignatura ");
			p.imparteAsignatura(asig, dedicacion);
			
				System.out.println("La asignatura se imparte con "
						+ "la dedicacion correcta");
			
			
			} catch (ExcepcionProfesorOperacionNoPermitida e) {
				
				System.out.println("Excepcion Profesor OPERACION NO PERMITIDA");
				
			} catch (Exception e){
				
				System.out.println("Excepcion Inesperada");
			}
	}
	private static void testImparteAsignatura2() {
		System.out.println("-----------------------");
		System.out.println("TestConstructorImparteAsignatura2");
		System.out.println("-----------------------");
		
		Asignatura asig = new AsignaturaImpl("Calculo Infinitesimal", "2050004", 6.,
				TipoAsignatura.PRIMER_CUATRIMESTRE, 1, 
				new DepartamentoImpl("Matematica Aplicada I"));
		Double dedicacion = 6.0;
		Profesor p = new ProfesorImpl2("28200400P", "María", "MartinOviedo", LocalDate.of(1964, 12, 1), 
				"maria.martin@us.es", 
				Categoria.TITULAR, new DepartamentoImpl("Matematica Aplicada I"));
		Asignatura asig2 = new AsignaturaImpl("Calculo Infinitesimal", "2050004", 8.,
				TipoAsignatura.PRIMER_CUATRIMESTRE, 1, 
				new DepartamentoImpl("Matematica Aplicada I"));
		Double dedicacion2 = 7.0;
		testImparteAsignatura(p,asig,asig2,dedicacion,dedicacion2);
	}


	private static void testImparteAsignatura(Profesor p, Asignatura asig,
			Asignatura asig2, Double dedicacion, Double dedicacion2) {

		try{
			
			System.out.println("Asignatura " + asig);
			System.out.println("Dedicacion " + dedicacion);
			
			System.out.println("Se imparte la asignatura ");
			p.imparteAsignatura(asig, dedicacion);
			
				System.out.println("La asignatura se imparte con "
						+ "la dedicacion correcta");
			System.out.println("----------------------------------------");
			System.out.println("----------------------------------------");
			System.out.println("\n----------------------------------------");
			
			System.out.println("Asignatura " + asig2);
			System.out.println("Dedicacion " + dedicacion2);
			
			p.imparteAsignatura(asig2, dedicacion2);
			
			System.out.println("Se actualiza la información");
				System.out.println("----------------------------------------");
				System.out.println("----------------------------------------");
				System.out.println("----------------------------------------");
			
			} catch (ExcepcionProfesorOperacionNoPermitida e) {
				
				System.out.println("Excepcion Profesor OPERACION NO PERMITIDA");
				
			} catch (Exception e){
				
				System.out.println("Excepcion Inesperada");
			}
	}
		
	private static void testConstructor(String dni, String nombre,
			String apellidos, LocalDate FechaNacimiento, String email, Categoria categoria, Departamento departamento) {
		
		try{
			
		Profesor p = new ProfesorImpl2(dni, nombre, apellidos, FechaNacimiento, email, categoria, departamento);
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
