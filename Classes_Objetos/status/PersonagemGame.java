public class PersonagemGame {
    private int saudeAtual;
    private String nome;
    private String status;

    public int getSaudeAtual() {
        return saudeAtual;
    }

    public void setSaudeAtual(int saudeAtual) {
        this.saudeAtual = saudeAtual;
        if(this.saudeAtual > 0)
            this.status = "vivo";
        else
            this.status = "morto";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getStatus() {
        return status;
    }

    public void tomarDano(int quantidadeDeDano) {
        if(this.saudeAtual - quantidadeDeDano < 0)
            this.setSaudeAtual(0);
        else
            this.setSaudeAtual(this.saudeAtual - quantidadeDeDano);    
    }

    public void receberCura(int quantidadeDeCura) {
        if(this.saudeAtual + quantidadeDeCura > 100)
            this.setSaudeAtual(100);
        else
            this.setSaudeAtual(this.saudeAtual + quantidadeDeCura);
    }
}