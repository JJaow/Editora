public class AutorLivro {
    private int idAutor;
    private int idLivro;

    public void setIdAutor(int idAutor) {
        if (idAutor <= 0) System.out.println("ID de autor inválido.");
        else this.idAutor = idAutor;
    }
    public int getIdAutor() { return idAutor; }

    public void setIdLivro(int idLivro) {
        if (idLivro <= 0) System.out.println("ID de livro inválido.");
        else this.idLivro = idLivro;
    }
    public int getIdLivro() { return idLivro; }

    @Override
    public String toString() {
        return "AutorLivro [AutorID=" + idAutor + ", LivroID=" + idLivro + "]";
    }
}