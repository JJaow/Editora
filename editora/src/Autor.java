public class Autor extends BaseEntity {
    private String nome;
    private String pseudonimo;

    public Autor() {}

    public Autor(String nome, String pseudonimo, String observacao) {
        super(observacao);
        this.nome = nome;
        this.pseudonimo = pseudonimo;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank() || nome.length() < 3)
            System.out.println("Nome inválido.");
        else this.nome = nome;
    }
    public String getNome() { return nome; }

    public void setPseudonimo(String pseudonimo) { this.pseudonimo = pseudonimo; }
    public String getPseudonimo() { return pseudonimo; }

    @Override
    public String toString() {
        return "Autor [ID=" + getId() + ", Nome=" + nome + ", Pseudônimo=" + pseudonimo +
               ", Observação=" + getObservacao() + "]";
    }
}