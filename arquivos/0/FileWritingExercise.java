 import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


 public class FileWritingExercise {
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita o nome do arquivo
        System.out.print("Digite o nome do arquivo (com extensão .txt): ");
        String fileName = scanner.nextLine();

        // implemente o codigo aqui
        // criar arquivo
        File file = new File(fileName);
        try {
            file.createNewFile();
            FileWriter writer = new FileWriter(file);
            // pedir texto do usuário
            System.out.print("Digite o texto: ");
            String texto = scanner.nextLine();
            while(!texto.equals("sair")) {
                if(texto.equals("sair"))
                    break;
                writer.append(texto + "\n");
                System.out.print("Digite o texto: ");
                texto = scanner.nextLine();
            }
            scanner.close();
            writer.close();
            System.out.println("Arquivo criado com sucesso");
        } catch (IOException e) {
            System.err.printf("Erro ao criar o arquivo: %s %s", fileName, e.getMessage());
        }
     }
 }