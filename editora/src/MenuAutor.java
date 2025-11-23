import java.util.Scanner;
import java.util.List;

public class MenuAutor {
    private Scanner teclado = new Scanner(System.in);
    private AutorBanco banco = new AutorBanco();

    private boolean validarDescricao(String descricao) {
        if (descricao == null || descricao.isBlank() || descricao.length() < 3) {
            System.out.println("Erro: Observação não pode ser nula, vazia ou ter menos de 3 caracteres.");
            return false;
        }
        return true;
    }

    public void exibir() {
        int opcao;
        do {
            System.out.println("\n--- Menu Autor ---");
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
        Autor a = new Autor();
        System.out.print("Nome: ");
        a.setNome(teclado.nextLine());
        System.out.print("Pseudônimo: ");
        a.setPseudonimo(teclado.nextLine());
        System.out.print("Observação: ");
        String obs = teclado.nextLine();
        if (!validarDescricao(obs)) {
            return;
        }
        a.setObservacao(obs);
        banco.inserir(a);
        System.out.println("Autor cadastrado com sucesso.");
    }

    private void alterar() {
        System.out.print("ID do autor: ");
        int id = teclado.nextInt();
        teclado.nextLine();
        if (!banco.exist(id)) {
            System.out.println("Autor não encontrado.");
            return;
        }
        Autor a = new Autor();
        a.setId(id);
        System.out.print("Novo nome: ");
        a.setNome(teclado.nextLine());
        System.out.print("Novo pseudônimo: ");
        a.setPseudonimo(teclado.nextLine());
        System.out.print("Nova observação: ");
        String obs = teclado.nextLine();
        if (!validarDescricao(obs)) {
            return;
        }
        a.setObservacao(obs);
        banco.update(a);
        System.out.println("Autor atualizado com sucesso.");
    }

    private void excluir() {
        System.out.print("ID do autor: ");
        int id = teclado.nextInt();
        teclado.nextLine();
        banco.remove(id);
    }

    private void pesquisar() {
        System.out.print("ID do autor: ");
        int id = teclado.nextInt();
        teclado.nextLine();
        Autor a = banco.get(id);
        System.out.println(a != null ? a : "Autor não encontrado.");
    }

    private void imprimirTodos() {
        List<Autor> lista = banco.listarTodos();
        if (lista.isEmpty()) System.out.println("Nenhum autor cadastrado.");
        else lista.forEach(System.out::println);
    }
}