package handlers;

import java.util.EnumSet;
import java.util.Scanner;

import catalogos.CatalogoAjudas;
import catalogos.CatalogoUtilizadores;
import dominio.Ajuda;
import dominio.Alojamento;
import dominio.Regiao;
import dominio.Utilizador;
import dominio.Voluntario;

/**
 * RegistarAjudaHandler
 */
public class RegistarAjudaHandler {

    private CatalogoUtilizadores catalogoUtilizadores;
    private CatalogoAjudas catalogoAjudas;
    private Voluntario voluntario;

    private Scanner sc = new Scanner(System.in);

    public RegistarAjudaHandler(CatalogoUtilizadores catUtilizadores, CatalogoAjudas catAjudas, Voluntario v) throws Exception{
        this.catalogoUtilizadores = catUtilizadores;
        this.catalogoAjudas = catAjudas;
        
        if(catalogoUtilizadores.identificar(v))
            this.voluntario = v;
        else
            throw new Exception("O voluntario " + v.getID() + " nao está no catalogo");
    }

    public void registarAjuda(){
        
    }

    public <T extends Ajuda> T indicarTipoAjuda(){
        System.out.print("Indique o tipo de ajuda que pretende oferecer. As 2 opções são Alojamento e Item: ");
        String ajuda = sc.nextLine();
        if(ajuda.equals("Alojamento")){
            System.out.print("Indique o número de pessoas que o alojamento pode acolher(ex: 2): ");
            int numeroPessoas = sc.nextInt();
            System.out.println("Esta é a lista de regiões disponíveis: ");
            for (Regiao r : EnumSet.allOf(Regiao.class)) {
                System.out.println(r + " ");
            }
            System.out.print("Indique qual é a região do alojamento, seguindo o formato usado na lista: ");
            sc.nextLine();
            String regStr = sc.nextLine();
            Regiao regiao = Regiao.valueOf(regStr);
            Alojamento a = new Alojamento("Alojamento", catalogoAjudas.getAjudas().size(), numeroPessoas, regiao);
            return (T)a;
        } else{
            return null;
        }
    }

}