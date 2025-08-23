package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ImovelDao extends BaseDao {

    public void salvarImovel(String endereco, String tipo, int quartos, double valor, boolean disponivel) {
        try {
            String sql = "INSERT INTO imovel (endereco, tipo, quartos, valor, disponivel ) VALUES (?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, endereco);
            stmt.setString(2, tipo);
            stmt.setInt(3, quartos);
            stmt.setDouble(4, valor);
            stmt.setBoolean(5, disponivel);

            stmt.executeUpdate();
            stmt.close();
            System.out.println("Imóvel salvo com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listarImoveis() {
        try {
            String sql = "SELECT * FROM imovel";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                                ", Endereço: " + rs.getString("endereco") +
                                ",tipo:" + rs.getString("tipo")+
                                ",quartos:" + rs.getString("quartos")+
                                ", Valor: " + rs.getDouble("valor")+
                                ",disponivel:" + rs.getString("disponivel"));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
