public class Email implements CanalNotificacao {

    @Override
    public void notificarMensagem(Mensagem mensagem) {
        System.out.printf("[EMAIL] {%s} - %s\n", mensagem.getTipoMensagem(), mensagem.getTexto());
    }

}
