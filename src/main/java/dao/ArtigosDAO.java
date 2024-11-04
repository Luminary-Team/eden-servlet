package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ArtigosDAO {
    private Conexao conexao;

    //    Ligando a classe com o banco
    public ArtigosDAO(){
        this.conexao = new Conexao();
    }

//    Dando um select no banco para mostrar todos os artigos
    public ResultSet getArtigos(){
        conexao.conectar();
        try{
            conexao.pstmt = conexao.conn.prepareStatement("SELECT * FROM INFORMATIVE_ARTICLES ORDER BY 1");
            return conexao.pstmt.executeQuery();
        }catch (SQLException sqe){
            sqe.printStackTrace();
            return null;
        }finally {
            conexao.desconectar();
        }
    }

//    Adicionando artigo no banco
    public boolean adicionarArtigo(String headline, String news_url, String source){
        conexao.conectar();
        try{
            conexao.pstmt = conexao.conn.prepareStatement("INSERT INTO INFORMATIVE_ARTICLES(headline, news_url, source) VALUES (?,?,?)");
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
    //    METODO PARA REMOVER O ADMINISTRADOR
    public boolean removeArtigo(int id_articles){
        conexao.conectar();
        try{
            conexao.pstmt = conexao.conn.prepareStatement("DELETE FROM INFORMATIVE_ARTICLES WHERE ID_ARTICLE = ?");
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
            conexao.pstmt = conexao.conn.prepareStatement("update informative_articles set headLine = ?, news_url = ?, source = ? where id_article = ? ");
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
