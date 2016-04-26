package fp.grados.tipos.test;

import fp.grados.tipos.PersonaImpl;
import fp.grados.utiles.Grados;

public class TestPersona {

	public static void main(String[] args) {

		System.out.println(Grados.leeFichero("ficheros/personas.txt", x-> new PersonaImpl(x)));
	}

}
