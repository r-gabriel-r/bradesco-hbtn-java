import java.util.ArrayList;
import java.util.List;

public class GestaoAlunos {

    private List<Aluno> alunos = new ArrayList<Aluno>();

    public void adicionarAluno(Aluno aluno) {
        this.alunos.add(aluno);
    }

    public void excluirAluno(String nome) {

        for (Aluno a : alunos) {
            if (a.getNome().equals(nome)) {
                this.alunos.remove(a);
                System.out.printf("Aluno %s excluído com sucesso\n", nome);
                return;
            }
        }
        System.out.printf("Aluno %s não encontrado\n", nome);
    }

    public void buscarAluno(String nome) {
        for (Aluno a : alunos) {
            if (a.getNome().equals(nome)) {
                System.out.println(a.toString());
                return; 
            }
        }
        System.out.printf("Aluno %s não encontrado\n", nome);
    }

    public void listarAlunos() {
        for (Aluno aluno : alunos) {
            System.out.println(aluno.toString());
        }
    }

}
