import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // Constantes
    private static final int REGISTRA_LIVRO = 1;
    private static final int MODIFICA_LIVRO = 2;
    private static final int REMOVE_LIVRO = 3;
    private static final int EXIBIR_TODOS_LIVROS = 4;
    private static final int SAIR = 5;

    // Lista de livros registrados
    private static ArrayList<Livro> livrosRegistrados = new ArrayList();

    // Scanner para leitura de dados pelo terminal
    private static Scanner sc;

    // Criar um objeto livro e o adicionar à lista de livros registrados
    private static void registrarLivro() {
        String titulo;
        String autor;
        int anoPublicacao;
        double preco;

        System.out.println("Informe o título: ");
        titulo = sc.nextLine();

        System.out.println("Informe o autor: ");
        autor = sc.nextLine();

        System.out.println("Informe o ano de publicação: ");
        anoPublicacao = sc.nextInt();
        sc.nextLine();

        System.out.println("Informe o preço: ");
        preco = sc.nextDouble();
        sc.nextLine();
        Livro livro;
        try {
            livro = new Livro(titulo, autor, anoPublicacao, preco);
            livrosRegistrados.add(livro);
            System.out.println("O livro foi registrado");
        } catch (Exception e) {
            System.out.println("Erro: Não foi possível registrar o livro tente novamente.");
        }
    }

    // Modifica um objeto livro da lista de livros registrados
    private static void modificarLivro() {
        // O usuário informa o título
        // e se houverem mais de um livro com o
        // mesmo título será necessário informar um índice
        String titulo;
        int indiceLivro = 0;
        int dadoAModificar;
        System.out.println("Informe o título do livro: ");
        titulo = sc.nextLine();
        int quantLivrosEncontrados = 0;
        for(int i=0; i< livrosRegistrados.size(); i++){
            if(livrosRegistrados.get(i).getTitulo().toLowerCase()==titulo.toLowerCase()){
                quantLivrosEncontrados += 1;
                indiceLivro = i;
            }
        }
        // Um livro foi encontrado
        if(quantLivrosEncontrados==1){
            System.out.println("Um livro foi encontrado");
        }
        // Diversos livros foram encontrados
        else if(quantLivrosEncontrados>1){
            ArrayList<Integer> indicesDeLivros = new ArrayList<>();
            System.out.println("Diversos livros foram encontrados, informe o indice do livro: ");
            for(int i=0; i< livrosRegistrados.size(); i++){
                if(livrosRegistrados.get(i).getTitulo()==titulo){
                    System.out.println("Índice do livro: "+i);
                    livrosRegistrados.get(i).exibirInformacoes();
                    indicesDeLivros.add(i);
                }
            }
            indiceLivro = sc.nextInt();
            sc.nextLine();
            while(!indicesDeLivros.contains(indiceLivro)){
                System.out.println("Erro - Especifique um índice de livro válido.");
                System.out.println("Digite (-1) para retornar ao Menu");
                indiceLivro = sc.nextInt();
                sc.nextLine();
                if(indiceLivro==-1){
                    return;
                }
            }
        }
        // Qual dado será modificado do livro
        System.out.println("Informe qual dado será modificado: ");
        System.out.println("1 - Título");
        System.out.println("2 - Autor");
        System.out.println("3 - Ano de publicação");
        System.out.println("4 - Preço\n");
        dadoAModificar = sc.nextInt();
        sc.nextLine();
        while (dadoAModificar<1||dadoAModificar>4) {
            System.out.println("Erro - opção inválida tente novamente: ");
            dadoAModificar = sc.nextInt();
            sc.nextLine();
        }
        Livro novoLivro = livrosRegistrados.get(indiceLivro);
        try{
            switch (dadoAModificar) {
                case 1:
                    System.out.println("Informe o novo título: ");
                    String novoTitulo = sc.nextLine();
                    novoLivro.setTitulo(novoTitulo);
                    break;
                case 2:
                    System.out.println("Informe o novo autor: ");
                    String novoAutor = sc.nextLine();
                    novoLivro.setAutor(novoAutor);
                    break;  
                case 3:
                    System.out.println("Informe o novo ano de publicação: ");
                    int novoAnoPub = sc.nextInt();
                    sc.nextLine();
                    novoLivro.setAnoPublicacao(novoAnoPub);
                    break;
                case 4:
                    System.out.println("Informe o novo preço: ");
                    double novoPreco = sc.nextDouble();
                    sc.nextLine();
                    novoLivro.setPreco(novoPreco);
                    break;      
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
        catch(Exception e){
            System.out.println("Ocorreu um erro.");
        }
    }

    // Remover um livro da lista de livros registrados
    private static void removerLivro() {
        // O usuário informa o título
        // e se houverem mais de um livro com o
        // mesmo título será necessário informar um índice
        String titulo;
        int indiceLivro = 0;
        System.out.println("Informe o título do livro: ");
        titulo = sc.nextLine();
        int quantLivrosEncontrados = 0;
        for(int i=0; i< livrosRegistrados.size(); i++){
            if(livrosRegistrados.get(i).getTitulo().toLowerCase()==titulo.toLowerCase()){
                quantLivrosEncontrados += 1;
                indiceLivro = i;
            }
        }
        // Um livro foi encontrado
        if(quantLivrosEncontrados==1){
            System.out.println("Um livro foi encontrado");
        }
        // Diversos livros foram encontrados
        else if(quantLivrosEncontrados>1){
            ArrayList<Integer> indicesDeLivros = new ArrayList<>();
            System.out.println("Diversos livros foram encontrados, informe o indice do livro: ");
            for(int i=0; i< livrosRegistrados.size(); i++){
                if(livrosRegistrados.get(i).getTitulo()==titulo){
                    System.out.println("Índice do livro: "+i);
                    livrosRegistrados.get(i).exibirInformacoes();
                    indicesDeLivros.add(i);
                }
            }
            indiceLivro = sc.nextInt();
            sc.nextLine();
            while(!indicesDeLivros.contains(indiceLivro)){
                System.out.println("Erro - Especifique um índice de livro válido.");
                System.out.println("Digite (-1) para retornar ao menu principal.");
                indiceLivro = sc.nextInt();
                sc.nextLine();
                if(indiceLivro==-1){
                    return;
                }
            }
        }
        try {
            livrosRegistrados.remove(indiceLivro);
            System.out.println("O livro foi removido.");  
        } catch (Exception e) {
            System.out.println("Ocorreu um erro.");
        }
    }

    // Exibe as informações de cada livro registrado
    private static void exibirLivros() {
        System.out.println("Exibindo informações dos livros registrados: ");
        for (Livro livro : livrosRegistrados) {
            livro.exibirInformacoes();
        }
    }

    // Loop do menu de gerenciamento o qual funciona pelo terminal
    private static void loopMenu() {
        int escolha = 0;
        while(escolha!=SAIR) {

            System.out.println("\n[Menu de Gerenciamento de Livros]");
            System.out.println("1 - Registrar novo livro");
            System.out.println("2 - Modificar  um livro");
            System.out.println("3 - Remover um livro");
            System.out.println("4 - Exibir todos os livros registrados");
            System.out.println("5 - Sair\n");

            escolha = sc.nextInt();
            sc.nextLine();
            
            while(escolha<1||escolha>5) {
                System.out.println("Erro - Informe uma opção válida.\n");
                escolha = sc.nextInt();
                sc.nextLine();
            }

            switch (escolha) {

                case REGISTRA_LIVRO:
                    registrarLivro();
                    break;

                case MODIFICA_LIVRO:
                    modificarLivro();
                    break;

                case REMOVE_LIVRO:
                    removerLivro();
                    break;

                case EXIBIR_TODOS_LIVROS:
                    exibirLivros();
                    break;

                case SAIR:
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    break;
            }
        }
    }

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        loopMenu();
        sc.close();
    }
}
