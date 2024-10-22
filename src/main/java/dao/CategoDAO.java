package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoDAO {
    private Conexao conexao;

    public CategoDAO(){
        this.conexao = new Conexao();
    }

    public ResultSet getCategorias(){
        conexao.conectar();
        try {
            conexao.pstmt = conexao.conn.prepareStatement("SELECT * FROM CATEGORIES");
            return conexao.pstmt.executeQuery();
        } catch (SQLException sqe) {
            sqe.printStackTrace();
            return null;
        } finally {
            conexao.desconectar();
        }    }


}
