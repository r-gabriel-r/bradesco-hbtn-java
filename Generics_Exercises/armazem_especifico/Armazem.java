import java.util.HashMap;
import java.util.Map;

public abstract class Armazem<T> implements Armazenavel<T> {

    private Map<String, T> itens = new HashMap<>();

    @Override
    public void adicionarAoInventario(String nome, T valor) {
        this.itens.put(nome, valor);
    }

    @Override
    public T obterDoInventario(String nome) {
        return this.itens.get(nome);
    }

}
