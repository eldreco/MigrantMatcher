import java.util.Scanner;

import catalogos.CatalogoAjudas;
import catalogos.CatalogoUtilizadores;
import configuration.Configuration;

import dominio.Alojamento;
import dominio.Item;
import dominio.Regiao;
import dominio.Voluntario;
import handlers.ProcurarAjudaHandler;
import handlers.RegistarAjudaHandler;


/**
 * MigrantMatcher
 */
public class MigrantMatcher {

	private static final Configuration config = Configuration.getInstance();
	private static Scanner sc = new Scanner(System.in);
	
    private static CatalogoUtilizadores catU = new CatalogoUtilizadores();
    private static CatalogoAjudas catA = new CatalogoAjudas();
    public static void main(String[] args) throws Exception {
         Voluntario v = new Voluntario(0, "André", 967026542);
         Voluntario v2 = new Voluntario(1, "José", 964626540);


         catU.adicionaUtilizador(v);
         catU.adicionaUtilizador(v2);
         catA.adicionaAjuda(new Alojamento("Casa", 0, 3, Regiao.LEIRIA, v));
         catA.adicionaAjuda(new Alojamento("Casa", 0, 3, Regiao.LISBOA, v));
         catA.adicionaAjuda(new Alojamento("Casa", 0, 1, Regiao.AVEIRO, v));
         catA.adicionaAjuda(new Alojamento("Casa", 0, 2, Regiao.LISBOA, v2));
         catA.adicionaAjuda(new Item("calcas", 0, "ganga, homem", v));
         catA.adicionaAjuda(new Item("camisola", 0, "homem", v));
         catA.adicionaAjuda(new Item("calcas", 0, "ganga, crianca", v));
         catA.adicionaAjuda(new Item("t-shirt", 0, "mulher", v));
         catA.adicionaAjuda(new Item("brinquedo", 0, "bola de futebol", v));

         String metodoExec = config.getString("metodoExecucao", "terminal");
         if(metodoExec.equals("terminal")) 
        	 executar();
         else if(metodoExec.equals("tests")) {
        	 System.out.println("Pode executar os testes JUnit, no package tests, no Eclipse");
         }
        	 
         

    }
    
    private static void executar() throws Exception {
   	 System.out.print("Olá, pretende registar ajuda ou procurar ajuda?(Registar ou Procurar): ");
   	 String input = sc.nextLine();
   	 if(input.equals("Registar")) {
         Voluntario v = new Voluntario(0, "André", 967026542);
   		 RegistarAjudaHandler rgH = new RegistarAjudaHandler(catU, catA, v);
   		 rgH.registarAjuda();
   	 }else if(input.equals("Procurar")) {
   		 ProcurarAjudaHandler pAH = new ProcurarAjudaHandler(catU, catA);
   		 pAH.procurarAjuda();
   	 }
   		 
    }
    
}