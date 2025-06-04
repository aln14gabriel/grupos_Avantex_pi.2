package src.model;

public class Pagamento {
    private int id;
    private int membroId;
    private int valor;
    private String status;

    public Pagamento(int id, int membroId, int valor, String status) {
        this.id = id;
        this.membroId = membroId;
        this.valor = valor;
        this.status = status;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMembroId() {
        return membroId;
    }

    public void setMembroId(int membroId) {
        this.membroId = membroId;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Pagamento{" +
                "id=" + id +
                ", membroId=" + membroId +
                ", valor=" + valor +
                ", status='" + status + '\'' +
                '}';
    }
}
