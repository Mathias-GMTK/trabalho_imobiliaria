package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDao extends BaseDao{

    public void adicionarCliente(String nome, String cpf, String email, String telefone){
        try{
            String SQL = "INSERT INTO Cliente(nome, cpf, email, telefone) VALUES (?,?)";
            PreparedStatement stmt = con.prepareStatement(SQL);
            stmt.setString(1, nome);
            stmt.setString(2,cpf);
            stmt.setString(3,email);
            stmt.setString(4,telefone);
            stmt.executeUpdate();
            stmt.close();
            System.out.println("Cliente salvo com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listarClientes(){
        try {
            String SQL = "SELECT * FROM CLIENTES";
            PreparedStatement stmt = con.prepareStatement(SQL);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                System.out.println("id:"+rs.getInt("id")+
                                    ",nome:"+ rs.getString("nome")+
                                    ",cpf:" + rs.getString("cpf")+
                                    ",email:" + rs.getString("email")+
                                    ",telefone:" + rs.getString("telefone"));
            }
            rs.close();
            stmt.close();
            }catch (SQLException e) {
                e.printStackTrace();
        }

    }
}