import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Blog {

    private List<Post> post;

    public Blog() {
        this.post = new ArrayList<>();
    }

    public void adicionarPostagem(Post post) {

        for (Post p : this.post) {
            if (p.getAutor().equals(post.getAutor()) && p.getTitulo().equals(post.getTitulo())) {
                throw new IllegalArgumentException("Postagem jah existente");
            }
        }

        this.post.add(post);
    }

    public Set<Autor> obterTodosAutores() {
        Collections.sort(post);
        Set<Autor> autores = new TreeSet<>();
        for (Post post : post) {
            autores.add(post.getAutor());
        }
        return autores;
    }

    public Map<Categorias, Integer> obterContagemPorCategoria() {
        Map<Categorias, Integer> mapaCategorias = new HashMap<>();
        for (Post post : this.post) {
            Integer quantidade = mapaCategorias.get(post.getCategoria());
            if (quantidade != null) {
                mapaCategorias.put(post.getCategoria(), quantidade + 1);
            } else {
                mapaCategorias.put(post.getCategoria(), 1);
            }
        }
        return mapaCategorias;
    }

    public Set<Post> obterPostsPorAutor(Autor autor) {
        List<Post> listaPosts = this.post;
        Collections.sort(listaPosts);
        Set<Post> postsAutor = new TreeSet<>();
        for (Post p : listaPosts) {
            if(p.getAutor().equals(autor)) {
                postsAutor.add(p);
            }
        }
        return postsAutor;
    }

    public Set<Post> obterPostsPorCategoria(Categorias categoria) {
        List<Post> listaPosts = this.post;
        Collections.sort(listaPosts);
        Set<Post> postsCategoria = new TreeSet<>();
        for (Post p : listaPosts) {
            if(p.getCategoria().equals(categoria)) {
                postsCategoria.add(p);
            }
        }
        return postsCategoria;
    }

    public Map<Categorias, Set<Post>> obterTodosPostsPorCategorias() {
        Map<Categorias, Set<Post>> postPorCategoria = new HashMap<>();
        for (Post p : this.post) {
            if(!postPorCategoria.containsKey(p.getCategoria())) {
                postPorCategoria.put(p.getCategoria(), new TreeSet<>());
            }
            postPorCategoria.get(p.getCategoria()).add(p);
        }
        return postPorCategoria;
    }

    public Map<Autor, Set<Post>> obterTodosPostsPorAutor() {
        Map<Autor, Set<Post>> postsPorAutor = new HashMap<>();
        for (Post p : this.post) {
            if(!postsPorAutor.containsKey(p.getAutor())) {
                postsPorAutor.put(p.getAutor(), new TreeSet<>());
            }
            postsPorAutor.get(p.getAutor()).add(p);
        }
        return postsPorAutor;
    }
}
