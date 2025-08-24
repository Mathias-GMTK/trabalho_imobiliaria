package DAO;

import java.sql.*;
import java.util.*;
import Entidade.Contrato;
import DAO.ConnectionFactory;

public class ContratoDAOImpl implements ContratoDAO {



    @Override
    public void salvar(Contrato contrato) {
        String sql = "INSERT INTO contrato (id_cliente, id_imovel, data_inicio, data_fim, valor) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, contrato.getIdCliente());
            stmt.setInt(2, contrato.getIdImovel());
            stmt.setDate(3, java.sql.Date.valueOf(contrato.getDataInicio()));
            stmt.setDate(4, java.sql.Date.valueOf(contrato.getDataFim()));
            stmt.setDouble(5, contrato.getValorAluguel());
            stmt.executeUpdate();

            // atualizar imóvel para indisponível
            String sqlUpdate = "UPDATE imovel SET disponivel = false WHERE id = ?";
            try (PreparedStatement stmt2 = conn.prepareStatement(sqlUpdate)) {
                stmt2.setInt(1, contrato.getIdImovel());
                stmt2.executeUpdate();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Contrato> listarAtivos() {
        List<Contrato> lista = new ArrayList<>();
        String sql = "SELECT * FROM contrato WHERE CURDATE() BETWEEN data_inicio AND data_fim";
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(new Contrato(
                        rs.getInt("id_contrato"),
                        rs.getInt("id_cliente"),
                        rs.getInt("id_imovel"),
                        rs.getString("data_inicio"),
                        rs.getString("data_fim"),
                        rs.getDouble("valor")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public List<String> clientesComMaisContratos() {
        List<String> lista = new ArrayList<>();
        String sql = """
            SELECT c.nome, COUNT(*) AS total 
            FROM contrato ct 
            JOIN cliente c ON ct.id_cliente = c.id 
            GROUP BY c.nome 
            ORDER BY total DESC
            """;
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(rs.getString("nome") + " - " + rs.getInt("total") + " contratos");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public List<Contrato> contratosExpirando30Dias() {
        List<Contrato> lista = new ArrayList<>();
        String sql = """
            SELECT * FROM contrato 
            WHERE data_fim BETWEEN CURDATE() AND DATE_ADD(CURDATE(), INTERVAL 30 DAY)
            """;
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(new Contrato(
                        rs.getInt("id_contrato"),
                        rs.getInt("id_cliente"),
                        rs.getInt("id_imovel"),
                        rs.getString("data_inicio"),
                        rs.getString("data_fim"),
                        rs.getDouble("valor")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
}
