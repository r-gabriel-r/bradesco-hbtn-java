import java.util.ArrayList;
import java.util.List;

public class ListaTodo {

    private List<Tarefa> tarefas;

    public ListaTodo() {
        this.tarefas = new ArrayList<>();
    }

    public void adicionarTarefa(Tarefa tarefa) {
        Tarefa tarefaEncontrada = this.getTarefa(tarefa.getIdentificador());
        if(tarefaEncontrada == null) {
            this.tarefas.add(tarefa);
        } else {
            String msg = String.format("Tarefa com identificador %d ja existente na lista", tarefa.getIdentificador());
            throw new IllegalArgumentException(msg);
        }
    }

    public boolean marcarTarefaFeita(int id) {
        Tarefa tarefaEncontrada = this.getTarefa(id);
        if(tarefaEncontrada != null) {
            tarefaEncontrada.setEstahFeita(true);
            return true;
        }
        return false;
    }

    public boolean desfazerTarefa(int id) {
        Tarefa tarefaEncontrada = this.getTarefa(id);
        if(tarefaEncontrada != null) {
            tarefaEncontrada.setEstahFeita(false);
            return true;
        }
        return false;
    }

    public void desfazerTodas() {
        for (Tarefa tarefa : tarefas) {
            tarefa.setEstahFeita(false);
        }
    }

    public void fazerTodas() {
        for (Tarefa tarefa : tarefas) {
            tarefa.setEstahFeita(true);
        }
    }

    public void listarTarefas() {
        for (Tarefa tarefa : tarefas) {
            System.out.printf("[%s]  Id: %d - Descricao: %s\n", tarefa.isEstahFeita() ? 'X' : ' ',
                    tarefa.getIdentificador(), tarefa.getDescricao());
        }

    }

    private Tarefa getTarefa(int id) {
        for (Tarefa t : this.tarefas) {
            if (t.getIdentificador() == id) {
                return t;
            }
        }
        return null;
    }

}
