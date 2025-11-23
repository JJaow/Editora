import java.util.ArrayList;
import java.util.List;

public class AutorBanco {
    private List<Autor> list = new ArrayList<>();

    public void inserir(Autor a) {
        int id = IdGenerator.nextId("Autor");
        a.setId(id);
        list.add(a);
        System.out.println("Autor inserido com sucesso. ID gerado: " + id);
    }

    public void update(Autor a) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == a.getId()) {
                list.set(i, a);
                System.out.println("Autor atualizado.");
                return;
            }
        }
        System.out.println("Autor não encontrado.");
    }

    public void remove(int id) {
        boolean removido = list.removeIf(x -> x.getId() == id);
        System.out.println(removido ? "Autor removido." : "Autor não encontrado.");
    }

    public Autor get(int id) {
        for (Autor a : list) if (a.getId() == id) return a;
        return null;
    }

    public List<Autor> listarTodos() {
        return list;
    }

    public int getCont() { return list.size(); }

    public boolean exist(int id) {
        return list.stream().anyMatch(a -> a.getId() == id);
    }
}