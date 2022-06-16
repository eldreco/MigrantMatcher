package catalogos;

import java.util.ArrayList;
import java.util.List;

import dominio.Utilizador;

/**
 * CatalogoUtilizadores
 */
public class CatalogoUtilizadores {
    private List<Utilizador> utilizadores = new ArrayList<>();

	public void adicionaUtilizador(Utilizador u) {
		utilizadores.add(u);
	}

	public boolean identificar(Utilizador u) {
		return utilizadores.contains(u);
	}
    
}