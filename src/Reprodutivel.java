public interface Reprodutivel {

    void reproduzir();

    void pausar();

    void parar();

    default void exibirStatus() {
        System.out.println("Status: midia pronta para reproducao.");
    }
}
