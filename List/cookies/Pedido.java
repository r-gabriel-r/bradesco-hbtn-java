import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Pedido {

    private ArrayList<PedidoCookie> cookies;

    public Pedido() {
        this.cookies = new ArrayList<>();
    }
    
    public void adicionarPedidoCookie(PedidoCookie pedidoCookie) {
        this.cookies.add(pedidoCookie);
    }

    public int obterTotalCaixas() {
        int total = 0;
        for (PedidoCookie pedidoCookie : cookies) {
            total += pedidoCookie.getQuantidadeCaixas();
        }
        return total;
    }

    public int removerSabor(String sabor) {
        int itensRemovidos = 0;
        Iterator<PedidoCookie> iteratorCookies = cookies.iterator();
        while(iteratorCookies.hasNext()) {
            PedidoCookie pedido = iteratorCookies.next();
            if(pedido.getSabor().equals(sabor)) {
                itensRemovidos+= pedido.getQuantidadeCaixas();
                iteratorCookies.remove();
            }
        }
        return itensRemovidos;
    }
}
