import DAO.ConnectionFactory;
import Entidade.Cliente;

import java.sql.*;
import java.util.*;

public class ClienteDAOImpl implements ClienteDAO {

    @Override
    public void salvar(ClienteDAO Cliente) {
        String sql = "INSERT INTO clientes (nome,CPF,telefone, email) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1,cliente.getNome());
            stmt.setString(2,cliente.getCPF());
            stmt.setString(3,cliente.getTelefone());
            stmt.setString(4,cliente.getEmail());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ClienteDAO> listarTodos(int idCliente) {
        List<ClienteDAO> lista = new ArrayList<>();
        String sql = "SELECT * FROM cliente";
        try (Connection conn = ConnectionFactory.ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Cliente(
                        rs.getInt("idCliente"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("telefone"),
                        rs.getString("email")
                );
                {

                    public void salvar(ClienteDAO cliente) {

                    }


                    public List<Cliente> listarTodos() {
                        return List.of();
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
}

