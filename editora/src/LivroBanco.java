import java.util.ArrayList;
import java.util.List;

public class LivroBanco {
    private List<Livro> list = new ArrayList<>();

    public void inserir(Livro l) {
        int id = IdGenerator.nextId("Livro");
        l.setId(id);
        list.add(l);
        System.out.println("Livro inserido com sucesso. ID gerado: " + id);
    }

    public void update(Livro l) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == l.getId()) {
                list.set(i, l);
                System.out.println("Livro atualizado.");
                return;
            }
        }
        System.out.println("Livro não encontrado.");
    }

    public void remove(int id) {
        boolean removido = list.removeIf(x -> x.getId() == id);
        System.out.println(removido ? "Livro removido." : "Livro não encontrado.");
    }

    public Livro get(int id) {
        for (Livro l : list) if (l.getId() == id) return l;
        return null;
    }

    public List<Livro> listarTodos() {
        return list;
    }

    public int getCont() { return list.size(); }

    public boolean exist(int id) {
        return list.stream().anyMatch(l -> l.getId() == id);
    }
}