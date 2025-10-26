import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Random;

enum Estado {
	SUCESSO, FALHA, PENDENTE
}

public class ProcessamentoDePagamentos {

	// Logger SLF4j
	private static final Logger logger = LoggerFactory.getLogger(ProcessamentoDePagamentos.class);

	private static final int NUMERO_PAGAMENTOS = 5;

	public static void main(String[] args) {

		// tempo
		for (int i = 1; i <= NUMERO_PAGAMENTOS; i++) {
			logger.info("ProcessamentoDePagamentos -- Iniciando o processamento do pagamento {}", i);
			// obter resultado da tentativa pagamento
			Estado resultado = pagar();
			switch (resultado.name()) {
				case "SUCESSO": {
					logger.info("ProcessamentoDePagamentos -- Pagamento {} processado com sucesso.", i);
					continue;
				}
				case "FALHA": {
					logger.error("ProcessamentoDePagamentos -- Erro ao processar o pagamento {}: Falha na transação.", i);
					continue;
				}
				default: {
					logger.warn("ProcessamentoDePagamentos -- Pagamento {} está pendente. Aguardando confirmação.", i);
				}
			}

		}
		logger.info("ProcessamentoDePagamentos -- Processamento de pagamentos concluído.");

	}

	private static Estado pagar() {
		Estado[] estados = Estado.class.getEnumConstants();
		Random random = new Random();
		int randomEstadoIndex = random.nextInt(estados.length);
		return estados[randomEstadoIndex];
	}

}
