
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class ContratoDao extends BaseDao {

    public void salvarContrato(int idCliente, int idImovel, String dataInicio, String dataFim, double valor, boolean ativo) {
        try {
            String sql = "INSERT INTO contrato (id_cliente, id_imovel, data_inicio, data_fim, valor, ativo) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, idCliente);
            stmt.setInt(2, idImovel);
            stmt.setString(3, dataInicio);
            stmt.setString(4, dataFim);
            stmt.setDouble(5, valor);
            stmt.setBoolean(6, ativo);
            stmt.executeUpdate();
            stmt.close();
            System.out.println("Contrato salvo com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listarContratos() {
        try {
            String sql = "SELECT * FROM contrato";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        ", Cliente: " + rs.getInt("id_cliente") +
                        ", Imóvel: " + rs.getInt("id_imovel") +
                        ", Início: " + rs.getString("data_inicio") +
                        ", Fim: " + rs.getString("data_fim")+
                        ", Valor: " + rs.getDouble("valor") +
                        ", ativo:" + rs.getBoolean("ativo"));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
