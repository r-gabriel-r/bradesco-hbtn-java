import java.util.Random;

public class Produtor extends Thread {
    private Fila fila;


    public Produtor(Fila fila) {
        this.fila = fila;
    }


    @Override
    public void run() {
        try {
            for (int i = 1; i <= this.fila.getTamanho(); i++) {
                Random random = new Random();
                this.fila.adicionar(random.nextInt(101));  // O produtor o número na lista
                Thread.sleep(100);   // Simula o tempo para produzir um item
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}