import java.util.Scanner;
import java.math.BigDecimal;
import java.util.List;

public class MenuLivro {
    private Scanner teclado = new Scanner(System.in);
    private LivroBanco banco = new LivroBanco();

    private boolean validarDescricao(String descricao) {
        if (descricao == null || descricao.isBlank() || descricao.length() < 3) {
            System.out.println("Erro: Observações não podem ser nulas, vazias ou ter menos de 3 caracteres.");
            return false;
        }
        return true;
    }

    public void exibir() {
        int opcao;
        do {
            System.out.println("\n--- Menu Livro ---");
            System.out.println("1. Inserir");
            System.out.println("2. Alterar");
            System.out.println("3. Excluir");
            System.out.println("4. Pesquisar");
            System.out.println("5. Imprimir todos");
            System.out.println("6. Obter número de itens");
            System.out.println("7. Sair");
            System.out.print("Escolha: ");
            opcao = teclado.nextInt();
            teclado.nextLine();

            switch (opcao) {
                case 1 -> inserir();
                case 2 -> alterar();
                case 3 -> excluir();
                case 4 -> pesquisar();
                case 5 -> imprimirTodos();
                case 6 -> System.out.println("Total: " + banco.getCont());
                case 7 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 7);
    }

    private void inserir() {
        Livro l = new Livro();
        System.out.print("Nome: ");
        l.setNome(teclado.nextLine());
        System.out.print("Ano de Publicação: ");
        l.setAnoPublicacao(teclado.nextInt());
        teclado.nextLine();
        System.out.print("ISBN: ");
        l.setIsbn(new BigDecimal(teclado.nextLine()));
        System.out.print("Observações: ");
        String obs = teclado.nextLine();
        if (!validarDescricao(obs)) {
            return;
        }
        l.setObservacoes(obs);
        System.out.print("ID da Editora: ");
        l.setIdEditora(teclado.nextInt());
        teclado.nextLine();
        banco.inserir(l);
        System.out.println("Livro cadastrado com sucesso.");
    }

    private void alterar() {
        System.out.print("ID do livro: ");
        int id = teclado.nextInt();
        teclado.nextLine();
        if (!banco.exist(id)) {
            System.out.println("Livro não encontrado.");
            return;
        }
        Livro l = new Livro();
        l.setId(id);
        System.out.print("Novo nome: ");
        l.setNome(teclado.nextLine());
        System.out.print("Novo ano: ");
        l.setAnoPublicacao(teclado.nextInt());
        teclado.nextLine();
        System.out.print("Novo ISBN: ");
        l.setIsbn(new BigDecimal(teclado.nextLine()));
        System.out.print("Nova observação: ");
        String obs = teclado.nextLine();
        if (!validarDescricao(obs)) {
            return;
        }
        l.setObservacoes(obs);
        System.out.print("Nova Editora ID: ");
        l.setIdEditora(teclado.nextInt());
        teclado.nextLine();
        banco.update(l);
        System.out.println("Livro atualizado com sucesso.");
    }

    private void excluir() {
        System.out.print("ID do livro: ");
        int id = teclado.nextInt();
        teclado.nextLine();
        banco.remove(id);
    }

    private void pesquisar() {
        System.out.print("ID do livro: ");
        int id = teclado.nextInt();
        teclado.nextLine();
        Livro l = banco.get(id);
        System.out.println(l != null ? l : "Livro não encontrado.");
    }

    private void imprimirTodos() {
        List<Livro> lista = banco.listarTodos();
        if (lista.isEmpty()) System.out.println("Nenhum livro cadastrado.");
        else lista.forEach(System.out::println);
    }
}