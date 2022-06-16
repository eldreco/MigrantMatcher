package catalogos;

import java.util.ArrayList;
import java.util.List;

import dominio.SMS;

public class CatalogoSMS {
    private List<SMS> SMSs = new ArrayList<>();

	public void adicionaFuncionario(SMS sms) {
		SMSs.add(sms);
	}

	public boolean contains(SMS sms) {
		return SMSs.contains(sms);
	}
    
}
