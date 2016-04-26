package fp.grados.tipos.test;

import java.time.LocalDate;
import java.util.Set;

import fp.grados.tipos.Categoria;
import fp.grados.tipos.Departamento;
import fp.grados.tipos.DepartamentoImpl;
import fp.grados.tipos.Profesor;
import fp.grados.tipos.ProfesorImpl;

public class ExperimentoRelacionBidireccionalDEPTOPROF {

	public static void main(String[] args) {
		System.out.println("\nBIDIRECCIONALIDAD --------------------- DepartamentoProfesor");
		
		Departamento d1 = new DepartamentoImpl("Lenguajes y Sistemas Informaticos");
		Departamento d2 = new DepartamentoImpl ("Ciencias de la Computacion e " + 
		"Inteligencia Artificial");
		Profesor prof = new ProfesorImpl("12345678Z", "Juan", "Nadie Nadie", LocalDate.of(1959, 6, 2),
				"juan.nadie@gmail.es", Categoria.COLABORADOR, d1);
		System.out.println("---------------------------------------------------");
		muestraDepartamentos(d1, d2);
		
		System.out.println("Profesor " + prof + " en " + prof.getDepartamento());
		System.out.println("Añadimos el profesor " + " al departamento " + d2);
		d2.nuevoProfesor(prof);
		System.out.println("---------------------------------------------------");
		muestraDepartamentos(d1, d2);
		
		Set <Profesor> set = d1.getProfesores();
		set.clear();
		
		System.out.println("Cambiamos el departamento" + " del profesor ...");
		prof.setDepartamento(d1);
		System.out.println("---------------------------------------------------");
		muestraDepartamentos (d1, d2);
	}

	private static void muestraDepartamentos(Departamento d1, Departamento d2) {

		System.out.println(d1 + ":" + d1.getProfesores());
		System.out.println(d2 + ":" + d2.getProfesores());
		
	}
	
}
