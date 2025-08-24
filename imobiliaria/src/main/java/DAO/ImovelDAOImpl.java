package DAO;

import java.sql.*;
import java.util.*;
import Entidade.Imovel;

public class ImovelDAOImpl implements ImovelDAO {


    @Override
    public int salvar(Imovel imovel) {
        String sql = "INSERT INTO imovel (endereco, tipo, valor, quartos, status) VALUES (?, ?, ?, ?, ?)";
        int idGerado = -1;

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, imovel.getEndereco());
            stmt.setString(2, imovel.getTipo());
            stmt.setDouble(3, imovel.getValor());
            stmt.setInt(4, imovel.getQuartos());
            stmt.setString(5, imovel.getStatus() != null ? imovel.getStatus().name() : "INATIVO");

            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Falha ao inserir imóvel, nenhuma linha afetada.");
            }

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    idGerado = rs.getInt(1);
                    imovel.setIdImovel(idGerado);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar imóvel: " + imovel, e);
        }

        return idGerado;
    }


    @Override
    public List<Imovel> listarDisponiveis() {
        List<Imovel> lista = new ArrayList<>();
        String sql = "SELECT * FROM imovel WHERE status = 'ATIVO'";

        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(mapearImovel(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar imóveis disponíveis", e);
        }

        return lista;
    }


    @Override
    public void atualizar(Imovel imovel) {
        String sql = "UPDATE imovel SET endereco = ?, tipo = ?, valor = ?, quartos = ?, status = ? WHERE idImovel = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, imovel.getEndereco());
            stmt.setString(2, imovel.getTipo());
            stmt.setDouble(3, imovel.getValor());
            stmt.setInt(4, imovel.getQuartos());
            stmt.setString(5, imovel.getStatus() != null ? imovel.getStatus().name() : "INATIVO");
            stmt.setInt(6, imovel.getIdImovel());

            int updated = stmt.executeUpdate();
            if (updated == 0) {
                throw new SQLException("Nenhum imóvel encontrado com o ID: " + imovel.getIdImovel());
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar imóvel: " + imovel, e);
        }
    }


    @Override
    public void excluir(int id) {
        String sql = "DELETE FROM imovel WHERE idImovel = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int deleted = stmt.executeUpdate();
            if (deleted == 0) {
                throw new SQLException("Nenhum imóvel encontrado com o ID: " + id);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir imóvel com ID: " + id, e);
        }
    }


    @Override
    public List<Imovel> listarTodos(int idImovel) {
        List<Imovel> lista = new ArrayList<>();
        String sql = "SELECT * FROM imovel";

        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(mapearImovel(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar todos os imóveis", e);
        }

        return lista;
    }

    // Método auxiliar para mapear ResultSet para Imovel
    private Imovel mapearImovel(ResultSet rs) throws SQLException {
        String statusStr = rs.getString("status");
        return new Imovel(
                rs.getInt("idImovel"),
                rs.getString("endereco"),
                rs.getString("tipo"),
                rs.getDouble("valor"),
                rs.getInt("quartos"),
                statusStr != null ? Imovel.Status.valueOf(statusStr) : Imovel.Status.INATIVO
        );
    }
}
