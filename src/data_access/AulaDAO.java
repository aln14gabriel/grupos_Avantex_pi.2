package src.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import src.model.Aula;

public class AulaDAO {
    public void create(Aula aula) {
        String sql = "INSERT INTO aula (nome, horario, capacidade) VALUES (?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, aula.getNome());
            stmt.setString(2, aula.getHorario());
            stmt.setInt(3, aula.getCapacidade());

            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    aula.setCodigo(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar aula", e);
        }
    }

    public List<Aula> readAll() {
        String sql = "SELECT * FROM aula";
        List<Aula> aulas = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Aula aula = new Aula(
                        rs.getInt("codigo"),
                        rs.getString("nome"),
                        rs.getString("horario"),
                        rs.getInt("capacidade"));
                aulas.add(aula);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao ler aulas", e);
        }

        return aulas;
    }

    public void update(Aula aula) {
        String sql = "UPDATE aula SET nome = ?, horario = ?, capacidade = ? WHERE codigo = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, aula.getNome());
            stmt.setString(2, aula.getHorario());
            stmt.setInt(3, aula.getCapacidade());
            stmt.setInt(4, aula.getCodigo());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar aula", e);
        }
    }

    public void delete(int codigo) {
        String sql = "DELETE FROM aula WHERE codigo = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, codigo);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar aula", e);
        }
    }
}