import java.util.ArrayList;
import java.util.List;

public class EditoraBanco {
    private List<Editora> list;
    private int cont;

    public EditoraBanco() {
        this.list = new ArrayList<>();
        this.cont = 0;
    }

  public void inserir(Editora editora) {
        int id = IdGenerator.nextId("Editora");
        editora.setId(id);
        list.add(editora);
        this.cont++;
        System.out.println("Editora inserida com sucesso. ID gerado: " + id);
}

    public void remove(int id) {
        boolean removido = list.removeIf(e -> e.getId() == id);
        if (removido) {
            this.cont--;
        }
    }

    public Editora get(int id) {
        for (Editora e : list) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    public void update(Editora editora) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == editora.getId()) {
                list.set(i, editora);
                return;
            }
        }
        System.out.println("Editora com ID " + editora.getId() + " não encontrada.");
    }

    public int getCont() {
        return cont;
    }

    public boolean exist(int id) {
        for (Editora e : list) {
            if (e.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public List<Editora> listarTodos() {
        return list;
    }
}