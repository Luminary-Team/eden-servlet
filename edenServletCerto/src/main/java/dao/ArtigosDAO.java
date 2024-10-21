package dao;

import controller.Conexao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ArtigosDAO {
    private Conexao conexao;

    public ArtigosDAO(){
        this.conexao = new Conexao();
    }

    public ResultSet getArtigos(){
        conexao.conectar();
        try{
            conexao.pstmt = conexao.conn.prepareStatement("SELECT * FROM INFORMATIVE_ARTICLES");
            return conexao.pstmt.executeQuery();
        }catch (SQLException sqe){
            sqe.printStackTrace();
            return null;
        }finally {
            conexao.desconectar();
        }
    }
}
