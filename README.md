# ProjetoPooNup2

Projeto em Java para a NUP2 de POO.

Sistema simples de cadastro de artistas, albuns, musicas e montagem de playlists, com menu pelo terminal.

## Como rodar

Precisa do JDK instalado.

```
javac -d bin src/*.java
java -cp bin Main
```

Ao abrir, o programa pede o nome e o tamanho da playlist principal e mostra um menu.

## Arquivos

Tudo dentro da pasta `src`:

- Reprodutivel.java
- Midia.java
- Musica.java
- MusicaAoVivo.java
- Artista.java
- Album.java
- Playlist.java
- Main.java

## Conceitos usados

- Encapsulamento: atributos privados com getters e setters
- Construtores: varios construtores em cada classe
- Interface: Reprodutivel (reproduzir, pausar, parar)
- Classe abstrata: Midia
- Sobrecarga: construtores e o metodo adicionar da Playlist e do Album
- Sobreposicao: exibirFicha e os metodos da interface nas subclasses
- Composicao e agregacao: Album monta o array de faixas e referencia um Artista; Playlist guarda faixas externas
- Array: usado em Album, Playlist e no Main

## Menu

1 - Cadastrar Artista
2 - Cadastrar Musica
3 - Cadastrar Musica Ao Vivo
4 - Criar Album e adicionar faixas
5 - Adicionar faixa na Playlist
6 - Listar Artistas
7 - Listar Albuns
8 - Listar Playlist
9 - Reproduzir Playlist
10 - Exibir fichas da Playlist
11 - Duracao total da Playlist
0 - Sair
