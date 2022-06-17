package handlers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

import SMSproviders.SMSAdapter;
import SMSproviders.TelegramSMSAdapter;
import catalogos.CatalogoAjudas;
import catalogos.CatalogoUtilizadores;
import dominio.Ajuda;
import dominio.Alojamento;
import dominio.Item;
import dominio.Migrante;
import dominio.Regiao;

public class ProcurarAjudaHandler extends Handler{
	
    private CatalogoUtilizadores catU;
    private CatalogoAjudas catA;
    private Migrante migrante;
    private SMSAdapter sms = new TelegramSMSAdapter();    

    
    public ProcurarAjudaHandler(CatalogoUtilizadores catU, CatalogoAjudas catA) {
    	this.catU = catU;
    	this.catA = catA;
    }
    
    public void procurarAjuda() {
    	registo();
    	Regiao regiao = escolherRegiao();
    	indicarAjudas(regiao);
    }

	private void registo() {
    	System.out.print("Vamos comecar o registo!\nQuantos membros da familia pretende registar?\n ->0: Registo individual\n ->1 ou mais: Regista o utilizador juntamente com o número de familiares indicado\nIndique um número: ");
    	int numFamiliares = sc.nextInt();
    	sc.nextLine();

    	if(numFamiliares == 0) {
    		System.out.print("Indique o seu nome: ");
    		String nomeUt = sc.nextLine();
    		System.out.print("Indique o seu numero de telefone: ");
    		int contacto = pedirInteiro(111111111, 999999999);
    		Migrante m = new Migrante(catU.getUtilizadores().size(), nomeUt, contacto);
    		catU.adicionaUtilizador(m);
    		this.migrante = m;
    	}else if(numFamiliares > 0) {
    		System.out.print("Indique o nome da cabeca de casal: ");
    		String nomeUt = sc.nextLine();
    		System.out.print("Indique o número de telefone da cabeca de casal: ");
    		int contacto = pedirInteiro(111111111, 999999999);
    		List<String> familiares = new ArrayList<String>();
    		while(numFamiliares > 0) {
        		System.out.print("Indique o nome do proximo elemento da familia(Se deseja parar escreva Stop): ");
        		String input = sc.nextLine();
        		if(!input.equals("Stop"))
        			familiares.add(input);
        		else
        			break;
        		numFamiliares--;
    		}
    		Migrante m = new Migrante(catU.getUtilizadores().size(), nomeUt,contacto, familiares);
    		catU.adicionaUtilizador(m);
    		this.migrante = m;
    	}
    }
	
    
    private Regiao escolherRegiao() {
		System.out.println("Esta e a lista de regioes onde se pode mover:");
		HashSet<Regiao> regioes = null;
		if(!migrante.getTemFamiliares())
			regioes = catA.getRegioesComAlojamentoDisponivel(1);
		else
			regioes = catA.getRegioesComAlojamentoDisponivel(migrante.getFamiliares().size() + 1);
		if(regioes.isEmpty()) {
			System.out.print("Nao ha regioes diponiveis. Pedimos desculpa. pretende ser notificado se a situacao mudar?(Sim ou Nao) ");
			String input = sc.nextLine();
			if(input.equals("Sim"))
				migrante.setRegiaoNotificado(true);
			return null;
		}else {
			for(Regiao r : regioes) {
				System.out.println(r);
			}
		}
		System.out.print("Indique a regiao para onde se deseja mover: ");
		Regiao reg = pedirRegiao();
		if(regioes.contains(reg)) {
			return reg;
		}else
			return escolherRegiao();
	}
    

	private void indicarAjudas(Regiao regiao) {
		System.out.println();
		System.out.println("Aqui esta a lista de alojamentos disponiveis na regiao de " + regiao + " e de itens disponiveis:");
		List<Alojamento> alojamentos = catA.getAlojamentosEmRegiao(regiao);
		for(int i = 0; i < alojamentos.size(); i++) 
			System.out.println("Alojamento numero " + (i+1) + " --- " + alojamentos.get(i));
		List<Item> itens = catA.getItens();
		for(int i = 0; i < itens.size(); i++) 
			System.out.println("Item numero " + (i+1) + " --- " + itens.get(i));
		System.out.println("Que alojamento pretende? (Indique pelo numero): ");
		HashSet<Ajuda> ajudasPedidas = new HashSet<Ajuda>();
		ajudasPedidas.add(alojamentos.get(sc.nextInt()-1)); sc.nextLine();
		int itemIndex = 1;
		while(true) {
			System.out.print("Que item pretende pedir? (Indique o item pelo numero, se nao pretende mais nenhum escreva 0): ");
			itemIndex = sc.nextInt(); sc.nextLine();
			if(itemIndex <= itens.size() && itemIndex > 0)
				ajudasPedidas.add(itens.get(itemIndex-1));
			else if(itemIndex == 0)
				break;
			else
				System.out.print("Esse item nao existe, tente outra vez");
		}
		System.out.println();
		System.out.println("Muito bem, " + migrante.getNome() + ", estas sao as ajudas que pediu:");
		for(Ajuda a : ajudasPedidas)
			System.out.println(a);
		System.out.println("Pretende confirmar?(Sim ou Nao)");
		String confirmacao = sc.nextLine();
		if(confirmacao.equals("Sim")) {
			System.out.println("Foram-lhe atribuidas essas ajudas!");
			atribuirAjudas(ajudasPedidas);
		}else
			System.out.println("Se pretende tentar outra vez, comece do principio. Obrigado");
	}
	
	private void atribuirAjudas(HashSet<Ajuda> ajudas) {
		migrante.setAjudasAtribuidas(ajudas);
		for(Ajuda a : ajudas) {
			sms.enviar(String.valueOf(a.getVoluntario().getContacto()), "Confimamos que a sua ajuda " + a + " ajudou um migrante. Muito obrigado!");
		}
	}
}
