package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public abstract class BaseDao {

    protected Connection conn;

    public BaseDao() {
        this.conn = ConnectionFactory.getConnection();
    }


    protected void closeResources(Connection conn, PreparedStatement stmt, ResultSet rs) {
        try {
            if (rs != null) rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (stmt != null) stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Fecha apenas Statement e ResultSet (mantendo a conexão aberta)
     */
    protected void closeResources(PreparedStatement stmt, ResultSet rs) {
        closeResources(null, stmt, rs);
    }

    /**
     * Fecha apenas Statement (mantendo a conexão aberta)
     */
    protected void closeResources(PreparedStatement stmt) {
        closeResources(null, stmt, null);
    }
}
