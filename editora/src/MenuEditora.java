import java.util.Scanner;

public class MenuEditora {
    private Scanner teclado = new Scanner(System.in);
    private EditoraBanco banco = new EditoraBanco();

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
            System.out.println("\n--- Menu Editora ---");
                System.out.println("1. Cadastrar Editora");
                System.out.println("2. Listar Editoras");
                System.out.println("3. Atualizar Editora");
                System.out.println("4. Remover Editora");
                System.out.println("5. Imprimir todos");
                System.out.println("6. Obter número de itens");
                System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = teclado.nextInt();
            teclado.nextLine(); 
            
            switch (opcao) {
                case 1 -> cadastrar();
                case 2 -> listar();
                case 3 -> atualizar();
                case 4 -> remover();
                case 5 -> banco.listarTodos();
                case 6 -> System.out.println("Total: " + banco.getCont());
                case 7 -> System.out.println("Saindo do menu Editora.");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 7);
    }

    private void cadastrar() {
        Editora e = new Editora();
        System.out.print("Nome: ");
        String nome = teclado.nextLine();
        if (nome.isBlank()) {
            System.out.println("Nome inválido.");
            return;
        }
        e.setNome(nome);

        System.out.print("Sigla: ");
        String sigla = teclado.nextLine();
        if (sigla.isBlank()) {
            System.out.println("Sigla inválida.");
            return;
        }
        e.setSigla(sigla);

        System.out.print("Observação: ");
        String obs = teclado.nextLine();
        if (!validarDescricao(obs)) {
            return;
        }
        e.setObservacao(obs);

        banco.inserir(e);
        System.out.println("Editora cadastrada com sucesso.");
    }

    private void listar() {
        if (banco.getCont() == 0) {
            System.out.println("Nenhuma editora cadastrada.");
        } else {
            for (Editora e : banco.listarTodos()) {
                System.out.println("-------------------------");
                System.out.println("ID: " + e.getId());
                System.out.println("Nome: " + e.getNome());
                System.out.println("Sigla: " + e.getSigla());
                System.out.println("Observação: " + e.getObservacao());
                System.out.println("-------------------------");
            }
        }
    }

    private void atualizar() {
        System.out.print("Digite o ID da editora a atualizar: ");
        int id = teclado.nextInt();
        teclado.nextLine();

        if (!banco.exist(id)) {
            System.out.println("Editora não encontrada.");
            return;
        }

        Editora nova = new Editora();
        nova.setId(id);

        System.out.print("Novo nome: ");
        String nome = teclado.nextLine();
        if (nome.isBlank()) {
            System.out.println("Nome inválido.");
            return;
        }
        nova.setNome(nome);

        System.out.print("Nova sigla: ");
        String sigla = teclado.nextLine();
        if (sigla.isBlank()) {
            System.out.println("Sigla inválida.");
            return;
        }
        nova.setSigla(sigla);

        System.out.print("Nova observação: ");
        String obs = teclado.nextLine();
        if (!validarDescricao(obs)) {
            return;
        }
        nova.setObservacao(obs);

        banco.update(nova);
        System.out.println("Editora atualizada com sucesso.");
    }

    private void remover() {
        System.out.print("Digite o ID da editora a remover: ");
        int id = teclado.nextInt();
        teclado.nextLine();

        if (!banco.exist(id)) {
            System.out.println("Editora não encontrada.");
            return;
        }

        banco.remove(id);
        System.out.println("Editora removida com sucesso.");
    }
}