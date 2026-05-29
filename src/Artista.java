public class Artista {

    private String nome;
    private String paisOrigem;
    private int anoEstreia;

    public Artista(String nome, String paisOrigem, int anoEstreia) {
        this.nome = nome;
        this.paisOrigem = paisOrigem;
        this.anoEstreia = anoEstreia;
    }

    public Artista(String nome, String paisOrigem) {
        this(nome, paisOrigem, 2024);
    }

    public Artista(String nome) {
        this(nome, "Brasil", 2024);
    }

    public void exibirInfo() {
        System.out.println("Artista: " + nome + " (" + paisOrigem + ", desde " + anoEstreia + ")");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome != null && !nome.isEmpty()) {
            this.nome = nome;
        }
    }

    public String getPaisOrigem() {
        return paisOrigem;
    }

    public void setPaisOrigem(String paisOrigem) {
        this.paisOrigem = paisOrigem;
    }

    public int getAnoEstreia() {
        return anoEstreia;
    }

    public void setAnoEstreia(int anoEstreia) {
        this.anoEstreia = anoEstreia;
    }
}
