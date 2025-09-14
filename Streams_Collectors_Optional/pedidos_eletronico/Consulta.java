import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Consulta {

    public static List<Produto> obterLivrosDoPedido(Pedido pedido) {
        return pedido.getProdutos().stream()
                .filter(p -> p.getCategoria() == CategoriaProduto.LIVRO).collect(Collectors.toList());
    }

    public static Produto obterProdutoMaiorPreco(List<Produto> produtos) {
        Comparator<Produto> comparadorPreco = Comparator.comparing(Produto::getPreco).reversed();
        return produtos.stream().sorted(comparadorPreco).toList().get(0);
    }

    public static List<Produto> obterProdutosPorPrecoMinimo(List<Produto> produtos, double precoMinimo) {
        return produtos.stream().filter((p) -> p.getPreco() >= precoMinimo).toList();
    }

    public static List<Pedido> obterPedidosComEletronicos(List<Pedido> pedidos) {
        return pedidos.stream()
            .filter((p) -> p.getProdutos()
                    .stream()
                        .anyMatch(
                            (prod) -> prod.getCategoria() == CategoriaProduto.ELETRONICO))
            .toList();       
    }

}
