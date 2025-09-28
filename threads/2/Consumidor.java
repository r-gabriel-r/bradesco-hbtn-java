import java.util.List;

public class Consumidor extends Thread {
    private Fila fila;

    public Consumidor(Fila fila) {
        this.fila = fila;
    }


    @Override
    public void run() {
        try {
            for (int i = 1; i <= this.fila.getTamanho(); i++) {
                this.fila.retirar();  // O consumidor retira o item da fila
                Thread.sleep(500);  // Simula o tempo para consumir um item
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}