import com.pidgeonsmssender.sdk.PidgeonSMSSender;

import SMSproviders.PidgeonSMSAdapter;
import SMSproviders.SMSAdapter;
import catalogos.CatalogoAjudas;
import catalogos.CatalogoUtilizadores;
import dominio.Ajuda;
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

    public static void main(String[] args) throws Exception {
         Voluntario v = new Voluntario(0, "André", 967026542);
         Voluntario v2 = new Voluntario(1, "José", 964626540);

         CatalogoUtilizadores catU = new CatalogoUtilizadores();
         CatalogoAjudas catA = new CatalogoAjudas();
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


         
         ProcurarAjudaHandler pAHandler = new ProcurarAjudaHandler(catU, catA);
         pAHandler.procurarAjuda();
    	

    }
}