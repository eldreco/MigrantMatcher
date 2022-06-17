package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.Test;

import catalogos.CatalogoAjudas;

import dominio.Alojamento;
import dominio.Item;
import dominio.Migrante;
import dominio.Regiao;
import configuration.Configuration;

public class ProcurarAjudaTests {
	
	private static final Configuration config = Configuration.getInstance();
	
	@Test
	public void registoTest() {
		if(config.getInt("NumeroFamiliares", 0) == 0) {
			Migrante esperado = new Migrante(0, "Andre", 967820192);
			Migrante atual = new Migrante(config.getInt("NumeroFamiliares", 0), config.getString("NomeMigrante", ""), config.getInt("ContactoMigrante", 0));
			assertEquals(true, esperado.equals(atual));
		} else if(config.getInt("NumeroFamiliares", 0) > 0) {
			List<String> familiares = new ArrayList<String>();
			familiares.add("Irmao");
			familiares.add("Mulher");
			Migrante esperado = new Migrante(0, "Andre", 967820192, familiares);
			Migrante atual = new Migrante(config.getInt("NumeroFamiliares", 0), config.getString("NomeMigrante", ""), config.getInt("ContactoMigrante", 0), familiares);
			assertEquals(true, esperado.equals(atual));
		}
	}
	
	@Test
	public void escolherRegiaoTest() {
		CatalogoAjudas catA = new CatalogoAjudas();
        catA.adicionaAjuda(new Alojamento("Casa", 0, 3, Regiao.LEIRIA, null));
        catA.adicionaAjuda(new Alojamento("Casa", 0, 3, Regiao.LISBOA, null));
        catA.adicionaAjuda(new Alojamento("Casa", 0, 1, Regiao.AVEIRO, null));
        catA.adicionaAjuda(new Alojamento("Casa", 0, 2, Regiao.LISBOA, null));
        catA.adicionaAjuda(new Item("calcas", 0, "ganga, homem", null));
        catA.adicionaAjuda(new Item("camisola", 0, "homem", null));
        catA.adicionaAjuda(new Item("calcas", 0, "ganga, crianca", null));
        catA.adicionaAjuda(new Item("t-shirt", 0, "mulher", null));
        catA.adicionaAjuda(new Item("brinquedo", 0, "bola de futebol", null));
		HashSet<Regiao> regioes = null;
		if(config.getInt("NumeroFamiliares", 0) == 0) {
			regioes = catA.getRegioesComAlojamentoDisponivel(1);
			assertEquals(3, regioes.size());
		}else if(config.getInt("NumeroFamiliares", 0) == 1){
			regioes = catA.getRegioesComAlojamentoDisponivel(config.getInt("NumeroFamiliares", 0) + 1);
			assertEquals(2, regioes.size());
		}else if(config.getInt("NumeroFamiliares", 0) == 2){
			regioes = catA.getRegioesComAlojamentoDisponivel(config.getInt("NumeroFamiliares", 0) + 1);
			assertEquals(2, regioes.size());
		}else if(config.getInt("NumeroFamiliares", 0) == 3){
			regioes = catA.getRegioesComAlojamentoDisponivel(config.getInt("NumeroFamiliares", 0) + 1);
			assertEquals(0, regioes.size());
		}
		
	}
	
	@Test 
	public void indicarAjudasTest() {
		CatalogoAjudas catA = new CatalogoAjudas();
        catA.adicionaAjuda(new Alojamento("Casa", 0, 3, Regiao.LEIRIA, null));
        catA.adicionaAjuda(new Alojamento("Casa", 0, 3, Regiao.LISBOA, null));
        catA.adicionaAjuda(new Alojamento("Casa", 0, 1, Regiao.AVEIRO, null));
        catA.adicionaAjuda(new Alojamento("Casa", 0, 2, Regiao.LISBOA, null));
        catA.adicionaAjuda(new Item("calcas", 0, "ganga, homem", null));
        catA.adicionaAjuda(new Item("camisola", 0, "homem", null));
        catA.adicionaAjuda(new Item("calcas", 0, "ganga, crianca", null));
        catA.adicionaAjuda(new Item("t-shirt", 0, "mulher", null));
        catA.adicionaAjuda(new Item("brinquedo", 0, "bola de futebol", null));
		
		Regiao regiao = Regiao.valueOf(config.getString("RegiaoAjuda", ""));
		List<Alojamento> alojamentos = catA.getAlojamentosEmRegiao(regiao);
		switch(regiao) {
		case LISBOA:
			assertEquals(2, alojamentos.size());
			break;
		case LEIRIA:
			assertEquals(1, alojamentos.size());
			break;
		case AVEIRO:
			assertEquals(1, alojamentos.size());
			break;
		default:
			assertEquals(0, alojamentos.size());
		}
		
		assertEquals(5, catA.getItens());
	}

}

