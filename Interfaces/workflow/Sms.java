public class Sms implements CanalNotificacao{

    @Override
    public void notificarMensagem(Mensagem mensagem) {
        System.out.printf("[SMS] {%s} - %s\n", mensagem.getTipoMensagem(), mensagem.getTexto());
    }
    
}
