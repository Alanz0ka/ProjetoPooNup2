public class Playlist {

    private String nome;
    private Midia[] midias;
    private int quantidade;

    public Playlist(String nome, int capacidade) {
        this.nome = nome;
        this.midias = new Midia[capacidade];
        this.quantidade = 0;
    }

    public Playlist(String nome) {
        this(nome, 10);
    }

    public void adicionar(Midia midia) {
        if (quantidade < midias.length) {
            midias[quantidade] = midia;
            quantidade++;
        } else {
            System.out.println("Playlist cheia! Nao foi possivel adicionar " + midia.getTitulo());
        }
    }

    public void adicionar(Midia[] novas) {
        for (Midia m : novas) {
            adicionar(m);
        }
    }

    public void tocarTodas() {
        System.out.println("\n### Reproduzindo playlist: " + nome + " ###");
        for (int i = 0; i < quantidade; i++) {
            Midia m = midias[i];
            if (m instanceof Reprodutivel) {
                ((Reprodutivel) m).reproduzir();
            }
        }
    }

    public void listar() {
        System.out.println("\n--- Playlist: " + nome + " (" + quantidade + " itens) ---");
        for (int i = 0; i < quantidade; i++) {
            System.out.println((i + 1) + ". " + midias[i].getTitulo() + " - " + midias[i].getAutor()
                    + " [" + midias[i].formatarDuracao() + "]");
        }
    }

    public void exibirFichas() {
        for (int i = 0; i < quantidade; i++) {
            midias[i].exibirFicha();
            System.out.println();
        }
    }

    public int getDuracaoTotal() {
        int total = 0;
        for (int i = 0; i < quantidade; i++) {
            total += midias[i].getDuracaoSegundos();
        }
        return total;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }
}
