import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConsultaPessoas {

    public static Map<String, List<Pessoa>> obterPessoasPorCargo(List<Pessoa> lista) {
        return lista.stream().collect(Collectors.groupingBy(Pessoa::getCargo));
    }
    
}
