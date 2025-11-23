import java.util.ArrayList;
import java.util.List;

public class AutorLivroBanco {
    private List<AutorLivro> list = new ArrayList<>();

    public void inserir(AutorLivro al) {
        for (AutorLivro item : list) {
            if (item.getIdAutor() == al.getIdAutor() && item.getIdLivro() == al.getIdLivro()) {
                System.out.println("Erro: vínculo já existe.");
                return;
            }
        }
        list.add(al);
        System.out.println("Vínculo inserido com sucesso.");
    }

    public void remove(int idAutor, int idLivro) {
        boolean removido = list.removeIf(al -> al.getIdAutor() == idAutor && al.getIdLivro() == idLivro);
        System.out.println(removido ? "Vínculo removido." : "Vínculo não encontrado.");
    }

    public AutorLivro get(int idAutor, int idLivro) {
        for (AutorLivro al : list) {
            if (al.getIdAutor() == idAutor && al.getIdLivro() == idLivro) return al;
        }
        return null;
    }

    public List<AutorLivro> listarTodos() {
        return list;
    }

    public int getCont() { return list.size(); }
}