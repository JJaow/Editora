public class Editora extends BaseEntity {
    private String  nome;
    private String sigla;

    public Editora() {}

    public Editora(String nome, String sigla, String observacao) {
        super(observacao);
        this.nome = nome;
        this.sigla = sigla;
    }

    public void setNome(String nome){this.nome = nome;}
    public String getNome(){return this.nome;}

    public void setSigla(String sigla){this.sigla = sigla;}
    public String getSigla(){return this.sigla;}

    @Override
    public String toString() {
        return "Editora [ID=" + getId() + ", Nome=" + nome + ", Sigla=" + sigla + ", Observação=" + getObservacao() + "]";
    }

}
