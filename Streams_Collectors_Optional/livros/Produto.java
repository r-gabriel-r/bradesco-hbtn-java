import java.util.Locale;

public class Produto {

    private int codigo;

    private String nome;

    private CategoriaProduto categoria;

    private double preco;

    public Produto(int codigo, String nome, CategoriaProduto categoria, double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
    }

    public CategoriaProduto getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return String.format(Locale.ITALIAN , "[%d] %s %s R$ %.2f", this.codigo, this.nome, this.categoria, this.preco);
    }
}
