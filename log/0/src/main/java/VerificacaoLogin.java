import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class VerificacaoLogin {


    // Inicialização do logger
    private static final Logger logger = LoggerFactory.getLogger(VerificacaoLogin.class);


    public static void main(String[] args) {
        // Simulação de entradas do usuário
        String usuarioCorreto = "admin";
        String senhaCorreta = "12345";


        // Tentativas de login
        realizarLogin("admin", "12345", usuarioCorreto, senhaCorreta); // Login correto
        realizarLogin("admin", "senhaErrada", usuarioCorreto, senhaCorreta); // Senha incorreta
        realizarLogin("usuarioDesconhecido", "12345", usuarioCorreto, senhaCorreta); // Usuário desconhecido
    }


    public static void realizarLogin(String usuario, String senha, String usuarioCorreto, String senhaCorreta) {
        
    	logger.info("VerificacaoLogin -- Tentativa de login com o usuário: {}", usuario);
    	if(usuario.equals(usuarioCorreto) && senha.equals(senhaCorreta)) {
    		logger.info("VerificacaoLogin -- Login bem-sucedido para o usuário: {}", usuario);
    		return;
    	}
    	
    	if(!senha.equals(senhaCorreta)) {
    		logger.error("VerificacaoLogin -- Senha incorreta para o usuário: {}", usuario);
    		return;
    	}
    	
    	logger.warn("VerificacaoLogin -- Usuário usuarioDesconhecido não encontrado!");
    	
    }
}