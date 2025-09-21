import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ConsultaPessoas {

    public static TreeMap<String, TreeSet<Pessoa>> obterPessoasAgrupadasPorCargoEmOrdemReversa(List<Pessoa> lista) {
        System.err.println("-->" + lista + "<--");
        return lista.stream()
                .collect(Collectors.groupingBy(Pessoa::getCargo,
                        () -> new TreeMap<>(Comparator.reverseOrder()),
                        Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Pessoa::getNome)))));

    }

}