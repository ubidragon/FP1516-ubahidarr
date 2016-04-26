package fp.grados.tipos.test;


import java.util.SortedMap;
import java.util.SortedSet;

import fp.grados.tipos.Asignatura;
import fp.grados.tipos.Beca;
import fp.grados.tipos.TipoEspacio;

public class TestRepasoEntrega3 {

	public static void main(String[] args) {
		
		SortedMap <Beca, Integer> map = RepasoEntrega3.duracionesBecas("ficheros/becas.txt", 5000.);
		
		System.out.println("\nDuraciones de beca con cuantia de 5000: " + map);
		
		Integer numeroBecasDuracion = RepasoEntrega3.numeroBecasDuracion("ficheros/becas.txt", 6);
		
		System.out.println("\nNumero Becas Duracion: " + numeroBecasDuracion);

		Integer a = RepasoEntrega3.capacidadTotalEspaciosTipo("ficheros/espacios.txt", TipoEspacio.LABORATORIO);
		
		System.out.println("\nCapacidadTotalEspaciosTipo: " + a);
		
		SortedSet<Asignatura> asignaturas = RepasoEntrega3.seleccionaAnuales("ficheros/asignaturas.txt");
		
		System.out.println("\nAsignaturas Anuales: " + asignaturas);
		
		
	}

}
