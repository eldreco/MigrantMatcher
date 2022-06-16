import com.pidgeonsmssender.sdk.PidgeonSMSSender;

import SMSproviders.PidgeonSMSAdapter;
import SMSproviders.SMSAdapter;
import catalogos.CatalogoAjudas;
import catalogos.CatalogoUtilizadores;
import dominio.Ajuda;
import dominio.Alojamento;
import dominio.Voluntario;
import handlers.RegistarAjudaHandler;

/**
 * MigrantMatcher
 */
public class MigrantMatcher {

    public static void main(String[] args) throws Exception {
         Voluntario v = new Voluntario(0, 967026542);
         Voluntario v2 = new Voluntario(1, 967026542);

         CatalogoUtilizadores catU = new CatalogoUtilizadores();
         CatalogoAjudas catA = new CatalogoAjudas();
         catU.adicionaUtilizador(v);
         RegistarAjudaHandler rghandler = new RegistarAjudaHandler(catU, catA, v);
         rghandler.registarAjuda();

    	

    }
}