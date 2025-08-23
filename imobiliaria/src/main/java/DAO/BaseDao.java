
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class BaseDao {

    protected Connection con;

    public BaseDao() {
        try {
            String url = "jdbc:mysql://localhost:3306/imobiliaria";
            String user = "root";
            String password = "1234";

            this.con = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão estabelecida!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void fecharConexao() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
                System.out.println("Conexão fechada.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

