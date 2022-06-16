package SMSproviders;

import java.util.HashSet;
import java.util.Random;

public interface SMSAdapter {
	public static final HashSet<Integer> codigos = new HashSet<Integer>();
	public void enviar(String numero, String conteudo);
	public default int gerarCodigo() {
		Random rd = new Random();
		int codigo = 0000;
		while(!codigos.contains(codigo)) {
			codigo = rd.nextInt(999999);
			codigos.add(codigo);
		}

		return codigo;
	}
}