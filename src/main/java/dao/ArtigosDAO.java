package dao;

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
            conexao.pstmt = conexao.conn.prepareStatement("SELECT * FROM INFORMATIVE_ARTICLES ORDER BY ID_INFORMATIVE");
            return conexao.pstmt.executeQuery();
        }catch (SQLException sqe){
            sqe.printStackTrace();
            return null;
        }finally {
            conexao.desconectar();
        }
    }

    public boolean adicionarArtigo(String headline, String news_url, String source){
        conexao.conectar();
        try{
            conexao.pstmt = conexao.conn.prepareStatement("INSERT INTO INFORMATIVE( headline, newa_url, source) VALUES (?,?,?)");
            conexao.pstmt.setString(1, headline);
            conexao.pstmt.setString(2, news_url);
            conexao.pstmt.setString(3, source);


            return conexao.pstmt.executeUpdate() > 0;

        } catch (SQLException sqe) {
            sqe.printStackTrace();
            return false;
        } finally {
            conexao.desconectar();
        }
    }

    public ResultSet getId_article(){
        conexao.conectar();
        try{
            conexao.pstmt = conexao.conn.prepareStatement("select distinct id_article from informative_articles order by 1 desc");
            return conexao.pstmt.executeQuery();
        }catch (SQLException sqe){
            sqe.printStackTrace();
            return null;
        }finally {
            conexao.desconectar();
        }
    }


    // método para pegar apenas um admin utilizado na editarAdmin
    public ResultSet getArtigo(int id_article) {
        conexao.conectar();
        try {
            conexao.pstmt = conexao.conn.prepareStatement("SELECT * FROM INFORMATIVE_ARTICLES WHERE ID_ARTICLES = ?");
            conexao.pstmt.setInt(1, id_article);
            return conexao.pstmt.executeQuery();
        } catch (SQLException sqe) {
            sqe.printStackTrace();
            return null;
        } finally {
            conexao.desconectar();
        }
    }

    //    METODO PARA REMOVER O ADMINISTRADOR
    public boolean removeArtigo(int id_articles){
        conexao.conectar();
        try{
            conexao.pstmt = conexao.conn.prepareStatement("DELETE FROM INFORMATIVE_ARTICLES WHERE ID_ARTICLES = ?");
            conexao.pstmt.setInt(1, id_articles);
            return conexao.pstmt.executeUpdate() > 0;
        } catch (SQLException sqe) {
            sqe.printStackTrace();
            return false;
        } finally {
            conexao.desconectar();
        }
    }

//    METODO PARA EDITAR O ADMINISTRADOR

    public boolean editarArtigo(int id_articles, String headline, String news_url, String source){
        conexao.conectar();
        try {
            conexao.pstmt = conexao.conn.prepareStatement("update informative_articles set headLine = ?, news_url = ?, source = ? where id_articles = ? ");
            conexao.pstmt.setString(1, headline);
            conexao.pstmt.setString(2, news_url);
            conexao.pstmt.setString(3, source);
            conexao.pstmt.setInt(4, id_articles);


            return conexao.pstmt.executeUpdate() > 0;

        }catch (SQLException sqe){
            sqe.printStackTrace();
            return false;
        }finally {
            conexao.desconectar();
        }
    }
}
