package catalogos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

import configuration.Configuration;
import dominio.Ajuda;
import dominio.Alojamento;
import dominio.Item;
import dominio.Regiao;


public class CatalogoAjudas {
    private List<Ajuda> ajudas = new ArrayList<Ajuda>();
    PriorityQueue<Ajuda> pq = new 
            PriorityQueue<Ajuda>(1, new AjudaComparator());

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

class AjudaComparator implements Comparator<Ajuda>{
    private Configuration config = Configuration.getInstance();
    String ordem = config.getString("ordemDatasAjudas", "Ascendente");
	@Override
	public int compare(Ajuda a1, Ajuda a2) {
        if (a1.getData().compareTo(a2.getData()) > 0) {
        	if(ordem.equals("Ascendente"))
        		return 1;
        	else
        		return -1;
        }else if (a1.getData().compareTo(a2.getData()) < 0) {
        	if(ordem.equals("Ascendente"))
        		return -1;
        	else
        		return 1;
        }
        return 0;
	}
}
