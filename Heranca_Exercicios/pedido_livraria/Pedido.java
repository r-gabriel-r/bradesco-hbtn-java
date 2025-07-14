public class Pedido {
    
    private double percentualDesconto;
    private ItemPedido[] itens;

    public Pedido(double percentualDesconto, ItemPedido[] itens) {
        this.percentualDesconto = percentualDesconto;
        this.itens = itens;
    }

    public ItemPedido[] getItens() {
        return itens;
    }
    public void setItens(ItemPedido[] itens) {
        this.itens = itens;
    }

    public double calcularTotal() {
        double total = 0;

        for (ItemPedido itemPedido : itens) {
            total += itemPedido.getProduto().obterPrecoLiquido() * itemPedido.getQuantidade(); 
        }

        return total * (1 - percentualDesconto/100);

    }


}