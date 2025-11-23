import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== Sistema de Editoras, Autores e Livros ===");
            System.out.println("1. Menu Editora");
            System.out.println("2. Menu Autor");
            System.out.println("3. Menu Livro");
            System.out.println("4. Menu AutorLivro (vínculos)");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = teclado.nextInt();
            teclado.nextLine();

            switch (opcao) {
                case 1 -> new MenuEditora().exibir();
                case 2 -> new MenuAutor().exibir();
                case 3 -> new MenuLivro().exibir();
                case 4 -> new MenuAutorLivro().exibir();
                case 5 -> System.out.println("Encerrando o sistema...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 5);

        teclado.close();
    }
}