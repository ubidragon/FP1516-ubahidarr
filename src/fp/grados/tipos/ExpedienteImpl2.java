package fp.grados.tipos;

public class ExpedienteImpl2 extends ExpedienteImpl {

	public ExpedienteImpl2(){

		super();

	}

	public Double getNotaMedia() {
		return getNotas().stream().filter(n -> n.getValor() >= 5).mapToDouble(n -> n.getValor()).average().orElse(0.0);
	}

}
