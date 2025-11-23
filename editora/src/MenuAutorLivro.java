import java.util.Scanner;
import java.util.List;

public class MenuAutorLivro {
    private Scanner teclado = new Scanner(System.in);
    private AutorLivroBanco banco = new AutorLivroBanco();
    private AutorBanco autorBanco = new AutorBanco();
    private LivroBanco livroBanco = new LivroBanco();

    public void exibir() {
        int opcao;
        do {
            System.out.println("\n--- Menu AutorLivro ---");
            System.out.println("1. Inserir vínculo");
            System.out.println("2. Excluir vínculo");
            System.out.println("3. Pesquisar vínculo");
            System.out.println("4. Imprimir todos");
            System.out.println("5. Obter número de vínculos");
            System.out.println("6. Sair");
            System.out.print("Escolha: ");
            opcao = teclado.nextInt();
            teclado.nextLine();

            switch (opcao) {
                case 1 -> inserir();
                case 2 -> excluir();
                case 3 -> pesquisar();
                case 4 -> imprimirTodos();
                case 5 -> System.out.println("Total de vínculos: " + banco.getCont());
                case 6 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 6);
    }

    private void inserir() {
        AutorLivro al = new AutorLivro();
        System.out.print("ID do Autor: ");
        int idAutor = teclado.nextInt();
        teclado.nextLine();

        if (!autorBanco.exist(idAutor)) {
            System.out.println("Autor não encontrado. Insira o autor primeiro.");
            return;
        }

        System.out.print("ID do Livro: ");
        int idLivro = teclado.nextInt();
        teclado.nextLine();

        if (!livroBanco.exist(idLivro)) {
            System.out.println("Livro não encontrado. Insira o livro primeiro.");
            return;
        }

        al.setIdAutor(idAutor);
        al.setIdLivro(idLivro);
        banco.inserir(al);
    }

    private void excluir() {
        System.out.print("ID do Autor: ");
        int idAutor = teclado.nextInt();
        teclado.nextLine();
        System.out.print("ID do Livro: ");
        int idLivro = teclado.nextInt();
        teclado.nextLine();
        banco.remove(idAutor, idLivro);
    }

    private void pesquisar() {
        System.out.print("ID do Autor: ");
        int idAutor = teclado.nextInt();
        teclado.nextLine();
        System.out.print("ID do Livro: ");
        int idLivro = teclado.nextInt();
        teclado.nextLine();
        AutorLivro al = banco.get(idAutor, idLivro);
        System.out.println(al != null ? al : "Vínculo não encontrado.");
    }

    private void imprimirTodos() {
        List<AutorLivro> lista = banco.listarTodos();
        if (lista.isEmpty()) System.out.println("Nenhum vínculo cadastrado.");
        else lista.forEach(System.out::println);
    }
}