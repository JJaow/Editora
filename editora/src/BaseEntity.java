public abstract class BaseEntity {
    private int id;
    private String observacao;

    public BaseEntity() {}

    public BaseEntity(String observacao) {
        if (observacao == null || observacao.isBlank() || observacao.length() < 3) {
            System.out.println("Observação inválida. Deve ter pelo menos 3 caracteres.");
        } else {
            this.observacao = observacao;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id <= 0) {
            System.out.println("ID inválido.");
        } else {
            this.id = id;
        }
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        if (observacao == null || observacao.isBlank() || observacao.length() < 3) {
            System.out.println("Observação inválida. Deve ter pelo menos 3 caracteres.");
        } else {
            this.observacao = observacao;
        }
    }
}
