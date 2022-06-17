package dominio;

import java.util.HashSet;
import java.util.List;

public class Migrante extends Utilizador {
	
	private List<String> familiares;
	private boolean temFamiliares;
	private HashSet<Ajuda> ajudasAtribuidas;
	
    public Migrante(int id, String nome, int contacto) {
        super(id, nome, contacto);
        temFamiliares = false;
        //TODO Auto-generated constructor stub
    }
    
    public Migrante(int id, String nome, int contacto, List<String> familiares) {
        super(id, nome, contacto);
        this.familiares = familiares;
        temFamiliares = true;
    }
    
    public List<String> getFamiliares(){
    	return this.familiares;
    }

    public boolean getTemFamiliares() {
    	return this.temFamiliares;
    }

	public HashSet<Ajuda> getAjudasAtribuidas() {
		return ajudasAtribuidas;
	}

	public void setAjudasAtribuidas(HashSet<Ajuda> ajudasAtribuidas) {
		this.ajudasAtribuidas = ajudasAtribuidas;
	}
    
}
