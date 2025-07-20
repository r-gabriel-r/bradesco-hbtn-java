import java.util.List;

import atividade.Atividade;

public class MaquinaWorkflow {

    void executar(Workflow workflow){
        List<Atividade> atividades = workflow.obterListaAtividades();
        for (Atividade atividade : atividades) {
            atividade.executar();
        }
    }
}