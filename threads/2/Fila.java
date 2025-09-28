import java.util.LinkedList;

public class Fila {

    private LinkedList <Integer> lista;

    private int tamanho;

    public Fila(int tamanho) {
        this.lista = new LinkedList<>();
        this.tamanho = tamanho;
    }

    public int getTamanho() {
        return tamanho;
    }

    public LinkedList<Integer> getLista() {
        return lista;
    }

    public synchronized void adicionar(int item) throws InterruptedException {
        while(lista.size() == this.tamanho) {
            // aguarda consumidor consumir item
            wait();
        }

        if(lista.size() < 10) {
            lista.add(item);
            System.out.println(this.lista);
        }
        notifyAll();
    }

    public synchronized int retirar() throws InterruptedException {
        while(lista.size() == 0) {
            // aguarda produtor adicionar item
            wait();
        } 
        
        int item = lista.get(0);
        lista.remove(0);
        System.out.println(this.lista);
        notifyAll();
        return item;
    }

}
