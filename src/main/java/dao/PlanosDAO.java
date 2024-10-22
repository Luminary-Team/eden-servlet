package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlanosDAO {
    private Conexao conexao;

    public PlanosDAO(){
        this.conexao = new Conexao();
    }

    public ResultSet getPlanos(){
        conexao.conectar();
        try{
            conexao.pstmt = conexao.conn.prepareStatement("SELECT * FROM BOOST_PLAN");
            return conexao.pstmt.executeQuery();
        }catch (SQLException sqe){
            sqe.printStackTrace();
            return null;
        }finally {
            conexao.desconectar();
        }
    }
}
