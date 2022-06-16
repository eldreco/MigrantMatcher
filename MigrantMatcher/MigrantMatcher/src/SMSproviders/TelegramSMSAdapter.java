package SMSproviders;

import com.telegramsms.TelegramSMSSender;

public class TelegramSMSAdapter implements SMSAdapter{

    private TelegramSMSSender telegram = new TelegramSMSSender();

    @Override
    public void enviar(String numero, String conteudo) {
        telegram.setNumber(numero);
        telegram.setText(conteudo);
        telegram.send();
    }
}
