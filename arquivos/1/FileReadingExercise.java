import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;


public class FileReadingExercise {
    public static void main(String[] args) {
        String fileName = "exemplo.txt"; // Nome do arquivo fixo para leitura

        // efetue a leitura do arquivo
        System.out.printf("Conteúdo do arquivo " + "'"+ fileName +"':\n\n");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String linha = reader.readLine();
            while(linha !=null) {
                System.out.println(linha);
                linha = reader.readLine();
            }
            System.out.printf("\nLeitura do arquivo concluída.");
            reader.close();
        } catch(IOException e) {
            System.err.printf("Erro ao ler o arquivo %s", fileName);
        }
        
    }
}
