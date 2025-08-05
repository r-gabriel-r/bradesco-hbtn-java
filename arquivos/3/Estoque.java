import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Estoque {

    private String file;

    public Estoque(String file) {
        this.file = file;
    }

    public void adicionarProduto(String nome, int quantidade, double preco) {
        try {
            var filereader = new FileReader(file);
            var filewriter = new FileWriter(file, true);
            var reader = new BufferedReader(filereader);
            // percorrer arquivo e criar lista temporária
            String ultimo = "";
            String linha = reader.readLine();
            while(linha != null) {
                ultimo = linha;
                linha = reader.readLine();
            }
            // obtemos o último registro e então podemos calcular o id do próximo produto
            int proximoId = Integer.parseInt(ultimo.split(",")[0]) + 1;
            // criar novo produto
            Produto produto = new Produto(proximoId, nome, quantidade, preco);

            // gravar no final do arquivo o novo produto
            BufferedWriter writer = new BufferedWriter(filewriter);
            writer.write("\n");
            writer.write(produto.toCsv());
            
            reader.close();
            writer.close();
        } catch (IOException e) {
            System.err.printf("Erro ao adicionar produto %s", e.getMessage());
        }
    }

    public void excluirProduto(int id) {
        try {
            var filereader = new FileReader(file);
            var reader = new BufferedReader(filereader);
            // guardar registros no array temporário
            List<String> tempList = new ArrayList<>();
            String linha = reader.readLine();
            while(linha != null) {
                // não adiciona o produto que será excluído
                String[] itensLinha = linha.split(",");
                if(!itensLinha[0].equals(String.valueOf(id))){
                    tempList.add(linha);
                }
                linha = reader.readLine();
            }
            // limpar arquivo
            var filewriter = new FileWriter(file, false);
            BufferedWriter writer = new BufferedWriter(filewriter);
            // gravar no arquivo os produtos com exceção do produto excluído
            for (String linhaProduto : tempList) {
                writer.write("\n");
                writer.write(linhaProduto);
            }
            reader.close();
            writer.close();
        } catch (IOException e) {
            System.err.printf("Erro ao excluir produto %s", e.getMessage());
        }
    }

    public void exibirEstoque() {
        // ler arquivo e exibir cada produto
        try {
            var filereader = new FileReader(file);
            var reader = new BufferedReader(filereader);
            String linha = reader.readLine();
            while(linha != null) {
                String[] partesLinha = linha.split(",");
                Produto produto = new Produto(Integer.parseInt(partesLinha[0]), partesLinha[1], Integer.parseInt(partesLinha[2]), Double.parseDouble(partesLinha[3]));
                System.out.printf("%s\n", produto.toString()); 
                linha = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            System.err.printf("Erro ao exibir estoque %s", e.getMessage());
        }
    }

    public void atualizarQuantidade(int id, int novaQtde) {
        // ler arquivo
        try {
            var filereader = new FileReader(file);
            var reader = new BufferedReader(filereader);
            List<String> tempList = new ArrayList<>();
            String linha = reader.readLine();
            Produto produto;
            while(linha != null) {
                // guardar registros no array temporário atualizando o produto
                String[] partesLinha = linha.split(",");
                if(id == Integer.valueOf(partesLinha[0])){
                    produto = new Produto(Integer.parseInt(partesLinha[0]), partesLinha[1], novaQtde, Double.parseDouble(partesLinha[3]));
                }else {
                    produto = new Produto(Integer.parseInt(partesLinha[0]), partesLinha[1], Integer.parseInt(partesLinha[2]), Double.parseDouble(partesLinha[3]));
                }
                tempList.add(produto.toCsv());
                linha = reader.readLine();
            }
            reader.close();
            // atualizar o arquivo com os produtos do array temporário
            var filewriter = new FileWriter(file, false);
            BufferedWriter writer = new BufferedWriter(filewriter);
            for (String linhaProduto : tempList) {
                writer.write("\n");
                writer.write(linhaProduto);
            }
            writer.close();
            
        } catch (Exception e) {
            System.err.printf("Erro ao atualizar quantidade %s", e.getMessage());
        }
    }
}
