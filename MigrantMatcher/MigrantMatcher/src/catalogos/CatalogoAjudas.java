package catalogos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import dominio.Ajuda;
import dominio.Alojamento;
import dominio.Item;
import dominio.Regiao;


public class CatalogoAjudas {
    private List<Ajuda> ajudas = new ArrayList<Ajuda>();

	public void adicionaAjuda(Ajuda a) {
		ajudas.add(a);
	}

	public boolean contains(Ajuda a) {
		return ajudas.contains(a);
	}

	public List<Ajuda> getAjudas(){
		return this.ajudas;
	}
	
	public HashSet<Regiao> getRegioesComAlojamentoDisponivel(int numMigrantes){
		HashSet<Regiao> regioes = new HashSet<Regiao>();
		for(Ajuda a : this.ajudas) {
			if(a instanceof Alojamento && ((Alojamento) a).getNumeroPessoas() >= numMigrantes) {
				Alojamento al = (Alojamento)a;
				regioes.add(al.getRegiao());
			}
		}
		
		return regioes;
	}
	
	public List<Item> getItens(){
		List<Item> itens = new ArrayList<Item>();
		for(Ajuda a : this.ajudas) {
			if(a instanceof Item) {
				Item i = (Item)a;
				itens.add(i);
			}
		}
		return itens;
	}
    
	public List<Alojamento> getAlojamentosEmRegiao(Regiao regiao){
		List<Alojamento> alojamentos = new ArrayList<Alojamento>();
		for(Ajuda a : this.ajudas) {
			if(a instanceof Alojamento && ((Alojamento) a).getRegiao().equals(regiao)) {
				Alojamento al = (Alojamento)a;
				alojamentos.add(al);
			}
		}
		return alojamentos;
	}
}
