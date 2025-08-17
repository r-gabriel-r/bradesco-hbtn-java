import java.util.ArrayList;
import java.util.List;

public class Biblioteca<T> {

    private List<T> lista = new ArrayList<>();

    public void adicionarMidia(T t) {
        this.lista.add(t);
    }

    public String obterListaMidias() {
        return this.lista.toString();
    }
    
}
