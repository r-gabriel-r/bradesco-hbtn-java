import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Blog {

    private List<Post> postagens;

    public Blog() {
        this.postagens = new ArrayList<>();
    }

    public void adicionarPostagem(Post blog) {
        this.postagens.add(blog);
    }

    public Set<String> obterTodosAutores() {
        Collections.sort(postagens);
        Set<String> autores = new TreeSet<>();
        for (Post post : postagens) {
            autores.add(post.getAutor());
        }
        return autores;
    }

    public Map<String, Integer> obterContagemPorCategoria() {
        Map<String, Integer> mapaCategorias = new TreeMap<>();
        for (Post post : this.postagens) {
            Integer quantidade = mapaCategorias.get(post.getCategoria());
            if(quantidade != null ) {
                mapaCategorias.put(post.getCategoria(), quantidade + 1);
            } else {
                mapaCategorias.put(post.getCategoria(), 1);
            }
        }
        
        return mapaCategorias;
    }
}
