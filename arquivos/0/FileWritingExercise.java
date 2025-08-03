 import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


 public class FileWritingExercise {
     public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        // Solicita o nome do arquivo
        System.out.print("Digite o nome do arquivo (com extensão .txt): ");
        String fileName = scanner.nextLine();

        // implemente o codigo aqui
        // criar arquivo
        File file = new File(fileName);
        file.createNewFile();
        FileWriter writer = new FileWriter(file);
        // pedir texto do usuário
        String texto = "";
        while(!texto.equals("sair")) {
            System.out.print("Digite o texto: ");
            texto = scanner.nextLine();
            if(!texto.equals("sair"))
                writer.append(texto + "\n");
        }
        scanner.close();
        writer.close();
        System.out.println("Arquivo criado com sucesso");
     }
 }