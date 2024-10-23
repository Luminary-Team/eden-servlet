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
        }
    }

    public boolean adicionarCategoria(String category, String description){
        conexao.conectar();
        try{
            conexao.pstmt = conexao.conn.prepareStatement("INSERT INTO INFORMATIVE( category, description ) VALUES (?,?)");
            conexao.pstmt.setString(1,category);
            conexao.pstmt.setString(2,description);


            return conexao.pstmt.executeUpdate() > 0;

        } catch (SQLException sqe) {
            sqe.printStackTrace();
            return false;
        } finally {
            conexao.desconectar();
        }
    }

    public ResultSet getPk_id(){
        conexao.conectar();
        try{
            conexao.pstmt = conexao.conn.prepareStatement("select distinct pk_id from categories order by 1 desc");
            return conexao.pstmt.executeQuery();
        }catch (SQLException sqe){
            sqe.printStackTrace();
            return null;
        }finally {
            conexao.desconectar();
        }
    }


    // método para pegar apenas um admin utilizado na editarCategory
    public ResultSet getCategory(int pk_id) {
        conexao.conectar();
        try {
            conexao.pstmt = conexao.conn.prepareStatement("SELECT * FROM CATEGORY WHERE PK_ID = ?");
            conexao.pstmt.setInt(1, pk_id);
            return conexao.pstmt.executeQuery();
        } catch (SQLException sqe) {
            sqe.printStackTrace();
            return null;
        } finally {
            conexao.desconectar();
        }
    }

    //    METODO PARA REMOVER O CATEGORIA
    public boolean removeCategory(int pk_id){
        conexao.conectar();
        try{
            conexao.pstmt = conexao.conn.prepareStatement("DELETE FROM CATEGORY WHERE PK_ID = ?");
            conexao.pstmt.setInt(1, pk_id);
            return conexao.pstmt.executeUpdate() > 0;
        } catch (SQLException sqe) {
            sqe.printStackTrace();
            return false;
        } finally {
            conexao.desconectar();
        }
    }

//    METODO PARA EDITAR O CATEGORIA
    public boolean editarCategory(int pk_id, String category, String description){
        conexao.conectar();
        try {
            conexao.pstmt = conexao.conn.prepareStatement("update informative_articles set category = ?, description = ? where pk_id = ? ");
            conexao.pstmt.setString(1, category);
            conexao.pstmt.setString(2, description);
            conexao.pstmt.setInt(3, pk_id);

            return conexao.pstmt.executeUpdate() > 0;

        }catch (SQLException sqe){
            sqe.printStackTrace();
            return false;
        }finally {
            conexao.desconectar();
        }
    }

}
