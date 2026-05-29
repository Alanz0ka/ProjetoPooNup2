import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    private static final int MAX_ARTISTAS = 20;
    private static final int MAX_ALBUNS = 20;
    private static final int MAX_FAIXAS = 50;

    private static Artista[] artistas = new Artista[MAX_ARTISTAS];
    private static int totalArtistas = 0;

    private static Album[] albuns = new Album[MAX_ALBUNS];
    private static int totalAlbuns = 0;

    private static Midia[] faixas = new Midia[MAX_FAIXAS];
    private static int totalFaixas = 0;

    private static Playlist playlist;

    public static void main(String[] args) {
        System.out.println("===== SISTEMA DE MUSICA =====");
        System.out.print("Nome da sua playlist principal: ");
        String nome = sc.nextLine();
        System.out.print("Capacidade da playlist: ");
        int cap = lerInt();
        playlist = new Playlist(nome, cap);

        int opcao;
        do {
            exibirMenu();
            opcao = lerInt();
            switch (opcao) {
                case 1: cadastrarArtista(); break;
                case 2: cadastrarMusica(); break;
                case 3: cadastrarMusicaAoVivo(); break;
                case 4: criarAlbum(); break;
                case 5: adicionarNaPlaylist(); break;
                case 6: listarArtistas(); break;
                case 7: listarAlbuns(); break;
                case 8: playlist.listar(); break;
                case 9: playlist.tocarTodas(); break;
                case 10: playlist.exibirFichas(); break;
                case 11:
                    System.out.println("Duracao total da playlist: "
                            + playlist.getDuracaoTotal() + " s");
                    break;
                case 0: System.out.println("Encerrando..."); break;
                default: System.out.println("Opcao invalida.");
            }
        } while (opcao != 0);

        sc.close();
        System.out.println("===== FIM =====");
    }

    private static void exibirMenu() {
        System.out.println("\n----- MENU -----");
        System.out.println("1  - Cadastrar Artista");
        System.out.println("2  - Cadastrar Musica (estudio)");
        System.out.println("3  - Cadastrar Musica Ao Vivo");
        System.out.println("4  - Criar Album e adicionar faixas");
        System.out.println("5  - Adicionar faixa na Playlist");
        System.out.println("6  - Listar Artistas");
        System.out.println("7  - Listar Albuns");
        System.out.println("8  - Listar Playlist");
        System.out.println("9  - Reproduzir Playlist");
        System.out.println("10 - Exibir fichas da Playlist");
        System.out.println("11 - Duracao total da Playlist");
        System.out.println("0  - Sair");
        System.out.print("Escolha: ");
    }

    private static void cadastrarArtista() {
        if (totalArtistas >= MAX_ARTISTAS) {
            System.out.println("Limite de artistas atingido.");
            return;
        }
        System.out.print("Nome do artista: ");
        String nome = sc.nextLine();
        System.out.print("Pais de origem: ");
        String pais = sc.nextLine();
        System.out.print("Ano de estreia: ");
        int ano = lerInt();
        artistas[totalArtistas++] = new Artista(nome, pais, ano);
        System.out.println("Artista cadastrado!");
    }

    private static void cadastrarMusica() {
        if (totalFaixas >= MAX_FAIXAS) {
            System.out.println("Limite de faixas atingido.");
            return;
        }
        System.out.print("Titulo: ");
        String titulo = sc.nextLine();
        System.out.print("Artista (nome): ");
        String autor = sc.nextLine();
        System.out.print("Duracao (segundos): ");
        int dur = lerInt();
        System.out.print("Ano: ");
        int ano = lerInt();
        System.out.print("Genero: ");
        String genero = sc.nextLine();
        System.out.print("Album (texto): ");
        String album = sc.nextLine();

        Musica m = new Musica(titulo, autor, dur, ano, genero, album);
        faixas[totalFaixas++] = m;
        System.out.println("Musica cadastrada!");
    }

    private static void cadastrarMusicaAoVivo() {
        if (totalFaixas >= MAX_FAIXAS) {
            System.out.println("Limite de faixas atingido.");
            return;
        }
        System.out.print("Titulo: ");
        String titulo = sc.nextLine();
        System.out.print("Artista (nome): ");
        String autor = sc.nextLine();
        System.out.print("Duracao (segundos): ");
        int dur = lerInt();
        System.out.print("Ano: ");
        int ano = lerInt();
        System.out.print("Genero: ");
        String genero = sc.nextLine();
        System.out.print("Local do show: ");
        String local = sc.nextLine();
        System.out.print("Publico estimado: ");
        int pub = lerInt();

        MusicaAoVivo mv = new MusicaAoVivo(titulo, autor, dur, ano, genero, local, pub);
        faixas[totalFaixas++] = mv;
        System.out.println("Musica ao vivo cadastrada!");
    }

    private static void criarAlbum() {
        if (totalAlbuns >= MAX_ALBUNS) {
            System.out.println("Limite de albuns atingido.");
            return;
        }
        if (totalArtistas == 0) {
            System.out.println("Cadastre um artista antes.");
            return;
        }
        System.out.print("Titulo do album: ");
        String titulo = sc.nextLine();
        System.out.print("Ano: ");
        int ano = lerInt();

        listarArtistas();
        System.out.print("Indice do artista: ");
        int idxA = lerInt();
        if (idxA < 0 || idxA >= totalArtistas) {
            System.out.println("Indice invalido.");
            return;
        }

        Album novo = new Album(titulo, ano, artistas[idxA]);

        if (totalFaixas == 0) {
            System.out.println("(Nenhuma faixa cadastrada para adicionar agora.)");
        } else {
            System.out.println("Faixas disponiveis:");
            for (int i = 0; i < totalFaixas; i++) {
                System.out.println("  " + i + " - " + faixas[i].getTitulo());
            }
            System.out.print("Quantas faixas adicionar? ");
            int qtd = lerInt();
            for (int i = 0; i < qtd; i++) {
                System.out.print("Indice da faixa #" + (i + 1) + ": ");
                int idxF = lerInt();
                if (idxF >= 0 && idxF < totalFaixas) {
                    novo.adicionarFaixa(faixas[idxF]);
                } else {
                    System.out.println("Indice invalido, pulando.");
                }
            }
        }

        albuns[totalAlbuns++] = novo;
        novo.exibirAlbum();
    }

    private static void adicionarNaPlaylist() {
        if (totalFaixas == 0) {
            System.out.println("Nenhuma faixa cadastrada ainda.");
            return;
        }
        System.out.println("Faixas disponiveis:");
        for (int i = 0; i < totalFaixas; i++) {
            System.out.println("  " + i + " - " + faixas[i].getTitulo() + " (" + faixas[i].getAutor() + ")");
        }
        System.out.print("Indice da faixa para adicionar: ");
        int idx = lerInt();
        if (idx >= 0 && idx < totalFaixas) {
            playlist.adicionar(faixas[idx]);
            System.out.println("Adicionada na playlist!");
        } else {
            System.out.println("Indice invalido.");
        }
    }

    private static void listarArtistas() {
        if (totalArtistas == 0) {
            System.out.println("Nenhum artista cadastrado.");
            return;
        }
        System.out.println("--- Artistas ---");
        for (int i = 0; i < totalArtistas; i++) {
            System.out.print("  " + i + " - ");
            artistas[i].exibirInfo();
        }
    }

    private static void listarAlbuns() {
        if (totalAlbuns == 0) {
            System.out.println("Nenhum album criado.");
            return;
        }
        for (int i = 0; i < totalAlbuns; i++) {
            albuns[i].exibirAlbum();
        }
    }

    private static int lerInt() {
        while (true) {
            String linha = sc.nextLine();
            try {
                return Integer.parseInt(linha.trim());
            } catch (NumberFormatException e) {
                System.out.print("Valor invalido. Digite um numero: ");
            }
        }
    }
}
