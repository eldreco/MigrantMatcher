package SMSproviders;

import com.pidgeonsmssender.sdk.PidgeonSMSSender;

public class PidgeonSMSAdapter implements SMSAdapter{

    private PidgeonSMSSender pidgeon = new PidgeonSMSSender();

    @Override
    public void enviar(String numero, String conteudo) {
        pidgeon.send(numero, conteudo);
    }
    
}
