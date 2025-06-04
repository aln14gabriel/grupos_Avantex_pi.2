package src.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import src.model.Aluno;

public class AlunoDAO {
    public void create(Aluno aluno) {
        String sql = "INSERT INTO aluno (nome, cpf, plano, data_inicio) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getCpf());
            stmt.setString(3, aluno.getPlano());
            stmt.setString(4, aluno.getDataInicio());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar aluno", e);
        }
    }

    public List<Aluno> readAll() {
        String sql = "SELECT * FROM aluno";
        List<Aluno> alunos = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Aluno aluno = new Aluno(
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("plano"),
                        rs.getString("data_inicio"));
                alunos.add(aluno);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao ler alunos", e);
        }

        return alunos;
    }

    public void update(Aluno aluno, String cpf) {
        String sql = "UPDATE aluno SET nome = ?, plano = ?, data_inicio = ? WHERE cpf = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getPlano());
            stmt.setString(3, aluno.getDataInicio());
            stmt.setString(4, cpf);

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar aluno", e);
        }
    }

    public void delete(String cpf) {
        String sql = "DELETE FROM aluno WHERE cpf = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cpf);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar aluno", e);
        }
    }
}