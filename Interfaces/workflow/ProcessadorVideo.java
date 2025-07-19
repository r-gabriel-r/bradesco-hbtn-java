import java.util.ArrayList;
import java.util.List;

public class ProcessadorVideo {

    List<CanalNotificacao> canais = new ArrayList<>();

    public void registrarCanal(CanalNotificacao canal) {
        this.canais.add(canal);
    }

    public void processar(Video video) {

        for (CanalNotificacao canalNotificacao : canais) {
            Mensagem mensagem = new Mensagem();
            mensagem.setTexto(video.getArquivo() + " - " + video.getFormato());
            mensagem.setTipoMensagem(TipoMensagem.LOG);
            canalNotificacao.notificarMensagem(mensagem);
        }

    }

}
