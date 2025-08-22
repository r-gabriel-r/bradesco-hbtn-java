public class Post implements Comparable<Post> {

    private Autor autor;
    private String titulo;
    private String corpo;
    private Categorias categoria;

    public Post(Autor autor, String titulo, String corpo, Categorias categoria) {
        this.autor = autor;
        this.titulo = titulo;
        this.corpo = corpo;
        this.categoria = categoria;
    }

    public Categorias getCategoria() {
        return categoria;
    }

    public Autor getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    @Override
    public int compareTo(Post other) {
        return other.getTitulo().compareTo(this.titulo);
    }

    @Override
    public String toString() {
        return this.titulo;
    }
}
