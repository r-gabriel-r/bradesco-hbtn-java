public class Post implements Comparable<Post>{

    private String autor;
    private String titulo;
    private String corpo;
    private String categoria;

    public Post(String autor, String titulo, String corpo, String categoria) {
        this.autor = autor;
        this.titulo = titulo;
        this.corpo = corpo;
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getAutor() {
        return autor;
    }

    @Override
    public int compareTo(Post other) {
        if(this.autor.charAt(0) == other.getAutor().charAt(0)){
            return 0;
        }
        if(this.autor.charAt(0) > other.getAutor().charAt(0)){
            return 1;
        } 
        return -1;
    }
}
