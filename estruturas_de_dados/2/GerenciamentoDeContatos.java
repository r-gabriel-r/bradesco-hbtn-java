import java.util.HashMap;
import java.util.Map;

public class GerenciamentoDeContatos {
    private Map<String, Contato> contatos;


    // Construtor
    public GerenciamentoDeContatos() {
        contatos = new HashMap<>();
    }

    // Adiciona um novo contato
    public void adicionarContato(String nome, String telefone, String email) {
        if(this.contatos.containsKey(nome)){
            System.out.printf("Erro: Contato com nome %s já existe!\n", nome);
            return;
        }
        Contato novoContato = new Contato();
        novoContato.adicionarEmail(email);
        novoContato.adicionarTelefone(telefone);
        this.contatos.put(nome, novoContato);
        System.out.printf("Contato %s adicionado com sucesso!\n", nome);
    }


    // Exibe todos os contatos
    public void exibirContatos() {
        for (Map.Entry<String, Contato> contato : this.contatos.entrySet()) {
            System.out.printf("Nome: %s\n", contato.getKey());
            System.out.printf("Telefones: %s\n", contato.getValue().getTelefones());
            System.out.printf("Emails: %s\n", contato.getValue().getEmails());
            System.out.println("-------------------------------");
        }

    }

        


    // Busca um contato pelo nome
    public void buscarContato(String nome) {
        if(this.contatos.containsKey(nome)) {
            System.out.printf("Contato encontrado: %s\n", nome);
            Contato contato = this.contatos.get(nome);
            System.out.printf("Telefones: %s\n", contato.getTelefones());
            System.out.printf("Emails: %s\n", contato.getEmails());
        }
    }


    // Remove um contato pelo nome
    public void removerContato(String nome) {
        if(this.contatos.containsKey(nome)) {
            this.contatos.remove(nome);
            System.out.printf("Contato %s removido com sucesso!\n", nome);
        }else {
            System.out.printf("Contato %s não encontrado.", nome);
        }
    }


    public static void main(String[] args) {
        GerenciamentoDeContatos gestao = new GerenciamentoDeContatos();


        // Adicionando contatos
        gestao.adicionarContato("Carlos", "1234-5678", "carlos@email.com");
        gestao.adicionarContato("Maria", "8765-4321", "maria@email.com");
        gestao.adicionarContato("Ana", "1122-3344", "ana@email.com");
        gestao.adicionarContato("Carlos", "1234-5678", "carlos@email.com"); // Tentando duplicar


        // Exibindo todos os contatos
        System.out.println("\nExibindo todos os contatos:");
        gestao.exibirContatos();


        // Buscando um contato
        System.out.println("\nBuscando contato 'Maria':");
        gestao.buscarContato("Maria");


        // Removendo um contato
        System.out.println("\nRemovendo contato 'Carlos':");
        gestao.removerContato("Carlos");


        // Tentando remover um contato inexistente
        System.out.println("\nTentando remover contato 'João' que não existe:");
        gestao.removerContato("João");


        // Exibindo todos os contatos após remoções
        System.out.println("\nExibindo todos os contatos após remoções:");
        gestao.exibirContatos();
    }
}