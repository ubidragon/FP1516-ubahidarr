package fp.grados.tipos.test;

import java.util.Set;

import fp.grados.tipos.Asignatura;
import fp.grados.tipos.AsignaturaImpl;
import fp.grados.tipos.Departamento;
import fp.grados.tipos.DepartamentoImpl;
import fp.grados.tipos.TipoAsignatura;

public class ExperimentosRelacionDepartamentoAsignatura {

	public static void main(String[] args) {

		Departamento lsi = new DepartamentoImpl("Lenguajes y Sistemas Informaticos");
		Departamento ccia = new DepartamentoImpl ("Ciencias de la Computacion e " + "Inteligencia Artificial");
		Asignatura fp = new AsignaturaImpl ("Fundamentos" + " de Programacion", "2050001", 12.0, 
				TipoAsignatura.ANUAL, 1, lsi);
		System.out.println("---------------------------------------------------");
		muestraDepartamentos(lsi, ccia);
		
		System.out.println("Asignatura " + fp + " en " + fp.getDepartamento());
		System.out.println("Añadimos la asignatura FP " + " al departamento CCIA");
		ccia.nuevaAsignatura(fp);
		System.out.println("---------------------------------------------------");
		muestraDepartamentos(lsi, ccia);
		
		
		System.out.println("Cambiamos el departamento" + " de la asignatura FP...");
		fp.setDepartamento(lsi);
		System.out.println("---------------------------------------------------");
		muestraDepartamentos (lsi, ccia);
		
		
		Set <Asignatura> set = lsi.getAsignaturas();
		set.clear();

		System.out.println("Cambiamos el departamento" + " de la asignatura FP...");
		fp.setDepartamento(lsi);
		System.out.println("---------------------------------------------------");
		muestraDepartamentos (lsi, ccia);
		
	}
	private static void  muestraDepartamentos (Departamento d1, Departamento d2){
		System.out.println(d1 + ":" + d1.getAsignaturas());
		System.out.println(d2 + ":" + d2.getAsignaturas());
	}

}
