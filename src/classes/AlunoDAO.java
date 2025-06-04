package src.model;

public class Aluno {
    private String nome;
    private String cpf;
    private String plano;
    private String dataInicio;

    public Aluno(String nome, String cpf, String plano, String dataInicio) {
        this.nome = nome;
        this.cpf = cpf;
        this.plano = plano;
        this.dataInicio = dataInicio;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", plano='" + plano + '\'' +
                ", dataInicio='" + dataInicio + '\'' +
                '}';
    }
}