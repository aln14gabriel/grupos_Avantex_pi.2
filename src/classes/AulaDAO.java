package src.model;

public class Aula {
    private int codigo;
    private String nome;
    private String horario;
    private int capacidade;

    public Aula(int codigo, String nome, String horario, int capacidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.horario = horario;
        this.capacidade = capacidade;
    }

    // Getters e Setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    @Override
    public String toString() {
        return "Aula{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", horario='" + horario + '\'' +
                ", capacidade=" + capacidade +
                '}';
    }
}