package src.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import src.model.Equipamento;

public class EquipamentoDAO {
    public void create(Equipamento equipamento) {
        String sql = "INSERT INTO equipamento (nome, status) VALUES (?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, equipamento.getNome());
            stmt.setString(2, equipamento.getStatus());

            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    equipamento.setId(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar equipamento", e);
        }
    }

    public List<Equipamento> readAll() {
        String sql = "SELECT * FROM equipamento";
        List<Equipamento> equipamentos = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Equipamento equipamento = new Equipamento(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("status"));
                equipamentos.add(equipamento);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao ler equipamentos", e);
        }

        return equipamentos;
    }

    public void update(Equipamento equipamento) {
        String sql = "UPDATE equipamento SET nome = ?, status = ? WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, equipamento.getNome());
            stmt.setString(2, equipamento.getStatus());
            stmt.setInt(3, equipamento.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar equipamento", e);
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM equipamento WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar equipamento", e);
        }
    }
}