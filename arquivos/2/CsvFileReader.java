import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CsvFileReader {
    
    public static void main(String[] args) {
        
        // ler arquivo
        try {
            BufferedReader reader = new BufferedReader(new FileReader("funcionarios.csv"));
            String linha = reader.readLine();
            while(linha != null) {
                String[] itensLinha = linha.split(",");
                String nome = itensLinha[0];
                String idade = itensLinha[1];
                String depto =  itensLinha[2];
                String salarial = itensLinha[3];
                System.out.printf("Funcionário: %s\n", nome);
                System.out.printf("Idade: %s\n", idade);
                System.out.printf("Departamento: %s\n", depto);
                System.out.printf("Salarial: %s\n", salarial);
                System.out.printf("------------------------\n");
                linha = reader.readLine();
            }
            System.out.printf("Leitura do arquivo concluída.\n");
            reader.close();
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo funcionarios.csv");
        }
        

    }

}
