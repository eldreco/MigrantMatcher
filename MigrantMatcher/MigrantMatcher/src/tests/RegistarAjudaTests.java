package tests;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import catalogos.CatalogoAjudas;
import catalogos.CatalogoUtilizadores;
import dominio.Alojamento;
import dominio.Item;
import dominio.Regiao;
import dominio.Voluntario;
import handlers.RegistarAjudaHandler;
import configuration.Configuration;

public class RegistarAjudaTests {
	
	private static final Configuration config = Configuration.getInstance();

	@Test
	public void identificaVoluntarioTest() throws Exception{
        CatalogoUtilizadores catU = new CatalogoUtilizadores();
        CatalogoAjudas catA = new CatalogoAjudas();
        Voluntario v = new Voluntario(0, "André", 967026542);

        assertThrows(Exception.class, () ->{
        new RegistarAjudaHandler(catU, catA, v);
        });
        
        catU.adicionaUtilizador(v);
        assertDoesNotThrow(() -> new RegistarAjudaHandler(catU, catA, v));
       
	}
	
	@Test 
	public void indicarAlojamentoTest() throws Exception {
        CatalogoUtilizadores catU = new CatalogoUtilizadores();
        Voluntario v = new Voluntario(0, "André", 967026542);
        catU.adicionaUtilizador(v);
        Alojamento alojamentoEsperado = new Alojamento(config.getString("AlojamentoEsperadoNome", "Alojamento"),0, config.getInt("AlojamentoEsperadoPessoas", 2), Regiao.valueOf(config.getString("AlojamentoEsperadoRegiao", "LISBOA")), v);
        Alojamento alojamentoAtual = new Alojamento(config.getString("AlojamentoAtualNome", "Alojamento"),0, config.getInt("AlojamentoAtualPessoas", 2), Regiao.valueOf(config.getString("AlojamentoAtualRegiao", "LISBOA")), v);
        assertEquals(true, alojamentoEsperado.equals(alojamentoAtual));
	}
	
	@Test 
	public void indicarItemTest() throws Exception {
        CatalogoUtilizadores catU = new CatalogoUtilizadores();
        Voluntario v = new Voluntario(0, "André", 967026542);
        catU.adicionaUtilizador(v);
        Item itemEsperado = new Item(config.getString("ItemEsperadoNome", ""),0, config.getString("ItemEsperadoDescricao", ""), v);
        Item itemAtual = new Item(config.getString("ItemAtualNome", ""),0, config.getString("ItemAtualDescricao", ""), v);
        assertEquals(true, itemEsperado.equals(itemAtual));
	}

}
