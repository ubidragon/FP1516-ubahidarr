package fp.grados.tipos;

public interface Espacio extends Comparable<Espacio> {

	TipoEspacio getTipo();

	String getNombre();

	Integer getCapacidad();

	Integer getPlanta();

	void setNombre(String nombre);

	void setCapacidad(Integer capacidad);

	void setTipo(TipoEspacio tipo);

}
