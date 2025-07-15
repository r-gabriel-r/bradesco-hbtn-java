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

    private double calcularTotal() {
        double total = 0;
        for (ItemPedido itemPedido : itens) {
            total += itemPedido.getProduto().obterPrecoLiquido() * itemPedido.getQuantidade(); 
        }
        return total;
    }

    private double calcularDesconto() {
        return this.calcularTotal() * (percentualDesconto/100);
    }

    public void apresentarResumoPedido() {

        System.out.printf("------- RESUMO PEDIDO -------\n");
        for (ItemPedido itemPedido : itens) {
            System.out.printf("Tipo: %s  Titulo: %s  Preco: %.2f  Quant: %d  Total: %.2f\n", 
            itemPedido.getProduto().getClass().getSimpleName(),
            itemPedido.getProduto().getTitulo(),
            itemPedido.getProduto().obterPrecoLiquido(),
            itemPedido.getQuantidade(),
            this.precoTotalItem(itemPedido));
        }
        System.out.printf("----------------------------\n");
        System.out.printf("DESCONTO: %.2f\n", this.calcularDesconto());
        System.out.printf("TOTAL PRODUTOS: %.2f\n", this.calcularTotal());
        System.out.printf("----------------------------\n");
        System.out.printf("TOTAL PEDIDO: %.2f\n", (this.calcularTotal() - this.calcularDesconto()));
        System.out.print("----------------------------\n");

    }

    private double precoTotalItem(ItemPedido itemPedido) {
        return itemPedido.getProduto().obterPrecoLiquido() * itemPedido.getQuantidade();
    }


}