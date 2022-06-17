package handlers;

import java.util.EnumSet;
import java.util.Scanner;

import SMSproviders.PidgeonSMSAdapter;
import SMSproviders.SMSAdapter;
import catalogos.CatalogoAjudas;
import catalogos.CatalogoUtilizadores;
import dominio.Ajuda;
import dominio.Alojamento;
import dominio.Item;
import dominio.Regiao;
import dominio.Utilizador;
import dominio.Voluntario;

/**
 * RegistarAjudaHandler
 */
public class RegistarAjudaHandler extends Handler{

    private CatalogoUtilizadores catalogoUtilizadores;
    private CatalogoAjudas catalogoAjudas;
    private Voluntario voluntario;
    private SMSAdapter sms = new PidgeonSMSAdapter();    

    public RegistarAjudaHandler(CatalogoUtilizadores catUtilizadores, CatalogoAjudas catAjudas, Voluntario v) throws Exception{
        this.catalogoUtilizadores = catUtilizadores;
        this.catalogoAjudas = catAjudas;
        
        if(catalogoUtilizadores.identificar(v))
            this.voluntario = v;
        else
            throw new Exception("O voluntario " + v.getID() + " nao estÃ¡ no catalogo");
    }

    public void registarAjuda(){
        System.out.println("Vamos comeÃ§ar o processo de oferecer ajuda! Muito obrigado!");
        catalogoAjudas.adicionaAjuda(indicarTipoAjuda());
        String codigo = String.valueOf(sms.gerarCodigo());
        sms.enviar(String.valueOf(voluntario.getContacto()), codigo);
        confirmarCodigo(codigo);
    }

    public <T extends Ajuda> T indicarTipoAjuda(){
        boolean whileCond = true;
        T result = null;
        while(whileCond){
            System.out.print("Indique o tipo de ajuda que pretende oferecer. As 2 opções são Alojamento e Item: ");
            String ajuda = sc.nextLine();
            if(ajuda.equals("Alojamento")){
                System.out.print("Indique o número de pessoas que o alojamento pode acolher, de 1 a 10(ex: 2): ");
                int numeroPessoas = pedirInteiro(1, 10);
                System.out.println("Esta é a lista de regiões disponíveis: ");
                for (Regiao r : EnumSet.allOf(Regiao.class)) {
                    System.out.println(r + " ");
                }
                System.out.print("Indique qual é a região do alojamento, seguindo o formato usado na lista: ");
                Regiao regiao = pedirRegiao();
                Alojamento a = new Alojamento("Alojamento", catalogoAjudas.getAjudas().size(), numeroPessoas, regiao, this.voluntario);
                result = (T)a;
                break;
            } else if(ajuda.equals("Item")){
                System.out.print("Indique o nome do item: ");
                String nome = sc.nextLine();
                System.out.print("Indique uma curta descrição do item: ");
                String desc = sc.nextLine();
                Item i = new Item(nome, catalogoAjudas.getAjudas().size(), desc, this.voluntario);
                result = (T)i;
                break;
            } 
        }
        return result;
        
    }
    
    private void confirmarCodigo(String codigo) {
    	boolean confirmacao = false;
    	while(!confirmacao) {
    		System.out.print("Introduza o código enviado por SMS para confirmar a ajuda: ");
    		String input = sc.nextLine();
    		if(codigo.equals(input)) {
    			System.out.println("Confirmado, muito obrigado por ajudar!");
    			break;
    		}else
    			System.out.println("Código errado");
    			
    	}
    	
    }
}