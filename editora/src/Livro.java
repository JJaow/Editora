import java.math.BigDecimal;

public class Livro extends BaseEntity {
    private String nome;
    private int anoPublicacao;
    private BigDecimal isbn;
    private String observacoes;
    private int idEditora; // FK para Editora

    public Livro() {}

    public Livro(String nome, int anoPublicacao, BigDecimal isbn, String observacoes, int idEditora) {
        super(observacoes);
        this.nome = nome;
        this.anoPublicacao = anoPublicacao;
        this.isbn = isbn;
        this.idEditora = idEditora;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank() || nome.length() < 3)
            System.out.println("Nome inválido.");
        else this.nome = nome;
    }
    public String getNome() { return nome; }

    public void setAnoPublicacao(int ano) {
        if (ano < 1000 || ano > 9999)
            System.out.println("Ano inválido.");
        else this.anoPublicacao = ano;
    }
    public int getAnoPublicacao() { return anoPublicacao; }

    public void setIsbn(BigDecimal isbn) { this.isbn = isbn; }
    public BigDecimal getIsbn() { return isbn; }

    public void setObservacoes(String obs) {
        if (obs == null || obs.isBlank() || obs.length() < 3)
            System.out.println("Observação inválida.");
        else this.observacoes = obs;
    }
    public String getObservacoes() { return observacoes; }

    public void setIdEditora(int idEditora) {
        if (idEditora <= 0) System.out.println("ID de editora inválido.");
        else this.idEditora = idEditora;
    }
    public int getIdEditora() { return idEditora; }

    @Override
    public String toString() {
        return "Livro [ID=" + getId() + ", Nome=" + nome + ", Ano=" + anoPublicacao +
               ", ISBN=" + isbn + ", Observações=" + getObservacoes() +
               ", EditoraID=" + idEditora + "]";
    }
}