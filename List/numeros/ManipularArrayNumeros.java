import java.util.List;

public class ManipularArrayNumeros {
    
    public static int buscarPosicaoNumero(List<Integer> lista, Integer numero) {
        return lista.indexOf(numero);
    }

    public static void adicionarNumero(List<Integer> lista, Integer numero) {
        if(buscarPosicaoNumero(lista, numero) ==-1) {
            lista.add(numero);
        } else {
            throw new IllegalArgumentException("Numero jah contido na lista");
        }
    }

    public static void removerNumero(List<Integer> lista, Integer numero) {
        int posicao = buscarPosicaoNumero(lista, numero);
        if(posicao != -1) {
            lista.remove(posicao);
        } else{
            throw new IllegalArgumentException("Numero nao encontrado na lista");
        }
    }

    public static void substituirNumero(List<Integer> lista, Integer numeroSubstituir, Integer numeroSubstituto) {
        int posicao = buscarPosicaoNumero(lista, numeroSubstituir);
        if(posicao != -1) {
            lista.set(posicao, numeroSubstituto);
        } else {
            lista.add(numeroSubstituto);
        }
    }


}
