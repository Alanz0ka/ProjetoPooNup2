public class MusicaAoVivo extends Midia implements Reprodutivel {

    private String local;
    private int publicoEstimado;
    private String genero;

    public MusicaAoVivo(String titulo, String autor, int duracaoSegundos, int anoLancamento,
                        String genero, String local, int publicoEstimado) {
        super(titulo, autor, duracaoSegundos, anoLancamento);
        this.genero = genero;
        this.local = local;
        this.publicoEstimado = publicoEstimado;
    }

    public MusicaAoVivo(String titulo, String autor, int duracaoSegundos, String genero, String local) {
        super(titulo, autor, duracaoSegundos);
        this.genero = genero;
        this.local = local;
        this.publicoEstimado = 0;
    }

    @Override
    public void exibirFicha() {
        System.out.println("=== MUSICA AO VIVO ===");
        System.out.println("Titulo: " + getTitulo());
        System.out.println("Artista: " + getAutor());
        System.out.println("Genero: " + genero);
        System.out.println("Local: " + local);
        System.out.println("Publico estimado: " + publicoEstimado);
        System.out.println("Duracao: " + formatarDuracao());
        System.out.println("Ano: " + getAnoLancamento());
    }

    @Override
    public void reproduzir() {
        System.out.println(">> Tocando ao vivo: " + getTitulo() + " - " + getAutor() + " (em " + local + ")");
    }

    @Override
    public void pausar() {
        System.out.println("|| Gravacao pausada: " + getTitulo());
    }

    @Override
    public void parar() {
        System.out.println("[] Gravacao encerrada: " + getTitulo());
    }

    @Override
    public void exibirStatus() {
        System.out.println("Status ao vivo '" + getTitulo() + "': gravada em " + local
                + " para " + publicoEstimado + " pessoas.");
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getPublicoEstimado() {
        return publicoEstimado;
    }

    public void setPublicoEstimado(int publicoEstimado) {
        if (publicoEstimado >= 0) {
            this.publicoEstimado = publicoEstimado;
        }
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
