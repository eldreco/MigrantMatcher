package catalogos;

import java.util.ArrayList;
import java.util.List;

import dominio.Ajuda;

public class CatalogoAjudas {
    private List<Ajuda> ajudas = new ArrayList<>();

	public void adicionaAjuda(Ajuda a) {
		ajudas.add(a);
	}

	public boolean contains(Ajuda a) {
		return ajudas.contains(a);
	}

	public List<Ajuda> getAjudas(){
		return this.ajudas;
	}
    
}
