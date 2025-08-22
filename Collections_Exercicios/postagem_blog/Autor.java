public class Autor implements Comparable<Autor>{

    private String nome;
    private String sobrenome;

    public Autor(String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    @Override
    public String toString() {
        return this.nome + " " + this.sobrenome;
    }

    @Override
    public boolean equals(Object obj) {
        // 1. Checar por auto-referência
        if (this == obj) {
            return true;
        }

        // 2. Checar por null e se são do mesmo tipo de classe
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        // 3. Fazer o "cast" para a classe concreta
        Autor outroAutor = (Autor) obj;
        if (this.nome.equals(outroAutor.getNome()) && this.sobrenome.equals(outroAutor.getSobrenome())) {
            return true;
        }

        return false;
    }

    @Override
    public int hashCode() {
        int resultado = this.nome.hashCode() + this.sobrenome.hashCode();
        resultado = 31 * resultado
                + (this.nome != null && this.sobrenome != null ? nome.hashCode() + sobrenome.hashCode() : 0);
        return resultado;
    }

    @Override
    public int compareTo(Autor o) {
        return this.nome.compareTo(o.nome);
    }

}
