package fp.grados.excepciones;

public class ExcepcionAsignaturaNoValida extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExcepcionAsignaturaNoValida() {

		super();

	}

	public ExcepcionAsignaturaNoValida(String string) {

		super(string);

	}

}