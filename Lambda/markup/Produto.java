import java.util.function.Consumer;
import java.util.function.Supplier;

public class Produto {

    private String nome;

    private Double preco;

    private Double percentualMarkup ;

    public Supplier<Double> precoComMarkup = () -> this.preco * (1 + this.percentualMarkup / 100 );

    public Consumer<Double> atualizarMarkup = (novoPercentual) -> this.percentualMarkup = novoPercentual;

    public Produto(Double preco, String nome) {
        this.nome = nome;
        this.preco = preco;
        this.percentualMarkup = 10d;
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }

    public Double getPercentualMarkup() {
        return percentualMarkup;
    }
       
}
