public class Album {

    private String titulo;
    private int anoLancamento;
    private Artista artista;
    private Midia[] faixas;
    private int totalFaixas;

    public Album(String titulo, int anoLancamento, Artista artista, int capacidade) {
        this.titulo = titulo;
        this.anoLancamento = anoLancamento;
        this.artista = artista;
        this.faixas = new Midia[capacidade];
        this.totalFaixas = 0;
    }

    public Album(String titulo, int anoLancamento, Artista artista) {
        this(titulo, anoLancamento, artista, 12);
    }

    public void adicionarFaixa(Midia faixa) {
        if (totalFaixas < faixas.length) {
            faixas[totalFaixas] = faixa;
            totalFaixas++;
        } else {
            System.out.println("Album cheio! Nao foi possivel adicionar " + faixa.getTitulo());
        }
    }

    public void adicionarFaixa(Midia[] novas) {
        for (Midia m : novas) {
            adicionarFaixa(m);
        }
    }

    public void exibirAlbum() {
        System.out.println("\n========= ALBUM =========");
        System.out.println("Titulo: " + titulo + " (" + anoLancamento + ")");
        if (artista != null) {
            artista.exibirInfo();
        }
        System.out.println("Faixas (" + totalFaixas + "):");
        for (int i = 0; i < totalFaixas; i++) {
            System.out.println("  " + (i + 1) + ". " + faixas[i].getTitulo() + " [" + faixas[i].formatarDuracao() + "]");
        }
    }

    public int getDuracaoTotal() {
        int total = 0;
        for (int i = 0; i < totalFaixas; i++) {
            total += faixas[i].getDuracaoSegundos();
        }
        return total;
    }

    public Midia[] getFaixasValidas() {
        Midia[] copia = new Midia[totalFaixas];
        for (int i = 0; i < totalFaixas; i++) {
            copia[i] = faixas[i];
        }
        return copia;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public int getTotalFaixas() {
        return totalFaixas;
    }
}
