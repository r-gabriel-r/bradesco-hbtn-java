import java.util.ArrayList;
import java.util.List;

import atividades.Atividade;

public class Workflow {

    private List<Atividade> listaAtividades = new ArrayList<>();

    public void registrarAtividade(Atividade atividade) {
        this.listaAtividades.add(atividade);
    }

    public List<Atividade> obterListaAtividades() {
        return this.listaAtividades;
    }
    
}
