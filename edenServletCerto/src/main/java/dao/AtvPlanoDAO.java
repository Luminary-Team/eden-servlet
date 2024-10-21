package dao;

import controller.Conexao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AtvPlanoDAO {
    private Conexao conexao;
    public AtvPlanoDAO(){
        this.conexao = new Conexao();
    }
    public ResultSet getAtvPlanos() {
        conexao.conectar();
        try {
            conexao.pstmt = conexao.conn.prepareStatement("SELECT * FROM ACTIVATE_PLAN");
            return conexao.pstmt.executeQuery();
        } catch (SQLException sqe) {
            sqe.printStackTrace();
            return null;
        } finally {
            conexao.desconectar();
        }
    }
}
