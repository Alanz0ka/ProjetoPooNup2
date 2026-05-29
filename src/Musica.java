public class Musica extends Midia implements Reprodutivel {

    private String genero;
    private String album;

    public Musica(String titulo, String autor, int duracaoSegundos, int anoLancamento, String genero, String album) {
        super(titulo, autor, duracaoSegundos, anoLancamento);
        this.genero = genero;
        this.album = album;
    }

    public Musica(String titulo, String autor, int duracaoSegundos, String genero) {
        super(titulo, autor, duracaoSegundos);
        this.genero = genero;
        this.album = "Single";
    }

    @Override
    public void exibirFicha() {
        System.out.println("=== MUSICA ===");
        System.out.println("Titulo: " + getTitulo());
        System.out.println("Artista: " + getAutor());
        System.out.println("Album: " + album);
        System.out.println("Genero: " + genero);
        System.out.println("Duracao: " + formatarDuracao());
        System.out.println("Ano: " + getAnoLancamento());
    }

    @Override
    public void reproduzir() {
        System.out.println(">> Tocando musica: " + getTitulo() + " - " + getAutor());
    }

    @Override
    public void pausar() {
        System.out.println("|| Musica pausada: " + getTitulo());
    }

    @Override
    public void parar() {
        System.out.println("[] Musica parada: " + getTitulo());
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }
}
