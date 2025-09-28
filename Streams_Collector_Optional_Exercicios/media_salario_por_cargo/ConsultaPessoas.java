import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ConsultaPessoas {

        public static TreeMap<String, TreeSet<Pessoa>> obterPessoasAgrupadasPorCargoEmOrdemReversa(List<Pessoa> lista) {
                return lista.stream()
                                .collect(Collectors.groupingBy(Pessoa::getCargo,
                                                () -> new TreeMap<>(Comparator.reverseOrder()),
                                                Collectors.toCollection(() -> new TreeSet<>(
                                                                Comparator.comparing(Pessoa::getNome)))));
        }

        public static Map<String, Long> obterContagemPessoasPorCargo(List<Pessoa> lista) {
                return lista.stream()
                                .collect(Collectors.groupingBy(Pessoa::getCargo,
                                                Collectors.counting()));
        }

        public static Map<String, Map<Integer, Long>> obterContagemPessoasPorCargoEIdade(List<Pessoa> lista) {
                return lista.stream()
                                .collect(Collectors.groupingBy(Pessoa::getCargo,
                                                Collectors.groupingBy(Pessoa::getIdade, Collectors.counting())));
        }

        public static Map<String, Double> obterMediaSalarioPorCargo(List<Pessoa> lista) {
                return lista.stream().collect(Collectors.groupingBy(Pessoa::getCargo,
                                Collectors.averagingDouble(Pessoa::getSalario)));
        }

}