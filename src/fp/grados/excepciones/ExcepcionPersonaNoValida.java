package fp.grados.excepciones;

public class ExcepcionPersonaNoValida extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExcepcionPersonaNoValida() {

		super();

	}

	public ExcepcionPersonaNoValida(String string) {

		super(string);

	}

}