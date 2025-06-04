package src.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import src.model.Pagamento;

public class PagamentoDAO {
    public void create(Pagamento pagamento) {
        String sql = "INSERT INTO pagamento (membro_id, valor, status) VALUES (?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, pagamento.getMembroId());
            stmt.setInt(2, pagamento.getValor());
            stmt.setString(3, pagamento.getStatus());

            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    pagamento.setId(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar pagamento", e);
        }
    }

    public List<Pagamento> readAll() {
        String sql = "SELECT * FROM pagamento";
        List<Pagamento> pagamentos = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Pagamento pagamento = new Pagamento(
                        rs.getInt("id"),
                        rs.getInt("membro_id"),
                        rs.getInt("valor"),
                        rs.getString("status"));
                pagamentos.add(pagamento);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao ler pagamentos", e);
        }

        return pagamentos;
    }

    public void update(Pagamento pagamento) {
        String sql = "UPDATE pagamento SET membro_id = ?, valor = ?, status = ? WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, pagamento.getMembroId());
            stmt.setInt(2, pagamento.getValor());
            stmt.setString(3, pagamento.getStatus());
            stmt.setInt(4, pagamento.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar pagamento", e);
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM pagamento WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar pagamento", e);
        }
    }
}
