public abstract class Midia {

    private String titulo;
    private String autor;
    private int duracaoSegundos;
    private int anoLancamento;

    public Midia(String titulo, String autor, int duracaoSegundos, int anoLancamento) {
        this.titulo = titulo;
        this.autor = autor;
        this.duracaoSegundos = duracaoSegundos;
        this.anoLancamento = anoLancamento;
    }

    public Midia(String titulo, String autor, int duracaoSegundos) {
        this(titulo, autor, duracaoSegundos, 2024);
    }

    public Midia(String titulo) {
        this(titulo, "Descxonhecido", 0, 2024);
    }

    public abstract void exibirFicha();

    public String formatarDuracao() {
        int minutos = duracaoSegundos / 60;
        int segundos = duracaoSegundos % 60;
        return String.format("%d min %02d s", minutos, segundos);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo != null && !titulo.isEmpty()) {
            this.titulo = titulo;
        }
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getDuracaoSegundos() {
        return duracaoSegundos;
    }

    public void setDuracaoSegundos(int duracaoSegundos) {
        if (duracaoSegundos >= 0) {
            this.duracaoSegundos = duracaoSegundos;
        }
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }
}
